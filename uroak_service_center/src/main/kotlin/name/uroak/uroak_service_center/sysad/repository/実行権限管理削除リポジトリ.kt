package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 実行権限管理削除リポジトリ {
    /**
     *
     */
    fun 実行権限データを削除する(
        @Param("削除対象会員識別子") 削除対象会員識別子: Int? = null,
        @Param("削除対象手続き識別子") 削除対象手続き識別子: Int? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null
    ): Int
}