package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.base.constants.レスポンスフィールド名
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス

/**
 *
 */
class 検索系戻り値クラス : 戻り値クラス {

    private val 未設定整数値 = -1

    /**今回、返却するデータの件数（limit, offsetを使用して検索を実行した場合、全体件数とは異なった値になる）*/
    private var 返却件数 = 0

    /**検索条件にかかったデータの件数*/
    private var 全体件数 = 0

    /**取得件数の上限（limit）*/
    private var 取得件数上限 = -1

    /**今回取得したページ。offsetに該当するもの。０～*/
    private var 取得開始位置 = -1

    /**今回、返却するデータ*/
    private var 取得データ: List<Map<String, Any?>> = mutableListOf<MutableMap<String, Any?>>()

    /**
     *
     */
    constructor(手続き実行情報: 手続き実行情報クラス) : super(手続き実行種別一覧.検索, 手続き実行情報)

    /**
     *
     */
    fun 取得データをセットする(取得データ: Map<String, Any?>?): 検索系戻り値クラス {
        this.取得データ = mutableListOf<MutableMap<String, Any?>>()
        var 件数 = 0
        if (取得データ != null) {
            this.取得データ += 取得データ
            件数 = 1
        }
        this.返却件数 = 件数
        this.全体件数 = 件数
        this.取得開始位置 = 未設定整数値
        this.取得件数上限 = 未設定整数値

        return this
    }

    /**
     *
     */
    fun 取得データをセットする(取得データ: List<Map<String, Any?>>?): 検索系戻り値クラス {
        this.取得データ = 取得データ ?: mutableListOf<MutableMap<String, Any?>>()
        val 件数 = (取得データ?.size) ?: 0
        this.返却件数 = 件数
        this.全体件数 = 件数
        this.取得開始位置 = 未設定整数値
        this.取得件数上限 = 未設定整数値

        return this
    }

    /**
     *
     */
    fun 取得データをセットする(取得データ: List<Map<String, Any?>>?, 取得開始位置: Int?, 全体件数: Int?, 取得件数上限: Int?): 検索系戻り値クラス {
        this.取得データ = 取得データ ?: mutableListOf<MutableMap<String, Any?>>()
        val 件数 = (取得データ?.size) ?: 0
        this.返却件数 = 件数
        this.全体件数 = 全体件数 ?: 件数
        this.取得開始位置 = 取得開始位置 ?: 未設定整数値
        this.取得件数上限 = 取得件数上限 ?: 未設定整数値

        return this
    }

    /**
     *
     */
    override fun 各APIの返却値を作成する(): Map<String, Any> {
        var 返却値 = mutableMapOf<String, Any>()

        返却値[名称を返す(レスポンスフィールド名.実行状況)] = 実行状況を作成する()

        返却値[名称を返す(レスポンスフィールド名.取得レコード)] = this.取得データ

        return 返却値
    }

    /**
     *
     */
    private fun 実行状況を作成する(): Map<String, Any> {
        var 実行状況 = mutableMapOf<String, Any>()

        実行状況[名称を返す(レスポンスフィールド名.全体の件数)] = 全体件数

        実行状況[名称を返す(レスポンスフィールド名.今回の返却件数)] = 返却件数

        実行状況[名称を返す(レスポンスフィールド名.一回の取得件数上限)] = 取得件数上限

        return 実行状況
    }

}