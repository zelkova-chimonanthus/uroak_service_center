package name.uroak.uroak_service_center.shared.util.tool

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.afterburner.AfterburnerModule
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import java.text.SimpleDateFormat

/**
 *
 */
object JSON道具箱 {
    /***/
    const val 日付書式 = "yyyy-MM-dd HH:mm:ss"

    /***/
    private val JSON操作: ObjectMapper

    /**
     *
     */
    init {

        JSON操作 = ObjectMapper()

        // 速度効率化
        JSON操作.registerModule(AfterburnerModule())

        // Java8で導入されたDate and Time API 対応モジュールをロードする
        // これをしておかないとWRITE_DATES_AS_TIMESTAMPSの操作が効かない。
        JSON操作.findAndRegisterModules()

        // floatタイプをBigDecimal型で扱う
        JSON操作.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)

        // Timestamp型データを、指定された書式で文字列で出力する
        // これを設定しておかないとTimestampクラスのオブジェクトとして扱われるので、Timestampクラス内の全てのフィールドの値が出力されてしまう
        JSON操作.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

        // セット対象のエンティティにないプロパティがJSON文字列の中にあった場合にエラーにせずに続行する
        JSON操作.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

        // 日時の書式を、所定の書式に変更する
        JSON操作.dateFormat = SimpleDateFormat(日付書式)
    }

    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(JSON道具箱.javaClass, メッセージID, *パラメータ)
    }

    /**
     *
     */
    fun JSON文字列に変換する(オブジェクト: Any): String {
        try {
            return JSON操作.writeValueAsString(オブジェクト)
        } catch (例外: Throwable) {
            throw 共通処理エラークラス(JSON道具箱.javaClass, メッセージID一覧.JSN_E_0001, オブジェクト.javaClass.name)
        }
    }

    /**
     *
     */
    fun <オブジェクトタイプ> オブジェクトに変換する(JSON文字列: String, 対象タイプ: Class<オブジェクトタイプ>): オブジェクトタイプ {
        try {
            return JSON操作.readValue(JSON文字列, 対象タイプ) as オブジェクトタイプ
        } catch (例外: Throwable) {
            throw 共通処理エラークラス(JSON道具箱.javaClass, メッセージID一覧.JSN_E_0002, 対象タイプ.name)
        }
    }

    /**
     *
     */
    fun <オブジェクトタイプ> 別のオブジェクトに変換する(対象オブジェクト: Any, 対象タイプ: Class<オブジェクトタイプ>): オブジェクトタイプ {
        try {
            return JSON操作.readValue(JSON文字列に変換する(対象オブジェクト), 対象タイプ) as オブジェクトタイプ
        } catch (例外: Throwable) {
            throw 共通処理エラークラス(JSON道具箱.javaClass, メッセージID一覧.JSN_E_0002, 対象タイプ.name)
        }
    }

    /**
     *
     */
    fun マップに変換する(JSON文字列: String): Map<String, Any> {
        try {
            return JSON操作.readValue(JSON文字列, object : TypeReference<Map<String, Any>>() {})
        } catch (例外: Throwable) {
            throw 共通処理エラークラス(JSON道具箱.javaClass, メッセージID一覧.JSN_E_0002, LinkedHashMap<String, Any>().javaClass.name)
        }
    }
}