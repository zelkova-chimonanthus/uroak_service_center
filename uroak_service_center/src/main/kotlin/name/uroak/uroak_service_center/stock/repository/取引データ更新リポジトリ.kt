package name.uroak.uroak_service_center.stock.repository

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface 取引データ更新リポジトリ {

    /**
     *
     */
    fun 入出金を記録する(
        @Param("入出金日") 入出金日: String,
        @Param("入出金種別") 入出金種別: Int,
        @Param("金額") 金額: Int,
        @Param("登録者") 登録者識別子: Int
    ): Int

}