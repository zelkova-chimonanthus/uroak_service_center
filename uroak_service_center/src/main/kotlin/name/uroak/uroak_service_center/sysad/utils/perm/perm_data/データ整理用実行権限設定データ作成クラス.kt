package name.uroak.uroak_service_center.sysad.utils.perm.perm_data

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.実行権限チェックエラークラス
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する_NULL不可
import name.uroak.uroak_service_center.sysad.constants.取得データ名
import name.uroak.uroak_service_center.sysad.utils.perm.*
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧.*
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧.*
import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
class データ整理用実行権限設定データ作成クラス {
    /***/
    private var 利用者_会員: データ整理用利用者クラス? = null

    /***/
    private var 利用者マップ_会員目録 = mutableMapOf<Int, データ整理用利用者クラス>()

    /***/
    private var 利用者マップ_会員グループ = mutableMapOf<Int, データ整理用利用者クラス>()

    /***/
    private var 利用対象_手続き: データ整理用利用対象クラス? = null

    /***/
    private var 利用対象マップ_手続き目録 = mutableMapOf<Int, データ整理用利用対象クラス>()

    /***/
    private var 利用対象マップ_手続きグループ = mutableMapOf<Int, データ整理用利用対象クラス>()

    /***/
    private var 実行権限設定データ配列 = mutableListOf<データ整理用実行権限設定データクラス>()

    /**
     *
     */
    constructor()

    /**
     *
     */
    fun 当事者をセットする(
        会員: データ整理用会員クラス,
        手続き: データ整理用手続きクラス,
        会員目録階層: データ整理用会員目録階層クラス,
        手続き目録階層: データ整理用手続き目録階層クラス,
        会員グループ群: データ整理用会員グループ群クラス,
        手続きグループ群: データ整理用手続きグループ群クラス
    ) {
        利用者_会員?.当事者をセットする(会員)
        利用対象_手続き?.当事者をセットする(手続き)

        会員目録階層.ループ処理をする {
            利用者マップ_会員目録[it.識別子を返す()]?.当事者をセットする(it)
        }
        手続き目録階層.ループ処理をする {
            利用対象マップ_手続き目録[it.識別子を返す()]?.当事者をセットする(it)
        }

        会員グループ群.ループ処理をする {
            利用者マップ_会員グループ[it.識別子を返す()]?.当事者をセットする(it)
        }
        手続きグループ群.ループ処理をする {
            利用対象マップ_手続きグループ[it.識別子を返す()]?.当事者をセットする(it)
        }
    }

    /**
     *
     */
    fun 実行権限設定データ配列を返す() = 実行権限設定データ配列

    /**
     *
     */
    fun クリアする() {
        利用者_会員 = null
        利用者マップ_会員目録.clear()
        利用者マップ_会員グループ.clear()
        利用対象_手続き = null
        利用対象マップ_手続き目録.clear()
        利用対象マップ_手続きグループ.clear()
        実行権限設定データ配列.clear()
    }

    /**
     *
     */
    fun 実行権限設定レコードからデータを作成する(実行権限設定レコード配列: List<Map<String, Any?>>) {
        クリアする()
        実行権限設定レコード配列.forEach {
            実行権限設定データ配列 += 実行権限設定データを作成する(it)
        }
    }

    private fun 実行権限設定データを作成する(レコード: Map<String, Any?>): データ整理用実行権限設定データクラス {
        val 識別子 = レコード.Int値で取得する_NULL不可(取得データ名.識別子)
        val 権限 = 権限属性クラス(レコード.Int値で取得する_NULL不可(取得データ名.権限))

        val 利用者ID = レコード.Int値で取得する_NULL不可(取得データ名.利用者ID)
        val 利用者種別 = 実行権限利用者種別一覧.JSONフィールド値を列挙定数に変換する(レコード.Int値で取得する_NULL不可(取得データ名.利用者種別))
        val 利用者 = 利用者を取得する(利用者種別, 利用者ID) ?: 利用者を作成する(利用者種別, 利用者ID)

        val 利用対象ID = レコード.Int値で取得する_NULL不可(取得データ名.利用対象ID)
        val 利用対象種別 = 実行権限利用対象種別一覧.JSONフィールド値を列挙定数に変換する(レコード.Int値で取得する_NULL不可(取得データ名.利用対象種別))
        val 利用対象 = 利用対象を取得する(利用対象種別, 利用対象ID) ?: 利用対象を作成する(利用対象種別, 利用対象ID)

        return データ整理用実行権限設定データクラス(識別子, 利用者, 利用対象, 権限)
    }

    /**
     *
     */
    private fun 利用者を取得する(利用者種別: 実行権限利用者種別一覧, 利用者ID: Int): データ整理用利用者クラス? {
        return when (利用者種別) {
            会員 -> 利用者_会員
            会員目録 -> 利用者マップ_会員目録[利用者ID]
            会員グループ -> 利用者マップ_会員グループ[利用者ID]
            else -> throw 実行権限チェックエラークラス(this.javaClass, メッセージID一覧.CMN_E_0002, "この利用者種別は、ここでは想定外です。利用者種別：" + 利用者種別.name)
        }
    }

    /**
     *
     */
    private fun 利用者を作成する(利用者種別: 実行権限利用者種別一覧, 利用者ID: Int): データ整理用利用者クラス {
        val 利用者 = データ整理用利用者クラス(利用者ID, 利用者種別)
        when (利用者種別) {
            会員 -> 利用者_会員 = 利用者
            会員目録 -> 利用者マップ_会員目録[利用者ID] = 利用者
            会員グループ -> 利用者マップ_会員グループ[利用者ID] = 利用者
            else -> {}
        }
        return 利用者
    }

    /**
     *
     */
    private fun 利用対象を取得する(利用対象種別: 実行権限利用対象種別一覧, 利用対象ID: Int): データ整理用利用対象クラス? {
        return when (利用対象種別) {
            手続き -> 利用対象_手続き
            手続き目録 -> 利用対象マップ_手続き目録[利用対象ID]
            手続きグループ -> 利用対象マップ_手続きグループ[利用対象ID]
            else -> throw 実行権限チェックエラークラス(this.javaClass, メッセージID一覧.CMN_E_0002, "この利用対象種別は、ここでは想定外です。利用対象種別：" + 利用対象種別.name)
        }
    }

    /**
     *
     */
    private fun 利用対象を作成する(利用対象種別: 実行権限利用対象種別一覧, 利用対象ID: Int): データ整理用利用対象クラス {
        val 利用対象 = データ整理用利用対象クラス(利用対象ID, 利用対象種別)
        when (利用対象種別) {
            手続き -> 利用対象_手続き = 利用対象
            手続き目録 -> 利用対象マップ_手続き目録[利用対象ID] = 利用対象
            手続きグループ -> 利用対象マップ_手続きグループ[利用対象ID] = 利用対象
            else -> {}
        }
        return 利用対象
    }

}