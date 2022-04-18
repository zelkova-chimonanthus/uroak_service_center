package name.uroak.uroak_service_center.status_test.controllers

import name.uroak.uroak_service_center.base.controllers.コントローラクラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.status_test.services.システム状態確認サービスクラス
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 *
 */
@RestController("システム状態確認コントローラ")
class システム状態確認コントローラクラス : コントローラクラス {
    /***/
    @Autowired
    private lateinit var サービス: システム状態確認サービスクラス

    /**
     *
     */
    constructor() : super("システム状態確認コントローラ") {

    }

    /**
     *
     */
    override fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス? {
        return if (サービス.指定された手続きが実装されているか(手続きパス)) サービス else null
    }
}