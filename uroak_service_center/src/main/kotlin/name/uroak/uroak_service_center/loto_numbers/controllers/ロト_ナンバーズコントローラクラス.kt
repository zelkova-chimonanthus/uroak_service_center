package name.uroak.uroak_service_center.loto_numbers.controllers

import name.uroak.uroak_service_center.base.controllers.コントローラクラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.loto_numbers.services.ロト_ナンバーズ手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 *
 */
@RestController("ロト_ナンバーズコントローラ")
class ロト_ナンバーズコントローラクラス : コントローラクラス {

    /***/
    @Autowired
    private lateinit var サービス: ロト_ナンバーズ手続きサービスクラス

    /**
     *
     */
    constructor() : super("ロト_ナンバーズコントローラ") {

    }

    /**
     *
     */
    override fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス? {
        return if (サービス.指定された手続きが実装されているか(手続きパス)) サービス else null
    }
}