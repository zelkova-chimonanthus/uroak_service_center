package name.uroak.uroak_service_center.shared.base.param.single

import name.uroak.uroak_service_center.base.constants.リクエストフィールド名
import name.uroak.uroak_service_center.shared.base.util.集合関数一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.基盤処理エラークラス

/**
 *
 */
class 単一テーブル用返却カラム指定クラス {
    /***/
    private var カラム名: String = ""

    /***/
    private var 集合関数: 集合関数一覧? = null

    /**
     *
     */
    constructor(カラム名: String, 集合関数: 集合関数一覧?) {
        this.カラム名 = カラム名
        this.集合関数 = 集合関数
    }

    /**
     *
     */
    constructor(カラム名: String, 集合関数名: String?) {
        this.カラム名 = カラム名
        this.集合関数 =
            if (集合関数名 == null)
                null
            else {
                集合関数一覧.JSONフィールド値を列挙定数に変換する(集合関数名).apply {
                    if (this == 集合関数一覧.不明)
                        throw 基盤処理エラークラス(this.javaClass, メッセージID一覧.BAS_E_0014, リクエストフィールド名.単一テーブル_返却カラム, 集合関数名 ?: "")
                }
            }
    }

    /**
     *
     */
    fun カラム名を返す(): String = カラム名

    /**
     *
     */
    fun 集合関数を返す(): 集合関数一覧? = 集合関数
}

