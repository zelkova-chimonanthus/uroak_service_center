package name.uroak.uroak_service_center.sysad.entity

import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
data class 実行権限データクラス(
    /***/
    val 会員識別子: Int?,
    /***/
    val 手続き識別子: Int?,
    /***/
    val 権限: 権限属性クラス
)
