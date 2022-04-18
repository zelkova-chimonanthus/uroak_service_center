package name.uroak.uroak_service_center.base.controllers

import name.uroak.uroak_service_center.base.core.基盤処理実行体クラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.shared.base.util.コントローラ情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.Uroakサービスエラークラス
import name.uroak.uroak_service_center.shared.util.core.DIコンポーネント検索クラス
import name.uroak.uroak_service_center.shared.util.log.ログ
import name.uroak.uroak_service_center.sysad.services.実行権限チェックサービスクラス
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/**
 * 全ての入り口となるコントローラ
 */
@RestController
@RequestMapping("/procedure")
class Uroakサービスセンターコントローラクラス : 基盤処理実行体クラス {

    /**
     *
     */
    private data class コントローラマップクラス(
        /**コントローラ情報*/
        var コントローラ情報: コントローラ情報クラス,
        /**コントローラクラス*/
        var コントローラ: コントローラクラス?
    )

    /***/
    @Autowired
    private lateinit var DIコンポーネント検索係: DIコンポーネント検索クラス

    /***/
    @Autowired
    private lateinit var 実行権限管理サービス: 実行権限チェックサービスクラス

    /***/
    private val コントローラ検索マップ: Map<String, コントローラマップクラス> by lazy {
        準備を行う()
    }

    /**
     *
     */
    constructor() : super("Uroakサービスセンターコントローラ")

    /**
     * コントローラオブジェクトを集めて保持する
     */
    private fun 準備を行う(): Map<String, コントローラマップクラス> {
        return try {

            ログ.情報ログを出力する(this.javaClass, "Uroakサービスセンターコントローラの準備処理を実行します")

            val コントローラ情報セット = 実行権限管理サービス.コントローラ情報を収集する()

            ログ.情報ログを出力する(this.javaClass, "コントローラ情報を収集しました。コントローラ数：" + コントローラ情報セット.size)

            with(mutableMapOf<String, コントローラマップクラス>()) {
                if (コントローラ情報セット.isNotEmpty()) {
                    コントローラ情報セット.forEach {

                        val コントローラ情報 = コントローラ情報クラス(it)
                        val コントローラデータ = コントローラ情報.コントローラデータを返す()

                        ログ.情報ログを出力する(this.javaClass, "コントローラ情報を登録します。コントローラクラス名：" + コントローラ情報.パッケージ付きのクラス名を取得する())

                        this[コントローラデータ.URLパス] = コントローラマップクラス(
                            コントローラ情報 = コントローラ情報,
                            コントローラ = DIコンポーネント検索係.DIコンポーネントを取得する<コントローラクラス>(コントローラデータ.DIコンポーネント名)
                        )
                    }
                }
                return this
            }
        } catch (ビーン検索例外: NoSuchBeanDefinitionException) {
            システムエラーを処理する(
                ビーン検索例外,
                "コントローラ管理テーブルに登録されているDIコンポネント名が付与されているコントローラクラスがありません。DIコンポネント名（@RestControllerのvalueで設定）：" + ビーン検索例外.beanName
            )
        } catch (例外: Throwable) {
            システムエラーを処理する(例外, "コントローラマップの準備作業の際にエラーが発生しました。")
        }
    }

    /**
     *
     */
    @RequestMapping(
        // POSTメソッド
        method = [RequestMethod.POST],
        // パラメータはJSON形式のみ対応
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        // リクエストのパス
        path = [
            "/{コントローラパス}/{手続きコード}",
            "/{コントローラパス}/{手続きコード}/{手続き補助コード}",
            "/{コントローラパス}/{手続きコード}/{手続き補助コード}/{手続き補助コード2}"
        ],
        // 戻り値はJSON形式
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun 手続きを処理する(
        @RequestHeader(name = "X-UROAK-AUTHKEYSTR", required = true) ユーザトークン: String,
        @RequestBody(required = false) POSTデータ: String?,
        @PathVariable("コントローラパス") コントローラパス: String,
        @PathVariable("手続きコード") 手続きコード: String,
        @PathVariable("手続き補助コード") 手続き補助コード: String?,
        @PathVariable("手続き補助コード2") 手続き補助コード2: String?
    ): String {

        ログ.情報ログを出力する(
            this.javaClass,
            "リクエスト受信",
            "リクエストを受信しました。コントローラパス：%s、手続きコード：%s、手続き補助コード：%s、手続き補助コード2：%s",
            コントローラパス, 手続きコード, 手続き補助コード, 手続き補助コード2
        )

        return try {
            val コントローラマップデータ = コントローラ検索マップ[コントローラパス] ?: 例外をスローする(メッセージID一覧.BAS_E_0001, コントローラパス)

            return (コントローラマップデータ.コントローラ ?: 例外をスローする(メッセージID一覧.BAS_E_0002, コントローラパス))
                .手続きを実行する(
                    ユーザトークン,
                    コントローラマップデータ.コントローラ情報,
                    手続きパスクラス(手続きコード, 手続き補助コード ?: "", 手続き補助コード2 ?: ""),
                    POSTデータ
                )
        } catch (例外: Throwable) {
            システムエラーを処理する(例外, "依頼された手続きを処理している中でエラーが発生しました。")
        }
    }
}