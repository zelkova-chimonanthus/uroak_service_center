package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
class データ整理用手続き目録クラス(private val 識別子: Int, private val 階層番号: Int) : データ整理用目録クラス(識別子, 階層番号, 実行権限当事者種別一覧.利用対象) {
    /**
     *
     */
    override fun 実行権限利用対象種別を返す() = 実行権限利用対象種別一覧.手続き目録
}