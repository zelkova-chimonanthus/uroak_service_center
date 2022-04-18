package name.uroak.uroak_service_center.base.services

import name.uroak.uroak_service_center.base.utils.手続きメソッド情報クラス
import name.uroak.uroak_service_center.base.utils.手続きメソッド集積庫クラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続きトランザクション種別一覧.*
import name.uroak.uroak_service_center.shared.base.util.手続きメソッドデータクラス
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.tool.クラス道具箱
import java.lang.reflect.Method


/**
 *サービスAPIを実装するサービスクラスの共通親クラス
 */
abstract class 手続きサービスクラス : 一般サービス共通クラス {

    /***/
    private val 手続きメソッド集積庫 by lazy {
        集積庫に手続きメソッド情報を集積する(クリアしてから行う = false)
    }

    /**
     *
     */
    private fun 集積庫に手続きメソッド情報を集積する(手続きメソッド集積庫: 手続きメソッド集積庫クラス? = null, クリアしてから行う: Boolean = true): 手続きメソッド集積庫クラス {
        val 集積庫: 手続きメソッド集積庫クラス = 手続きメソッド集積庫 ?: 手続きメソッド集積庫クラス()

        if (クリアしてから行う) {
            集積庫.クリアする()
        }

        クラス道具箱.メソッドを収集する(
            オブジェクト = this,
            対象メソッドチェック = fun(メソッド: Method): Boolean {
                val チェック結果: Boolean = メソッド.getAnnotation(手続き呼出し::class.java) != null
                if (チェック結果) {
                    集積庫.手続きメソッド情報を追加する(メソッド)
                }
                return チェック結果
            }
        )

        return 集積庫
    }

    /**
     *
     */
    constructor(名前: String) : super(名前) {

    }

    /**
     *
     */
    constructor() : super() {

    }

    /**
     *
     */
    override fun 個別の手続き実行前処理を行う(手続き実行情報: 手続き実行情報クラス): Boolean {
        // 入力値を校正する

        // 入力チェックを行う

        return true
    }

    /**
     *
     */
    override fun 個別の手続き実行後処理を行う(手続き実行情報: 手続き実行情報クラス, 戻り値: 戻り値クラス?): 戻り値クラス? {
        return 戻り値
    }

    /**
     *
     */
    fun 指定された手続きが実装されているか(
        手続きパス: 手続きパスクラス
    ): Boolean {
        return 手続きメソッド集積庫.指定された手続きメソッドが格納されているか(手続きパス)
    }

    /**
     *
     */
    fun 手続きを処理する(
        手続き実行情報: 手続き実行情報クラス
    ): 戻り値クラス? {
        val 手続きパス = 手続き実行情報.対象手続き情報を返す().手続きパスを返す()

        val 手続きメソッド情報: 手続きメソッド情報クラス = 手続きメソッド集積庫.手続きメソッド情報を取得する(手続きパス)
            ?: 例外をスローする(メッセージID一覧.BAS_E_0007,
                手続きパス.手続きコード,
                手続きパス.手続き補助コード,
                手続きパス.手続き補助コード2)

        val 手続きメソッドデータ: 手続きメソッドデータクラス = 手続きメソッド情報.データオブジェクトに変換する()

        手続き実行情報.手続き処理種別を調整する(手続きメソッドデータ)

        return when (手続きメソッドデータ.処理種別.手続き種別) {
            検索 -> {
                読込専用トランザクションで実行する(手続き実行情報, 手続きメソッドデータ.メソッド)
            }
            更新 -> {
                更新可能トランザクションで実行する(手続き実行情報, 手続きメソッドデータ.メソッド)
            }
            その他 -> {
                トランザクションなしで手続きを実行する(手続き実行情報, 手続きメソッドデータ.メソッド)
            }
            不明 -> {
                例外をスローする(
                    メッセージID一覧.BAS_E_0031,
                    手続き実行情報.コントローラ名称を返す(),
                    手続きパス.手続きコード,
                    手続きパス.手続き補助コード,
                    手続きパス.手続き補助コード2
                )
            }
        }

    }
}