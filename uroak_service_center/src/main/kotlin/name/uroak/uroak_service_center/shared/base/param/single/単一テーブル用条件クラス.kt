package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.util.extension.マップ配列を取得する_空配列

/**
 *
 */
class 単一テーブル用条件クラス : 手続きパラメータ共通クラス() {
    /***/
    private var カラム条件配列: List<単一テーブル用条件カラム指定クラス> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val マップ配列 = マップ.マップ配列を取得する_空配列(リクエストフィールド名.単一テーブル_条件一覧)
        マップ配列.forEach {
            if (it != null) {
                単一テーブル用条件カラム指定クラス().apply {
                    this.パラメータからデータをセットする(it)
                    カラム条件配列 += this
                }
            }
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        カラム条件配列 = mutableListOf()
    }

    /**
     *
     */
    fun カラム条件配列を返す() = カラム条件配列
}
