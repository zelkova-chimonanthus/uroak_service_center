package name.uroak.uroak_service_center.shared.util.tool

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.type.SqlDate
import name.uroak.uroak_service_center.shared.type.SqlTime
import name.uroak.uroak_service_center.shared.type.UtilDate
import name.uroak.uroak_service_center.shared.util.log.ログ
import java.math.BigDecimal
import java.math.BigInteger
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 *
 */
object マップ道具箱 {

    /**
     *
     */
    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(マップ道具箱.javaClass, メッセージID, *パラメータ)
    }

    /**
     *
     */
    private fun NULL不可エラーをスローする(キー名: String): Nothing {
        例外をスローする(メッセージID一覧.SHR_E_0001, キー名)
    }

    /**
     *
     */
    fun マップのコピーを作成する(マップ: Map<String, Any?>): Map<String, Any?> {
        val コピー: MutableMap<String, Any?> = mutableMapOf()
        マップ.keys.forEach {
            コピー[it] = マップ[it]
        }
        return コピー
    }

    ////////////////////////////////////////////////

    /**
     *
     */
    private fun <対象型> マップから指定した型の値を取得する(
        マップ: Map<String, Any?>,
        キー名: String,
        削除するか: Boolean = false,
        想定される型名: String
    ): 対象型? {
        val 値 = マップ[キー名]

        return if (値 == null) {
            null
        } else {
            try {
                if (削除するか) {
                    if (マップ is MutableMap) {
                        マップ.remove(キー名)
                    } else if (マップ is java.util.HashMap) {
                        マップ.remove(キー名)
                    }
                }
                値 as 対象型
            } catch (エラー: Throwable) {
                ログ.エラーログを出力する(this.javaClass, エラー, "マップからの取得値のキャストの際にエラーが発生しました。")
                例外をスローする(メッセージID一覧.SHR_E_0021, キー名, 値.javaClass.name, 想定される型名)
            }
        }
    }

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    fun マップからBoolean値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Boolean? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Boolean")
    }

    fun マップからByte値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Byte? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Byte")
    }

    fun マップからShort値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Short? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Short")
    }

    fun マップからInt値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Int? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Int")
    }

    fun マップからLong値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Long? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Long")
    }

    fun マップからFloat値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Float? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Float")
    }

    fun マップからDouble値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Double? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Double")
    }

    fun マップからBigInteger値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigInteger? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "BigInteger")
    }

    fun マップからBigDecimal値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigDecimal? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "BigDecimal")
    }

    fun マップからUtilDate値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): UtilDate? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "UtilDate")
    }

    fun マップからSqlDate値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlDate? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "SqlDate")
    }

    fun マップからSqlTime値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlTime? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "SqlTime")
    }

    fun マップからTimestamp値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Timestamp? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Timestamp")
    }

    fun マップからLocalDate値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDate? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "LocalDate")
    }

    fun マップからLocalTime値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalTime? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "LocalTime")
    }

    fun マップからLocalDateTime値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDateTime? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "LocalDateTime")
    }

    fun マップから文字列値を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): String? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "String")
    }

    fun マップからマップを取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Map<String, Any>? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "Map<*,*>")
    }

    fun マップからマップ配列を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): List<Map<String, Any>>? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "List<*>")
    }

    fun マップから配列を取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): List<Any?>? {
        return マップから指定した型の値を取得する(マップ, キー名, 削除するか, "List<*>")
    }

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    fun マップからBoolean値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Boolean {
        return マップからBoolean値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからByte値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Byte {
        return マップからByte値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからShort値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Short {
        return マップからShort値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからInt値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Int {
        return マップからInt値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLong値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Long {
        return マップからLong値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからFloat値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Float {
        return マップからFloat値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからDouble値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Double {
        return マップからDouble値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからBigInteger値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigInteger {
        return マップからBigInteger値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからBigDecimal値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigDecimal {
        return マップからBigDecimal値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからUtilDate値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): UtilDate {
        return マップからUtilDate値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからSqlDate値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlDate {
        return マップからSqlDate値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからSqlTime値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlTime {
        return マップからSqlTime値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからTimestamp値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Timestamp {
        return マップからTimestamp値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalDate値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDate {
        return マップからLocalDate値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalTime値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalTime {
        return マップからLocalTime値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalDateTime値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDateTime {
        return マップからLocalDateTime値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップから文字列値を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): String {
        return マップから文字列値を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからマップを取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Map<String, Any> {
        return マップからマップを取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからマップ配列を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): List<Map<String, Any>> {
        return マップからマップ配列を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップから配列を取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): List<Any?> {
        return マップから配列を取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    /**
     *
     */
    private fun <取得対象の型> マップからXXX値で取得する(
        マップ: Map<String, Any?>,
        キー名: String,
        削除するか: Boolean,
        変換処理: (Any) -> 取得対象の型
    ): 取得対象の型? {
        val 値 = マップ[キー名]
        return when (値) {
            null -> null
            else -> {
                val 変換後の値 = 変換処理(値)
                if (削除するか && 変換後の値 != null) {
                    // 変換に成功した場合に削除する
                    マップ.minus(キー名)
                }
                変換後の値
            }
        }
    }

    fun マップからBoolean値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Boolean? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Booleanに変換する(値) }))
    }

    fun マップからByte値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Byte? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Byteに変換する(値) }))
    }

    fun マップからShort値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Short? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Shortに変換する(値) }))
    }

    fun マップからInt値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Int? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Intに変換する(値) }))
    }

    fun マップからLong値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Long? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Longに変換する(値) }))
    }

    fun マップからFloat値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Float? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Floatに変換する(値) }))
    }

    fun マップからDouble値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Double? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Doubleに変換する(値) }))
    }

    fun マップからBigInteger値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigInteger? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.BigIntegerに変換する(値) }))
    }

    fun マップからBigDecimal値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigDecimal? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.BigDecimalに変換する(値) }))
    }

    fun マップからUtilDate値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): UtilDate? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.UtilDateに変換する(値) }))
    }

    fun マップからSqlDate値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlDate? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.SqlDateに変換する(値) }))
    }

    fun マップからSqlTime値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlTime? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.SqlTimeに変換する(値) }))
    }

    fun マップからTimestamp値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Timestamp? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.Timestampに変換する(値) }))
    }

    fun マップからLocalDate値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDate? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.LocalDateに変換する(値) }))
    }

    fun マップからLocalTime値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalTime? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.LocalTimeに変換する(値) }))
    }

    fun マップからLocalDateTime値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDateTime? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 型道具箱.LocalDateTimeに変換する(値) }))
    }

    fun マップから文字列値で取得する(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): String? {
        return マップからXXX値で取得する(マップ, キー名, 削除するか, ({ 値 -> 値?.toString() }))
    }

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    fun マップからBoolean値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Boolean {
        return マップからBoolean値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからByte値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Byte {
        return マップからByte値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからShort値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Short {
        return マップからShort値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからInt値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Int {
        return マップからInt値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLong値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Long {
        return マップからLong値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからFloat値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Float {
        return マップからFloat値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからDouble値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Double {
        return マップからDouble値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからBigInteger値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigInteger {
        return マップからBigInteger値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからBigDecimal値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): BigDecimal {
        return マップからBigDecimal値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからUtilDate値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): UtilDate {
        return マップからUtilDate値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからSqlDate値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlDate {
        return マップからSqlDate値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからSqlTime値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): SqlTime {
        return マップからSqlTime値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからTimestamp値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): Timestamp {
        return マップからTimestamp値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalDate値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDate {
        return マップからLocalDate値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalTime値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalTime {
        return マップからLocalTime値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップからLocalDateTime値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): LocalDateTime {
        return マップからLocalDateTime値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

    fun マップから文字列値で取得する_NULL不可(マップ: Map<String, Any?>, キー名: String, 削除するか: Boolean = false): String {
        return マップから文字列値で取得する(マップ, キー名, 削除するか) ?: NULL不可エラーをスローする(キー名)
    }

}