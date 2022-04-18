package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す

/**
 *
 */
enum class 手続き実行種別一覧 {
    /**検索系API*/
    検索(1),

    /**登録・更新・論理削除系API*/
    登録_更新_論理削除(2),

    /**物理削除系API*/
    物理削除(3),

    /***/
    インポート(4),

    /***/
    エクスポート(5),

    /***/
    その他(6),

    /**API実行前に発生したエラーによる終了の場合などに使用*/
    システムエラー(100),

    /***/
    無効(-1);

    /***/
    val 値: Int

    companion object {
        @JvmStatic
        fun 列挙定数に変換する(値: Int): 手続き実行種別一覧? {
            return 値に対応する列挙定数を返す(
                値,
                手続き実行種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.値 }),
                無効
            )
        }
    }

    /**
     *
     */
    constructor(値: Int) {
        this.値 = 値
    }
}

