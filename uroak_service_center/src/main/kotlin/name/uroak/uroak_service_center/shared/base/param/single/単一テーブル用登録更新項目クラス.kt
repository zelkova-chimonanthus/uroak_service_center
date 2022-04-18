package name.uroak.uroak_service_center.shared.base.param.single

/**
 *
 */
class 単一テーブル用登録更新項目クラス {
    /***/
    private var カラム名: String = ""

    /***/
    private var 登録更新値: Any? = null

    /**
     *
     */
    constructor(カラム名: String, 登録更新値: Any?) {
        this.カラム名 = カラム名
        this.登録更新値 = 登録更新値
    }

    /**
     *
     */
    fun カラム名を返す(): String = カラム名

    /**
     *
     */
    fun 登録更新値を返す(): Any? = 登録更新値
}
