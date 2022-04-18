package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
class データ整理用会員グループクラス(private val 識別子: Int) : データ整理用グループクラス<データ整理用会員クラス, データ整理用会員目録クラス, データ整理用会員目録階層クラス>(識別子, 実行権限当事者種別一覧.利用者) {

    /**
     *
     */
    override fun 実行権限利用者種別を返す() = 実行権限利用者種別一覧.会員グループ

    /**
     *
     */
    fun この会員はメンバーか(会員識別子: Int): Boolean {
        return super.このやりとり当事者はメンバーか(会員識別子)
    }

    /**
     *
     */
    fun この会員目録はメンバーか(会員目録識別子: Int): Boolean {
        return super.この目録はメンバーか(会員目録識別子)
    }

    /**
     *
     */
    fun この会員がメンバーならセットする(会員: データ整理用会員クラス): Boolean {
        return super.このやり取り当事者がメンバーならセットする(会員)
    }

    /**
     *
     */
    fun この会員目録がメンバーならセットする(会員目録階層: データ整理用会員目録階層クラス): Boolean {
        return super.この目録がメンバーならセットする(会員目録階層)
    }

    /**
     *
     */
    fun この階層番号の会員目録がメンバーにいるか(階層番号: Int): Boolean {
        return super.この階層番号の目録がメンバーにいるか(階層番号)
    }

    /**
     *
     */
    fun 会員がメンバーにいるか(): Boolean {
        return super.やりとり当事者がメンバーにいるか()
    }
}