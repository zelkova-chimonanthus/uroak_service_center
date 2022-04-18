package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import name.uroak.uroak_service_center.sysad.entity.会員データクラス
import name.uroak.uroak_service_center.sysad.services.実行権限チェックサービスクラス

/**
 *
 */
class 会員情報クラス {
    /***/
    private var 識別子: Int = -1

    /***/
    private var 目録識別子: Int? = null

    /***/
    private var 目録名称: String = ""

    /***/
    private var 識別トークン: String = ""

    /***/
    private var 名称: String = ""

    /***/
    private var 備考: String = ""

    /***/
    private var ログイン不可: Boolean = true

    /***/
    private var システム管理者フラグ: Boolean = false

    /***/
    private var サービス管理者フラグ: Boolean = false

    /**
     *
     */
    constructor()

    /**
     *
     */
    constructor(会員データ: 会員データクラス) {
        識別子 = 会員データ.識別子
        目録識別子 = 会員データ.目録識別子
        目録名称 = 会員データ.目録名称
        識別トークン = 会員データ.識別トークン
        名称 = 会員データ.名称
        備考 = 会員データ.備考
        ログイン不可 = 会員データ.ログイン不可
        システム管理者フラグ = 会員データ.システム管理者フラグ
        サービス管理者フラグ = 会員データ.サービス管理者フラグ
    }

    /**
     *
     */
    fun 詳細情報を文字列化する(): String {
        return String.format(
            "利用者［識別子：%d、名称：%s、識別トークン：%s、ログイン不可：%s、システム管理者：%s、サービス管理者：%s　（親目録［識別子：%d、名称：%s］）］",
            識別子,
            名称,
            識別トークン,
            ログイン不可.toString(),
            システム管理者フラグ.toString(),
            サービス管理者フラグ.toString(),
            目録識別子,
            目録名称,
        )
    }

    /**
     *
     */
    fun 会員識別子を返す() = 識別子

    /**
     *
     */
    fun 会員の親目録識別子を返す() = 目録識別子

    /**
     *
     */
    fun 会員の親目録名称を返す() = 目録名称

    /**
     *
     */
    fun 会員の識別トークンを返す() = 識別トークン

    /**
     *
     */
    fun 会員名称を返す() = 名称

    /**
     *
     */
    fun ログイン不可の会員か() = ログイン不可

    /***/
    fun システム管理者か() = システム管理者フラグ

    /***/
    fun サービス管理者か() = サービス管理者フラグ
}