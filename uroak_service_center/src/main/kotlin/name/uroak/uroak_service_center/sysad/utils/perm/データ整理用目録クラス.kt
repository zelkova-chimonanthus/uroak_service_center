package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
open class データ整理用目録クラス(private val 識別子: Int, private val 階層番号: Int, private val 当事者種別: 実行権限当事者種別一覧) :
    データ整理用所属グループ付き当事者クラス(識別子, 当事者種別) {
    /**
     *
     */
    fun 階層番号を返す() = 階層番号
}