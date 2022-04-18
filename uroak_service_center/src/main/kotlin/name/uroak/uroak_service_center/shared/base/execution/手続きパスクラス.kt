package name.uroak.uroak_service_center.shared.base.execution

import name.uroak.uroak_service_center.shared.base.util.コントローラ情報クラス
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import java.lang.StringBuilder

/**
 *
 */
class 手続きパスクラス(
    /***/
    val 手続きコード: String = "",
    /***/
    val 手続き補助コード: String = "",
    /***/
    val 手続き補助コード2: String = ""
) {
    fun 文字列化する(コントローラ情報: コントローラ情報クラス): String {
        val 文字列 = StringBuilder(100)
        文字列.append(コントローラ情報.コントローラURLパスを返す()).append('/')
        文字列.append(手続きコード)
        if (!文字列道具箱.空白文字列か(手続き補助コード)) {
            文字列.append('/').append(手続き補助コード)
            if (!文字列道具箱.空白文字列か(手続き補助コード2)) {
                文字列.append('/').append(手続き補助コード2)
            }
        }
        return 文字列.toString()
    }
}
