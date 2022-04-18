package name.uroak.uroak_service_center.shared.base.util

import name.uroak.uroak_service_center.shared.util.etc.複数値文字列定数値クラス
import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する
import name.uroak.uroak_service_center.shared.util.extension.Long値で取得する
import name.uroak.uroak_service_center.shared.util.extension.マップを取得する
import name.uroak.uroak_service_center.shared.util.extension.文字列値で取得する

/**
 *
 */
class JSONフィールド名定数クラス : 複数値文字列定数値クラス {

    /**
     *
     */
    constructor()

    /**
     *
     */
    constructor(定数セット: MutableList<String>) : super(定数セット)

    /**
     *
     */
    constructor(vararg 定数: String) {
        var 英語名称 = ""
        var 日本語名称 = ""
        when (定数.size) {
            1 -> {
                英語名称 = 定数[JSONフィールド名言語一覧.英語.位置]
            }
            2 -> {
                英語名称 = 定数[JSONフィールド名言語一覧.英語.位置]
                日本語名称 = 定数[JSONフィールド名言語一覧.日本語.位置]
            }
        }
        定数をセットする(英語名称, 日本語名称)
    }

    /**
     *
     */
    fun 名称を返す(JSONフィールド名言語: JSONフィールド名言語一覧) = 定数を取得する(JSONフィールド名言語.位置)

    /**
     *
     */
    fun 日本語名称を返す() = 定数を取得する(JSONフィールド名言語一覧.日本語.位置)

    /**
     *
     */
    fun 英語名称を返す() = 定数を取得する(JSONフィールド名言語一覧.英語.位置)


    /**
     *
     */
    fun 名称をセットする(英語名: String?, 日本語名: String?) {
        var 英語名称 = 英語名 ?: 日本語名 ?: ""
        var 日本語名称 = 日本語名 ?: 英語名 ?: ""

        定数をセットする(英語名称, 日本語名称)
    }

    /**
     *
     */
    fun フィールド名を文字列化する(): String {
        return String.format("[%s, %s]", 英語名称を返す(), 日本語名称を返す())
    }

    /**
     *
     */
    fun 同名のフィールドをマップで取得する(パラメータ: Map<String, Any?>): Map<String, Any?>? {
        return パラメータ.マップを取得する(定数を取得する(JSONフィールド名言語一覧.英語.位置)) ?: パラメータ.マップを取得する(定数を取得する(JSONフィールド名言語一覧.日本語.位置))
    }

    /**
     *
     */
    fun 同名のフィールドを文字列値で取得する(パラメータ: Map<String, Any?>): String? {
        return パラメータ.文字列値で取得する(定数を取得する(JSONフィールド名言語一覧.英語.位置)) ?: パラメータ.文字列値で取得する(定数を取得する(JSONフィールド名言語一覧.日本語.位置))
    }

    /**
     *
     */
    fun 同名のフィールドをInt値で取得する(パラメータ: Map<String, Any?>): Int? {
        return パラメータ.Int値で取得する(定数を取得する(JSONフィールド名言語一覧.英語.位置)) ?: パラメータ.Int値で取得する(定数を取得する(JSONフィールド名言語一覧.日本語.位置))
    }

    /**
     *
     */
    fun 同名のフィールドをLong値で取得する(パラメータ: Map<String, Any?>): Long? {
        return パラメータ.Long値で取得する(定数を取得する(JSONフィールド名言語一覧.英語.位置)) ?: パラメータ.Long値で取得する(定数を取得する(JSONフィールド名言語一覧.日本語.位置))
    }

}