package name.uroak.uroak_service_center.sysad.utils

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す

/**
 * 実行権限の利用対象側に設定可能な種別の一覧
 * 「手続き」、「手続き目録」、「手続きグループ」、「不明」
 */
enum class 実行権限利用対象種別一覧 {
    /***/
    手続き(1),

    /***/
    手続き目録(2),

    /***/
    手続きグループ(3),

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
    fun JSON値を返す() = JSON値

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON値: Int?): 実行権限利用対象種別一覧 {
            return 値に対応する列挙定数を返す(
                JSON値,
                実行権限利用対象種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON値 }),
                不明
            ) as 実行権限利用対象種別一覧
        }
    }
}