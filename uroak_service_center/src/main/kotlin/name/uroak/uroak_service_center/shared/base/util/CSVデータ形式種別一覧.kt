package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.値に対応する列挙定数を返す
import name.uroak.uroak_service_center.shared.util.tool.文字列値に対応する列挙定数を返す

enum class CSVデータ形式種別一覧 {
    CSV文字列そのまま(1),
    base64エンコーディング(2),
    不明(0);

    /**
     *
     */
    companion object {
        /**
         *
         */
        @JvmStatic
        fun JSONフィールド値を列挙定数に変換する(JSON文字列値: String?): CSVデータ形式種別一覧 {
            return 文字列値に対応する列挙定数を返す(
                JSON文字列値,
                CSVデータ形式種別一覧::class.java,
                ({ 列挙定数 -> 列挙定数.JSON値.toString() }),
                不明
            ) as CSVデータ形式種別一覧
        }
    }

    private val JSON値: Int

    constructor(JSON値: Int) {
        this.JSON値 = JSON値
    }
}