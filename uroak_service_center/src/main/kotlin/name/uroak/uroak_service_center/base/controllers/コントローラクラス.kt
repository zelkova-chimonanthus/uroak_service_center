package name.uroak.uroak_service_center.base.controllers

import name.uroak.uroak_service_center.base.core.基盤処理実行体クラス
import name.uroak.uroak_service_center.base.services.手続きサービスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.コントローラ情報クラス
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.実行権限チェックエラークラス
import name.uroak.uroak_service_center.sysad.services.実行権限チェックサービスクラス
import org.springframework.beans.factory.annotation.Autowired

/**
 *全てのコントローラクラスの共通親クラス
 */
abstract class コントローラクラス : 基盤処理実行体クラス {

    /***/
    @Autowired
    private lateinit var 実行権限管理サービス: 実行権限チェックサービスクラス

    /**
     *
     */
    constructor(名前: String) : super(名前) {

    }

    /**
     *
     */
    constructor() : super() {

    }

    /**
     *
     */
    protected abstract fun 指定された手続きを実装しているサービスインスタンスを返す(手続きパス: 手続きパスクラス): 手続きサービスクラス?

    /**
     *
     */
    private fun 手続き実行前の処理を行う(ユーザトークン: String, コントローラ情報: コントローラ情報クラス, 手続きパス: 手続きパスクラス, POSTデータ: String?): 手続き実行情報クラス? {

        val 実行権限チェック結果 = 実行権限管理サービス.実行権限をチェックする(ユーザトークン, コントローラ情報, 手続きパス)

        if (!実行権限チェック結果.実行可能) {
            throw 実行権限チェックエラークラス(this.javaClass, メッセージID一覧.BAS_E_0040)
        }

        val 手続き実行情報 = 手続き実行情報クラス()
        手続き実行情報.利用者情報をセットする(実行権限チェック結果.会員情報)
        手続き実行情報.対象手続き情報を作成する(実行権限チェック結果.手続き情報)
        手続き実行情報.POSTデータをセットする(POSTデータ)

        if (!個別の手続き実行前処理を行う(手続き実行情報)) {
            return null
        }

        return 手続き実行情報
    }

    /**
     *
     */
    private fun 手続き実行後の処理を行う(手続き実行情報: 手続き実行情報クラス, 戻り値: 戻り値クラス?): Boolean {
        if (!個別の手続き実行後処理を行う(手続き実行情報, 戻り値)) {
            return false
        }
        return true
    }


    /**
     *
     */
    fun 手続きを実行する(ユーザトークン: String, コントローラ情報: コントローラ情報クラス, 手続きパス: 手続きパスクラス, POSTデータ: String?): String {

        val 手続き実行情報 = 手続き実行前の処理を行う(ユーザトークン, コントローラ情報, 手続きパス, POSTデータ) ?: 例外をスローする(メッセージID一覧.BAS_E_0026)

        val 手続きサービス = 指定された手続きを実装しているサービスインスタンスを返す(手続きパス) ?: 例外をスローする(メッセージID一覧.BAS_E_0034)

        val 戻り値 = 手続きサービス.手続きを処理する(手続き実行情報) ?: 例外をスローする(メッセージID一覧.BAS_E_0028)

        if (!手続き実行後の処理を行う(手続き実行情報, 戻り値)) {
            例外をスローする(メッセージID一覧.BAS_E_0027)
        }

        return 戻り値.返却値を作成してJSON化する()
    }

    /**
     *
     */
    protected open fun 個別の手続き実行前処理を行う(手続き実行情報: 手続き実行情報クラス): Boolean {
        return true
    }

    /**
     *
     */
    protected open fun 個別の手続き実行後処理を行う(手続き実行情報: 手続き実行情報クラス, 戻り値: 戻り値クラス?): Boolean {
        return true
    }

}