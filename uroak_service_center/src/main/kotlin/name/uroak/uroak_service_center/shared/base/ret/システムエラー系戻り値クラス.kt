package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名言語一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧

/**
 *
 */
class システムエラー系戻り値クラス : 戻り値クラス {

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス) : super(手続き実行種別一覧.システムエラー, 手続き実行情報)

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス, メッセージID: メッセージID一覧, vararg パラメータ: Any?) : super(手続き実行種別一覧.システムエラー, 手続き実行情報) {
        エラーとする(メッセージID, *パラメータ)
    }

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス, メッセージID: メッセージID一覧) : super(手続き実行種別一覧.システムエラー, 手続き実行情報) {
        エラーとする(メッセージID)
    }

    /**
     *
     */
    constructor(返信言語: JSONフィールド名言語一覧) : super(手続き実行種別一覧.システムエラー, 返信言語)

    /**
     *
     */
    constructor(返信言語: JSONフィールド名言語一覧, メッセージID: メッセージID一覧, vararg パラメータ: Any?) : super(手続き実行種別一覧.システムエラー, 返信言語) {
        エラーとする(メッセージID, *パラメータ)
    }

    /**
     *
     */
    constructor(返信言語: JSONフィールド名言語一覧, メッセージID: メッセージID一覧) : super(手続き実行種別一覧.システムエラー, 返信言語) {
        エラーとする(メッセージID)
    }

    /**
     *
     */
    override fun 各APIの返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        return 返却値
    }
}