package name.uroak.uroak_service_center.sysad.utils

import name.uroak.uroak_service_center.shared.base.util.会員情報クラス
import name.uroak.uroak_service_center.shared.base.util.手続き情報クラス

/**
 *
 */
data class 実行権限チェック結果データクラス(
    /***/
    var 実行可能: Boolean = false,
    /***/
    var 会員情報: 会員情報クラス,
    /***/
    var 手続き情報: 手続き情報クラス
)

