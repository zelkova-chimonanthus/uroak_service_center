package name.uroak.uroak_service_center.shared.base.execution

import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import java.lang.reflect.Method

/**
 * 手続きメソッドのAPI仕様
 */
typealias 手続きメソッド型 = (手続き実行情報: 手続き実行情報クラス) -> 戻り値クラス

/**
 * 手続きメソッドの仕様に一致しているかチェックする。
 *
 * チェック点は下記。
 * 1. 戻り値の型が「戻り値クラス」かどうか
 * 2. パラメータが１つかどうか
 * 3. パラメータの型が「手続き実行情報クラス」かどうか
 *
 * 一致していない場合は例外をスローする。（falseを返すわけではない）
 */
fun 手続きメソッドの仕様に一致しているかチェックする(メソッド: Method?): Boolean {
    val 自クラス: Class<Any> = ::手続きメソッドの仕様に一致しているかチェックする.javaClass

    if (メソッド == null) {
        throw 共通処理エラークラス(自クラス, メッセージID一覧.CMN_E_0002, "パラメータがNULLです。")
    }

    val 戻り値の型 = メソッド.returnType

    return if (戻り値の型 != 戻り値クラス::class.java) {
        throw 共通処理エラークラス(自クラス, メッセージID一覧.BAS_E_0003, 戻り値の型.name)
    } else {

        if (メソッド.parameterCount != 1) {
            throw 共通処理エラークラス(自クラス, メッセージID一覧.BAS_E_0004, メソッド.parameterCount)

        } else {
            val 第一パラメータの型 = メソッド.parameters[0].type

            if (第一パラメータの型 != 手続き実行情報クラス::class.java) {
                throw 共通処理エラークラス(自クラス, メッセージID一覧.BAS_E_0005, 第一パラメータの型.name)
            }
        }
        true
    }
}