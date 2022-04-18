package name.uroak.uroak_service_center.shared.util.execution

/**
 * MutableMap<String, Any?>の別名
 */
typealias パラメータセットクラス = MutableMap<String, Any?>

/**
 * パラメータ用マップ（MutableMap<String, Any?>）を作成する
 */
fun パラメータセットの容器を用意する(): パラメータセットクラス {
    return mutableMapOf()
}

/**
 * 「フィールド名、フィールド値・・・」の配列をもとにパラメータ用マップを作成する
 */
fun パラメータセットを用意する(vararg パラメータ: Any?): パラメータセットクラス {
    val パラメータセット: パラメータセットクラス = mutableMapOf()
    for (インデックス in パラメータ.indices step 2) {
        パラメータセット[パラメータ[インデックス] as String] = パラメータ[インデックス + 1]
    }
    return パラメータセット
}

