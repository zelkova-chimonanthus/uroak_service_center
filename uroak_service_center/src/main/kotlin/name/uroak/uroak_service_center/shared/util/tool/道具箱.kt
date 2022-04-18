package name.uroak.uroak_service_center.shared.util.tool

import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.log.ログ
import java.io.PrintWriter
import java.io.StringWriter
import java.text.MessageFormat

/**
 *
 */
object 道具箱 {

    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(道具箱.javaClass, メッセージID, *パラメータ)
    }


    fun スタックトレースを文字列化する(例外: Throwable): String {
        val 文字列出力: StringWriter = StringWriter()
        val 出力: PrintWriter = PrintWriter(文字列出力, true)
        例外.printStackTrace(出力)
        return 文字列出力.toString()
    }

    fun 空の配列か(配列: List<Any>?): Boolean {
        return 配列?.isEmpty() ?: true
    }

    fun 可変長引数を配列に変換する(可変長パラメータ: Array<out Any?>?): Array<Any?>? {
        return if (可変長パラメータ == null || 可変長パラメータ.isEmpty()) {
            null
        } else if (可変長パラメータ[0] is Array<*>) {
            // 可変長パラメータを展開せずに可変長パラメータに渡すと、第一引数が配列となって可変長パラメータが渡される。
            // 本来、バグだが、便宜的に回避措置を取っておく
            try {
                throw Exception("発生位置を明示するために一時的にスローした例外")
            } catch (一時例外: Exception) {
                ログ.警告ログを出力する(this.javaClass, 一時例外, "可変長パラメータの第一引数に可変長パラメータ全てが格納されている。")
            }
            var パラメータ配列: Array<Any?> = 可変長パラメータ[0] as Array<Any?>
            if (パラメータ配列.size == 1 && パラメータ配列[0] == null) {
                null
            } else {
                パラメータ配列
            }
        } else {
            可変長パラメータ as Array<Any?>
        }
    }

    fun 可変長引数を文字列配列に変換する(パラメータ: Array<out Any?>?): Array<String?>? {
        val 配列 = 可変長引数を配列に変換する(パラメータ)
        return if (配列 == null)
            null
        else {
            val 文字列配列 = mutableListOf<String>()
            for (各パラメータ in 配列) {
                文字列配列.add(各パラメータ.toString())
            }
            文字列配列.toTypedArray()
        }
    }
}