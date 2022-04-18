package name.uroak.uroak_service_center.shared.service

import name.uroak.uroak_service_center.base.services.サービスクラス
import name.uroak.uroak_service_center.base.services.汎用サービスクラス
import name.uroak.uroak_service_center.shared.repository.汎用データ操作リポジトリ
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class データ操作サービスクラス : サービスクラス {

    @Autowired
    private lateinit var 汎用データ操作: 汎用データ操作リポジトリ

    /**
     *
     */
    constructor() : super("データ操作サービス") {

    }

    /**
     *
     */
    fun 全体行数を取得する(): Int {
        return 汎用データ操作.全体行数を取得する()
    }
}