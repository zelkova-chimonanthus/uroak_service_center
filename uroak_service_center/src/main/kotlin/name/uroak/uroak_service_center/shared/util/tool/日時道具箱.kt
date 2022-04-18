package name.uroak.uroak_service_center.shared.util.tool

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.type.SqlDate
import name.uroak.uroak_service_center.shared.type.SqlTime
import name.uroak.uroak_service_center.shared.type.SqlTimestamp
import name.uroak.uroak_service_center.shared.type.UtilDate
import java.sql.Timestamp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.*
import java.util.*


internal open class 日時書式フラグセットクラス {

    companion object フラグビット {
        const val ハイフン = 1
        const val スラッシュ = 2
        const val コロン = 4
        const val ドット = 8
        const val 年月日時刻区切り文字 = 16
        const val 半角スペース = 32
        const val 時間帯文字 = 64
        const val カンマ = 128
    }

    private var 書式フラグビットセット: Int = 0

    constructor()

    constructor(書式文字列: String) {
        書式フラグをセットする(書式文字列)
    }

    fun クリアする() {
        書式フラグビットセット = 0
    }

    fun 書式フラグを返す(): Int {
        return 書式フラグビットセット
    }

    fun 等しいか(日時書式フラグセット: 日時書式フラグセットクラス): Boolean {
        return this.書式フラグビットセット == 日時書式フラグセット.書式フラグビットセット
    }

    fun 書式フラグをセットする(書式文字列: String) {
        クリアする()

        if (書式文字列 == null) return

        // 年月日をハイフンで区切る書式
        ハイフンビットを変更する(書式文字列.indexOf('-') >= 0)

        // 年月日をスラッシュで区切る書式
        スラッシュビットを変更する(書式文字列.indexOf('/') >= 0)

        // 時分秒をコロンで区切る書式
        コロンビットを変更する(書式文字列.indexOf(':') >= 0)

        // ミリ秒を表す小数点（イギリス式の場合、ドットを使用する。日本もイギリス式を採用している）
        ドットビットを変更する(書式文字列.indexOf('.') >= 0)

        // 年月日と時分秒を'T'で区切る書式。（ISO-8601で採用されている書式。LocalDateTimeクラスを文字列化すると、この書式が使用される）
        年月日時刻区切り文字ビットを変更する(書式文字列.indexOf('T') >= 0)

        // 年月日と時分秒を半角スペースで区切る書式。
        半角スペースビットを変更する(書式文字列.indexOf(' ') >= 0)

        // ISO-8601では、時間帯(timezone）付き書式の場合、UTCからの時差を表すのに±を使用する。またUTCであることを示す場合は'Z'が使用される。
        時間帯文字ビットを変更する(書式文字列.indexOf('+') >= 0 || 書式文字列.indexOf('-') >= 0 || 書式文字列.indexOf('Z') >= 0)

        // ミリ秒を表す小数点（フランス式の場合、カンマを使用する。ISO-8601では、こちらが推奨されている）
        カンマビットを変更する(書式文字列.indexOf(',') >= 0)

    }

    private fun フラグをチェックする(フラグ: Int): Boolean {
        return (書式フラグビットセット and フラグ) != 0
    }

    private fun フラグを変更する(フラグ: Int, ON_OFF: Boolean) {
        書式フラグビットセット = if (ON_OFF) {
            書式フラグビットセット or フラグ
        } else {
            書式フラグビットセット and (フラグ xor 0xffffffff.toInt())
        }
    }

    fun ハイフンがあるか(): Boolean {
        return フラグをチェックする(ハイフン)
    }

    fun スラッシュがあるか(): Boolean {
        return フラグをチェックする(スラッシュ)
    }

    fun コロンがあるか(): Boolean {
        return フラグをチェックする(コロン)
    }

    fun ドットがあるか(): Boolean {
        return フラグをチェックする(ドット)
    }

    fun 年月日時刻区切り文字があるか(): Boolean {
        return フラグをチェックする(年月日時刻区切り文字)
    }

    fun 半角スペースがあるか(): Boolean {
        return フラグをチェックする(半角スペース)
    }

    fun 時間帯文字があるか(): Boolean {
        return フラグをチェックする(時間帯文字)
    }

    fun カンマがあるか(): Boolean {
        return フラグをチェックする(カンマ)
    }

