package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 実行権限管理検索権限関連リポジトリ {

    /**
     *
     */
    fun 実行権限データを収集する(
        @Param("利用者会員識別子") 利用者会員識別子: Int? = null,
        @Param("利用者会員名称") 利用者会員名称: String? = null,
        @Param("利用者会員親目録識別子") 利用者会員親目録識別子: Int? = null,
        @Param("利用者会員親目録名称") 利用者会員親目録名称: String? = null,
        @Param("利用者会員システム管理者") 利用者会員システム管理者: Boolean? = null,
        @Param("利用者会員サービス管理者") 利用者会員サービス管理者: Boolean? = null,
        @Param("対象手続き識別子") 対象手続き識別子: Int? = null,
        @Param("対象手続き名称") 対象手続き名称: String? = null,
        @Param("対象手続き処理種別") 対象手続き処理種別: Int? = null,
        @Param("対象手続き親目録識別子") 対象手続き親目録識別子: Int? = null,
        @Param("対象手続き親目録名称") 対象手続き親目録名称: String? = null,
        @Param("対象手続きコントローラ識別子") 対象手続きコントローラ識別子: Int? = null,
        @Param("対象手続きコントローラ名称") 対象手続きコントローラ名称: String? = null,
        @Param("対象手続きコントローラURLパス") 対象手続きコントローラURLパス: String? = null,
        @Param("対象手続きコントローラ使用中止") 対象手続きコントローラ使用中止: Boolean? = null,
        @Param("対象手続きコード") 対象手続きコード: String? = null,
        @Param("対象手続き補助コード") 対象手続き補助コード: String? = null,
        @Param("対象手続き補助コード2") 対象手続き補助コード2: String? = null,
        @Param("手続きパス") 手続きパス: String? = null,
        @Param("実行権限_読込") 実行権限_読込: Boolean? = null,
        @Param("実行権限_登録") 実行権限_登録: Boolean? = null,
        @Param("実行権限_更新_論理削除") 実行権限_更新_論理削除: Boolean? = null,
        @Param("実行権限_物理削除") 実行権限_物理削除: Boolean? = null,
        @Param("実行権限_インポート") 実行権限_インポート: Boolean? = null,
        @Param("実行権限_エクスポート") 実行権限_エクスポート: Boolean? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>

    /**
     *
     */
    fun 実行権限設定情報を収集する(
        @Param("利用者種別") 利用者種別: Int? = null,
        @Param("利用者識別子") 利用者識別子: Int? = null,
        @Param("利用者会員識別子") 利用者会員識別子: Int? = null,
        @Param("利用者会員名称") 利用者会員名称: String? = null,
        @Param("利用者会員親目録識別子") 利用者会員親目録識別子: Int? = null,
        @Param("利用者会員親目録名称") 利用者会員親目録名称: String? = null,
        @Param("利用者会員システム管理者") 利用者会員システム管理者: Boolean? = null,
        @Param("利用者会員サービス管理者") 利用者会員サービス管理者: Boolean? = null,
        @Param("利用者会員目録識別子") 利用者会員目録識別子: Int? = null,
        @Param("利用者会員目録名称") 利用者会員目録名称: String? = null,
        @Param("利用者会員目録親目録識別子") 利用者会員目録親目録識別子: Int? = null,
        @Param("利用者会員目録親目録名称") 利用者会員目録親目録名称: String? = null,
        @Param("利用者会員グループ識別子") 利用者会員グループ識別子: Int? = null,
        @Param("利用者会員グループ名称") 利用者会員グループ名称: String? = null,
        @Param("管理者グループ識別子") 管理者グループ識別子: Int? = null,
        @Param("管理者グループ名称") 管理者グループ名称: String? = null,
        @Param("利用対象種別") 利用対象種別: Int? = null,
        @Param("利用対象識別子") 利用対象識別子: Int? = null,
        @Param("対象手続き識別子") 対象手続き識別子: Int? = null,
        @Param("対象手続き名称") 対象手続き名称: String? = null,
        @Param("対象手続き処理種別") 対象手続き処理種別: Int? = null,
        @Param("対象手続き親目録識別子") 対象手続き親目録識別子: Int? = null,
        @Param("対象手続き親目録名称") 対象手続き親目録名称: String? = null,
        @Param("対象手続きコントローラ存在") 対象手続きコントローラ存在: Boolean? = null,
        @Param("対象手続きコントローラ識別子") 対象手続きコントローラ識別子: Int? = null,
        @Param("対象手続きコントローラ名称") 対象手続きコントローラ名称: String? = null,
        @Param("対象手続きコントローラ使用中止") 対象手続きコントローラ使用中止: Boolean? = null,
        @Param("手続きパス") 手続きパス: String? = null,
        @Param("対象手続き目録識別子") 対象手続き目録識別子: Int? = null,
        @Param("対象手続き目録名称") 対象手続き目録名称: String? = null,
        @Param("対象手続き目録コントローラ存在") 対象手続き目録コントローラ存在: Boolean? = null,
        @Param("対象手続き目録コントローラ識別子") 対象手続き目録コントローラ識別子: Int? = null,
        @Param("対象手続き目録コントローラ名称") 対象手続き目録コントローラ名称: String? = null,
        @Param("対象手続き目録コントローラ使用中止") 対象手続き目録コントローラ使用中止: Boolean? = null,
        @Param("対象手続き目録親目録識別子") 対象手続き目録親目録識別子: Int? = null,
        @Param("対象手続き目録親目録名称") 対象手続き目録親目録名称: String? = null,
        @Param("対象手続き目録コントローラURLパス") 対象手続き目録コントローラURLパス: String? = null,
        @Param("対象手続きグループ識別子") 対象手続きグループ識別子: Int? = null,
        @Param("対象手続きグループ名称") 対象手続きグループ名称: String? = null,
        @Param("実行権限_読込") 実行権限_読込: Boolean? = null,
        @Param("実行権限_登録") 実行権限_登録: Boolean? = null,
        @Param("実行権限_更新_論理削除") 実行権限_更新_論理削除: Boolean? = null,
        @Param("実行権限_物理削除") 実行権限_物理削除: Boolean? = null,
        @Param("実行権限_インポート") 実行権限_インポート: Boolean? = null,
        @Param("実行権限_エクスポート") 実行権限_エクスポート: Boolean? = null,
        @Param("更新日時最大値") 更新日時最大値: String? = null,
        @Param("更新日時最小値") 更新日時最小値: String? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any>>
}