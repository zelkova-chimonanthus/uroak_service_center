package name.uroak.uroak_service_center.stock.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.constants.共通引数フィールド名
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.検索系戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.物理削除系戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.登録_更新_論理削除系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する_NULL不可
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する_NULL不可
import name.uroak.uroak_service_center.stock.constants.引数フィールド名
import name.uroak.uroak_service_center.stock.repository.マスタ検索リポジトリ
import name.uroak.uroak_service_center.stock.repository.取引データ更新リポジトリ
import name.uroak.uroak_service_center.stock.utils.入出金種別一覧
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class 株取引更新手続きサービスクラス : 手続きサービスクラス {

    /***/
    @Autowired
    private lateinit var 取引データ更新リポジトリ: 取引データ更新リポジトリ

    /**
     *
     */
    constructor() : super("株取引更新手続きサービス") {

    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "funds",
        手続きコード補助コード = "money",
        手続きコード補助コード2 = "deposit",
        処理種別 = 手続き処理種別一覧.登録
    )
    fun 入金を記録する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(
            取引データ更新リポジトリ.入出金を記録する(
                入出金日 = パラメータ.文字列値で取得する_NULL不可(引数フィールド名.入出金日),
                入出金種別 = 入出金種別一覧.入金.DB値を返す(),
                金額 = パラメータ.Int値で取得する_NULL不可(引数フィールド名.金額),
                登録者識別子 = 手続き実行情報.利用者情報を返す().会員識別子を返す()
            )
        )
    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "funds",
        手続きコード補助コード = "money",
        手続きコード補助コード2 = "withdraw",
        処理種別 = 手続き処理種別一覧.登録
    )
    fun 出金を記録する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(
            取引データ更新リポジトリ.入出金を記録する(
                入出金日 = パラメータ.文字列値で取得する_NULL不可(引数フィールド名.入出金日),
                入出金種別 = 入出金種別一覧.出金.DB値を返す(),
                金額 = パラメータ.Int値で取得する_NULL不可(引数フィールド名.金額),
                登録者識別子 = 手続き実行情報.利用者情報を返す().会員識別子を返す()
            )
        )
    }
}