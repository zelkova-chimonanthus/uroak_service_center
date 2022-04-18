package name.uroak.uroak_service_center.sysad.utils.perm.perm_data

import name.uroak.uroak_service_center.sysad.utils.perm.データ整理用やりとり当事者クラス
import name.uroak.uroak_service_center.sysad.utils.perm.データ整理用グループクラス
import name.uroak.uroak_service_center.sysad.utils.perm.データ整理用当事者クラス
import name.uroak.uroak_service_center.sysad.utils.perm.データ整理用目録クラス
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧.*
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧

/**
 *
 */
abstract class データ整理用権限端クラス {
    /***/
    private var 目録階層番号 = mutableSetOf<Int>()

    /***/
    private var やり取り当事者フラグ = false

    /***/
    private var 当事者: データ整理用当事者クラス? = null

    /**
     * パラメータの階層番号は下記を意味する。
     * - 目録の実行権限だった場合、その目録の階層番号
     * - グループの場合はグループの目録メンバーの階層番号（目録メンバーは複数存在するときもある）
     */
    fun この目録階層に該当するか(階層番号: Int) = 目録階層番号.contains(階層番号)

    /**
     * これがtrueを返すケースは以下の２つ。
     * - 実行権限の当事者がやりとり当事者（会員、手続き）の場合
     * - 実行権限の当事者がグループで、かつメンバーにやりとり当事者（会員、手続き）がいる場合
     */
    fun やり取り当事者に該当するか() = やり取り当事者フラグ

    /**
     *
     */
    fun 当事者を返す() = 当事者

    fun 同じ当事者か(当事者: データ整理用当事者クラス): Boolean {
        return when (当事者.実行権限当事者種別を返す()) {
            利用者 -> 同じ当事者か(当事者.実行権限利用者種別を返す() ?: 実行権限利用者種別一覧.不明, 当事者.識別子を返す())
            利用対象 -> 同じ当事者か(当事者.実行権限利用対象種別を返す() ?: 実行権限利用対象種別一覧.不明, 当事者.識別子を返す())
            不明 -> false
        }
    }

    open fun 同じ当事者か(利用者種別: 実行権限利用者種別一覧, 識別子: Int): Boolean {
        return false
    }

    open fun 同じ当事者か(利用対象種別: 実行権限利用対象種別一覧, 識別子: Int): Boolean {
        return false
    }

    /**
     * 当事者をセットし、目録ならば階層番号、グループならば目録メンバーの階層番号をセットする
     */
    fun 当事者をセットする(当事者: データ整理用当事者クラス) {
        if (同じ当事者か(当事者)) {
            this.当事者 = 当事者
            when (当事者) {
                is データ整理用グループクラス<*, *, *> -> {
                    目録階層番号 = 当事者.目録メンバー階層番号セットを返す()
                    やり取り当事者フラグ = 当事者.やりとり当事者がメンバーにいるか()
                }
                is データ整理用目録クラス -> {
                    目録階層番号.clear()
                    目録階層番号 += 当事者.階層番号を返す()
                }
                is データ整理用やりとり当事者クラス -> {
                    やり取り当事者フラグ = true
                }
            }
        }
    }

    /**
     *
     */
    fun 目録階層番号を追加する(階層番号: Int) {
        目録階層番号 += 階層番号
    }
}