package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス

/**
 *
 */
class インポート系戻り値クラス : 戻り値クラス {
    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス) : super(手続き実行種別一覧.インポート, 手続き実行情報)

    /**
     *
     */
    override fun 各APIの返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        return 返却値
    }
}