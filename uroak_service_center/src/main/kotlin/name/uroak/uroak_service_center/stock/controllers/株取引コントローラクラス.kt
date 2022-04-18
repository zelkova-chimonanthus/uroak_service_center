package name.uroak.uroak_service_center.stock.controllers

import name.uroak.uroak_service_center.base.controllers.コントローラクラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.stock.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 *
 */
@RestController("株取引コントローラ")
class 株取引コントローラクラス : コントローラクラス {
    /***/
    @Autowired
    private lateinit var マスタ検索手続きサービス: 株取引マスタ検索手続きサービスクラス

    /***/
    @Autowired
    private lateinit var マスタ更新手続きサービス: 株取引マスタ更新手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 検索手続きサービス: 株取引検索手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 更新手続きサービス: 株取引更新手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 削除手続きサービス: 株取引削除手続きサービスクラス

    /**
     *
     */
    constructor() : super("株取引コントローラ") {

    }

    /**
     *
     */
    override fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス? {
        return if (マスタ検索手続きサービス.指定された手続きが実装されているか(手続きパス))
            マスタ検索手続きサービス
        else if (検索手続きサービス.指定された手続きが実装されているか(手続きパス))
            検索手続きサービス
        else if (更新手続きサービス.指定された手続きが実装されているか(手続きパス))
            更新手続きサービス
        else if (マスタ更新手続きサービス.指定された手続きが実装されているか(手続きパス))
            マスタ更新手続きサービス
        else if (削除手続きサービス.指定された手続きが実装されているか(手続きパス))
            削除手続きサービス
        else
            null
    }
}