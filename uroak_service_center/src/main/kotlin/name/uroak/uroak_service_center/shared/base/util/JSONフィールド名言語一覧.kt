package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す

/**
 *
 */
enum class JSONフィールド名言語一覧 {
    /***/
    英語(0, "english", "英語"),

    /***/
    日本語(1, "japanese", "日本語"),

    /***/
    不明(-1, "", "");

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String): JSONフィールド名言語一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                JSONフィールド名言語一覧::class.java,
                ({ 列挙定数, 比較対象値 ->
                    when (比較対象値) {
                        列挙定数.JSON文字列値e -> true
                        列挙定数.JSON文字列値j -> true
                        else -> false
                    }
                }),
                不明
            ) as JSONフィールド名言語一覧
        }
    }

    /***/
    private val JSON文字列値e: String

    /***/
    private val JSON文字列値j: String

    /***/
    val 位置: Int

    /**
     *
     */
    constructor(位置: Int, JSON文字列値e: String, JSON文字列値j: String) {
        this.位置 = 位置
        this.JSON文字列値e = JSON文字列値e
        this.JSON文字列値j = JSON文字列値j
    }
}
