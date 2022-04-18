package name.uroak.uroak_service_center.sysad.utils

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す

/**
 * 会員グループのメンバーに設定可能な種別の一覧
 *  「会員」、「会員目録」、「会員グループ」、「不明」
 */
enum class 会員メンバー種別一覧 {
    /***/
    会員(1),

    /***/
    会員目録(2),

    /***/
    会員グループ(3),

    /***/
    不明(-1);

    /***/
    private val JSON値: Int

    /**
     *
     */
    constructor(JSON値: Int) {
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
        fun JSONフィールド値を列挙定数に変換する(JSON値: Int?): 会員メンバー種別一覧 {
            return 値に対応する列挙定数を返す(
                JSON値,
                会員メンバー種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON値 }),
                不明
            ) as 会員メンバー種別一覧
        }
    }
}

