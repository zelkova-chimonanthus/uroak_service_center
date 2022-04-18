package name.uroak.uroak_service_center.stock.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.constants.共通引数フィールド名
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.検索系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する
import name.uroak.uroak_service_center.stock.constants.引数フィールド名
import name.uroak.uroak_service_center.stock.repository.マスタ検索リポジトリ
import name.uroak.uroak_service_center.stock.repository.取引データ検索リポジトリ
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class 株取引マスタ更新手続きサービスクラス : 手続きサービスクラス {

    /***/
    @Autowired
    private lateinit var 取引データ検索リポジトリ: 取引データ検索リポジトリ

    /**
     *
     */
    constructor() : super("株取引マスタ更新手続きサービス") {

    }

}