package name.uroak.uroak_service_center.base.core

import name.uroak.uroak_service_center.shared.base.core.ログ可能な実行体クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.Uroakサービスエラークラス
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス
import name.uroak.uroak_service_center.shared.error.exception.実行権限チェックエラークラス
import name.uroak.uroak_service_center.shared.error.exception.実行権限管理エラークラス

/**
 * 基盤処理エラーをスローするので、基盤処理関連の実行体の親クラスとしてのみ使用可能
 */
abstract class 基盤処理実行体クラス : ログ可能な実行体クラス {
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
    protected fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any?): Nothing {
        throw 基盤処理エラークラス(this.javaClass, メッセージID, *パラメータ)
    }

    /**
     * システムエラーを受け取ってエラーログを出力し、代わりに単なるシステムエラー発生の例外をスローする
     */
    protected fun システムエラーを処理する(システムエラー: Throwable, エラーメッセージ: String): Nothing {
        val メッセージ =
            if (システムエラー is Uroakサービスエラークラス) {
                エラーメッセージ + "\n" + システムエラー.文字列化する()
            } else {
                エラーメッセージ
            }

        // システム障害の詳細はログにのみ記録しておく
        if (システムエラー is Uroakサービスエラークラス) {
            システムエラー.ログに出力する()
        }
        エラーログを出力する(システムエラー, メッセージID一覧.CMN_E_0002, メッセージ)

        when (システムエラー) {
            is 基盤処理エラークラス -> {
                // システム障害の詳細を外部に広報しないために、詳細を明らかにしない単なるシステムエラーに置き換えておく
                例外をスローする(メッセージID一覧.CMN_E_0001)
            }
            is 実行権限チェックエラークラス -> {
                例外をスローする(メッセージID一覧.CMN_E_0002, "実行対象手続きを実行できる権限がありません。")
            }
            is 実行権限管理エラークラス -> {
                // システム障害の詳細を外部に広報しないために、詳細を明らかにしない単なるシステムエラーに置き換えておく
                例外をスローする(メッセージID一覧.CMN_E_0001)
            }
            is Uroakサービスエラークラス -> {
                throw システムエラー
            }
            else -> {
                // システム障害の詳細を外部に広報しないために、詳細を明らかにしない単なるシステムエラーに置き換えておく
                例外をスローする(メッセージID一覧.CMN_E_0001)
            }
        }
    }

}