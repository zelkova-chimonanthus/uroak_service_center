package name.uroak.uroak_service_center.shared.base.param

import name.uroak.uroak_service_center.shared.base.param.multiple.汎用CSVデータクラス
import name.uroak.uroak_service_center.shared.base.param.multiple.汎用条件クラス
import name.uroak.uroak_service_center.shared.base.param.multiple.汎用登録更新クラス

/**
 *
 */
class 汎用パラメータデータクラス : 手続きパラメータ共通クラス() {
    /***/
    private var 条件パラメータ: 汎用条件クラス = 汎用条件クラス()

    /***/
    private var 登録更新パラメータ: 汎用登録更新クラス = 汎用登録更新クラス()

    /***/
    private var CSVデータ: 汎用CSVデータクラス = 汎用CSVデータクラス()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        条件パラメータ.パラメータからデータをセットする(マップ)
        登録更新パラメータ.パラメータからデータをセットする(マップ)
        CSVデータ.パラメータからデータをセットする(マップ)
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        条件パラメータ = 汎用条件クラス()
        登録更新パラメータ = 汎用登録更新クラス()
        CSVデータ = 汎用CSVデータクラス()
    }

    /**
     *
     */
    fun 条件パラメータを返す() = 条件パラメータ


    /**
     *
     */
    fun 登録更新パラメータを返す() = 登録更新パラメータ


    /**
     *
     */
    fun CSVデータを返す() = CSVデータ

}