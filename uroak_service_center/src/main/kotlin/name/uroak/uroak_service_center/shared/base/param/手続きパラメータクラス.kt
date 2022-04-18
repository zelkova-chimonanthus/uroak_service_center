package name.uroak.uroak_service_center.shared.base.param

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.util.対象テーブル構成種別一覧.*
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.tool.JSON道具箱
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱

/**
 * 検索用、更新用など用途別のパラメータクラスの親クラス
 */
class 手続きパラメータクラス : 手続きパラメータ共通クラス() {
    /***/
    private var POSTデータ: String? = null

    /***/
    private var 共通パラメータ: 共通パラメータクラス = 共通パラメータクラス()

    /***/
    private var 単一テーブル用パラメータデータ: 単一テーブル用パラメータデータクラス = 単一テーブル用パラメータデータクラス()

    /***/
    private var 汎用パラメータデータ: 汎用パラメータデータクラス = 汎用パラメータデータクラス()

    /**
     *
     */
    fun クリアする(): Unit {
        POSTデータ = null
        解析結果をクリアする()
    }

    /**
     *
     */
    fun POSTデータをセットして解析する(POSTデータ: String?) {
        POSTデータをセットする(POSTデータ)
        POSTデータを解析する()
    }

    /**
     *
     */
    fun POSTデータをセットする(POSTデータ: String?) {
        クリアする()
        this.POSTデータ = POSTデータ
    }

    /**
     *
     */
    fun POSTデータを解析する() {

        if (文字列道具箱.空白文字列か(POSTデータ)) {
            解析結果をクリアする()
            return
        }

        マップからデータをセットする(JSON道具箱.マップに変換する(POSTデータ as String))
    }

    /**
     *
     */
    override fun マップからデータをセットする(マップ: Map<String, Any?>) {

        共通パラメータ.パラメータからデータをセットする(マップ)

        val パラメータデータ = リクエストフィールド名.パラメータデータ.同名のフィールドをマップで取得する(マップ) ?: エラーをスローする(
            メッセージID一覧.BAS_E_0035,
            リクエストフィールド名.パラメータデータ.フィールド名を文字列化する()
        )

        if (パラメータデータ != null) {
            when (共通パラメータ.対象テーブル構成を返す()) {
                単一テーブル -> 単一テーブル用パラメータデータ.パラメータからデータをセットする(パラメータデータ)
                テーブル数限定なし -> 汎用パラメータデータ.パラメータからデータをセットする(パラメータデータ)
                不明 -> エラーをスローする(メッセージID一覧.BAS_E_0032)
            }
        }
    }

    /**
     *
     */
    override fun 解析結果をクリアする(): Unit {
        共通パラメータ = 共通パラメータクラス()
        単一テーブル用パラメータデータ = 単一テーブル用パラメータデータクラス()
        汎用パラメータデータ = 汎用パラメータデータクラス()
    }

    // ********************************************************************
    // 共通パラメータ
    // ********************************************************************
    /**
     * 手続き処理種別は対象テーブル構成が単一の場合はパラメータから設定され、それ以外の場合は手続きメソッドのアノテーションで指定する。
     */
    fun 手続き処理種別をセットする(手続き処理種別: 手続き処理種別一覧) {
        共通パラメータ.手続き処理種別をセットする(手続き処理種別)
    }

    /**
     *
     */
    fun 対象テーブル構成と手続き処理種別を返す() = 共通パラメータ.対象テーブル構成と手続き処理種別を返す()

    /**
     *
     */
    fun 対象テーブル構成を返す() = 共通パラメータ.対象テーブル構成を返す()

    /**
     *
     */
    fun 手続き処理種別を返す() = 共通パラメータ.手続き処理種別を返す()

    /**
     *
     */
    fun 返信言語種別を返す() = 共通パラメータ.返信言語種別を返す()

    // ********************************************************************
    // 単一テーブル用パラメータデータ
    // ********************************************************************
    /**
     *
     */
    fun 単一テーブル用パラメータデータを返す() = 単一テーブル用パラメータデータ

    // ********************************************************************
    // 汎用パラメータデータ
    // ********************************************************************
    /**
     *
     */
    fun 汎用パラメータデータを返す() = 汎用パラメータデータ

}
