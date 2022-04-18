package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.base.util.CSVデータ形式種別一覧
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱

/**
 *
 */
class 単一テーブル用CSVデータクラス : 手続きパラメータ共通クラス() {
    /***/
    private var CSVデータ: String = ""

    /***/
    private var CSVデータ形式: CSVデータ形式種別一覧 = CSVデータ形式種別一覧.不明

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()

        val 解析結果 =
            CSVフィールドの内容を解析する(マップ, リクエストフィールド名.単一テーブル_CSV, リクエストフィールド名.単一テーブル_CSV_形式, リクエストフィールド名.単一テーブル_CSV_データ) ?: return
        CSVデータ形式 = 解析結果.CSVデータ形式
        CSVデータ = 解析結果.CSVデータ
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        CSVデータ = ""
        CSVデータ形式 = CSVデータ形式種別一覧.不明
    }

    /**
     *
     */
    fun CSVデータを返す() = CSVデータ

    /**
     *
     */
    fun CSVデータが空か() = 文字列道具箱.空文字列か(CSVデータ)
}

