package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.entity.グループメンバーデータクラス
import name.uroak.uroak_service_center.sysad.entity.会員グループメンバーデータクラス
import name.uroak.uroak_service_center.sysad.entity.手続きグループメンバーデータクラス
import name.uroak.uroak_service_center.sysad.utils.会員メンバー種別一覧.会員
import name.uroak.uroak_service_center.sysad.utils.会員メンバー種別一覧.会員目録
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧
import name.uroak.uroak_service_center.sysad.utils.手続きメンバー種別一覧.手続き
import name.uroak.uroak_service_center.sysad.utils.手続きメンバー種別一覧.手続き目録

/**
 *
 */
open class データ整理用グループクラス<やり取り当事者クラス : データ整理用やりとり当事者クラス, 目録クラス : データ整理用目録クラス, 目録階層クラス : データ整理用目録階層クラス>(private val 識別子: Int, private val 当事者種別: 実行権限当事者種別一覧) :
    データ整理用当事者クラス(識別子, 当事者種別) {

    /***/
    private var やりとり当事者メンバー識別子: Int? = null

    /***/
    private var 目録メンバー識別子配列 = mutableListOf<Int>()

    /***/
    private var 目録メンバー識別子セット = mutableSetOf<Int>()

    /***/
    private var やりとり当事者メンバー: やり取り当事者クラス? = null

    /***/
    private var 目録メンバー配列 = mutableListOf<目録クラス>()

    /***/
    private var 目録メンバーマップ = mutableMapOf<Int, 目録クラス>()

    /***/
    private var 目録メンバー階層番号セット = mutableSetOf<Int>()

    /**
     *
     */
    fun 目録メンバー階層番号セットを返す() = 目録メンバー階層番号セット.toMutableSet()

    /**
     *
     */
    fun メンバーをセットする(メンバーデータ配列: List<グループメンバーデータクラス>) {
        メンバーデータ配列.forEach {

            if (it is 会員グループメンバーデータクラス) {

                when (it.メンバー種別) {
                    会員 -> やりとり当事者メンバー識別子 = it.メンバー識別子
                    会員目録 -> {
                        目録メンバー識別子配列 += it.メンバー識別子
                        目録メンバー識別子セット += it.メンバー識別子
                    }
                    else -> {}
                }
            } else if (it is 手続きグループメンバーデータクラス) {
                it.メンバー識別子
                when (it.メンバー種別) {
                    手続き -> やりとり当事者メンバー識別子 = it.メンバー識別子
                    手続き目録 -> {
                        目録メンバー識別子配列 += it.メンバー識別子
                        目録メンバー識別子セット += it.メンバー識別子
                    }
                    else -> {}
                }
            }
        }
    }

    /**
     *
     */
    fun このやりとり当事者はメンバーか(識別子: Int): Boolean {
        return 識別子 == やりとり当事者メンバー識別子
    }

    /**
     *
     */
    fun この目録はメンバーか(識別子: Int): Boolean {
        return 目録メンバー識別子セット.contains(識別子)
    }

    /**
     * やりとり当事者がこのグループのメンバーならメンバー配列に追加する。同時にやりとり当事者の所属グループにこのグループを追加する。
     */
    protected fun このやり取り当事者がメンバーならセットする(やり取り当事者: やり取り当事者クラス): Boolean {
        return if (このやりとり当事者はメンバーか(やり取り当事者.識別子を返す())) {
            やりとり当事者メンバー = やり取り当事者
            やり取り当事者.所属グループを追加する(this)
            true
        } else {
            やりとり当事者メンバー = null
            false
        }
    }

    /**
     * 目録がこのグループのメンバーならメンバー配列に追加する。同時に目録の所属グループにこのグループを追加する。
     */
    protected fun この目録がメンバーならセットする(目録階層: 目録階層クラス): Boolean {
        var セット = false
        目録階層.ループ処理をする {
            val 目録 = it as 目録クラス
            val 識別子 = it.識別子を返す()
            if (この目録はメンバーか(識別子)) {
                目録メンバーマップ[識別子] = 目録
                目録メンバー配列 += 目録
                目録メンバー階層番号セット += 目録.階層番号を返す()
                目録.所属グループを追加する(this)
                セット = true
            }
        }
        return セット
    }

    /**
     *
     */
    fun この階層番号の目録がメンバーにいるか(階層番号: Int): Boolean {
        return 目録メンバー階層番号セット.contains(階層番号)
    }

    /**
     *
     */
    fun やりとり当事者がメンバーにいるか(): Boolean {
        return やりとり当事者メンバー != null
    }
}