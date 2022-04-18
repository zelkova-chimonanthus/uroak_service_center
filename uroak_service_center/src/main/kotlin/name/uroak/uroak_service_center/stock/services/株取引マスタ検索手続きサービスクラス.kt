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
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class 株取引マスタ検索手続きサービスクラス : 手続きサービスクラス {

    /***/
    @Autowired
    private lateinit var マスタ検索リポジトリ: マスタ検索リポジトリ

    /**
     *
     */
    constructor() : super("株取引マスタ検索手続きサービス") {

    }

    @手続き呼出し(
        手続きコード = "master",
        手続きコード補助コード = "list",
        手続きコード補助コード2 = "six_continents",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 六大州情報を取得する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        val 取得データ = マスタ検索リポジトリ.六大州情報を取得する(
            六大州コード = パラメータ.Int値で取得する(引数フィールド名.六大州コード)
        )

        return 戻り値.取得データをセットする(取得データ)
    }

    @手続き呼出し(
        手続きコード = "master",
        手続きコード補助コード = "list",
        手続きコード補助コード2 = "world_area",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 国の地域情報を取得する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        val 取得データ = マスタ検索リポジトリ.国の地域情報を取得する(
            国の地域コード = パラメータ.Int値で取得する(引数フィールド名.国の地域コード),
            六大州コード = パラメータ.Int値で取得する(引数フィールド名.六大州コード)
        )

        return 戻り値.取得データをセットする(取得データ)
    }

    @手続き呼出し(
        手続きコード = "master",
        手続きコード補助コード = "list",
        手続きコード補助コード2 = "countries",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 国情報を取得する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()

        val 取得件数上限 = パラメータ.Int値で取得する(共通引数フィールド名.取得件数上限)
        val 取得開始位置 = パラメータ.Int値で取得する(共通引数フィールド名.取得開始位置)

        val 取得データ = マスタ検索リポジトリ.国情報を取得する(
            コード_数字3桁 = パラメータ.文字列値で取得する(引数フィールド名.コード_数字3桁),
            コード_英字3文字 = パラメータ.文字列値で取得する(引数フィールド名.コード_英字3文字),
            コード_英字2文字 = パラメータ.文字列値で取得する(引数フィールド名.コード_英字2文字),
            国名称 = パラメータ.文字列値で取得する(引数フィールド名.国名称),
            国正式名称 = パラメータ.文字列値で取得する(引数フィールド名.国正式名称),
            地域コード = パラメータ.Int値で取得する(引数フィールド名.地域コード),
            六大州コード = パラメータ.Int値で取得する(引数フィールド名.六大州コード),
            取得件数上限 = 取得件数上限,
            取得開始位置 = 取得開始位置
        )

        var 全体件数: Int? = 取得件数が限定されていれば全体件数を返す(取得件数上限 != null)

        return 戻り値.取得データをセットする(取得データ, 取得開始位置, 全体件数, 取得件数上限)
    }

    @手続き呼出し(
        手続きコード = "master",
        手続きコード補助コード = "list",
        手続きコード補助コード2 = "regions",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 地方情報を取得する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        val 取得データ = マスタ検索リポジトリ.地方情報を取得する(
            地方コード = パラメータ.Int値で取得する(引数フィールド名.地方コード)
        )

        return 戻り値.取得データをセットする(取得データ)
    }

    @手続き呼出し(
        手続きコード = "master",
        手続きコード補助コード = "list",
        手続きコード補助コード2 = "prefectures",
        処理種別 = 手続き処理種別一覧.検索
    )
    fun 都道府県情報を取得する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val 戻り値 = 検索系戻り値クラス(手続き実行情報)

        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()
        val 取得件数上限 = パラメータ.Int値で取得する(共通引数フィールド名.取得件数上限)
        val 取得開始位置 = パラメータ.Int値で取得する(共通引数フィールド名.取得開始位置)
        val 取得データ = マスタ検索リポジトリ.都道府県情報を取得する(
            都道府県コード = パラメータ.Int値で取得する(引数フィールド名.都道府県コード),
            地方コード = パラメータ.Int値で取得する(引数フィールド名.地方コード),
            取得件数上限 = 取得件数上限,
            取得開始位置 = 取得開始位置
        )

        var 全体件数: Int? = 取得件数が限定されていれば全体件数を返す(取得件数上限 != null)

        return 戻り値.取得データをセットする(取得データ, 取得開始位置, 全体件数, 取得件数上限)
    }
}