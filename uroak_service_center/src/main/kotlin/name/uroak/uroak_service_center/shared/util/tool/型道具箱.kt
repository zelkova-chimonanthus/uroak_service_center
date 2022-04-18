package name.uroak.uroak_service_center.shared.util.tool

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.type.SqlDate
import name.uroak.uroak_service_center.shared.type.SqlTime
import name.uroak.uroak_service_center.shared.type.UtilDate
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.sql.Timestamp
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object 型道具箱 {

    private val Boolean文字列マップ = mutableMapOf<String, Boolean>()

    init {
        Boolean文字列マップ["1"] = true
        Boolean文字列マップ["0"] = false
        Boolean文字列マップ["true"] = true
        Boolean文字列マップ["false"] = false
        Boolean文字列マップ["on"] = true
        Boolean文字列マップ["off"] = false
        Boolean文字列マップ["ok"] = true
        Boolean文字列マップ["yes"] = true
        Boolean文字列マップ["no"] = false
        Boolean文字列マップ["はい"] = true
        Boolean文字列マップ["いいえ"] = false
        Boolean文字列マップ["可"] = true
        Boolean文字列マップ["不可"] = false
        Boolean文字列マップ["真"] = true
        Boolean文字列マップ["偽"] = false
    }

    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(型道具箱.javaClass, メッセージID, *パラメータ)
    }

    fun Booleanに変換する(値: Any?): Boolean? {
        return when (値) {
            is String -> Booleanに変換する(値)
            is Int -> Booleanに変換する(値)
            else -> null
        }
    }

    fun Booleanに変換する_NULLはfalseとする(値: Any?): Boolean? {
        return when (値) {
            is String -> Booleanに変換する_NULLはfalseとする(値)
            is Int -> Booleanに変換する_NULLはfalseとする(値)
            else -> null
        }
    }

    fun Booleanに変換する(文字列値: String?): Boolean? {
        return when (文字列値) {
            null -> null
            else -> Boolean文字列マップ[文字列値.lowercase()]
        }
    }

    fun Booleanに変換する_NULLはfalseとする(文字列値: String?): Boolean {
        return when (文字列値) {
            null -> false
            else -> Booleanに変換する(文字列値) as Boolean
        }
    }

    fun Booleanに変換する(整数値: Int?): Boolean? {
        return when (整数値) {
            null -> null
            0 -> false
            1 -> true
            else -> null
        }
    }

    fun Booleanに変換する_NULLはfalseとする(整数値: Int?): Boolean {
        return when (整数値) {
            null -> false
            else -> Booleanに変換する(整数値) as Boolean
        }
    }

    fun Booleanを文字列化する(Boolean値: Boolean?): String? {
        return when (Boolean値) {
            null -> null
            true -> "true"
            false -> "false"
            else -> null
        }
    }

    fun Booleanを文字列化する_NULLは空文字列とする(Boolean値: Boolean?): String {
        return when (Boolean値) {
            null -> ""
            else -> Booleanを文字列化する(Boolean値) as String
        }
    }

    fun Booleanを整数文字列化する(Boolean値: Boolean?): String? {
        return when (Boolean値) {
            null -> null
            true -> "1"
            false -> "0"
            else -> null
        }
    }

    fun Booleanを整数文字列化する_NULLは空文字列とする(Boolean値: Boolean?): String {
        return when (Boolean値) {
            null -> ""
            else -> Booleanを文字列化する(Boolean値) as String
        }
    }

    fun Booleanを整数化する(Boolean値: Boolean?): Int? {
        return when (Boolean値) {
            null -> null
            true -> 1
            false -> 0
            else -> null
        }
    }

    fun Booleanを整数化する_NULLは0とする(Boolean値: Boolean?): Int {
        return when (Boolean値) {
            null -> 0
            else -> Booleanを整数化する(Boolean値) as Int
        }
    }

    fun 指定された書式で文字列値をLongに変換する(変換対象文字列値: String?, 書式: String? = null): Long? {
        return if (変換対象文字列値 == null) {
            null
        } else {
            with(if (書式 == null) DecimalFormat() else DecimalFormat(書式)) {
                try {
                    with(this.parse(変換対象文字列値)) {
                        return when (this) {
                            is Long -> this as Long
                            is Double -> (this as Double).toLong()
                            is BigDecimal -> (this as BigDecimal).longValueExact()
                            else -> 例外をスローする(
                                メッセージID一覧.CMN_E_0002,
                                "文字列値をLongに変換後の型が想定外のものでした。（型：" + this.javaClass.name + "）"
                            )
                        }
                    }
                } catch (エラー: Throwable) {
                    例外をスローする(メッセージID一覧.SHR_E_0006, 変換対象文字列値, 書式 ?: "<null>")
                }
            }
        }
    }

    fun 指定された書式で文字列値をDoubleに変換する(変換対象文字列値: String?, 書式: String? = null): Double? {
        return if (変換対象文字列値 == null) {
            null
        } else {
            with(if (書式 == null) DecimalFormat() else DecimalFormat(書式)) {
                try {
                    with(this.parse(変換対象文字列値)) {
                        return when (this) {
                            is Long -> (this as Long).toDouble()
                            is Double -> this as Double
                            is BigDecimal -> (this as BigDecimal).toDouble()
                            else -> 例外をスローする(
                                メッセージID一覧.CMN_E_0002,
                                "文字列値をDoubleに変換後の型が想定外のものでした。（型：" + this.javaClass.name + "）"
                            )
                        }
                    }
                } catch (エラー: Throwable) {
                    例外をスローする(メッセージID一覧.SHR_E_0007, 変換対象文字列値, 書式 ?: "<null>")
                }
            }
        }
    }

    fun 指定された書式で文字列値をBigDecimalに変換する(変換対象文字列値: String?, 書式: String? = null): BigDecimal? {
        return if (変換対象文字列値 == null) {
            null
        } else {
            with(if (書式 == null) DecimalFormat() else DecimalFormat(書式)) {
                try {
                    with(this.parse(変換対象文字列値)) {
                        return when (this) {
                            is Long -> (this as Long).toBigDecimal()
                            is Double -> (this as Double).toBigDecimal()
                            is BigDecimal -> this as BigDecimal
                            else -> 例外をスローする(
                                メッセージID一覧.CMN_E_0002,
                                "文字列値をBigDecimalに変換後の型が想定外のものでした。（型：" + this.javaClass.name + "）"
                            )
                        }
                    }
                } catch (エラー: Throwable) {
                    例外をスローする(メッセージID一覧.SHR_E_0008, 変換対象文字列値, 書式 ?: "<null>")
                }
            }
        }
    }

    fun Byteに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Byte? {
        return when (値) {
            null -> null
            is String -> 値.toByte()
            is Byte -> 値 as Byte
            is Short -> (値 as Short).toByte()
            is Int -> (値 as Int).toByte()
            is Long -> (値 as Long).toByte()
            is Float -> (値 as Float).toInt().toByte()
            is Double -> (値 as Double).toInt().toByte()
            is Boolean -> Booleanを整数化する(値 as Boolean)?.toByte()
            is BigDecimal -> (値 as BigDecimal).toString().toByte()
            is BigInteger -> (値 as BigInteger).toString().toByte()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0009, 値.javaClass.name)
        }
    }

    fun Shortに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Short? {
        return when (値) {
            null -> null
            is String -> 値.toShort()
            is Byte -> (値 as Byte).toShort()
            is Short -> 値 as Short
            is Int -> (値 as Int).toShort()
            is Long -> (値 as Long).toShort()
            is Float -> (値 as Float).toInt().toShort()
            is Double -> (値 as Double).toInt().toShort()
            is Boolean -> Booleanを整数化する(値 as Boolean)?.toShort()
            is BigDecimal -> (値 as BigDecimal).toString().toShort()
            is BigInteger -> (値 as BigInteger).toString().toShort()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0009, 値.javaClass.name)
        }
    }

    fun Intに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Int? {
        return when (値) {
            null -> null
            is String -> 値.toInt()
            is Byte -> (値 as Byte).toInt()
            is Short -> (値 as Short).toInt()
            is Int -> 値 as Int
            is Long -> (値 as Long).toInt()
            is Float -> (値 as Float).toInt()
            is Double -> (値 as Double).toInt()
            is Boolean -> Booleanを整数化する(値 as Boolean)
            is BigDecimal -> (値 as BigDecimal).toString().toInt()
            is BigInteger -> (値 as BigInteger).toString().toInt()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0009, 値.javaClass.name)
        }
    }

    fun Longに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Long? {
        return when (値) {
            null -> null
            is String -> 値.toLong()
            is Byte -> (値 as Byte).toLong()
            is Short -> (値 as Short).toLong()
            is Int -> (値 as Int).toLong()
            is Long -> 値 as Long
            is Float -> (値 as Float).toLong()
            is Double -> (値 as Double).toLong()
            is Boolean -> Booleanを整数化する(値 as Boolean) as Long
            is BigDecimal -> (値 as BigDecimal).toString().toLong()
            is BigInteger -> (値 as BigInteger).toString().toLong()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0010, 値.javaClass.name)
        }
    }

    fun Floatに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Float? {
        return when (値) {
            null -> null
            is String -> 値.toFloat()
            is Byte -> (値 as Byte).toFloat()
            is Short -> (値 as Short).toFloat()
            is Int -> (値 as Int).toFloat()
            is Long -> (値 as Long).toFloat()
            is Float -> 値 as Float
            is Double -> (値 as Double).toFloat()
            is Boolean -> Booleanを整数化する(値 as Boolean)?.toFloat()
            is BigDecimal -> (値 as BigDecimal).toString().toFloat()
            is BigInteger -> (値 as BigInteger).toString().toFloat()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0010, 値.javaClass.name)
        }
    }

    fun Doubleに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Double? {
        return when (値) {
            null -> null
            is String -> 値.toDouble()
            is Byte -> (値 as Byte).toDouble()
            is Short -> (値 as Short).toDouble()
            is Int -> (値 as Int).toDouble()
            is Long -> (値 as Long).toDouble()
            is Float -> (値 as Float).toDouble()
            is Double -> 値 as Double
            is Boolean -> Booleanを整数化する(値 as Boolean)?.toDouble()
            is BigDecimal -> (値 as BigDecimal).toString().toDouble()
            is BigInteger -> (値 as BigInteger).toString().toDouble()
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0010, 値.javaClass.name)
        }
    }

    fun BigIntegerに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): BigInteger? {
        return when (値) {
            null -> null
            is String -> BigInteger(値 as String)
            is Byte -> BigInteger((値 as Byte).toString())
            is Short -> BigInteger((値 as Short).toString())
            is Int -> BigInteger((値 as Int).toString())
            is Long -> BigInteger((値 as Long).toString())
            is Float -> BigInteger((値 as Float).toString())
            is Double -> BigInteger((値 as Double).toString())
            is Boolean -> BigInteger(Booleanを整数化する(値 as Boolean).toString())
            is BigDecimal -> BigInteger((値 as BigDecimal).toString())
            is BigInteger -> 値 as BigInteger
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0011, 値.javaClass.name)
        }
    }

    fun BigDecimalに変換する(値: Double, 精度: Int? = null): BigDecimal {
        with(BigDecimal(値.toString())) {
            return if (精度 == null) this else this.setScale(精度, RoundingMode.DOWN)
        }
    }

    fun BigDecimalに変換する(値: Float, 精度: Int? = null): BigDecimal {
        with(BigDecimal(値.toString())) {
            return if (精度 == null) this else this.setScale(精度, RoundingMode.DOWN)
        }
    }

    fun BigDecimalに変換する(値: Int, 精度: Int? = null): BigDecimal {
        with(BigDecimal(値)) {
            return if (精度 == null) this else this.setScale(精度, RoundingMode.DOWN)
        }
    }

    fun BigDecimalに変換する(値: Long, 精度: Int? = null): BigDecimal {
        with(BigDecimal(値)) {
            return if (精度 == null) this else this.setScale(精度, RoundingMode.DOWN)
        }
    }

    fun BigDecimalに変換する(値: String, 精度: Int? = null): BigDecimal {
        with(BigDecimal(値)) {
            return if (精度 == null) this else this.setScale(精度, RoundingMode.DOWN)
        }
    }

    fun 配列か(オブジェクト: Any?): Boolean {
        return オブジェクト?.javaClass?.isArray ?: false
    }

    fun BigDecimalに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): BigDecimal? {
        return when (値) {
            null -> null
            is BigDecimal -> 値
            is Int -> BigDecimalに変換する(値)
            is String -> BigDecimalに変換する(値)
            is BigInteger -> 値.toBigDecimal()
            is Byte -> BigDecimalに変換する(値.toInt())
            is Short -> BigDecimalに変換する(値.toInt())
            is Long -> BigDecimalに変換する(値)
            is Float -> BigDecimalに変換する(値)
            is Double -> BigDecimalに変換する(値)
            is Boolean -> BigDecimalに変換する(Booleanを整数化する(値))
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0011, 値.javaClass.name)
        }
    }

    fun UtilDateに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): UtilDate? {
        return when (値) {
            null -> null
            is UtilDate -> 値
            is String -> 日時道具箱.文字列をUtilDate値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をUtilDate値に変換する(値)
            is LocalDate -> 日時道具箱.LocalDate値をUtilDate値に変換する(値)
            is Long -> 日時道具箱.Long値をUtilDate値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をUtilDate値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をUtilDate値に変換する(値)
            // is LocalTime ->
            is LocalDateTime -> 日時道具箱.LocalDateTime値をUtilDate値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0012, 値.javaClass.name)
        }
    }

    fun SqlDateに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): SqlDate? {
        return when (値) {
            null -> null
            is SqlDate -> 値
            is String -> 日時道具箱.文字列をSqlDate値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をSqlDate値に変換する(値)
            is LocalDate -> 日時道具箱.LocalDate値をSqlDate値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をSqlDate値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をSqlDate値に変換する(値)
            // is LocalTime ->
            is LocalDateTime -> 日時道具箱.LocalDateTime値をSqlDate値に変換する(値)
            is Long -> 日時道具箱.Long値をSqlDate値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0013, 値.javaClass.name)
        }
    }

    fun SqlTimeに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): SqlTime? {
        return when (値) {
            null -> null
            is SqlTime -> 値
            is String -> 日時道具箱.文字列をSqlTime値に変換する(値)
            is LocalTime -> 日時道具箱.LocalTime値をSqlTime値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をSqlTime値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をSqlTime値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をSqlTime値に変換する(値)
            // is LocalDate ->
            is LocalDateTime -> 日時道具箱.LocalDateTime値をSqlTime値に変換する(値)
            is Long -> 日時道具箱.Long値をSqlTime値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0014, 値.javaClass.name)
        }
    }

    fun Timestampに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): Timestamp? {
        return when (値) {
            null -> null
            is Timestamp -> 値
            is String -> 日時道具箱.文字列をTimestamp値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をTimestamp値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をTimestamp値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をTimestamp値に変換する(値)
            is LocalDateTime -> 日時道具箱.LocalDateTime値をTimestamp値に変換する(値)
            is LocalDate -> 日時道具箱.LocalDate値をTimestamp値に変換する(値)
            is LocalTime -> 日時道具箱.LocalTime値をTimestamp値に変換する(値)
            is Long -> 日時道具箱.Long値をTimestamp値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0015, 値.javaClass.name)
        }
    }

    fun LocalDateに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): LocalDate? {
        return when (値) {
            null -> null
            is LocalDate -> 値
            is String -> 日時道具箱.文字列をLocalDate値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をLocalDate値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をLocalDate値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をLocalDate値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をLocalDate値に変換する(値)
            // is LocalTime ->
            is LocalDateTime -> 日時道具箱.LocalDateTime値をLocalDate値に変換する(値)
            is Long -> 日時道具箱.Long値をLocalDate値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0016, 値.javaClass.name)
        }
    }

    fun LocalTimeに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): LocalTime? {
        return when (値) {
            null -> null
            is LocalTime -> 値
            is String -> 日時道具箱.文字列をLocalTime値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をLocalTime値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をLocalTime値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をLocalTime値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をLocalTime値に変換する(値)
            // is LocalDate ->
            is LocalDateTime -> 日時道具箱.LocalDateTime値をLocalTime値に変換する(値)
            is Long -> 日時道具箱.Long値をLocalTime値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0017, 値.javaClass.name)
        }
    }

    fun LocalDateTimeに変換する(値: Any?, 変換不可の場合はNULLを返すか: Boolean = false): LocalDateTime? {
        return when (値) {
            null -> null
            is LocalDateTime -> 値
            is String -> 日時道具箱.文字列をLocalDateTime値に変換する(値)
            is Timestamp -> 日時道具箱.Timestamp値をLocalDateTime値に変換する(値)
            is SqlDate -> 日時道具箱.SqlDate値をLocalDateTime値に変換する(値)
            is SqlTime -> 日時道具箱.SqlTime値をLocalDateTime値に変換する(値)
            is UtilDate -> 日時道具箱.UtilDate値をLocalDateTime値に変換する(値)
            is LocalDate -> 日時道具箱.LocalDate値をLocalDateTime値に変換する(値)
            // is LocalTime ->
            is Long -> 日時道具箱.Long値をLocalDateTime値に変換する(値)
            else -> if (変換不可の場合はNULLを返すか) null else 例外をスローする(メッセージID一覧.SHR_E_0018, 値.javaClass.name)
        }
    }
}