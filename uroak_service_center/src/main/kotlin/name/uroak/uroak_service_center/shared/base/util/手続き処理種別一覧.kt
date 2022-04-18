package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す
import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す


/**
 * 手続きメソッドをカテゴリー別に分けた区分
 */
enum class 手続き処理種別一覧 {

    /***/
    検索(1, "select", "検索", 手続きトランザクション種別一覧.検索),

    /***/
    登録(2, "register", "登録", 手続きトランザクション種別一覧.更新),

    /***/
    更新(3, "update", "更新", 手続きトランザクション種別一覧.更新),

    /***/
    登録_更新(4, "register_update", "登録_更新", 手続きトランザクション種別一覧.更新),

    /***/
    論理削除(5, "logical_delete", "論理削除", 手続きトランザクション種別一覧.更新),

    /***/
    物理削除(6, "delete", "物理削除", 手続きトランザクション種別一覧.更新),

    /***/
    インポート(7, "import", "インポート", 手続きトランザクション種別一覧.更新),

    /***/
    エクスポート(8, "export", "エクスポート", 手続きトランザクション種別一覧.検索),

    /***/
    その他(9, "other", "その他", 手続きトランザクション種別一覧.その他),

    /**対象テーブル構成種別が「テーブル数限定なし」の場合に一時的に設定される*/
    未定(-1, "", "", 手続きトランザクション種別一覧.不明),

    /***/
    不明(-2, "", "", 手続きトランザクション種別一覧.不明);

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String?): 手続き処理種別一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                手続き処理種別一覧::class.java,
                ({ 列挙定数, 比較対象値 ->
                    if (列挙定数.カラム値 < 0)
                        false
                    else
                        when (比較対象値) {
                            列挙定数.JSON文字列値e -> true
                            列挙定数.JSON文字列値j -> true
                            else -> false
                        }
                }),
                不明
            ) as 手続き処理種別一覧
        }

        @JvmStatic
        fun カラム値を列挙定数に変換する(カラム値: Int?): 手続き処理種別一覧 {
            return 値に対応する列挙定数を返す(
                カラム値,
                手続き処理種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.カラム値 }),
                不明
            ) as 手続き処理種別一覧
        }
    }

    /***/
    val カラム値: Int

    /***/
    private val JSON文字列値e: String

    /***/
    private val JSON文字列値j: String

    /***/
    val 手続き種別: 手続きトランザクション種別一覧

    /**
     *
     */
    constructor(カラム値: Int, JSON文字列値e: String, JSON文字列値j: String, 手続き種別: 手続きトランザクション種別一覧) {
        this.カラム値 = カラム値
        this.JSON文字列値e = JSON文字列値e
        this.JSON文字列値j = JSON文字列値j
        this.手続き種別 = 手続き種別
    }

}
