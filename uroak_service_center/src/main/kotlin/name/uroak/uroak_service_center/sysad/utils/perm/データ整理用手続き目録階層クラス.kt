package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.entity.手続き目録階層データクラス
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧

/**
 *
 */
class データ整理用手続き目録階層クラス : データ整理用目録階層クラス(実行権限当事者種別一覧.利用対象) {
    /**
     *
     */
    override fun 目録を作成する(識別子: Int, 階層番号: Int): データ整理用目録クラス {
        return データ整理用手続き目録クラス(識別子, 階層番号)
    }

    /**
     *
     */
    fun 目録配列をセットする(手続き目録階層配列: MutableList<手続き目録階層データクラス>) {
        super.目録配列をセットする(手続き目録階層配列) { 目録階層配列 ->
            目録階層配列.forEach {
                目録を追加する(it.識別子, it.階層番号)
            }
        }
    }
}