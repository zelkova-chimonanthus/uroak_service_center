package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.手続きパラメータ共通クラス
import name.uroak.uroak_service_center.shared.base.util.ソート種別一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する

/**
 *
 */
class 単一テーブル用返却ソート指定クラス : 手続きパラメータ共通クラス() {
    /***/
    private var カラム名: String = ""

    /***/
    private var ソート種別: ソート種別一覧 = ソート種別一覧.不明

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        val キーセット = マップ.keys
        when (キーセット.size) {
            0 -> {
                エラーをスローする(メッセージID一覧.BAS_E_0018, リクエストフィールド名.単一テーブル_ソート指定一覧)
            }
            1 -> {
                val キー名 = キーセット.single()
                val 値 = マップ.文字列値で取得する(キー名)
                ソート種別 =
                    if (値 == null)
                        ソート種別一覧.昇順
                    else {
                        ソート種別一覧.JSONフィールド値を列挙定数に変換する(値).apply {
                            if (this == ソート種別一覧.不明)
                                エラーをスローする(メッセージID一覧.BAS_E_0016, 値)
                            this
                        }
                    }
                カラム名 = キー名
            }
            else -> {
                エラーをスローする(メッセージID一覧.BAS_E_0019, リクエストフィールド名.単一テーブル_ソート指定一覧)
            }
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        カラム名 = ""
        ソート種別 = ソート種別一覧.不明
    }

    /**
     *
     */
    fun カラム名を返す() = カラム名

    /**
     *
     */
    fun ソート種別を返す() = ソート種別

}

