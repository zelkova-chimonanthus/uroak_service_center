package name.uroak.uroak_service_center.shared.constants

/**
 *
 */
object 共有定数 {
    /***/
    const val Uroakサービスセンターパッケージ階層: String = "name.uroak.uroak_service_center"

    /**
     *
     */
    fun 共通のパッケージ階層を除去する(クラス名: String): String {
        var 残す先頭位置: Int = クラス名.indexOf(Uroakサービスセンターパッケージ階層)
        残す先頭位置 += Uroakサービスセンターパッケージ階層.length + ".".length
        if (残す先頭位置 >= クラス名.length) {
            return クラス名
        }
        return クラス名.substring(残す先頭位置)
    }

    /**
     *
     */
    fun 共通のパッケージ階層を除去したクラス名を返す(クラス: Class<Any>): String {
        return 共通のパッケージ階層を除去する(クラス.canonicalName)
    }
}