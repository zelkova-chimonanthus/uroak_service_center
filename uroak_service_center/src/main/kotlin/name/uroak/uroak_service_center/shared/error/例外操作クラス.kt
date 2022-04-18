package name.uroak.uroak_service_center.shared.error

import name.uroak.uroak_service_center.shared.base.ret.システムエラー系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名言語一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.*
import name.uroak.uroak_service_center.shared.util.log.ログ
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 補足されずに最上層まで到達した例外を処理する
 */
@RestControllerAdvice
class 例外操作クラス {
    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(システム状態確認エラークラス::class)
    @ResponseBody
    fun システム状態確認エラーを扱う(エラー: システム状態確認エラークラス): String {
        return エラーレスポンスを返す(エラー, "システム状態確認エラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ロト_ナンバーズ管理エラークラス::class)
    @ResponseBody
    fun ロト_ナンバーズ管理エラーを扱う(エラー: ロト_ナンバーズ管理エラークラス): String {
        return エラーレスポンスを返す(エラー, "ロト_ナンバーズ管理エラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(共通処理エラークラス::class)
    @ResponseBody
    fun 共通処理エラーを扱う(エラー: 共通処理エラークラス): String {
        return エラーレスポンスを返す(エラー, "共通処理エラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(基盤処理エラークラス::class)
    @ResponseBody
    fun 基盤処理エラーを扱う(エラー: 基盤処理エラークラス): String {
        return エラーレスポンスを返す(エラー, "基盤処理エラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(実行権限管理エラークラス::class)
    @ResponseBody
    fun 実行権限管理エラーを扱う(エラー: 実行権限管理エラークラス): String {
        return エラーレスポンスを返す(エラー, "実行権限管理エラーが発生しました。")
    }
    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(実行権限チェックエラークラス::class)
    @ResponseBody
    fun 実行権限チェックエラーを扱う(エラー: 実行権限チェックエラークラス): String {
        return エラーレスポンスを返す(エラー, "実行権限のチェックでエラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(株取引管理エラークラス::class)
    @ResponseBody
    fun 株取引管理エラーを扱う(エラー: 株取引管理エラークラス): String {
        return エラーレスポンスを返す(エラー, "株取引管理エラーが発生しました。")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable::class)
    @ResponseBody
    fun その他のエラーを扱う(エラー: Throwable): String {
        return エラーレスポンスを返す(エラー, "エラーが発生しました。HTTPステータス：500（INTERNAL_SERVER_ERROR）")
    }

    /**
     *
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsernameNotFoundException::class)
    @ResponseBody
    fun 認証エラーを扱う(エラー: Throwable): String {
        return エラーレスポンスを返す(エラー, "エラー(UsernameNotFoundException)が発生しました。HTTPステータス：500（INTERNAL_SERVER_ERROR）")
    }

    /**
     *
     */
    private fun エラーレスポンスを返す(エラー: Throwable, メッセージ: String): String {
        ログ.エラーログを出力する(this.javaClass, エラー, "エラー発生", メッセージID一覧.CMN_E_0002, メッセージ)
        return システムエラー系戻り値クラス(JSONフィールド名言語一覧.英語, メッセージID一覧.CMN_E_0001).返却値を作成してJSON化する()
    }
}