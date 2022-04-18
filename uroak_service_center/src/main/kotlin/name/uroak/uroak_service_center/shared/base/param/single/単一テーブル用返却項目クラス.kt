package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.extension.マップを取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する

/**
 *
 */
class 単一テーブル用返却項目クラス : 手続きパラメータ共通クラス() {
    /***/
    private var 返却カラム配列: List<単一テーブル用返却カラム指定クラス> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val パラメータ = マップ.マップを取得する(リクエストフィールド名.単一テーブル_返却カラム)

        パラメータ ?: エラーをスローする(メッセージID一覧.BAS_E_0017, リクエストフィールド名.単一テーブル_返却カラム)

        パラメータ.keys.forEach {
            返却カラム配列 += 単一テーブル用返却カラム指定クラス(it, マップ.文字列値で取得する(it))
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        返却カラム配列 = mutableListOf()
    }

    /**
     *
     */
    fun 返却カラム配列を返す() = 返却カラム配列
}
