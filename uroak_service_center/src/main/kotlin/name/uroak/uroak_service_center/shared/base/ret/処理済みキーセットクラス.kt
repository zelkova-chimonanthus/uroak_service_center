package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.error.exception.共通処理エラークラス

/**
 *
 */
class 処理済みキーセットクラス {

    /***/
    private val 処理済みキー値 = mutableListOf<Map<String, Any>>()

    /***/
    private val キー名セット = mutableListOf<String>()

    /**
     *
     */
    constructor(vararg キー名: String) {
        キー名.forEach { キー名セット.add(it) }
    }

    /**
     *
     */
    fun 処理済みキー値を追加する(vararg キー値: Any) {
        if (キー名セット.size != キー値.size) {
            throw 共通処理エラークラス(this.javaClass, メッセージID一覧.SHR_E_0019, キー名セット.size, キー値.size)
        }

        val 今回のキー値 = mutableMapOf<String, Any>()

        for ((カウンター, キー名) in キー名セット.withIndex()) {
            今回のキー値[キー名] = キー値[カウンター]
        }

        処理済みキー値.add(今回のキー値)
    }

    /**
     *
     */
    fun 処理済みキー値を返す(): List<Map<String, Any>> {
        return 処理済みキー値
    }
}
