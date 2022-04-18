package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
class データ整理用手続きグループクラス(private val 識別子: Int) : データ整理用グループクラス<データ整理用手続きクラス, データ整理用手続き目録クラス, データ整理用手続き目録階層クラス>(識別子, 実行権限当事者種別一覧.利用対象) {

    /**
     *
     */
    override fun 実行権限利用対象種別を返す() = 実行権限利用対象種別一覧.手続きグループ

    /**
     *
     */
    fun この手続きはメンバーか(手続き識別子: Int): Boolean {
        return super.このやりとり当事者はメンバーか(手続き識別子)
    }

    /**
     *
     */
    fun この手続き目録はメンバーか(手続き目録識別子: Int): Boolean {
        return super.この目録はメンバーか(手続き目録識別子)
    }

    /**
     *
     */
    fun この手続きがメンバーならセットする(手続き: データ整理用手続きクラス): Boolean {
        return super.このやり取り当事者がメンバーならセットする(手続き)
    }

    /**
     *
     */
    fun この手続き目録がメンバーならセットする(手続き目録階層: データ整理用手続き目録階層クラス): Boolean {
        return super.この目録がメンバーならセットする(手続き目録階層)
    }

    /**
     *
     */
    fun この階層番号の手続き目録がメンバーにいるか(階層番号: Int): Boolean {
        return super.この階層番号の目録がメンバーにいるか(階層番号)
    }

    /**
     *
     */
    fun 手続きがメンバーにいるか(): Boolean {
        return super.やりとり当事者がメンバーにいるか()
    }
}