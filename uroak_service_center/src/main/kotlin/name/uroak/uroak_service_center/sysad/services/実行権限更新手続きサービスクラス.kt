package name.uroak.uroak_service_center.sysad.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.sysad.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class 実行権限更新手続きサービスクラス : 手続きサービスクラス {
    /***/
    @Autowired
    private lateinit var 実行権限管理更新リポジトリ: 実行権限管理更新リポジトリ

    /**
     *
     */
    constructor() : super("実行権限更新手続きサービス") {

    }

}