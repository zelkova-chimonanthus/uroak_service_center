package name.uroak.uroak_service_center.shared.base.param

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.util.CSVデータ形式種別一覧
import name.uroak.uroak_service_center.shared.base.util.比較演算子一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス
import name.uroak.uroak_service_center.shared.util.extension.マップを取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する_空文字列
import name.uroak.uroak_service_center.shared.util.extension.配列を取得する_空配列
import name.uroak.uroak_service_center.shared.util.tool.base64でデコードする

/**
 *
 */
abstract class 手続きパラメータ共通クラス : 手続きパラメータインターフェース {
    /**
     *
     */
    constructor()

    /**
     *
     */
    final override fun パラメータからデータをセットする(マップ: Map<String, Any?>) {
        解析結果をクリアする()
        マップからデータをセットする(マップ)
    }

    /**
     *
     */
    abstract fun マップからデータをセットする(マップ: Map<String, Any?>)

    /**
     *
     */
    abstract fun 解析結果をクリアする()

    /**
     *
     */
    fun エラーをスローする(メッセージID: メッセージID一覧, vararg メッセージパラメータ: Any): Nothing {
        throw 基盤処理エラークラス(this.javaClass, メッセージID, *メッセージパラメータ)
    }

    /**
     *
     */
    protected data class 条件指定データクラス(val カラム名: String, val 比較演算子: 比較演算子一覧, val 比較対象値: List<Any?>)

    /**
     *
     */
    protected fun マップから条件指定データをセットする(マップ: Map<String, Any?>, エラー対象JSONフィールド名: String): 条件指定データクラス {
        var カラム名 = ""
        var 比較演算子 = 比較演算子一覧.不明
        var 比較対象値: List<Any?> = mutableListOf()

        var 比較演算子存在フラグ = false
        var カラム定義存在フラグ = false

        マップ.keys.forEach {
            when (it) {
                リクエストフィールド名.単一テーブル_比較演算子 -> {
                    if (比較演算子存在フラグ) {
                        エラーをスローする(メッセージID一覧.BAS_E_0012, エラー対象JSONフィールド名)
                    } else {
                        比較演算子存在フラグ = true
                        val 比較演算子文字列 = マップ.文字列値で取得する(リクエストフィールド名.単一テーブル_比較演算子)
                        比較演算子 = 比較演算子一覧.JSONフィールド値を列挙定数に変換する(比較演算子文字列).apply {
                            when (this) {
                                比較演算子一覧.不明 -> {
                                    エラーをスローする(メッセージID一覧.BAS_E_0015, エラー対象JSONフィールド名, 比較演算子文字列 ?: "")
                                }
                                else -> this
                            }
                        }
                    }
                }
                else -> {
                    if (カラム定義存在フラグ) {
                        エラーをスローする(メッセージID一覧.BAS_E_0012, エラー対象JSONフィールド名)
                    } else {
                        カラム定義存在フラグ = true
                        カラム名 = it
                        比較対象値 = マップ.配列を取得する_空配列(it)
                    }
                }
            }
        }

        // カラム名の指定がない場合はエラー
        if (!カラム定義存在フラグ)
            エラーをスローする(メッセージID一覧.BAS_E_0020, エラー対象JSONフィールド名)

        // 比較演算子が未指定の場合は等号とする
        if (!比較演算子存在フラグ)
            比較演算子 = 比較演算子一覧.等しい

        return 条件指定データクラス(カラム名, 比較演算子, 比較対象値)
    }

    /**
     *
     */
    protected data class CSVフィールド解析結果(
        val CSVデータ形式: CSVデータ形式種別一覧 = CSVデータ形式種別一覧.不明,
        val CSVデータ: String = ""
    )

    /**
     *
     */
    protected fun CSVフィールドの内容を解析する(
        マップ: Map<String, Any?>,
        JSONフィールド名_CSV: String,
        JSONフィールド名_CSVデータ形式: String,
        JSONフィールド名_CSV_データ: String
    ): CSVフィールド解析結果? {
        val CSV = マップ.マップを取得する(JSONフィールド名_CSV) ?: return null

        val CSVデータ形式フィールド値 = CSV.文字列値で取得する(JSONフィールド名_CSVデータ形式)

        val CSVデータ形式 = CSVデータ形式種別一覧.JSONフィールド値を列挙定数に変換する(CSVデータ形式フィールド値)
        if (CSVデータ形式 == CSVデータ形式種別一覧.不明) {
            throw 基盤処理エラークラス(this.javaClass, メッセージID一覧.BAS_E_0033, JSONフィールド名_CSVデータ形式, CSVデータ形式フィールド値)
        }

        var CSVデータ = CSV.文字列値で取得する_空文字列(JSONフィールド名_CSV_データ)

        if (CSVデータ形式 == CSVデータ形式種別一覧.base64エンコーディング) {
            CSVデータ = base64でデコードする(CSVデータ)
        }

        return CSVフィールド解析結果(CSVデータ形式, CSVデータ)
    }
}