package name.uroak.uroak_service_center.shared.base.param.multiple

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.util.extension.コピーを作成する
import name.uroak.uroak_service_center.shared.util.extension.マップを取得する_空マップ

/**
 *
 */
class 汎用条件クラス : 手続きパラメータ共通クラス() {
    /***/
    private var フィールドマップ: Map<String, Any?> = mutableMapOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        フィールドマップ = マップ.マップを取得する_空マップ(リクエストフィールド名.条件一覧)
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        フィールドマップ = mutableMapOf()
    }

    /**
     * 条件パラメータマップのコピーを返す
     */
    fun 条件パラメータを返す(): Map<String, Any?> {
        return フィールドマップ.コピーを作成する()
    }
}
