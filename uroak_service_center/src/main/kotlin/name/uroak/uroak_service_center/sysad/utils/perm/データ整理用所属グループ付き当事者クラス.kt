package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.sysad.constants.権限管理定数
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用利用対象クラス
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧.*
import name.uroak.uroak_service_center.sysad.utils.実行権限当事者種別一覧
import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
open class データ整理用所属グループ付き当事者クラス(private val 識別子: Int, private val 当事者種別: 実行権限当事者種別一覧) : データ整理用当事者クラス(識別子, 当事者種別) {
    /***/
    private var 所属グループ配列 = mutableListOf<データ整理用グループクラス<*, *, *>>()

    /***/
    private var 所属グループ識別子セット = mutableSetOf<Int>()

    /***/
    private var 所属グループ権限対象手続き_権限: 権限属性クラス? = null

    /***/
    private var 所属グループ権限対象目録_階層別権限 = mutableMapOf<Int, 権限属性クラス>()

    /***/
    private var 所属グループ権限対象グループ_手続き権限: 権限属性クラス? = null

    /***/
    private var 所属グループ権限対象グループ_階層別権限 = mutableMapOf<Int, 権限属性クラス>()

    /**
     *
     */
    fun 所属グループの権限対象が手続きの場合の権限属性があるか() = 所属グループ権限対象手続き_権限 != null

    /**
     *
     */
    fun 所属グループの権限対象が手続き目録の場合の権限属性があるか(階層番号: Int) = 所属グループ権限対象目録_階層別権限[階層番号] != null

    /**
     *
     */
    fun 所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性があるか() = 所属グループ権限対象グループ_手続き権限 != null

    /**
     *
     */
    fun 所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性があるか(階層番号: Int) = 所属グループ権限対象グループ_階層別権限[階層番号] != null

    /**
     *
     */
    fun 所属グループの権限対象が手続きの場合の権限属性を返す() = 所属グループ権限対象手続き_権限

    /**
     *
     */
    fun 所属グループの権限対象が手続き目録の場合の権限属性を返す(階層番号: Int) = 所属グループ権限対象目録_階層別権限[階層番号]

    /**
     *
     */
    fun 所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性を返す() = 所属グループ権限対象グループ_手続き権限

    /**
     *
     */
    fun 所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性を返す(階層番号: Int) = 所属グループ権限対象グループ_階層別権限[階層番号]

    /**
     *
     */
    fun 所属グループの権限設定を利用対象ごとにまとめる(手続き目録階層: データ整理用手続き目録階層クラス): Boolean {
        if (利用対象側か()) {
            // 利用者側からの処理なので利用対象側の当事者の場合は処理しない
            return false
        }
        所属グループ配列.forEach { グループ ->
            グループ.権限設定データのループ処理をする { 権限設定データ ->
                val 権限属性 = 権限設定データ.権限を返す()
                val 権限利用対象 = 権限設定データ.利用対象を返す()
                when (権限利用対象.利用対象種別を返す()) {
                    手続き -> {
                        所属グループ権限対象手続き_権限 = やり取り当事者の権限を加算する(所属グループ権限対象手続き_権限, 権限属性)
                    }
                    手続き目録 -> {
                        目録階層の権限を加算する(所属グループ権限対象目録_階層別権限, 手続き目録階層, 権限利用対象, 権限属性)
                    }
                    手続きグループ -> {
                        if (権限利用対象.やり取り当事者に該当するか()) {
                            所属グループ権限対象グループ_手続き権限 = やり取り当事者の権限を加算する(所属グループ権限対象グループ_手続き権限, 権限属性)
                        }
                        目録階層の権限を加算する(所属グループ権限対象グループ_階層別権限, 手続き目録階層, 権限利用対象, 権限属性)
                    }
                    else -> {}
                }
            }
        }
        return true
    }

    /**
     *
     */
    private fun 目録階層の権限を加算する(目録階層権限: MutableMap<Int, 権限属性クラス>, 目録階層: データ整理用目録階層クラス, 権限利用対象: データ整理用利用対象クラス, 権限属性: 権限属性クラス) {
        for (階層番号 in 権限管理定数.目録階層番号開始値..目録階層.目録階層数を返す()) {
            if (権限利用対象.この目録階層に該当するか(階層番号)) {
                if (!目録階層権限.containsKey(階層番号)) {
                    目録階層権限[階層番号] = 権限属性.複製する()
                } else {
                    目録階層権限[階層番号]?.属性を加算した結果で更新する(権限属性)
                }
            }
        }
    }

    /**
     *
     */
    private fun やり取り当事者の権限を加算する(やり取り当事者権限: 権限属性クラス?, 権限属性: 権限属性クラス): 権限属性クラス {
        return if (やり取り当事者権限 == null) {
            権限属性.複製する()
        } else {
            やり取り当事者権限.属性を加算した結果で更新する(権限属性)
            やり取り当事者権限
        }
    }

    /**
     *
     */
    fun 所属グループ配列をクリアする() {
        所属グループ配列.clear()
        所属グループ識別子セット.clear()
    }

    /**
     *
     */
    fun 所属グループを追加する(所属グループ: データ整理用グループクラス<*, *, *>) {
        val 識別子 = 所属グループ.識別子を返す()
        if (!所属グループ識別子セット.contains(識別子)) {
            所属グループ配列 += 所属グループ
            所属グループ識別子セット += 識別子
        }
    }

    /**
     * 利用者側から同一の利用対象側への実行権限設定データの権限属性合算値を返す
     */
    fun 権限属性合算値を返す(利用対象: データ整理用利用対象クラス): 権限属性クラス? {
        return if (this.利用対象側か()) {
            null
        } else if (所属グループ配列.isEmpty()) {
            null
        } else {
            with(権限属性クラス()) {
                所属グループ配列.forEach {
                    this.属性を加算した結果で更新する(it.権限属性値を返す(利用対象))
                }
                this
            }
        }
    }
}