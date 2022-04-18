package name.uroak.uroak_service_center.test.controllers

import name.uroak.uroak_service_center.base.controllers.コントローラクラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.test.services.テスト用サービスcase03クラス
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController("テスト用コントローラcase03")
class テスト用コントローラcase03クラス : コントローラクラス {
    /***/
    @Autowired
    private lateinit var サービス: テスト用サービスcase03クラス

    /**
     *
     */
    constructor() : super("テスト用コントローラcase03") {

    }

    /**
     *
     */
    override fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス? {
        return if (サービス.指定された手続きが実装されているか(手続きパス)) サービス else null
    }
}