    private fun ハイフンビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(ハイフン, ON_OFF)
    }

    private fun スラッシュビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(スラッシュ, ON_OFF)
    }

    private fun コロンビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(コロン, ON_OFF)
    }

    private fun ドットビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(ドット, ON_OFF)
    }

    private fun 年月日時刻区切り文字ビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(年月日時刻区切り文字, ON_OFF)
    }

    private fun 半角スペースビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(半角スペース, ON_OFF)
    }

    private fun 時間帯文字ビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(時間帯文字, ON_OFF)
    }

    private fun カンマビットを変更する(ON_OFF: Boolean) {
        フラグを変更する(カンマ, ON_OFF)
    }
}

internal class 日時書式処理クラス : 日時書式フラグセットクラス {
    private var 日時書式: SimpleDateFormat? = null

    constructor()

    constructor(書式文字列: String) : super(書式文字列) {
        日時書式 = SimpleDateFormat()
    }

    fun 書式フラグが等しいか(日時書式フラグセット: 日時書式フラグセットクラス): Boolean {
        return 等しいか(日時書式フラグセット)
    }

    fun UtilDate値に変換する(日時文字列: String): UtilDate? {
        return if (日時文字列 == null) null
        else try {
            日時書式?.parse(日時文字列)
        } catch (エラー: ParseException) {
            null
        }
    }
}

internal class 日時文字列変換クラス {
    companion object {
        private val UtilDate書式 = mutableListOf<String>()
        private val Timestamp書式 = mutableListOf<String>()
        private val SqlDate書式 = mutableListOf<String>()
        private val SqlTime書式 = mutableListOf<String>()

        init {
            UtilDate書式.add("yyyy/MM/dd")
            UtilDate書式.add("yyyy-MM-dd")
            UtilDate書式.add("yyyyMMddHHmmss")
            UtilDate書式.add("yyyyMMddHHmm")
            UtilDate書式.add("yyyyMMdd")
            UtilDate書式.add("yyyy/MM/dd HH:mm:ss")
            UtilDate書式.add("yyyy-MM-dd HH:mm:ss")
            UtilDate書式.add("yyyy-MM-dd'T'HH:mm:ss")
            UtilDate書式.add("yyyyMMdd HH:mm:ss")
            UtilDate書式.add("yyyy/MM/dd HH:mm")
            UtilDate書式.add("yyyy-MM-dd HH:mm")
            UtilDate書式.add("yyyyMMdd HH:mm")
            UtilDate書式.add("yyyy/MM/dd HHmm")
            UtilDate書式.add("yyyy-MM-dd HHmm")
            UtilDate書式.add("yyyyMMdd HHmm")

            Timestamp書式.add("yyyy-MM-dd HH:mm:ss")
            Timestamp書式.add("yyyy/MM/dd HH:mm:ss")
            Timestamp書式.add("yyyy-MM-dd'T'HH:mm:ss")
            Timestamp書式.add("yyyy-MM-dd HH:mm:ss.SSS")
            Timestamp書式.add("yyyy/MM/dd HH:mm:ss.SSS")
            Timestamp書式.add("yyyy-MM-dd'T'HH:mm:ss.SSS")
            Timestamp書式.add("yyyyMMddHHmmss")
            Timestamp書式.add("yyyyMMdd HH:mm:ss")

            SqlDate書式.add("yyyy-MM-dd")
            SqlDate書式.add("yyyy/MM/dd")
            SqlDate書式.add("yyyyMMdd")

            SqlTime書式.add("HH:mm:ss")
            SqlTime書式.add("HHmmss")
        }
    }

    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(日時道具箱.javaClass, メッセージID, *パラメータ)
    }

    private fun UtilDate書式集を作る(): List<日時書式処理クラス> {
        return 日時書式集を作る(UtilDate書式)
    }

    private fun Timestamp書式集を作る(): List<日時書式処理クラス> {
        return 日時書式集を作る(Timestamp書式)
    }

    private fun SqlDate書式集を作る(): List<日時書式処理クラス> {
        return 日時書式集を作る(SqlDate書式)
    }

    private fun SqlTime書式集を作る(): List<日時書式処理クラス> {
        return 日時書式集を作る(SqlTime書式)
    }

    private fun 日時書式集を作る(書式文字列配列: List<String>): List<日時書式処理クラス> {
        with(mutableListOf<日時書式処理クラス>()) {
            書式文字列配列.forEach {
                this.add(日時書式処理クラス(it))
            }
            return this
        }
    }

    private fun UtilDate値に変換する(変換対象文字列値: String?, 書式集: List<日時書式処理クラス>): UtilDate? {
        return if (変換対象文字列値 == null) {
            null
        } else {
            with(日時書式フラグセットクラス(変換対象文字列値)) {
                for (日時書式 in 書式集) {
                    if (日時書式.書式フラグが等しいか(this)) {
                        with(日時書式.UtilDate値に変換する(変換対象文字列値)) {
                            if (this != null) {
                                return this
                            }
                        }
                    }
                }
                return null
            }
        }
    }

    private fun UtilDate値に変換する(変換対象文字列値: String?, 書式: String? = null): UtilDate? {
        return if (変換対象文字列値 == null) {
            null
        } else {
            with(if (書式 == null) SimpleDateFormat() else SimpleDateFormat(書式)) {
                try {
                    return this.parse(変換対象文字列値)
                } catch (エラー: Throwable) {
                    例外をスローする(メッセージID一覧.SHR_E_0005, 変換対象文字列値, 書式 ?: "<null>")
                }
            }
        }
    }

    fun 文字列をUtilDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): UtilDate? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { UtilDate書式集を作る() },
            { UtilDate値: UtilDate -> UtilDate値 }
        )
    }

    fun 文字列をSqlDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): SqlDate? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { SqlDate書式集を作る() },
            { UtilDate値: UtilDate -> SqlDate(UtilDate値.time) }
        )
    }

    fun 文字列をSqlTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): SqlTime? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { SqlTime書式集を作る() },
            { UtilDate値: UtilDate -> SqlTime(UtilDate値.time) }
        )
    }

    fun 文字列をTimestamp値に変換する(変換対象文字列値: String?, 日時書式: String? = null): Timestamp? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { Timestamp書式集を作る() },
            { UtilDate値: UtilDate -> Timestamp(UtilDate値.time) }
        )
    }

    fun 文字列をLocalDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalDate? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { SqlDate書式集を作る() },
            { UtilDate値: UtilDate -> 日時道具箱.UtilDate値をLocalDate値に変換する(UtilDate値) }
        )
    }

    fun 文字列をLocalTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalTime? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { SqlTime書式集を作る() },
            { UtilDate値: UtilDate -> 日時道具箱.UtilDate値をLocalTime値に変換する(UtilDate値) }
        )
    }

    fun 文字列をLocalDateTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalDateTime? {
        return 文字列を日時値に変換する(
            変換対象文字列値,
            日時書式,
            { Timestamp書式集を作る() },
            { UtilDate値: UtilDate -> 日時道具箱.UtilDate値をLocalDateTime値に変換する(UtilDate値) }
        )
    }

    private fun <日時型> 文字列を日時値に変換する(
        変換対象文字列値: String?,
        日時書式: String?,
        書式集作成処理: () -> List<日時書式処理クラス>,
        変換処理: (UtilDate) -> 日時型
    ): 日時型? {
        with(
            if (文字列道具箱.空白文字列か(日時書式)) UtilDate値に変換する(変換対象文字列値, 書式集作成処理())
            else UtilDate値に変換する(変換対象文字列値, 日時書式)
        ) {
            return if (this == null) null else 変換処理(this)
        }
    }
}

