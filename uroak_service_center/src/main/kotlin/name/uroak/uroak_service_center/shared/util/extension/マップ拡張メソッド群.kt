package name.uroak.uroak_service_center.shared.util.extension

import name.uroak.uroak_service_center.shared.type.SqlDate
import name.uroak.uroak_service_center.shared.type.SqlTime
import name.uroak.uroak_service_center.shared.type.UtilDate
import name.uroak.uroak_service_center.shared.util.tool.マップ道具箱
import java.math.BigDecimal
import java.math.BigInteger
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun Map<String, Any?>.コピーを作成する(): Map<String, Any?> {
    return マップ道具箱.マップのコピーを作成する(this)
}

////////////////////////////////////////////////
////////////////////////////////////////////////

fun Map<String, Any?>.Boolean値を取得する(キー名: String, 削除するか: Boolean = false): Boolean? {
    return マップ道具箱.マップからBoolean値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Byte値を取得する(キー名: String, 削除するか: Boolean = false): Byte? {
    return マップ道具箱.マップからByte値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Short値を取得する(キー名: String, 削除するか: Boolean = false): Short? {
    return マップ道具箱.マップからShort値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Int値を取得する(キー名: String, 削除するか: Boolean = false): Int? {
    return マップ道具箱.マップからInt値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Long値を取得する(キー名: String, 削除するか: Boolean = false): Long? {
    return マップ道具箱.マップからLong値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Float値を取得する(キー名: String, 削除するか: Boolean = false): Float? {
    return マップ道具箱.マップからFloat値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Double値を取得する(キー名: String, 削除するか: Boolean = false): Double? {
    return マップ道具箱.マップからDouble値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigInteger値を取得する(キー名: String, 削除するか: Boolean = false): BigInteger? {
    return マップ道具箱.マップからBigInteger値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigDecimal値を取得する(キー名: String, 削除するか: Boolean = false): BigDecimal? {
    return マップ道具箱.マップからBigDecimal値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.UtilDate値を取得する(キー名: String, 削除するか: Boolean = false): UtilDate? {
    return マップ道具箱.マップからUtilDate値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlDate値を取得する(キー名: String, 削除するか: Boolean = false): SqlDate? {
    return マップ道具箱.マップからSqlDate値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlTime値を取得する(キー名: String, 削除するか: Boolean = false): SqlTime? {
    return マップ道具箱.マップからSqlTime値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Timestamp値を取得する(キー名: String, 削除するか: Boolean = false): Timestamp? {
    return マップ道具箱.マップからTimestamp値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDate値を取得する(キー名: String, 削除するか: Boolean = false): LocalDate? {
    return マップ道具箱.マップからLocalDate値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalTime値を取得する(キー名: String, 削除するか: Boolean = false): LocalTime? {
    return マップ道具箱.マップからLocalTime値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDateTime値を取得する(キー名: String, 削除するか: Boolean = false): LocalDateTime? {
    return マップ道具箱.マップからLocalDateTime値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値を取得する(キー名: String, 削除するか: Boolean = false): String? {
    return マップ道具箱.マップから文字列値を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.マップを取得する(キー名: String, 削除するか: Boolean = false): Map<String, Any?>? {
    return マップ道具箱.マップからマップを取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.マップ配列を取得する(キー名: String, 削除するか: Boolean = false): List<Map<String, Any?>>? {
    return マップ道具箱.マップからマップ配列を取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.配列を取得する(キー名: String, 削除するか: Boolean = false): List<Any?>? {
    return マップ道具箱.マップから配列を取得する(this, キー名, 削除するか)
}

////////////////////////////////////////////////
////////////////////////////////////////////////

fun Map<String, Any?>.Boolean値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Boolean {
    return マップ道具箱.マップからBoolean値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Byte値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Byte {
    return マップ道具箱.マップからByte値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Short値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Short {
    return マップ道具箱.マップからShort値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Int値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Int {
    return マップ道具箱.マップからInt値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Long値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Long {
    return マップ道具箱.マップからLong値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Float値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Float {
    return マップ道具箱.マップからFloat値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Double値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Double {
    return マップ道具箱.マップからDouble値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigInteger値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): BigInteger {
    return マップ道具箱.マップからBigInteger値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigDecimal値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): BigDecimal {
    return マップ道具箱.マップからBigDecimal値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.UtilDate値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): UtilDate {
    return マップ道具箱.マップからUtilDate値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlDate値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): SqlDate {
    return マップ道具箱.マップからSqlDate値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlTime値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): SqlTime {
    return マップ道具箱.マップからSqlTime値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Timestamp値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Timestamp {
    return マップ道具箱.マップからTimestamp値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDate値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalDate {
    return マップ道具箱.マップからLocalDate値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalTime値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalTime {
    return マップ道具箱.マップからLocalTime値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDateTime値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalDateTime {
    return マップ道具箱.マップからLocalDateTime値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): String {
    return マップ道具箱.マップから文字列値を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値を取得する_空文字列(キー名: String, 削除するか: Boolean = false): String {
    return マップ道具箱.マップから文字列値を取得する(this, キー名, 削除するか) ?: ""
}

fun Map<String, Any?>.マップを取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Map<String, Any?> {
    return マップ道具箱.マップからマップを取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.マップを取得する_空マップ(キー名: String, 削除するか: Boolean = false): Map<String, Any?> {
    return マップ道具箱.マップからマップを取得する(this, キー名, 削除するか) ?: mutableMapOf()
}

fun Map<String, Any?>.マップ配列を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): List<Map<String, Any?>> {
    return マップ道具箱.マップからマップ配列を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.マップ配列を取得する_空配列(キー名: String, 削除するか: Boolean = false): List<Map<String, Any?>> {
    return マップ道具箱.マップからマップ配列を取得する(this, キー名, 削除するか) ?: mutableListOf()
}

fun Map<String, Any?>.配列を取得する_NULL不可(キー名: String, 削除するか: Boolean = false): List<Any?> {
    return マップ道具箱.マップから配列を取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.配列を取得する_空配列(キー名: String, 削除するか: Boolean = false): List<Any?> {
    return マップ道具箱.マップから配列を取得する(this, キー名, 削除するか) ?: mutableListOf()
}

////////////////////////////////////////////////
////////////////////////////////////////////////

fun Map<String, Any?>.Boolean値で取得する(キー名: String, 削除するか: Boolean = false): Boolean? {
    return マップ道具箱.マップからBoolean値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Byte値で取得する(キー名: String, 削除するか: Boolean = false): Byte? {
    return マップ道具箱.マップからByte値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Short値で取得する(キー名: String, 削除するか: Boolean = false): Short? {
    return マップ道具箱.マップからShort値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Int値で取得する(キー名: String, 削除するか: Boolean = false): Int? {
    return マップ道具箱.マップからInt値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Long値で取得する(キー名: String, 削除するか: Boolean = false): Long? {
    return マップ道具箱.マップからLong値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Float値で取得する(キー名: String, 削除するか: Boolean = false): Float? {
    return マップ道具箱.マップからFloat値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Double値で取得する(キー名: String, 削除するか: Boolean = false): Double? {
    return マップ道具箱.マップからDouble値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigInteger値で取得する(キー名: String, 削除するか: Boolean = false): BigInteger? {
    return マップ道具箱.マップからBigInteger値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigDecimal値で取得する(キー名: String, 削除するか: Boolean = false): BigDecimal? {
    return マップ道具箱.マップからBigDecimal値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.UtilDate値で取得する(キー名: String, 削除するか: Boolean = false): UtilDate? {
    return マップ道具箱.マップからUtilDate値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlDate値で取得する(キー名: String, 削除するか: Boolean = false): SqlDate? {
    return マップ道具箱.マップからSqlDate値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlTime値で取得する(キー名: String, 削除するか: Boolean = false): SqlTime? {
    return マップ道具箱.マップからSqlTime値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.Timestamp値で取得する(キー名: String, 削除するか: Boolean = false): Timestamp? {
    return マップ道具箱.マップからTimestamp値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDate値で取得する(キー名: String, 削除するか: Boolean = false): LocalDate? {
    return マップ道具箱.マップからLocalDate値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalTime値で取得する(キー名: String, 削除するか: Boolean = false): LocalTime? {
    return マップ道具箱.マップからLocalTime値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDateTime値で取得する(キー名: String, 削除するか: Boolean = false): LocalDateTime? {
    return マップ道具箱.マップからLocalDateTime値で取得する(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値で取得する(キー名: String, 削除するか: Boolean = false): String? {
    return マップ道具箱.マップから文字列値で取得する(this, キー名, 削除するか)
}

////////////////////////////////////////////////
////////////////////////////////////////////////

fun Map<String, Any?>.Boolean値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Boolean {
    return マップ道具箱.マップからBoolean値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Byte値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Byte {
    return マップ道具箱.マップからByte値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Short値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Short? {
    return マップ道具箱.マップからShort値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Int値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Int {
    return マップ道具箱.マップからInt値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Long値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Long {
    return マップ道具箱.マップからLong値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Float値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Float {
    return マップ道具箱.マップからFloat値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Double値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Double {
    return マップ道具箱.マップからDouble値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigInteger値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): BigInteger {
    return マップ道具箱.マップからBigInteger値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.BigDecimal値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): BigDecimal {
    return マップ道具箱.マップからBigDecimal値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.UtilDate値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): UtilDate {
    return マップ道具箱.マップからUtilDate値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlDate値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): SqlDate {
    return マップ道具箱.マップからSqlDate値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.SqlTime値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): SqlTime {
    return マップ道具箱.マップからSqlTime値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.Timestamp値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): Timestamp {
    return マップ道具箱.マップからTimestamp値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDate値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalDate {
    return マップ道具箱.マップからLocalDate値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalTime値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalTime {
    return マップ道具箱.マップからLocalTime値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.LocalDateTime値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): LocalDateTime {
    return マップ道具箱.マップからLocalDateTime値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値で取得する_NULL不可(キー名: String, 削除するか: Boolean = false): String {
    return マップ道具箱.マップから文字列値で取得する_NULL不可(this, キー名, 削除するか)
}

fun Map<String, Any?>.文字列値で取得する_空文字列(キー名: String, 削除するか: Boolean = false): String {
    return マップ道具箱.マップから文字列値で取得する(this, キー名, 削除するか) ?: ""
}
