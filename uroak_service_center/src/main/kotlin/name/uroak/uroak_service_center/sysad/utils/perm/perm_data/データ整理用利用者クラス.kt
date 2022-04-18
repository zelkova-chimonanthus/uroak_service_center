package name.uroak.uroak_service_center.sysad.utils.perm.perm_data

import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧

/**
 *
 */
class データ整理用利用者クラス(
    /***/
    private val 利用者ID: Int,
    /***/
    private val 利用者種別: 実行権限利用者種別一覧
) : データ整理用権限端クラス() {

    /**
     *
     */
    override fun 同じ当事者か(利用者種別: 実行権限利用者種別一覧, 識別子: Int): Boolean {
        return 利用者種別 == this.利用者種別 && 識別子 == this.利用者ID
    }

    /**
     *
     */
    fun 利用者IDを返す() = 利用者ID

    /**
     *
     */
    fun 利用者種別を返す() = 利用者種別

}