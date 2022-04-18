package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す

enum class 比較演算子一覧 {
    等しい("="),
    等しくない("!="),
    小なり("<"),
    大なり(">"),
    以下("<="),
    以上(">="),
    含まれる("IN"),
    含まれない("NOT_IN"),
    曖昧比較_等しい("LIKE"),
    曖昧比較_等しくない("NOT_LIKE"),
    間("BETWEEN"),
    NULLである("IS_NULL"),
    NULLではない("IS_NOT_NULL"),
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
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String?): 比較演算子一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                比較演算子一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON文字列値 }),
                不明
            ) as 比較演算子一覧
        }
    }

}
