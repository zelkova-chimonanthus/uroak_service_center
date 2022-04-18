package name.uroak.uroak_service_center.stock.utils

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す

enum class 入出金種別一覧 {
    入金(1, 1),
    出金(2, 2),
    不明(-1, -1);

    /***/
    private val DB値: Int

    /***/
    private val JSON値: Int

    constructor(JSON値: Int, DB値: Int) {
        this.DB値 = DB値
        this.JSON値 = JSON値
    }

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON値: Int?): 入出金種別一覧 {
            return 値に対応する列挙定数を返す(
                JSON値,
                入出金種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON値 }),
                入出金種別一覧.不明
            ) as 入出金種別一覧
        }
    }

    fun DB値を返す() = DB値
}