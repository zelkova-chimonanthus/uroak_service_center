package name.uroak.uroak_service_center.stock.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface マスタ検索リポジトリ {
    /**
     *
     */
    fun 六大州情報を取得する(
        @Param("六大州コード") 六大州コード: Int? = null
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 国の地域情報を取得する(
        @Param("国の地域コード") 国の地域コード: Int? = null,
        @Param("六大州コード") 六大州コード: Int? = null
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 国情報を取得する(
        @Param("コード_数字3桁") コード_数字3桁: String? = null,
        @Param("コード_英字3文字") コード_英字3文字: String? = null,
        @Param("コード_英字2文字") コード_英字2文字: String? = null,
        @Param("国名称") 国名称: String? = null,
        @Param("国正式名称") 国正式名称: String? = null,
        @Param("地域コード") 地域コード: Int? = null,
        @Param("六大州コード") 六大州コード: Int? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 地方情報を取得する(
        @Param("地方コード") 地方コード: Int? = null
    ): List<Map<String, Any?>>

    /**
     *
     */
    fun 都道府県情報を取得する(
        @Param("都道府県コード") 都道府県コード: Int? = null,
        @Param("地方コード") 地方コード: Int? = null,
        @Param("取得件数上限") 取得件数上限: Int? = null,
        @Param("取得開始位置") 取得開始位置: Int? = null
    ): List<Map<String, Any?>>
}