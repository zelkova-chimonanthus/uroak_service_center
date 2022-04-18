package name.uroak.uroak_service_center.shared.base.param

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.param.single.単一テーブル用CSVデータクラス
import name.uroak.uroak_service_center.shared.base.param.single.単一テーブル用条件クラス
import name.uroak.uroak_service_center.shared.base.param.single.単一テーブル用登録更新設定クラス
import name.uroak.uroak_service_center.shared.base.param.single.単一テーブル用返却項目設定クラス
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する_空文字列

/**
 *
 */
class 単一テーブル用パラメータデータクラス : 手続きパラメータ共通クラス() {
    /***/
    private var テーブル名: String = ""

    /***/
    private var 単一テーブル用条件: 単一テーブル用条件クラス = 単一テーブル用条件クラス()

    /***/
    private var 単一テーブル用返却項目設定: 単一テーブル用返却項目設定クラス = 単一テーブル用返却項目設定クラス()

    /***/
    private var 単一テーブル用登録更新項目設定: 単一テーブル用登録更新設定クラス = 単一テーブル用登録更新設定クラス()

    /***/
    private var 単一テーブル用CSVデータ: 単一テーブル用CSVデータクラス = 単一テーブル用CSVデータクラス()

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {
        テーブル名 = マップ.文字列値で取得する_空文字列(リクエストフィールド名.単一テーブル_対象テーブル名)
        単一テーブル用条件.パラメータからデータをセットする(マップ)
        単一テーブル用返却項目設定.パラメータからデータをセットする(マップ)
        単一テーブル用登録更新項目設定.パラメータからデータをセットする(マップ)
        単一テーブル用CSVデータ.パラメータからデータをセットする(マップ)
    }

    /**
     *
     */
    override fun 解析結果をクリアする() {
        テーブル名 = ""
        単一テーブル用条件 = 単一テーブル用条件クラス()
        単一テーブル用返却項目設定 = 単一テーブル用返却項目設定クラス()
        単一テーブル用登録更新項目設定 = 単一テーブル用登録更新設定クラス()
        単一テーブル用CSVデータ = 単一テーブル用CSVデータクラス()
    }

    /**
     *
     */
    fun テーブル名を返す() = テーブル名

    /**
     *
     */
    fun 単一テーブル用条件を返す() = 単一テーブル用条件


    /**
     *
     */
    fun 単一テーブル用返却項目設定を返す() = 単一テーブル用返却項目設定


    /**
     *
     */
    fun 単一テーブル用登録更新項目設定を返す() = 単一テーブル用登録更新項目設定


    /**
     *
     */
    fun 単一テーブル用CSVデータを返す() = 単一テーブル用CSVデータ
}