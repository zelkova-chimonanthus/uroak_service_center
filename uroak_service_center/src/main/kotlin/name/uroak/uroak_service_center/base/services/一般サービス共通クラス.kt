package name.uroak.uroak_service_center.base.services

import name.uroak.uroak_service_center.shared.service.データ操作サービスクラス
import org.springframework.beans.factory.annotation.Autowired

/**
 *
 */
abstract class 一般サービス共通クラス : サービスクラス {
    /***/
    @Autowired
    protected lateinit var データ操作サービス: データ操作サービスクラス

    /**
     *
     */
    constructor(名前: String) : super(名前) {

    }

    /**
     *
     */
    constructor() : super() {

    }

    /**
     *
     */
    fun 取得件数が限定されていれば全体件数を返す(件数限定フラグ: Boolean): Int? {
        return if (件数限定フラグ)
            データ操作サービス.全体行数を取得する()
        else
            null
    }
}