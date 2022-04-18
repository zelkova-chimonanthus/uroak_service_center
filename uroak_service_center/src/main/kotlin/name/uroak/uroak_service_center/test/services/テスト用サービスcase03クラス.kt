package name.uroak.uroak_service_center.test.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.検索系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.test.repository.テスト用case03リポジトリ
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class テスト用サービスcase03クラス : 手続きサービスクラス {
    /***/
    @Autowired
    private lateinit var テスト用case03リポジトリ: テスト用case03リポジトリ

    /**
     *
     */
    constructor() : super("テスト用サービスcase03") {

    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "case03",
        手続きコード補助コード = "pattern1",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 手続きpattern1を実行する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val 取得データ = mutableListOf<Map<String, Any?>>()

        val テスト用レコード = mutableMapOf<String, Any?>()
        テスト用レコード["名称"] = "テストcase03"
        テスト用レコード["パターン番号"] = 1

        取得データ += テスト用レコード

        return 戻り値.取得データをセットする(取得データ)
    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "case03",
        手続きコード補助コード = "pattern2",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 手続きpattern2を実行する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val 取得データ = mutableListOf<Map<String, Any?>>()

        val テスト用レコード = mutableMapOf<String, Any?>()
        テスト用レコード["名称"] = "テストcase03"
        テスト用レコード["パターン番号"] = 2

        取得データ += テスト用レコード

        return 戻り値.取得データをセットする(取得データ)
    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "case03",
        手続きコード補助コード = "pattern3",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 手続きpattern3を実行する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val 取得データ = mutableListOf<Map<String, Any?>>()

        val テスト用レコード = mutableMapOf<String, Any?>()
        テスト用レコード["名称"] = "テストcase03"
        テスト用レコード["パターン番号"] = 3

        取得データ += テスト用レコード

        return 戻り値.取得データをセットする(取得データ)
    }

    /**
     *
     */
    @手続き呼出し(
        手続きコード = "case03",
        手続きコード補助コード = "pattern4",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 手続きpattern4を実行する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val 取得データ = mutableListOf<Map<String, Any?>>()

        val テスト用レコード = mutableMapOf<String, Any?>()
        テスト用レコード["名称"] = "テストcase03"
        テスト用レコード["パターン番号"] = 4

        取得データ += テスト用レコード

        return 戻り値.取得データをセットする(取得データ)
    }
}