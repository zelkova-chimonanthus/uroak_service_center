package name.uroak.uroak_service_center.sysad.utils.perm.perm_data

import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧

/**
 *
 */
class データ整理用利用対象クラス(
    /***/
    private val 利用対象ID: Int,
    /***/
    private val 利用対象種別: 実行権限利用対象種別一覧
) : データ整理用権限端クラス() {

    /**
     *
     */
    override fun 同じ当事者か(利用対象種別: 実行権限利用対象種別一覧, 識別子: Int): Boolean {
        return 利用対象種別 == this.利用対象種別 && 識別子 == this.利用対象ID
    }

    /**
     *
     */
    fun 利用対象IDを返す() = 利用対象ID

    /**
     *
     */
    fun 利用対象種別を返す() = 利用対象種別

}