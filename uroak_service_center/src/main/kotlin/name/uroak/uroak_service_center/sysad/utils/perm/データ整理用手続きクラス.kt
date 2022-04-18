package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧

/**
 *
 */
class データ整理用手続きクラス(private val 識別子: Int) : データ整理用やりとり当事者クラス(識別子, 実行権限当事者種別一覧.利用対象) {
    /**
     *
     */
    override fun 実行権限利用対象種別を返す() = 実行権限利用対象種別一覧.手続き
}