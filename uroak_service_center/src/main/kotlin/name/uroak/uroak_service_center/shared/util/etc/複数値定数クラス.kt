package name.uroak.uroak_service_center.shared.util.etc

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス

/**
 *
 */
abstract class 複数値定数クラス<定数タイプ> {
    /***/
    private var 定数セット = mutableListOf<定数タイプ>()

    constructor() {
    }

    /**
     *
     */
    constructor(定数セット: MutableList<定数タイプ>) {
        this.定数セット = 定数セット
    }

    /**
     *
     */
    fun 定数をセットする(vararg 定数: 定数タイプ): Unit {
        定数セット.clear()
        定数.forEach {
            定数セット += it
        }
    }

    /**
     *
     */
    fun 定数の数を返す(): Int {
        return 定数セット.size
    }

    /**
     *
     */
    fun 定数未設定か(): Boolean {
        return 定数セット.isEmpty()
    }

    /***/
    protected abstract fun 等しいかチェックする(比較対象値: 定数タイプ, 位置: Int, 定数: 定数タイプ): Boolean

    /**
     *
     */
    fun 等しいかチェックする(比較対象値: 定数タイプ?): Boolean {
        比較対象値 ?: return false
        if (定数未設定か()) {
            return false
        }
        for ((位置, 定数) in 定数セット.withIndex()) {
            if (等しいかチェックする(比較対象値, 位置, 定数)) {
                return true
            }
        }
        return false
    }

    /**
     *
     */
    fun 定数を取得する(位置: Int): 定数タイプ {
        return if (定数未設定か())
            throw 共通処理エラークラス(this.javaClass, メッセージID一覧.SHR_E_0023)
        else if (定数の数を返す() <= 位置) {
            throw 共通処理エラークラス(this.javaClass, メッセージID一覧.SHR_E_0022, 定数の数を返す(), 位置)
        } else {
            定数セット[位置]
        }
    }
}

/**
 *
 */
open class 複数値文字列定数値クラス : 複数値定数クラス<String> {

    /**
     *
     */
    constructor()

    /**
     *
     */
    constructor(定数セット: MutableList<String>) : super(定数セット)

    /**
     *
     */
    override fun 等しいかチェックする(比較対象値: String, 位置: Int, 定数: String): Boolean {
        return 比較対象値 == 定数
    }
}

/**
 *
 */
open class 複数値整数定数値クラス : 複数値定数クラス<Int> {

    /**
     *
     */
    constructor()

    /**
     *
     */
    constructor(定数セット: MutableList<Int>) : super(定数セット)

    /**
     *
     */
    override fun 等しいかチェックする(比較対象値: Int, 位置: Int, 定数: Int): Boolean {
        return 比較対象値 == 定数
    }
}