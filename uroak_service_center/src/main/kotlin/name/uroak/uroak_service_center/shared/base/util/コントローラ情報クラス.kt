package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import name.uroak.uroak_service_center.sysad.entity.コントローラデータクラス

/**
 *
 */
internal object コントローラデータ作成道具箱 {
    /**
     *
     */
    fun コントローラデータを作成する(
        識別子: Int? = null,
        名称: String? = null,
        目録識別子: Int? = null,
        目録名称: String? = null,
        URLパス: String? = null,
        DIコンポーネント名: String? = null,
        クラス名: String? = null,
        クラスパッケージパス: String? = null,
        使用中止: Boolean? = null,
        システム管理用: Boolean? = null
    ): コントローラデータクラス {
        return コントローラデータクラス(
            設定用に識別子を調整する(識別子),
            設定用に名称を調整する(名称),
            設定用に識別子を調整する(目録識別子),
            設定用に名称を調整する(目録名称),
            設定用にURLパスを調整する(URLパス),
            設定用にDIコンポーネント名を調整する(DIコンポーネント名),
            設定用にクラス名を調整する(クラス名),
            設定用にクラスパッケージパスを調整する(クラスパッケージパス),
            設定用に使用中止を調整する(使用中止),
            設定用にシステム管理用を調整する(システム管理用)
        )
    }

    /**
     *
     */
    private fun 設定用に使用中止を調整する(使用中止: Boolean?): Boolean {
        return 使用中止 ?: true
    }

    /**
     *
     */
    private fun 設定用にシステム管理用を調整する(システム管理用: Boolean?): Boolean {
        return システム管理用 ?: false
    }

    /**
     *
     */
    private fun 設定用に識別子を調整する(識別子: Int?): Int {
        return 識別子 ?: -1
    }

    /**
     *
     */
    private fun 設定用に名称を調整する(名称: String?): String {
        return 名称 ?: ""
    }

    /**
     *
     */
    private fun 設定用にURLパスを調整する(URLパス: String?): String {
        return if (URLパス == null) {
            ""
        } else {
            var セット対象パス = URLパス
            if (セット対象パス.startsWith("/")) {
                セット対象パス = セット対象パス.substring(1)
            }
            if (セット対象パス.endsWith("/")) {
                セット対象パス = セット対象パス.substring(0, セット対象パス.length - 1)
            }
            セット対象パス
        }
    }

    /**
     *
     */
    private fun 設定用にDIコンポーネント名を調整する(DIコンポーネント名: String?): String {
        return DIコンポーネント名 ?: ""
    }

    /**
     *
     */
    private fun 設定用にクラス名を調整する(クラス名: String?): String {
        return クラス名 ?: ""
    }

    /**
     *
     */
    private fun 設定用にクラスパッケージパスを調整する(クラスパッケージパス: String?): String {
        return if (クラスパッケージパス == null) {
            ""
        } else if (クラスパッケージパス.endsWith(".")) {
            クラスパッケージパス.substring(0, クラスパッケージパス.length - 1)
        } else {
            クラスパッケージパス
        }
    }

}

/**
 *
 */
class コントローラ情報クラス {
    /***/
    private var コントローラデータ: コントローラデータクラス

    /**
     *
     */
    constructor(コントローラデータ: コントローラデータクラス) {

        this.コントローラデータ = コントローラデータ作成道具箱.コントローラデータを作成する(
            コントローラデータ.識別子,
            コントローラデータ.名称,
            コントローラデータ.目録識別子,
            コントローラデータ.目録名称,
            コントローラデータ.URLパス,
            コントローラデータ.DIコンポーネント名,
            コントローラデータ.クラス名,
            コントローラデータ.クラスパッケージパス,
            コントローラデータ.使用中止,
            コントローラデータ.システム管理用
        )

    }

    /**
     *
     */
    constructor(
        識別子: Int? = null,
        名称: String? = null,
        目録識別子: Int? = null,
        目録名称: String? = null,
        URLパス: String? = null,
        DIコンポーネント名: String? = null,
        クラス名: String? = null,
        クラスパッケージパス: String? = null,
        使用中止: Boolean? = null,
        システム管理用: Boolean? = null
    ) {
        this.コントローラデータ = コントローラデータ作成道具箱.コントローラデータを作成する(
            識別子,
            名称,
            目録識別子,
            目録名称,
            URLパス,
            DIコンポーネント名,
            クラス名,
            クラスパッケージパス,
            使用中止,
            システム管理用
        )
    }

    /**
     *
     */
    fun コントローラデータを返す(): コントローラデータクラス {
        return コントローラデータ
    }


    /**
     *
     */
    fun パッケージ付きのクラス名を取得する(): String? {
        return if (コントローラデータ == null) {
            null
        } else {
            if (文字列道具箱.空白文字列か(コントローラデータ.クラスパッケージパス)) {
                コントローラデータ.クラス名
            } else {
                コントローラデータ.クラスパッケージパス + "." + コントローラデータ.クラス名
            }
        }
    }

    /**
     *
     */
    fun 使用中止か() = コントローラデータ.使用中止

    /**
     *
     */
    fun システム管理用か() = コントローラデータ.システム管理用

    /**
     *
     */
    fun コントローラ名称を返す() = コントローラデータ.名称

    /**
     *
     */
    fun コントローラ目録名称を返す() = コントローラデータ.目録名称

    /**
     *
     */
    fun コントローラURLパスを返す() = コントローラデータ.URLパス
}