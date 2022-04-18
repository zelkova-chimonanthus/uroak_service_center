package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス
import name.uroak.uroak_service_center.sysad.entity.手続きデータクラス
import name.uroak.uroak_service_center.sysad.services.実行権限チェックサービスクラス


/**
 *
 */
class 手続き情報クラス {
    /***/
    private var 識別子: Int = -1

    /***/
    private var 目録識別子: Int = -1

    /***/
    private var 目録名称: String = ""

    /***/
    private var 処理種別: 手続き処理種別一覧 = 手続き処理種別一覧.不明

    /***/
    private var 名称: String = ""

    /***/
    private var 備考: String = ""

    /***/
    private var コントローラ情報: コントローラ情報クラス = コントローラ情報クラス()

    /***/
    private var 手続きパス: 手続きパスクラス = 手続きパスクラス()

    /**
     *
     */
    constructor()

    /**
     *
     */
    constructor(手続きデータ: 手続きデータクラス, コントローラ情報: コントローラ情報クラス, 手続きパス: 手続きパスクラス) {
        手続きデータをセットする(手続きデータ)
        this.コントローラ情報 = コントローラ情報
        this.手続きパス = 手続きパス
    }

    fun 手続きデータをセットする(手続きデータ: 手続きデータクラス) {
        識別子 = 手続きデータ.識別子
        目録識別子 = 手続きデータ.目録識別子
        目録名称 = 手続きデータ.目録名称
        処理種別 = 手続きデータ.処理種別 ?: 手続き処理種別一覧.不明
        名称 = 手続きデータ.名称
        備考 = 手続きデータ.備考 ?: ""
    }

    fun 詳細情報を文字列化する(): String {
        val コントローラデータ = コントローラ情報.コントローラデータを返す()
        return String.format(
            "手続き［識別子：%d、名称：%s、処理種別：%s、パス：%s、（親目録［識別子：%d、名称：%s］）（コントローラ［識別子：%d、名称：%s、使用中止：%s、システム管理用：%s］）］",
            識別子,
            名称,
            処理種別?.name,
            手続きパスを文字列化する(),
            目録識別子,
            目録名称,
            コントローラデータ.識別子,
            コントローラデータ.名称,
            コントローラデータ.使用中止.toString(),
            コントローラデータ.システム管理用.toString()
        )
    }

    /**
     *
     */
    fun 手続きパスを文字列化する(): String {
        return 手続きパス.文字列化する(コントローラ情報)
    }

    /**
     *
     */
    fun 手続き識別子を返す() = 識別子

    /**
     *
     */
    fun 手続きの親目録識別子を返す() = 目録識別子

    /**
     *
     */
    fun 手続きの親目録名称を返す() = 目録名称

    /**
     *
     */
    fun 手続き処理種別を返す() = 処理種別

    /**
     *
     */
    fun 手続き名称を返す() = 名称

    /**
     *
     */
    fun コントローラ情報を返す() = コントローラ情報

    /**
     *
     */
    fun 手続きパスを返す() = 手続きパス

    /**
     *
     */
    fun コントローラ名称を返す() = コントローラ情報.コントローラ名称を返す()

    /**
     *
     */
    fun コントローラ目録名称を返す() = コントローラ情報.コントローラ目録名称を返す()

    /**
     *
     */
    fun コントローラURLパスを返す() = コントローラ情報.コントローラURLパスを返す()
}