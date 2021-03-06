package name.uroak.uroak_service_center.shared.util.tool

import java.util.*

/**
 *
 */
fun <列挙定数型, 値の型> 値に対応する列挙定数を返す(
    対象値: 値の型?,
    列挙定数クラス: Class<列挙定数型>,
    値を返す関数: (列挙定数型) -> 値の型,
    ないときの列挙定数: 列挙定数型?
): 列挙定数型? {
    return 配列から値に対応する要素を返す(
        対象値,
        列挙定数クラス.enumConstants,
        値を返す関数,
        ないときの列挙定数
    )
}

/**
 * 各列挙定数の文字列値と、渡された文字列値を比較し、一致する列挙定数を返す。
 * デフォルトでは、比較の際に、双方を小文字化してから比較する。（→大文字・小文字の区別はなし）
 */
fun <列挙定数型> 文字列値に対応する列挙定数を返す(
    対象値: String?,
    列挙定数クラス: Class<列挙定数型>,
    値を返す関数: (列挙定数型) -> String,
    ないときの列挙定数: 列挙定数型?,
    大文字小文字区別なし: Boolean = true
): 列挙定数型? {
    return 配列から文字列値に対応する要素を返す(
        対象値,
        列挙定数クラス.enumConstants,
        値を返す関数,
        ないときの列挙定数,
        大文字小文字区別なし
    )
}

/**
 * 各列挙定数の値と、渡された値を比較し、一致する列挙定数を返す
 */
fun <要素型, 値の型> 配列から値に対応する要素を返す(
    対象値: 値の型?,
    要素配列: Array<要素型>,
    値を返す関数: (要素型) -> 値の型,
    ないときの要素: 要素型?
): 要素型? {
    if (対象値 != null) {
        for (要素 in 要素配列) {
            if (値を返す関数(要素) == 対象値) {
                return 要素
            }
        }
    }
    return ないときの要素
}

/**
 * 配列の各要素の持つ文字列値と、渡された文字列値を比較し、一致する要素を返す。
 * デフォルトでは、比較の際に、双方を小文字化してから比較する。（→大文字・小文字の区別はなし）
 */
fun <要素型> 配列から文字列値に対応する要素を返す(
    対象値: String?,
    要素配列: Array<要素型>,
    値を返す関数: (要素型) -> String,
    ないときの要素: 要素型?,
    大文字小文字区別なし: Boolean = true
): 要素型? {

    対象値 ?: return ないときの要素

    val 比較対象値 = 文字列道具箱.前後の空白を削除し_空ならnullで返す(if (大文字小文字区別なし) 対象値?.lowercase() else 対象値) ?: return ないときの要素

    if (大文字小文字区別なし) {
        for (要素 in 要素配列) {
            if (値を返す関数(要素)?.lowercase() == 比較対象値) {
                return 要素
            }
        }
    } else {
        for (要素 in 要素配列) {
            if (値を返す関数(要素) == 比較対象値) {
                return 要素
            }
        }
    }

    return ないときの要素
}

/**
 *
 */
fun <列挙定数型> 文字列値に対応する列挙定数を返す(
    対象値: String?,
    列挙定数クラス: Class<列挙定数型>,
    比較関数: (列挙定数型, String) -> Boolean,
    ないときの列挙定数: 列挙定数型?
): 列挙定数型? {
    return 配列から文字列値に対応する要素を返す(
        対象値,
        列挙定数クラス.enumConstants,
        比較関数,
        ないときの列挙定数
    )
}
/**
 *
 */
fun <要素型> 配列から文字列値に対応する要素を返す(
    対象値: String?,
    要素配列: Array<要素型>,
    比較関数: (要素型, String) -> Boolean,
    ないときの要素: 要素型?
): 要素型? {
    val 比較対象値 = 文字列道具箱.前後の空白を削除し_空ならnullで返す(対象値) ?: return ないときの要素
    for (要素 in 要素配列) {
        if (比較関数(要素, 比較対象値)) {
            return 要素
        }
    }
    return ないときの要素
}

/**
 *
 */
fun base64でエンコードする(対象文字列: String): String {
    return Base64.getEncoder().encodeToString(対象文字列.toByteArray())
}

/**
 *
 */
fun base64でデコードする(対象文字列: String): String {
    return Base64.getDecoder().decode(対象文字列.toByteArray()).toString(Charsets.UTF_8)
}