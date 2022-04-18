package name.uroak.uroak_service_center.shared.util.tool

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.util.*
import java.util.function.Predicate

/**
 *
 */
object クラス道具箱 {

    /**
     *
     */
    private fun 例外をスローする(メッセージID: メッセージID一覧, vararg パラメータ: Any): Nothing {
        throw 共通処理エラークラス(クラス道具箱.javaClass, メッセージID, *パラメータ)
    }

    /**
     *
     */
    fun 指定された名前の公開メソッドを取得する(オブジェクト: Any, メソッド名: String, vararg パラメータクラス配列: Any): Method? {
        return 指定された名前のメソッドを取得する(オブジェクト, false, メソッド名, *パラメータクラス配列)
    }

    /**
     *
     */
    fun 指定された名前の非公開メソッドを取得する(オブジェクト: Any, メソッド名: String, vararg パラメータクラス配列: Any): Method? {
        return 指定された名前のメソッドを取得する(オブジェクト, true, メソッド名, *パラメータクラス配列)
    }

    /**
     *
     */
    private fun 指定された名前のメソッドを取得する(
        オブジェクト: Any,
        非公開も含むか: Boolean = true,
        メソッド名: String,
        vararg パラメータクラス配列: Any
    ): Method? {
        var メソッド: Method? = null
        var クラス: Class<Any> = オブジェクト.javaClass
        while (クラス != null) {
            try {
                メソッド =
                    if (非公開も含むか)
                        クラス.getDeclaredMethod(メソッド名, *(パラメータクラス配列 as Array<out Class<*>>))
                    else
                        クラス.getMethod(メソッド名, *(パラメータクラス配列 as Array<out Class<*>>))
            } catch (例外: NoSuchMethodException) {
                // 例外を破棄
            }
            if (メソッド != null) {
                break
            }
            クラス = クラス.superclass
        }
        return メソッド
    }

    /**
     *
     */
    fun 公開メソッドを収集する(オブジェクト: Any, 対象メソッドチェック: Predicate<Method>? = null): List<Method>? {
        return メソッドを収集する(オブジェクト = オブジェクト, 非公開も含むか = false, 対象メソッドチェック = 対象メソッドチェック)
    }

    /**
     *
     */
    fun 公開メソッドを収集する(オブジェクト: Any, 収集結果格納場所: MutableList<Method>, 対象メソッドチェック: Predicate<Method>? = null): List<Method>? {
        return メソッドを収集する(オブジェクト = オブジェクト, 非公開も含むか = false, 収集結果格納場所 = 収集結果格納場所, 対象メソッドチェック = 対象メソッドチェック)
    }

    /**
     *
     */
    fun メソッドを収集する(
        オブジェクト: Any,
        非公開も含むか: Boolean = true,
        収集結果格納場所: MutableList<Method>? = null,
        対象メソッドチェック: Predicate<Method>? = null,
        結果を保持する: Boolean = true
    ): List<Method>? {
        var クラス: Class<Any> = オブジェクト.javaClass

        val 収集結果 =
            if (結果を保持する) {
                収集結果格納場所 ?: mutableListOf()
            } else {
                null
            }

        while (クラス != null) {
            var ストリーム = Arrays.stream(if (非公開も含むか) クラス.declaredMethods else クラス.methods)
            if (対象メソッドチェック != null) {
                ストリーム = ストリーム.filter(対象メソッドチェック)
            }
            ストリーム.forEach { 収集結果?.add(it) }

            クラス = クラス.superclass
        }

        return 収集結果
    }

    /**
     *
     */
    fun 公開メソッドを収集する(オブジェクト: Any, 対象メソッドチェック: (Method) -> Boolean): List<Method>? {
        return メソッドを収集する(オブジェクト, false, 対象メソッドチェック = 対象メソッドチェック)
    }

    /**
     *
     */
    fun 公開メソッドを収集する(オブジェクト: Any, 収集結果格納場所: MutableList<Method>, 対象メソッドチェック: (Method) -> Boolean): List<Method>? {
        return メソッドを収集する(オブジェクト, false, 収集結果格納場所, 対象メソッドチェック)
    }

    /**
     *
     */
    fun メソッドを収集する(
        オブジェクト: Any,
        非公開も含むか: Boolean = true,
        収集結果格納場所: MutableList<Method> = mutableListOf(),
        対象メソッドチェック: (Method) -> Boolean
    ): MutableList<Method>? {
        var クラス: Class<Any>? = オブジェクト.javaClass
        while (クラス != null) {
            for (メソッド in if (非公開も含むか) クラス.declaredMethods else クラス.methods) {
                if (対象メソッドチェック(メソッド)) {
                    収集結果格納場所.add(メソッド)
                }
            }
            クラス = クラス.superclass
        }
        return 収集結果格納場所
    }

    /**
     *
     */
    fun フィールドを取得する(オブジェクト: Any, フィールド名: String): Field? {
        var フィールド: Field? = null
        var クラス: Class<Any> = オブジェクト.javaClass
        while (クラス != null) {
            try {
                フィールド = クラス.getDeclaredField(フィールド名)
            } catch (例外: NoSuchFieldException) {
                // 例外を破棄
            }
            if (フィールド != null) {
                break
            }
            クラス = クラス.superclass
        }
        return フィールド
    }

    /**
     *
     */
    fun フィールドを収集する(オブジェクト: Any): List<Field>? {
        return フィールドを収集する(オブジェクト, mutableListOf<Field>())
    }

    /**
     *
     */
    fun フィールドを収集する(
        オブジェクト: Any,
        収集結果格納場所: MutableList<Field>,
        対象フィールドチェック: Predicate<Field>? = null
    ): List<Field>? {
        var クラス: Class<Any> = オブジェクト.javaClass
        while (クラス != null) {
            var ストリーム = Arrays.stream(クラス.declaredFields)
            if (対象フィールドチェック != null) {
                ストリーム = ストリーム.filter(対象フィールドチェック)
            }
            ストリーム.forEach { 収集結果格納場所.add(it) }
            クラス = クラス.superclass
        }
        return 収集結果格納場所
    }

    fun フィールドを収集する(
        オブジェクト: Any,
        収集結果格納場所: MutableList<Field>,
        対象フィールドチェック: (Method) -> Boolean
    ): List<Field>? {
        var クラス: Class<Any> = オブジェクト.javaClass
        while (クラス != null) {
            Arrays.stream(クラス.declaredFields).forEach {
                収集結果格納場所.add(it)
            }
            クラス = クラス.superclass
        }
        return 収集結果格納場所
    }
}