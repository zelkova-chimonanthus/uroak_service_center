package name.uroak.uroak_service_center.sysad.entity

data class 会員データクラス(

    /***/
    val 識別子: Int,

    /***/
    val 目録識別子: Int? = null,

    /***/
    val 目録名称: String,

    /***/
    val 識別トークン: String,

    /***/
    val 名称: String,

    /***/
    val 備考: String,

    /***/
    val ログイン不可: Boolean,

    /***/
    val 目録存在フラグ: Boolean,

    /***/
    val システム管理者フラグ: Boolean,

    /***/
    val サービス管理者フラグ: Boolean

)
