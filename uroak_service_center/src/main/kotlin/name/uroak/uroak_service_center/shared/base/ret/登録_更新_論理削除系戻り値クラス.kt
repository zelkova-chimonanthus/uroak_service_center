package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.base.constants.レスポンスフィールド名
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス

/**
 *
 */
class 登録_更新_論理削除系戻り値クラス : 戻り値クラス {

    /**入力パラメータが階層化されている場合の対応はしていない。最上層のデータの更新件数のみ返す*/
    private var 処理件数 = 0

    /**入力パラメータが階層化されている場合の対応はしていない。最上層のデータの更新対象のキーのみ返す*/
    private var 処理済みデータのキー値: List<Map<String, Any>> = mutableListOf()

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス) : super(手続き実行種別一覧.登録_更新_論理削除, 手続き実行情報)

    /**
     *
     */
    fun 処理件数をセットする(処理件数: Int?): 登録_更新_論理削除系戻り値クラス {
        this.処理件数 = 処理件数 ?: 0
        return this
    }

    /**
     *
     */
    fun 処理済みデータのキー値をセットする(処理済みキーセット: 処理済みキーセットクラス): 登録_更新_論理削除系戻り値クラス {
        this.処理済みデータのキー値 = 処理済みキーセット.処理済みキー値を返す()
        return this
    }

    /**
     *
     */
    override fun 各APIの返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        返却値[名称を返す(レスポンスフィールド名.処理件数)] = 処理件数

        返却値[名称を返す(レスポンスフィールド名.処理済みレコード)] = 処理済みデータのキー値

        return 返却値
    }
}