package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す

enum class 集合関数一覧 {
    平均値("AVG"),
    行数("COUNT"),
    値数("COUNT_DISTINCT"),
    文字列連結("GROUP_CONCAT"),
    最大値("MAX"),
    最小値("MIN"),
    母標準偏差("STDDEV_POP"),
    標本標準偏差("STDDEV_SAMP"),
    集計("SUM"),
    母標準分散("VAR_POP"),
    標本分散("VAR_SAMP"),
    不明("");

    private val JSON文字列値: String

    constructor(JSON文字列値: String) {
        this.JSON文字列値 = JSON文字列値
    }

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String?): 集合関数一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                集合関数一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON文字列値 }),
                不明
            ) as 集合関数一覧
        }
    }
}

