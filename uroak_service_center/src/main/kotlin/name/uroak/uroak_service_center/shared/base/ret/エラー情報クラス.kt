package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱

/**
 * エラー対象のリストをエラー項目ごとにまとめて、マップとして持っているクラス
 */
class エラー情報クラス {

    /***/
    val エラー項目セット = mutableMapOf<メッセージID一覧, エラー項目クラス>()

    /**
     *
     */
    fun エラーを追加する(エラーメッセージID: メッセージID一覧, 対象名称リスト: Collection<String>) {
        対象エラー項目を取得する(エラーメッセージID).対象名称リスト += 対象名称リスト
    }

    /**
     *
     */
    fun エラーを追加する(エラーメッセージID: メッセージID一覧, 対象名称: String) {
        対象エラー項目を取得する(エラーメッセージID).対象名称リスト += 対象名称
    }

    /**
     *
     */
    private fun 対象エラー項目を取得する(エラーメッセージID: メッセージID一覧): エラー項目クラス {
        var エラー項目: エラー項目クラス? = エラー項目セット[エラーメッセージID]
        if (エラー項目 == null) {
            エラー項目 = エラー項目クラス(エラーメッセージID)
            エラー項目セット[エラーメッセージID] = エラー項目
        }
        return エラー項目
    }

    /**
     *
     */
    fun 文字列化する(): String = 文字列道具箱.文字列配列を改行して接続する(配列化する())

    /**
     *
     */
    fun 配列化する(): List<エラー項目クラス> {
        val 配列 = mutableListOf<エラー項目クラス>()
        for (エラーメッセージID in エラー項目セット.keys) {
            val エラー項目 = エラー項目セット[エラーメッセージID]
            if (エラー項目 != null) {
                配列 += エラー項目
            }
        }
        return 配列
    }

    /**
     *
     */
    fun 指定されたエラー項目を取得する(エラーメッセージID: メッセージID一覧): エラー項目クラス? {
        return エラー項目セット[エラーメッセージID]
    }

    /**
     *
     */
    fun 設定されているエラーメッセージIDを返す(): List<メッセージID一覧> = エラー項目セット.keys.toList()

}