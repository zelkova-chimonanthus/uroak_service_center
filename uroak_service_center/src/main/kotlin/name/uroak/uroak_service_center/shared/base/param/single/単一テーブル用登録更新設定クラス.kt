package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.extension.マップを取得する

/**
 *
 */
class 単一テーブル用登録更新設定クラス : 手続きパラメータ共通クラス() {
    /***/
    private var 登録更新項目配列: List<単一テーブル用登録更新項目クラス> = mutableListOf()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val パラメータ = マップ.マップを取得する(リクエストフィールド名.単一テーブル_登録更新項目一覧)

        パラメータ ?: エラーをスローする(メッセージID一覧.BAS_E_0021, リクエストフィールド名.単一テーブル_登録更新項目一覧)

        パラメータ.keys.forEach {
            登録更新項目配列 += 単一テーブル用登録更新項目クラス(it, マップ[it])
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        登録更新項目配列 = mutableListOf()
    }

    /**
     *
     */
    fun 登録更新項目配列を返す() = 登録更新項目配列
}
