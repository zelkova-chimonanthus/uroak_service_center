package name.uroak.uroak_service_center.shared.error.exception

import name.uroak.uroak_service_center.shared.base.ret.エラー情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.constants.共有定数
import name.uroak.uroak_service_center.shared.util.log.メッセージ集積庫
import name.uroak.uroak_service_center.shared.util.log.ログ
import java.lang.Exception

/**
 * 例外クラスの共通親クラス
 */
abstract class Uroakサービスエラークラス : Exception {

    companion object {
        /**
         *
         */
        @JvmStatic
        fun メッセージを編集する(ログ出力クラス: Class<Any>, メッセージID: メッセージID一覧?, タイトル: String, パラメータ: Array<out Any?>): String {
            val 出力クラス名 = 共有定数.共通のパッケージ階層を除去したクラス名を返す(ログ出力クラス)

            val 出力メッセージ =
                if (メッセージID == null)
                    ""
                else
                    メッセージ集積庫.メッセージを編集する(メッセージID as メッセージID一覧, *パラメータ)

            return String.format(ログ.ログ書式1, 出力クラス名, タイトル, 出力メッセージ)
        }
    }

    /***/
    private var ログ出力クラス: Class<Any>

    /***/
    private var 原因となる例外: Throwable?

    /***/
    private var タイトル: String = ""

    /***/
    private var メッセージID: メッセージID一覧?

    /***/
    private var パラメータ: Array<out Any?>

    /***/
    private var エラー情報: エラー情報クラス?

    /**
     *
     */
    init {
        this.エラー情報 = null
    }

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        原因となる例外: Throwable?,
        エラー情報: エラー情報クラス?,
        メッセージID: メッセージID一覧?,
        vararg パラメータ: Any?
    ) : super(メッセージを編集する(ログ出力クラス, メッセージID, タイトル, パラメータ), 原因となる例外) {
        this.タイトル = タイトル
        this.ログ出力クラス = ログ出力クラス
        this.原因となる例外 = 原因となる例外
        this.エラー情報 = エラー情報
        this.メッセージID = メッセージID
        this.パラメータ = パラメータ
    }

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        原因となる例外: Throwable,
        メッセージID: メッセージID一覧,
        vararg パラメータ: Any?
    ) :
            this(
                タイトル, ログ出力クラス, 原因となる例外, null, メッセージID, *パラメータ
            )

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        原因となる例外: Throwable,
        メッセージID: メッセージID一覧
    ) :
            this(
                タイトル, ログ出力クラス, 原因となる例外, null, メッセージID
            )

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        メッセージID: メッセージID一覧,
        vararg パラメータ: Any?
    ) :
            this(
                タイトル, ログ出力クラス, null, null, メッセージID, *パラメータ
            )

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        メッセージID: メッセージID一覧
    ) :
            this(
                タイトル, ログ出力クラス, null, null, メッセージID
            )

    /**
     *
     */
    constructor(
        タイトル: String,
        ログ出力クラス: Class<Any>,
        エラー情報: エラー情報クラス
    ) :
            this(
                タイトル, ログ出力クラス, null, エラー情報, null
            )

    /**
     *
     */
    override fun toString(): String {
        return 文字列化する()
    }

    /**
     *
     */
    fun 文字列化する(): String {
        return メッセージを編集する(ログ出力クラス, メッセージID, タイトル, パラメータ)
    }

    /**
     *
     */
    fun ログに出力する() {
        if (エラー情報 != null) {
            ログ.エラーログを出力する(ログ出力クラス, タイトル, エラー情報 as エラー情報クラス)
        } else if (原因となる例外 == null) {
            if (パラメータ == null) {
                ログ.エラーログを出力する(ログ出力クラス, タイトル, メッセージID as メッセージID一覧)
            } else {
                ログ.エラーログを出力する(ログ出力クラス, タイトル, メッセージID as メッセージID一覧, *パラメータ)
            }
        } else {
            if (パラメータ == null) {
                ログ.エラーログを出力する(ログ出力クラス, 原因となる例外 as Throwable, タイトル, メッセージID as メッセージID一覧)
            } else {
                ログ.エラーログを出力する(ログ出力クラス, 原因となる例外 as Throwable, タイトル, メッセージID as メッセージID一覧, *パラメータ)
            }
        }
    }

}