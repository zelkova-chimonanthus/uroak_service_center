package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧

/**
 *
 */
class データ整理用会員クラス(private val 識別子: Int) : データ整理用やりとり当事者クラス(識別子, 実行権限当事者種別一覧.利用者) {
    /**
     *
     */
    override fun 実行権限利用者種別を返す() = 実行権限利用者種別一覧.会員
}