package name.uroak.uroak_service_center.sysad.entity

/**
 *
 */
data class 会員目録階層データクラス(
    /***/
    val 階層番号: Int,
    /***/
    val 識別子: Int,
    /***/
    val 名称: String? = "",
    /***/
    val 親目録識別子: Int? = null
)
