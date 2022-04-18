package name.uroak.uroak_service_center.shared.base.core

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.log.ログ

/**
 * ログ出力可能な実行体の親クラス（汎用）
 */
abstract class ログ可能な実行体クラス {
    /***/
    private val 名前: String


    /**
     *
     */
    constructor(名前: String) {
        this.名前 = 名前
    }

    /**
     *
     */
    constructor() : this("名前なし") {
    }

    /**
     *
     */
    protected fun 実行ログを出力する(メッセージ: String) {
        ログ.情報ログを出力する(this.javaClass, 名前, メッセージ)
    }

    /**
     *
     */
    protected fun 実行ログを出力する(メッセージ: String, vararg 引数: Any) {
        if (!ログ.情報ログは出力されるか()) return
        ログ.情報ログを出力する(this.javaClass, 名前, String.format(メッセージ, *引数))
    }

    /**
     *デバグレベルのメッセージを出力する
     */
    protected fun デバグログを出力する(メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.デバグログを出力する(this.javaClass, 名前, メッセージID, *パラメータ)
    }

    /**
     *情報レベルのメッセージを出力する
     */
    protected fun 情報ログを出力する(メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.情報ログを出力する(this.javaClass, 名前, メッセージID, *パラメータ)
    }

    /**
     *警告レベルのメッセージを出力する
     */
    protected fun 警告ログを出力する(メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.警告ログを出力する(this.javaClass, 名前, メッセージID, *パラメータ)
    }

    /**
     *エラーレベルのメッセージを出力する
     */
    protected fun エラーログを出力する(メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.エラーログを出力する(this.javaClass, 名前, メッセージID, *パラメータ)
    }

    /**
     *デバグレベルのメッセージを出力する
     */
    protected fun デバグログを出力する(エラーオブジェクト: Throwable, メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.デバグログを出力する(this.javaClass, エラーオブジェクト, 名前, メッセージID, *パラメータ)
    }

    /**
     *情報レベルのメッセージを出力する
     */
    protected fun 情報ログを出力する(エラーオブジェクト: Throwable, メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.情報ログを出力する(this.javaClass, エラーオブジェクト, 名前, メッセージID, *パラメータ)
    }

    /**
     *警告レベルのメッセージを出力する
     */
    protected fun 警告ログを出力する(エラーオブジェクト: Throwable, メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.警告ログを出力する(this.javaClass, エラーオブジェクト, 名前, メッセージID, *パラメータ)
    }

    /**
     *エラーレベルのメッセージを出力する
     */
    protected fun エラーログを出力する(エラーオブジェクト: Throwable, メッセージID: メッセージID一覧, vararg パラメータ: Any) {
        ログ.エラーログを出力する(this.javaClass, エラーオブジェクト, 名前, メッセージID, *パラメータ)
    }
}