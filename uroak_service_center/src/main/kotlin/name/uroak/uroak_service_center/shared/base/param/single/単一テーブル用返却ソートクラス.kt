package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.util.extension.マップ配列を取得する_空配列

/**
 *
 */
class 単一テーブル用返却ソートクラス : 手続きパラメータ共通クラス() {
    /***/
    private var 返却ソート指定配列: List<単一テーブル用返却ソート指定クラス> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()

        マップ.マップ配列を取得する_空配列(リクエストフィールド名.単一テーブル_ソート指定一覧).forEach {
            if (it != null) {
                返却ソート指定配列 += 単一テーブル用返却ソート指定クラス().apply {
                    this.パラメータからデータをセットする(it)
                }
            }
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        返却ソート指定配列 = mutableListOf()
    }

    /**
     *
     */
    fun 返却ソート指定配列を返す() = 返却ソート指定配列
}