object 日時道具箱 {

    private val 日時文字列変換: 日時文字列変換クラス = 日時文字列変換クラス()

    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(日時道具箱.javaClass, メッセージID, *パラメータ)
    }

    fun デフォルト時間帯の時差を取得する(): ZoneOffset {
        return ZoneOffset.of(ZoneId.systemDefault().id)
    }

    fun LocalDateTime値を作成する(基準時からの経過秒数: Long?, 基準時からの経過ナノ秒数: Int = 0, 標準時からの時差: ZoneOffset? = null): LocalDateTime? {
        return if (基準時からの経過秒数 == null) null
        else LocalDateTime.ofEpochSecond(
            基準時からの経過秒数,
            基準時からの経過ナノ秒数,
            標準時からの時差 ?: デフォルト時間帯の時差を取得する()
        )
    }

    fun LocalDate値から経過秒数を取得する(値: LocalDate): Long {
        return 値.toEpochSecond(LocalTime.MIDNIGHT, デフォルト時間帯の時差を取得する())
    }

    fun LocalDateTime値から経過秒数を取得する(値: LocalDateTime): Long {
        return 値.toEpochSecond(デフォルト時間帯の時差を取得する())
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun UtilDate値をSqlDate値に変換する(値: UtilDate?): SqlDate? {
        return if (値 == null) null else SqlDate(値.time)
    }

    fun UtilDate値をSqlTime値に変換する(値: UtilDate?): SqlTime? {
        return if (値 == null) null else SqlTime(値.time)
    }

    fun UtilDate値をTimestamp値に変換する(値: UtilDate?): Timestamp? {
        return if (値 == null) null else Timestamp(値.time)
    }

    fun UtilDate値をLocalDate値に変換する(値: UtilDate?): LocalDate? {
        return UtilDate値をLocalDateTime値に変換する(値)?.toLocalDate()
    }

    fun UtilDate値をLocalTime値に変換する(値: UtilDate?): LocalTime? {
        return UtilDate値をLocalDateTime値に変換する(値)?.toLocalTime()
    }

    fun UtilDate値をLocalDateTime値に変換する(値: UtilDate?): LocalDateTime? {
        return if (値 == null) null else LocalDateTime値を作成する(値.time)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun SqlDate値をUtilDate値に変換する(値: SqlDate?): UtilDate? {
        return if (値 == null) null else Long値をUtilDate値に変換する(値.time)
    }

    fun SqlDate値をSqlTime値に変換する(値: SqlDate?): SqlTime? {
        return if (値 == null) null else SqlTime(値.time)
    }

    fun SqlDate値をTimestamp値に変換する(値: SqlDate?): Timestamp? {
        return if (値 == null) null else Timestamp(値.time)
    }

    fun SqlDate値をLocalDate値に変換する(値: SqlDate?): LocalDate? {
        return SqlDate値をLocalDateTime値に変換する(値)?.toLocalDate()
    }

    fun SqlDate値をLocalTime値に変換する(値: SqlDate?): LocalTime? {
        return SqlDate値をLocalDateTime値に変換する(値)?.toLocalTime()
    }

    fun SqlDate値をLocalDateTime値に変換する(値: SqlDate?): LocalDateTime? {
        return if (値 == null) null else LocalDateTime値を作成する(値.time)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////


    fun SqlTime値をUtilDate値に変換する(値: SqlTime?): UtilDate? {
        return if (値 == null) null else Long値をUtilDate値に変換する(値.time)
    }

    fun SqlTime値をSqlDate値に変換する(値: SqlTime?): SqlDate? {
        return if (値 == null) null else SqlDate(値.time)
    }

    fun SqlTime値をTimestamp値に変換する(値: SqlTime?): Timestamp? {
        return if (値 == null) null else Timestamp(値.time)
    }

    fun SqlTime値をLocalDate値に変換する(値: SqlTime?): LocalDate? {
        return SqlTime値をLocalDateTime値に変換する(値)?.toLocalDate()
    }

    fun SqlTime値をLocalTime値に変換する(値: SqlTime?): LocalTime? {
        return SqlTime値をLocalDateTime値に変換する(値)?.toLocalTime()
    }

    fun SqlTime値をLocalDateTime値に変換する(値: SqlTime?): LocalDateTime? {
        return if (値 == null) null else LocalDateTime値を作成する(値.time)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun Timestamp値をUtilDate値に変換する(値: Timestamp?): UtilDate? {
        return if (値 == null) null else Long値をUtilDate値に変換する(値.time)
    }

    fun Timestamp値をSqlDate値に変換する(値: Timestamp?): SqlDate? {
        return if (値 == null) null else SqlDate(値.time)
    }

    fun Timestamp値をSqlTime値に変換する(値: Timestamp?): SqlTime? {
        return if (値 == null) null else SqlTime(値.time)
    }

    fun Timestamp値をLocalDate値に変換する(値: Timestamp?): LocalDate? {
        return Timestamp値をLocalDateTime値に変換する(値)?.toLocalDate()
    }

    fun Timestamp値をLocalTime値に変換する(値: Timestamp?): LocalTime? {
        return Timestamp値をLocalDateTime値に変換する(値)?.toLocalTime()
    }

    fun Timestamp値をLocalDateTime値に変換する(値: Timestamp?): LocalDateTime? {
        return if (値 == null) null else LocalDateTime値を作成する(値.time)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun LocalDate値をUtilDate値に変換する(値: LocalDate?): UtilDate? {
        return if (値 == null) null
        else Long値をUtilDate値に変換する(LocalDate値から経過秒数を取得する(値))
    }

    fun LocalDate値をSqlDate値に変換する(値: LocalDate?): SqlDate? {
        return if (値 == null) null else SqlDate.valueOf(値)
    }

    fun LocalDate値をSqlTime値に変換する(値: LocalDate?): SqlTime? {
        // LocalDateクラスは時分秒を持っていないので、SqlTimeには変換できない
        return null
    }

    fun LocalDate値をTimestamp値に変換する(値: LocalDate?): Timestamp? {
        return if (値 == null) null
        else Timestamp(LocalDate値から経過秒数を取得する(値))
    }

    fun LocalDate値をLocalTime値に変換する(値: LocalDate?): LocalTime? {
        // LocalDateクラスは時分秒を持っていないので、LocalTimeには変換できない
        return null
    }

    fun LocalDate値をLocalDateTime値に変換する(値: LocalDate?): LocalDateTime? {
        return if (値 == null) null else LocalDateTime値を作成する(LocalDate値から経過秒数を取得する(値))
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun LocalTime値をUtilDate値に変換する(値: LocalTime?): UtilDate? {
        // LocalTimeクラスは年月日を持っていないので、UtilDateには変換できない
        return null
    }

    fun LocalTime値をSqlDate値に変換する(値: LocalTime?): SqlDate? {
        // LocalTimeクラスは年月日を持っていないので、SqlDateには変換できない
        return null
    }

    fun LocalTime値をSqlTime値に変換する(値: LocalTime?): SqlTime? {
        return if (値 == null) null else SqlTime.valueOf(値)
    }

    fun LocalTime値をTimestamp値に変換する(値: LocalTime?): Timestamp? {
        // LocalTimeクラスは年月日を持っていないので、Timestampには変換できない
        return null
    }

    fun LocalTime値をLocalDate値に変換する(値: LocalTime?): LocalDate? {
        // LocalTimeクラスは年月日を持っていないので、LocalDateには変換できない
        return null
    }

    fun LocalTime値をLocalDateTime値に変換する(値: LocalTime?): LocalDateTime? {
        // LocalTimeクラスは年月日を持っていないので、LocalDateTimeには変換できない
        return null
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun LocalDateTime値をUtilDate値に変換する(値: LocalDateTime?): UtilDate? {
        return if (値 == null) null else UtilDate(LocalDateTime値から経過秒数を取得する(値))
    }

    fun LocalDateTime値をSqlDate値に変換する(値: LocalDateTime?): SqlDate? {
        return if (値 == null) null else SqlDate(LocalDateTime値から経過秒数を取得する(値))
    }

    fun LocalDateTime値をSqlTime値に変換する(値: LocalDateTime?): SqlTime? {
        return if (値 == null) null else SqlTime(LocalDateTime値から経過秒数を取得する(値))
    }

    fun LocalDateTime値をTimestamp値に変換する(値: LocalDateTime?): Timestamp? {
        return if (値 == null) null else Timestamp(LocalDateTime値から経過秒数を取得する(値))
    }

    fun LocalDateTime値をLocalDate値に変換する(値: LocalDateTime?): LocalDate? {
        return 値?.toLocalDate()
    }

    fun LocalDateTime値をLocalTime値に変換する(値: LocalDateTime?): LocalTime? {
        return 値?.toLocalTime()
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun Long値をUtilDate値に変換する(値: Long?): UtilDate? {
        return if (値 == null) null else
            with(Calendar.getInstance()) {
                this.timeInMillis = 値
                return this.time
            }
    }

    fun Long値をSqlDate値に変換する(値: Long?): SqlDate? {
        return if (値 == null) null else SqlDate(値)
    }

    fun Long値をSqlTime値に変換する(値: Long?): SqlTime? {
        return if (値 == null) null else SqlTime(値)
    }

    fun Long値をTimestamp値に変換する(値: Long?): Timestamp? {
        return if (値 == null) null else Timestamp(値)
    }

    fun Long値をLocalDate値に変換する(値: Long?): LocalDate? {
        return LocalDateTime値を作成する(値)?.toLocalDate()
    }

    fun Long値をLocalTime値に変換する(値: Long?): LocalTime? {
        return LocalDateTime値を作成する(値)?.toLocalTime()
    }

    fun Long値をLocalDateTime値に変換する(値: Long?): LocalDateTime? {
        return LocalDateTime値を作成する(値)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    fun 文字列をUtilDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): UtilDate? {
        return 日時文字列変換.文字列をUtilDate値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をSqlDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): SqlDate? {
        return 日時文字列変換.文字列をSqlDate値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をSqlTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): SqlTime? {
        return 日時文字列変換.文字列をSqlTime値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をTimestamp値に変換する(変換対象文字列値: String?, 日時書式: String? = null): Timestamp? {
        return 日時文字列変換.文字列をTimestamp値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をLocalDate値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalDate? {
        return 日時文字列変換.文字列をLocalDate値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をLocalTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalTime? {
        return 日時文字列変換.文字列をLocalTime値に変換する(変換対象文字列値, 日時書式)
    }

    fun 文字列をLocalDateTime値に変換する(変換対象文字列値: String?, 日時書式: String? = null): LocalDateTime? {
        return 日時文字列変換.文字列をLocalDateTime値に変換する(変換対象文字列値, 日時書式)
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////


}