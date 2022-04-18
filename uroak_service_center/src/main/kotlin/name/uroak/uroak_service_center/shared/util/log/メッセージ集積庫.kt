package name.uroak.uroak_service_center.shared.util.log

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.tool.道具箱
import java.text.MessageFormat
import java.util.*

/**
 * メッセージの図書館
 */
object メッセージ集積庫 {

    /** メッセージリソース名 */
    private const val リソース名 = "messages"

    /** リソースバンドル */
    private val リソースバンドル = ResourceBundle.getBundle(リソース名)

    /**
     * 指定されたIDのメッセージを取得する
     */
    fun メッセージを取得する(ID文字列: String) = リソースバンドル.getString(ID文字列)

    /**
     * 指定されたIDのメッセージを取得する
     */
    fun メッセージを取得する(メッセージID: メッセージID一覧) = メッセージを取得する(メッセージID.ID文字列)

    /**
     *
     */
    fun メッセージを編集する(メッセージ: String, vararg パラメータ: Any?): String {

        val パラメータ文字列配列 = 道具箱.可変長引数を文字列配列に変換する(パラメータ)

        return if (パラメータ文字列配列 == null)
            メッセージ
        else
            MessageFormat.format(メッセージ, *パラメータ文字列配列)
    }

    /**
     *
     */
    fun メッセージを編集する(メッセージID: メッセージID一覧, vararg パラメータ: Any?) = メッセージを編集する(メッセージを取得する(メッセージID), *パラメータ)

    /**
     *
     */
    fun メッセージを編集する(メッセージ: String): String {
        return メッセージ
    }

    /**
     *
     */
    fun メッセージを編集する(メッセージID: メッセージID一覧) = メッセージを取得する(メッセージID)
}