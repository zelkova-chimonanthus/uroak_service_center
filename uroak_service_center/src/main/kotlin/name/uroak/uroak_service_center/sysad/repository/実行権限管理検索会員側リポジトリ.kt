package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 実行権限管理検索会員側リポジトリ {

    /**
     *
     */
    fun システム管理者情報を収集する(
        @Param("メンバー識別子") メンバー識別子: Int? = null,
        @Param("会員ID") 会員ID: Int? = null,
        @Param("会員名称") 会員名称: String? = null,
        @Param("会員識別トークン") 会員識別トークン: String? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun サービス管理者情報を収集する(
        @Param("メンバー識別子") メンバー識別子: Int? = null,
        @Param("会員識別子") 会員識別子: Int? = null,
        @Param("会員名称") 会員名称: String? = null,
        @Param("会員識別トークン") 会員識別トークン: String? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 個別サービス管理者情報を収集する(
        @Param("グループ識別子") グループ識別子: Int? = null,
        @Param("グループ名称") グループ名称: String? = null,
        @Param("メンバー識別子") メンバー識別子: Int? = null,
        @Param("会員識別子") 会員識別子: Int? = null,
        @Param("会員名称") 会員名称: String? = null,
        @Param("会員識別トークン") 会員識別トークン: String? = null,
        @Param("会員親目録識別子") 会員親目録識別子: Int? = null,
        @Param("会員親目録名称") 会員親目録名称: String? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 会員情報を収集する(
        @Param("会員識別子") 会員識別子: Int? = null,
        @Param("会員識別トークン") 会員識別トークン: String? = null,
        @Param("ログイン不可") ログイン不可: Boolean? = null,
        @Param("会員名称") 会員名称: String? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("親目録名称") 親目録名称: String? = null,
        @Param("システム管理者") システム管理者: Boolean? = null,
        @Param("サービス管理者") サービス管理者: Boolean? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 会員目録情報を収集する(
        @Param("目録識別子") 目録識別子: Int? = null,
        @Param("目録名称") 目録名称: String? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("親目録名称") 親目録名称: String? = null,
        @Param("登録会員有無") 登録会員有無: Boolean? = null,
        @Param("登録目録有無") 登録目録有無: Boolean? = null,
        @Param("登録有無") 登録有無: Boolean? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 会員グループ情報を収集する(
        @Param("グループ識別子") グループ識別子: Int? = null,
        @Param("グループ名称") グループ名称: String? = null,
        @Param("所属会員有無") 所属会員有無: Boolean? = null,
        @Param("所属目録有無") 所属目録有無: Boolean? = null,
        @Param("所属グループ有無") 所属グループ有無: Boolean? = null,
        @Param("メンバー種別不明有無") メンバー種別不明有無: Boolean? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 会員グループメンバー情報を収集する(
        @Param("グループ識別子") グループ識別子: Int? = null,
        @Param("グループ名称") グループ名称: String? = null,
        @Param("メンバー種別") メンバー種別: Int? = null,
        @Param("メンバー会員識別子") メンバー会員識別子: Int? = null,
        @Param("メンバー会員名称") メンバー会員名称: String? = null,
        @Param("メンバー会員識別トークン") メンバー会員識別トークン: String? = null,
        @Param("メンバー会員ログイン不可") メンバー会員ログイン不可: Boolean? = null,
        @Param("メンバー目録識別子") メンバー目録識別子: Int? = null,
        @Param("メンバー目録名称") メンバー目録名称: String? = null,
        @Param("メンバー親目録識別子") メンバー親目録識別子: Int? = null,
        @Param("メンバー親目録名称") メンバー親目録名称: String? = null,
        @Param("メンバーグループ識別子") メンバーグループ識別子: Int? = null,
        @Param("メンバーグループ名称") メンバーグループ名称: String? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

}