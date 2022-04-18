package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
interface ユーザ認証リポジトリ {
    /**
     *
     */
    fun 認証ユーザとして登録されているかチェックする(
        @Param("利用者名") 利用者名: String,
        @Param("利用者パスワード") 利用者パスワード: String
    ): Int
}