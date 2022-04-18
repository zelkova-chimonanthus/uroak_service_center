package name.uroak.uroak_service_center.sysad.entity

import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧

data class 手続きデータクラス(
    /***/
    val 識別子: Int = -1,
    /***/
    val 目録識別子: Int = -1,
    /***/
    val 目録名称: String = "",
    /***/
    val コントローラ識別子: Int = -1,
    /***/
    val コントローラ名称: String = "",
    /***/
    val 手続きコード: String = "",
    /***/
    val 手続き補助コード: String? = null,
    /***/
    val 手続き補助コード2: String? = null,
    /***/
    val 処理種別: 手続き処理種別一覧? = null,
    /***/
    val 名称: String = "",
    /***/
    val 備考: String? = null
)
