package name.uroak.uroak_service_center.sysad.services

import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.constants.共通引数フィールド名
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.ret.物理削除系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する
import name.uroak.uroak_service_center.sysad.constants.引数フィールド名
import name.uroak.uroak_service_center.sysad.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class 実行権限削除手続きサービスクラス : 手続きサービスクラス {
    /***/
    @Autowired
    private lateinit var 実行権限管理削除リポジトリ: 実行権限管理削除リポジトリ

    /**
     *
     */
    constructor() : super("実行権限削除手続きサービス") {

    }

    @手続き呼出し(
        手続きコード = "permission",
        手続きコード補助コード = "data",
        手続きコード補助コード2 = "delete",
        処理種別 = 手続き処理種別一覧.物理削除
    )
    fun 実行権限データを削除する(手続き実行情報: 手続き実行情報クラス): 戻り値クラス {
        val パラメータ = 手続き実行情報.汎用手続き用条件パラメータを返す()

        return 物理削除系戻り値クラス(手続き実行情報).削除件数をセットする(
            実行権限管理削除リポジトリ.実行権限データを削除する(
                削除対象会員識別子 = パラメータ.Int値で取得する(引数フィールド名.削除対象会員識別子),
                削除対象手続き識別子 = パラメータ.Int値で取得する(引数フィールド名.削除対象手続き識別子),
                更新日時最大値 = パラメータ.文字列値で取得する(共通引数フィールド名.更新日時最大値),
                更新日時最小値 = パラメータ.文字列値で取得する(共通引数フィールド名.更新日時最小値)
            )
        );
    }
}