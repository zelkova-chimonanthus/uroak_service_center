package name.uroak.uroak_service_center.sysad.entity

data class コントローラデータクラス(
    /***/
    val 識別子: Int,
    /***/
    val 名称: String,
    /***/
    val 目録識別子: Int? = null,
    /***/
    val 目録名称: String,
    /***/
    val URLパス: String,
    /***/
    val DIコンポーネント名: String,
    /***/
    val クラス名: String? = null,
    /***/
    val クラスパッケージパス: String? = null,
    /***/
    val 使用中止: Boolean,
    /***/
    val システム管理用: Boolean
)
