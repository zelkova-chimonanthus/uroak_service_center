package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.util.extension.配列を取得する_空配列
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱

/**
 *
 */
class 単一テーブル用返却グルーピングクラス : 手続きパラメータ共通クラス() {
    /***/
    private var グルーピングカラム名配列: List<String> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val 名称配列 = mutableListOf<String>()
        マップ.配列を取得する_空配列(リクエストフィールド名.単一テーブル_グルーピング指定一覧).forEach {
            val 名称 = it as String
            if (!文字列道具箱.空白文字列か(名称))
                名称配列 += 名称
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        グルーピングカラム名配列 = mutableListOf()
    }

    /**
     *
     */
    fun グルーピングカラム名配列を返す() = グルーピングカラム名配列
}

