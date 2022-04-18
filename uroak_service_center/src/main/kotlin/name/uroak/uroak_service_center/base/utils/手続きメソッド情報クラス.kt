package name.uroak.uroak_service_center.base.utils

import name.uroak.uroak_service_center.shared.base.execution.手続きメソッドの仕様に一致しているかチェックする
import name.uroak.uroak_service_center.shared.base.util.手続きメソッドデータクラス
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import java.lang.reflect.Method

/**
 *
 */
class 手続きメソッド情報クラス {
    /***/
    private var 手続きコード: String? = null
        set(値) {
            field = 文字列道具箱.前後の空白を削除し_空ならnullで返す(値)
        }
        get() {
            return field
        }

    /***/
    private var 手続き補助コード: String? = null
        set(値) {
            field = 文字列道具箱.前後の空白を削除し_空ならnullで返す(値)
        }

    /***/
    private var 手続き補助コード2: String? = null
        set(値) {
            field = 文字列道具箱.前後の空白を削除し_空ならnullで返す(値)
        }

    /***/
    private var 処理種別: 手続き処理種別一覧? = null
        set(値) {
            field = 値 ?: 手続き処理種別一覧.不明
        }

    /***/
    private var メソッド: Method? = null
        set(値) {
            try {
                手続きメソッドの仕様に一致しているかチェックする(値)
            } catch (例外: Throwable) {
                throw 基盤処理エラークラス(this.javaClass, 例外, メッセージID一覧.BAS_E_0006, (値?.name) ?: "<null>")
            }
            field = 値
        }

    /**
     *
     */
    constructor(
        手続きコード: String? = null,
        手続き補助コード: String? = null,
        手続き補助コード2: String? = null,
        処理種別: 手続き処理種別一覧? = null,
        メソッド: Method? = null
    ) {
        this.手続きコード = 手続きコード
        this.手続き補助コード = 手続き補助コード
        this.手続き補助コード2 = 手続き補助コード2
        this.処理種別 = 処理種別
        this.メソッド = メソッド
    }

    /**
     *
     */
    fun キー文字列を作成する(): String {
        return 手続きメソッドキー文字列を作成する(手続きコード, 手続き補助コード, 手続き補助コード2)
    }

    /**
     *
     */
    fun データオブジェクトに変換する(): 手続きメソッドデータクラス {
        return 手続きメソッドデータクラス(
            手続きコード,
            手続き補助コード,
            手続き補助コード2,
            処理種別 as 手続き処理種別一覧,
            メソッド as Method
        )
    }
}
