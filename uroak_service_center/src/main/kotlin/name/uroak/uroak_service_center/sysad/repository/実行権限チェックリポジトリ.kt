package name.uroak.uroak_service_center.sysad.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 実行権限チェックリポジトリ {

    /**
     *
     */
    fun コントローラ情報を収集する(): List<Map<String, Any?>>

    /**
     *
     */
    fun 会員情報を取得する(
        @Param("識別トークン") 識別トークン: String
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 手続き情報を取得する(
        @Param("手続きコード") 手続きコード: String,
        @Param("手続き補助コード") 手続き補助コード: String?,
        @Param("手続き補助コード2") 手続き補助コード2: String?
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 実行権限を取得する(
        @Param("会員識別子") 会員識別子: Int?,
        @Param("手続き識別子") 手続き識別子: Int?
    ): List<Map<String, Any?>>

    /**
     *階層番号は階層の下位から振られている
     */
    fun 会員目録階層を取得する(
        @Param("会員識別子") 会員識別子: Int
    ): List<Map<String, Any?>>

    /**
     *階層番号は階層の下位から振られている
     */
    fun 手続き目録階層を取得する(
        @Param("手続き識別子") 手続き識別子: Int
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 指定会員が所属する会員グループを収集する(
        @Param("会員識別子") 会員識別子: Int,
        @Param("会員目録階層") 会員目録階層: List<Int>
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 指定手続きが所属する手続きグループを収集する(
        @Param("手続き識別子") 手続き識別子: Int,
        @Param("手続き目録階層") 手続き目録階層: List<Int>
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 会員グループを展開する(
        @Param("グループ識別子") 会員グループ識別子: Int,
        @Param("当事者識別子") 会員識別子: Int,
        @Param("目録階層") 会員目録階層: List<Int>
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 手続きグループを展開する(
        @Param("グループ識別子") 手続きグループ識別子: Int,
        @Param("当事者識別子") 手続き識別子: Int,
        @Param("目録階層") 手続き目録階層: List<Int>
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 対象限定管理者の実行権限設定データを取得する(
        @Param("会員識別子") 会員識別子: Int,
        @Param("手続き識別子") 手続き識別子: Int,
        @Param("手続き目録階層") 手続き目録階層: List<Int>,
        @Param("手続きグループ群") 手続きグループ群: List<Int>
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 実行権限設定データを取得する(
        @Param("会員識別子") 会員識別子: Int,
        @Param("会員目録階層") 会員目録階層: List<Int>,
        @Param("会員グループ群") 会員グループ群: List<Int>,
        @Param("手続き識別子") 手続き識別子: Int,
        @Param("手続き目録階層") 手続き目録階層: List<Int>,
        @Param("手続きグループ群") 手続きグループ群: List<Int>
    ): List<Map<String, Any?>>

    fun 実行権限データを登録する(
        @Param("会員識別子") 会員識別子: Int,
        @Param("手続き識別子") 手続き識別子: Int,
        @Param("権限") 権限: Int
    ): Int
}