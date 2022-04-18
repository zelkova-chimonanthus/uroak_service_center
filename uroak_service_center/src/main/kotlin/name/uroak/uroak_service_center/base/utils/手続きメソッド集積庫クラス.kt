package name.uroak.uroak_service_center.base.utils

import name.uroak.uroak_service_center.shared.base.execution.手続きパスクラス
import name.uroak.uroak_service_center.shared.base.execution.手続き呼出し
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import java.lang.reflect.Method

/**
 *
 */
internal fun 手続きメソッドキー文字列を作成する(
    手続きコード: String? = null,
    手続き補助コード: String? = null,
    手続き補助コード2: String? = null
): String {
    return String.format(
        "&&%s%%%s%%%s&&",
        文字列道具箱.前後の空白を削除し_空ならnullで返す(手続きコード) ?: "<null>",
        文字列道具箱.前後の空白を削除し_空ならnullで返す(手続き補助コード) ?: "<null>",
        文字列道具箱.前後の空白を削除し_空ならnullで返す(手続き補助コード2) ?: "<null>"
    )
}

/**
 *
 */
class 手続きメソッド集積庫クラス {

    /***/
    private val 集積庫 = mutableMapOf<String, 手続きメソッド情報クラス>()

    /**
     *
     */
    fun 手続きメソッド情報を追加する(メソッド: Method) {
        val 手続き呼出し注釈: 手続き呼出し = メソッド.getAnnotation(手続き呼出し::class.java)
        val 手続きメソッド情報 = 手続きメソッド情報クラス(
            手続き呼出し注釈.手続きコード,
            手続き呼出し注釈.手続きコード補助コード,
            手続き呼出し注釈.手続きコード補助コード2,
            手続き呼出し注釈.処理種別,
            メソッド
        )
        集積庫[手続きメソッド情報.キー文字列を作成する()] = 手続きメソッド情報
    }

    /**
     *
     */
    fun 手続きメソッド情報を取得する(
        手続きパス: 手続きパスクラス
    ): 手続きメソッド情報クラス? {
        return 集積庫[手続きメソッドキー文字列を作成する(手続きパス.手続きコード, 手続きパス.手続き補助コード, 手続きパス.手続き補助コード2)]
    }

    /**
     *
     */
    fun クリアする() {
        集積庫.clear()
    }

    /**
     *
     */
    fun 格納庫数を取得する(): Int = 集積庫.size

    /**
     *
     */
    fun 指定された手続きメソッドが格納されているか(
        手続きパス: 手続きパスクラス
    ): Boolean {
        return 集積庫.containsKey(手続きメソッドキー文字列を作成する(手続きパス.手続きコード, 手続きパス.手続き補助コード, 手続きパス.手続き補助コード2))
    }

}
