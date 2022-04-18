package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.base.constants.レスポンスフィールド名
import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名定数クラス
import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名言語一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.tool.JSON道具箱

/**
 *
 */
abstract class 戻り値クラス {

    /**正常終了かエラー終了かを示す*/
    private var 実行成功 = true

    /**エラー終了の場合にエラー情報がセットされる*/
    private var エラー情報 = mutableListOf<エラー項目クラス>()

    /***/
    private var 手続き実行種別: 手続き実行種別一覧 = 手続き実行種別一覧.無効

    /***/
    private var JSONフィールド名言語: JSONフィールド名言語一覧 = JSONフィールド名言語一覧.英語

    /**
     *
     */
    constructor(手続き実行種別: 手続き実行種別一覧) {
        this.手続き実行種別 = 手続き実行種別
    }

    /**
     *
     */
    constructor(手続き実行種別: 手続き実行種別一覧, JSONフィールド名言語: JSONフィールド名言語一覧) : this(手続き実行種別) {
        JSONフィールド名言語をセットする(JSONフィールド名言語)
    }

    /**
     *
     */
    constructor(手続き実行種別: 手続き実行種別一覧, 手続き実行情報: 手続き実行情報クラス) : this(手続き実行種別) {
        JSONフィールド名言語をセットする(手続き実行情報)
    }

    /**
     *
     */
    fun JSONフィールド名言語をセットする(手続き実行情報: 手続き実行情報クラス) {
        JSONフィールド名言語をセットする(手続き実行情報.返信言語種別を返す())
    }

    /**
     *
     */
    fun JSONフィールド名言語をセットする(JSONフィールド名言語: JSONフィールド名言語一覧) {
        this.JSONフィールド名言語 = JSONフィールド名言語
    }

    /**
     *
     */
    protected fun JSONフィールド名言語を返す() = JSONフィールド名言語

    /**
     *
     */
    fun 実行失敗とする() {
        実行成功 = false
    }

    /**
     *
     */
    fun エラーとする(エラーメッセージID: メッセージID一覧, vararg メッセージパラメータ: Any?) {
        エラーとする(エラー項目クラス(エラーメッセージID, *メッセージパラメータ))
    }

    /**
     *
     */
    fun エラーとする(エラーメッセージID: メッセージID一覧) {
        エラーとする(エラー項目クラス(エラーメッセージID))
    }

    /**
     *
     */
    fun エラーとする(エラー項目: エラー項目クラス) {
        実行失敗とする()
        セットされているエラーをクリアする()
        エラーを追加する(エラー項目)
    }

    /**
     *
     */
    fun エラーとする(エラー項目セット: List<エラー項目クラス>) {
        実行失敗とする()
        セットされているエラーをクリアする()
        エラーを追加する(エラー項目セット)
    }

    /**
     *
     */
    fun エラーを追加する(エラーメッセージID: メッセージID一覧, vararg メッセージパラメータ: Any?) {
        エラーを追加する(エラー項目クラス(エラーメッセージID, *メッセージパラメータ))
    }

    /**
     *
     */
    fun エラーを追加する(エラーメッセージID: メッセージID一覧) {
        エラーを追加する(エラー項目クラス(エラーメッセージID))
    }

    /**
     *
     */
    fun エラーを追加する(エラー項目: エラー項目クラス) {
        エラー情報.add(エラー項目)
    }

    /**
     *
     */
    fun エラーを追加する(エラー項目セット: List<エラー項目クラス>) {
        エラー項目セット.forEach {
            エラー情報.add(it)
        }
    }

    /**
     *
     */
    fun セットされているエラーをクリアする() {
        エラー情報 = mutableListOf()
    }

    /**
     *
     */
    protected fun 名称を返す(JSONフィールド名定数: JSONフィールド名定数クラス): String {
        return JSONフィールド名定数.名称を返す(JSONフィールド名言語)
    }

    /**
     *
     */
    fun 返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        返却値[名称を返す(レスポンスフィールド名.実行状態)] = 実行状態を作成する()

        返却値[名称を返す(レスポンスフィールド名.API種別)] = 手続き実行種別.値

        返却値[名称を返す(レスポンスフィールド名.実行結果)] = 各APIの返却値を作成する()

        return 返却値
    }

    /**
     *
     */
    fun 返却値を作成してJSON化する(): String {
        return JSON道具箱.JSON文字列に変換する(返却値を作成する())
    }

    /**
     *
     */
    private fun 実行状態を作成する(): Map<String, Any> {
        var 実行状態 = mutableMapOf<String, Any>()

        実行状態[名称を返す(レスポンスフィールド名.正常終了フラグ)] = if (実行成功) 1 else 0

        var エラー項目配列 = mutableListOf<Map<String, Any>>()

        エラー情報.forEach {
            エラー項目配列 += it.返却値を作成する(JSONフィールド名言語を返す())
        }

        実行状態[名称を返す(レスポンスフィールド名.エラー情報)] = エラー項目配列

        return 実行状態
    }

    /***/
    abstract fun 各APIの返却値を作成する(): Map<String, Any>

}