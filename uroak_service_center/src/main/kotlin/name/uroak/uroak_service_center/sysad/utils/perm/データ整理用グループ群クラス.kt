package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.entity.グループデータクラス
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
abstract class データ整理用グループ群クラス(private val 当事者種別: 実行権限当事者種別一覧) {
    /***/
    private var グループ配列 = mutableListOf<データ整理用グループクラス<*, *, *>>()

    /***/
    private var グループマップ = mutableMapOf<Int, データ整理用グループクラス<*, *, *>>()

    /**
     *
     */
    fun グループを返す(識別子: Int) = グループマップ[識別子]

    /**
     *
     */
    fun クリアする() {
        グループ配列.clear()
        グループマップ.clear()
    }

    /**
     *
     */
    fun グループを追加する(識別子: Int) {
        if (!グループが存在するか(識別子)) {
            val グループ = グループを作成する(識別子)
            グループ配列 += グループ
            グループマップ[識別子] = グループ
        }

    }

    /**
     *
     */
    protected abstract fun グループを作成する(識別子: Int): データ整理用グループクラス<*, *, *>

    /**
     *
     */
    fun グループが存在するか(識別子: Int): Boolean {
        return グループマップ.containsKey(識別子)
    }

    /**
     *
     */
    fun グループ群をセットする(グループデータ配列: MutableList<グループデータクラス>) {
        クリアする()
        グループデータ配列.forEach {
            val 識別子 = it.グループ識別子
            if (!グループが存在するか(識別子)) {
                val グループ = グループを作成する(識別子)
                グループ.メンバーをセットする(it.メンバー)
                グループ配列 += グループ
                グループマップ[識別子] = グループ
            }
        }
    }

    /**
     *
     */
    fun ループ処理をする(アクション: (データ整理用グループクラス<*, *, *>) -> Unit) {
        グループ配列.forEach(アクション)
    }

    /**
     *
     */
    fun グループ識別子配列を返す(): MutableList<Int> {
        with(mutableListOf<Int>()) {
            グループ配列.forEach {
                this += it.識別子を返す()
            }
            return this
        }
    }

    /**
     *
     */
    fun 実行権限設定データを整理する(手続き目録階層: データ整理用手続き目録階層クラス): Boolean {
        if (利用対象側か()) {
            // 利用者側の当事者のみ整理する
            return false
        }
        グループ配列.forEach {
            it.実行権限設定データを整理する(手続き目録階層)
        }
        return true
    }

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
}