package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.base.constants.レスポンスフィールド名
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス

/**
 *
 */
class 物理削除系戻り値クラス : 戻り値クラス {

    /***/
    private var 削除件数 = 0

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス) : super(手続き実行種別一覧.物理削除, 手続き実行情報)

    /**
     *
     */
    fun 削除件数をセットする(削除件数: Int?): 物理削除系戻り値クラス {
        this.削除件数 = 削除件数 ?: 0
        return this
    }

    /**
     *
     */
    override fun 各APIの返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        返却値[名称を返す(レスポンスフィールド名.削除件数)] = 削除件数

        return 返却値
    }
}