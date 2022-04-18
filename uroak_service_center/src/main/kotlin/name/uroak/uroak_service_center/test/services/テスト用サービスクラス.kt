package name.uroak.uroak_service_center.test.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.*
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.test.repository.テスト用リポジトリ
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class テスト用サービスクラス : 手続きサービスクラス {
    /***/
    @Autowired
    private lateinit var テスト用リポジトリ: テスト用リポジトリ

    /**
     *
     */
    constructor() : super("テスト用サービス") {

    }

    @手続き呼出し(
        手続きコード = "search",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 検索する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val 取得データ = mutableListOf<Map<String, Any?>>()

        val テスト用レコード = mutableMapOf<String, Any?>()
        テスト用レコード["識別子"] = 100
        テスト用レコード["名称"] = "テスト"

        取得データ += テスト用レコード

        return 戻り値.取得データをセットする(取得データ)
    }

    @手続き呼出し(
        手続きコード = "register",
        処理種別 = 手続き処理種別一覧.登録
    )
    fun 登録する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(100)
    }

    @手続き呼出し(
        手続きコード = "update",
        処理種別 = 手続き処理種別一覧.更新
    )
    fun 更新する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(100)
    }

    @手続き呼出し(
        手続きコード = "logical_delete",
        処理種別 = 手続き処理種別一覧.論理削除
    )
    fun 論理削除する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(100)
    }

    @手続き呼出し(
        手続きコード = "register_update",
        処理種別 = 手続き処理種別一覧.登録_更新
    )
    fun 登録_更新する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return 登録_更新_論理削除系戻り値クラス(手続き実行情報).処理件数をセットする(100)
    }

    @手続き呼出し(
        手続きコード = "delete",
        処理種別 = 手続き処理種別一覧.物理削除
    )
    fun 物理削除する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return 物理削除系戻り値クラス(手続き実行情報).削除件数をセットする(100)
    }

    @手続き呼出し(
        手続きコード = "import",
        処理種別 = 手続き処理種別一覧.インポート
    )
    fun インポートする(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return インポート系戻り値クラス(手続き実行情報)
    }

    @手続き呼出し(
        手続きコード = "export",
        処理種別 = 手続き処理種別一覧.エクスポート
    )
    fun エクスポートする(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        return エクスポート系戻り値クラス(手続き実行情報)
    }
}