package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
abstract class データ整理用目録階層クラス(private val 当事者種別: 実行権限当事者種別一覧) {
    /***/
    private var 目録階層 = mutableListOf<データ整理用目録クラス>()

    /***/
    private var 目録マップ = mutableMapOf<Int, データ整理用目録クラス>()

    /**
     *
     */
    protected abstract fun 目録を作成する(識別子: Int, 階層番号: Int): データ整理用目録クラス

    /**
     *
     */
    fun 目録を追加する(識別子: Int, 階層番号: Int) {
        if (!目録が存在するか(識別子)) {
            val 目録 = 目録を作成する(識別子, 階層番号)
            目録階層 += 目録
            目録マップ[識別子] = 目録
        }
    }

    /**
     *
     */
    fun クリアする() {
        目録階層.clear()
        目録マップ.clear()
    }

    /**
     *
     */
    fun 指定された階層の目録を返す(階層番号: Int) = 目録階層[階層番号 - 1]

    /**
     *
     */
    fun 利用者側か() = 実行権限当事者種別を返す() == 実行権限当事者種別一覧.利用者

    /**
     *
     */
    fun 利用対象側か() = 実行権限当事者種別を返す() == 実行権限当事者種別一覧.利用対象

    /**
     *
     */
    fun 実行権限当事者種別を返す() = 当事者種別

    /**
     *
     */
    fun ループ処理をする(アクション: (データ整理用目録クラス) -> Unit) {
        目録階層.forEach(アクション)
    }

    /**
     *
     */
    fun 実行権限設定データを整理する(手続き目録階層: データ整理用手続き目録階層クラス): Boolean {
        if (利用対象側か()) {
            // 利用者側の当事者のみ整理する
            return false
        }
        目録階層.forEach {
            it.実行権限設定データを整理する(手続き目録階層)
        }
        return true
    }

    /**
     *
     */
    fun 所属グループの権限設定を利用対象ごとにまとめる(手続き目録階層: データ整理用手続き目録階層クラス): Boolean {
        if (利用対象側か()) {
            // 利用者側からの処理なので利用対象側の当事者の場合は処理しない
            return false
        }
        目録階層.forEach {
            it.所属グループの権限設定を利用対象ごとにまとめる(手続き目録階層)
        }
        return true
    }

    /**
     *
     */
    fun 目録階層数を返す() = 目録階層.size

    /**
     *
     */
    fun 目録識別子を返す(階層番号: Int) = 目録階層[階層番号].識別子を返す()

    /**
     *
     */
    fun 目録識別子配列を返す(): MutableList<Int> {
        with(mutableListOf<Int>()) {
            目録階層.forEach {
                this += it.識別子を返す()
            }
            return this
        }
    }

    /**
     *
     */
    fun 目録が存在するか(識別子: Int) = 目録マップ.containsKey(識別子)

    /**
     *
     */
    fun 目録を返す(識別子: Int) = 目録マップ[識別子]

    /**
     *
     */
    protected open fun <目録階層データクラス> 目録配列をセットする(目録階層配列: MutableList<目録階層データクラス>, 目録追加処理: (MutableList<目録階層データクラス>) -> Unit) {
        クリアする()
        目録追加処理(目録階層配列)
        目録階層をソートする()
    }

    private fun 目録階層をソートする() {
        目録階層.sortBy { it.階層番号を返す() }
    }
}