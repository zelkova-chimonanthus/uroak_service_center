package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import java.lang.reflect.Method

/**
 *
 */
data class 手続きメソッドデータクラス(
    /***/
    val 手続きコード: String? = null,
    /***/
    val 手続き補助コード: String? = null,
    /***/
    val 手続き補助コード2: String? = null,
    /***/
    val 処理種別: 手続き処理種別一覧,
    /***/
    val メソッド: Method
)
