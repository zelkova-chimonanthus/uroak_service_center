package name.uroak.uroak_service_center.shared.error.exception

import name.uroak.uroak_service_center.shared.base.ret.エラー情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧

/**
 * システム状態管理でスローする例外
 */
class システム状態確認エラークラス : Uroakサービスエラークラス {
    companion object {
        /***/
        const val タイトル = "システム状態管理エラー"
    }

    /**
     *
     */
    constructor(
        ログ出力クラス: Class<Any>,
        原因となる例外: Throwable,
        メッセージID: メッセージID一覧,
        vararg パラメータ: Any?
    ) :
            super(
                タイトル, ログ出力クラス, 原因となる例外, メッセージID, *パラメータ
            )

    /**
     *
     */
    constructor(
        ログ出力クラス: Class<Any>,
        原因となる例外: Throwable,
        メッセージID: メッセージID一覧
    ) :
            super(
                タイトル, ログ出力クラス, 原因となる例外, メッセージID
            )

    /**
     *
     */
    constructor(
        ログ出力クラス: Class<Any>,
        メッセージID: メッセージID一覧,
        vararg パラメータ: Any?
    ) :
            super(
                タイトル, ログ出力クラス, メッセージID, *パラメータ
            )

    /**
     *
     */
    constructor(
        ログ出力クラス: Class<Any>,
        メッセージID: メッセージID一覧
    ) :
            super(
                タイトル, ログ出力クラス, メッセージID
            )

    /**
     *
     */
    constructor(
        ログ出力クラス: Class<Any>,
        エラー情報: エラー情報クラス
    ) :
            super(
                タイトル, ログ出力クラス, エラー情報
            )

}