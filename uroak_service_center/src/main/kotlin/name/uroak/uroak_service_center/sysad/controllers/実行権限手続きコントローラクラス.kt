package name.uroak.uroak_service_center.sysad.controllers

import name.uroak.uroak_service_center.base.controllers.コントローラクラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.sysad.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 *
 */
@RestController("実行権限手続きコントローラ")
class 実行権限手続きコントローラクラス : コントローラクラス {
    /***/
    @Autowired
    private lateinit var 検索会員側手続きサービス: 実行権限検索会員側手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 検索手続き側手続きサービス: 実行権限検索手続き側手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 検索権限関連手続きサービス: 実行権限検索権限関連手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 更新手続きサービス: 実行権限更新手続きサービスクラス

    /***/
    @Autowired
    private lateinit var 削除手続きサービス: 実行権限削除手続きサービスクラス

    /**
     *
     */
    constructor() : super("実行権限手続きコントローラ") {

    }

    /**
     *
     */
    override fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス? {
        return if (検索会員側手続きサービス.指定された手続きが実装されているか(手続きパス))
            検索会員側手続きサービス
        else if (検索手続き側手続きサービス.指定された手続きが実装されているか(手続きパス))
            検索手続き側手続きサービス
        else if (検索権限関連手続きサービス.指定された手続きが実装されているか(手続きパス))
            検索権限関連手続きサービス
        else if (更新手続きサービス.指定された手続きが実装されているか(手続きパス))
            更新手続きサービス
        else if (削除手続きサービス.指定された手続きが実装されているか(手続きパス))
            削除手続きサービス
        else
            null
    }
}