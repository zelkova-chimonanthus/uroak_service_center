package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 実行権限管理検索手続き側リポジトリ {

    /**
     *
     */
    fun 手続き情報を収集する(
        @Param("手続き識別子") 手続き識別子: Int? = null,
        @Param("手続き名称") 手続き名称: String? = null,
        @Param("手続き処理種別") 手続き処理種別: Int? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("親目録名称") 親目録名称: String? = null,
        @Param("コントローラ識別子") コントローラ識別子: Int? = null,
        @Param("コントローラ名称") コントローラ名称: String? = null,
        @Param("コントローラURLパス") コントローラURLパス: String? = null,
        @Param("コントローラ使用中止") コントローラ使用中止: Boolean? = null,
        @Param("手続きコード") 手続きコード: String? = null,
        @Param("手続き補助コード") 手続き補助コード: String? = null,
        @Param("手続き補助コード2") 手続き補助コード2: String? = null,
        @Param("手続きパス") 手続きパス: String? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 手続き目録情報を収集する(
        @Param("目録識別子") 目録識別子: Int? = null,
        @Param("目録名称") 目録名称: String? = null,
        @Param("コントローラ連携目録") コントローラ連携目録: Boolean? = null,
        @Param("コントローラ識別子") コントローラ識別子: Int? = null,
        @Param("コントローラ名称") コントローラ名称: String? = null,
        @Param("コントローラURLパス") コントローラURLパス: String? = null,
        @Param("コントローラ使用中止") コントローラ使用中止: Boolean? = null,
        @Param("親目録識別子") 親目録識別子: Int? = null,
        @Param("親目録名称") 親目録名称: String? = null,
        @Param("登録手続き有無") 登録手続き有無: Boolean? = null,
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
    fun 手続きグループ情報を収集する(
        @Param("グループ識別子") グループ識別子: Int? = null,
        @Param("グループ名称") グループ名称: String? = null,
        @Param("所属手続き有無") 所属手続き有無: Boolean? = null,
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
    fun 手続きグループメンバー情報を収集する(
        @Param("グループ識別子") グループ識別子: Int? = null,
        @Param("グループ名称") グループ名称: String? = null,
        @Param("メンバー識別子") メンバー識別子: Int? = null,
        @Param("メンバー種別") メンバー種別: Int? = null,
        @Param("メンバー対象識別子") メンバー対象識別子: Int? = null,
        @Param("メンバー手続き識別子") メンバー手続き識別子: Int? = null,
        @Param("メンバー手続き名称") メンバー手続き名称: String? = null,
        @Param("メンバー手続き親目録識別子") メンバー手続き親目録識別子: Int? = null,
        @Param("メンバー手続き親目録有無") メンバー手続き親目録有無: Boolean? = null,
        @Param("メンバー手続き親目録名称") メンバー手続き親目録名称: String? = null,
        @Param("メンバー目録識別子") メンバー目録識別子: Int? = null,
        @Param("メンバー目録名称") メンバー目録名称: String? = null,
        @Param("メンバー目録親目録識別子") メンバー目録親目録識別子: Int? = null,
        @Param("メンバー目録親目録有無") メンバー目録親目録有無: Boolean? = null,
        @Param("メンバー目録親目録名称") メンバー目録親目録名称: String? = null,
        @Param("メンバーグループ識別子") メンバーグループ識別子: Int? = null,
        @Param("メンバーグループ名称") メンバーグループ名称: String? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun コントローラ情報を収集する(
        @Param("コントローラ識別子") コントローラ識別子: Int? = null,
        @Param("コントローラ名称") コントローラ名称: String? = null,
        @Param("コントローラURLパス") コントローラURLパス: String? = null,
        @Param("コントローラDIコンポーネント名") コントローラDIコンポーネント名: String? = null,
        @Param("コントローラクラス名") コントローラクラス名: String? = null,
        @Param("コントローラクラスパッケージパス") コントローラクラスパッケージパス: String? = null,
        @Param("コントローラ使用中止") コントローラ使用中止: Boolean? = null,
        @Param("対応目録存在") 対応目録存在: Boolean? = null,
        @Param("対応目録識別子") 対応目録識別子: Int? = null,
        @Param("対応目録名称") 対応目録名称: String? = null,
        @Param("対応目録親目録識別子") 対応目録親目録識別子: Int? = null,
        @Param("対応目録親目録存在") 対応目録親目録存在: Boolean? = null,
        @Param("対応目録親目録名称") 対応目録親目録名称: String? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

}