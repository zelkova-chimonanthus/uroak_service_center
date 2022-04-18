package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.base.util.比較演算子一覧

/**
 *
 */
class 単一テーブル用条件カラム指定クラス : 手続きパラメータ共通クラス() {
    /***/
    private var カラム名: String = ""

    /***/
    private var 比較演算子: 比較演算子一覧 = 比較演算子一覧.不明

    /***/
    private var 比較対象値: List<Any?> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val 条件指定データ = マップから条件指定データをセットする(マップ, リクエストフィールド名.単一テーブル_条件一覧)
        カラム名 = 条件指定データ.カラム名
        比較対象値 = 条件指定データ.比較対象値
        比較演算子 = 条件指定データ.比較演算子
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        カラム名 = ""
        比較演算子 = 比較演算子一覧.不明
        比較対象値 = mutableListOf<Any?>()
    }

    /**
     *
     */
    fun カラム名を返す() = カラム名

    /**
     *
     */
    fun 比較演算子を返す() = 比較演算子

    /**
     *
     */
    fun 比較対象値を返す() = 比較対象値
}
