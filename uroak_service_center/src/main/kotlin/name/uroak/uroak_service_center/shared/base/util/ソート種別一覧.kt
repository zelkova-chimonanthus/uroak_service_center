package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す

/**
 *
 */
enum class ソート種別一覧 {
    /***/
    昇順("asc", "昇順"),

    /***/
    降順("desc", "降順"),

    /***/
    不明("", "");

    /***/
    private val JSON文字列値e: String

    /***/
    private val JSON文字列値j: String

    /**
     *
     */
    constructor(JSON文字列値e: String, JSON文字列値j: String) {
        this.JSON文字列値e = JSON文字列値e
        this.JSON文字列値j = JSON文字列値j
    }

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String?): ソート種別一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                ソート種別一覧::class.java,
                ({ 列挙定数, 比較対象値 ->
                    when (比較対象値) {
                        列挙定数.JSON文字列値e -> true
                        列挙定数.JSON文字列値j -> true
                        else -> false
                    }
                }),
                不明
            ) as ソート種別一覧
        }
    }
}
