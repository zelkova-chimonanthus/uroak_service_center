package name.uroak.uroak_service_center.sysad.entity

/**
 *
 */
data class グループデータクラス(
    /***/
    val グループ識別子: Int,
    /***/
    val グループ名称: String? = "",
    /**メンバーにグループが存在するかどうか*/
    var グループ存在フラグ: Boolean = false,
    /**グループメンバーの配列*/
    var メンバー: List<グループメンバーデータクラス> = mutableListOf()
)
