package name.uroak.uroak_service_center.shared.base.ret

import name.uroak.uroak_service_center.base.constants.レスポンスフィールド名
import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名言語一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.log.メッセージ集積庫
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱

/**
 *
 */
class エラー項目クラス {

    /***/
    val 対象名称リスト = mutableSetOf<String>()

    /***/
    private var エラーメッセージID: メッセージID一覧 = メッセージID一覧.INVALID

    /***/
    private var エラーメッセージ: String = ""

    /**
     *
     */
    constructor(エラーメッセージID: メッセージID一覧, vararg メッセージパラメータ: Any?) {
        エラーメッセージをセットする(エラーメッセージID, *メッセージパラメータ)
    }

    /**
     *
     */
    constructor(エラーメッセージID: メッセージID一覧) {
        エラーメッセージをセットする(エラーメッセージID)
    }

    /**
     *
     */
    constructor(対象名称リスト: Collection<String>, エラーメッセージID: メッセージID一覧, vararg メッセージパラメータ: Any?) : this(
        エラーメッセージID,
        *メッセージパラメータ
    ) {
        for (対象名称 in 対象名称リスト) {
            this.対象名称リスト += 対象名称
        }
    }

    /**
     *
     */
    constructor(対象名称リスト: Collection<String>, エラーメッセージID: メッセージID一覧) : this(
        エラーメッセージID
    ) {
        for (対象名称 in 対象名称リスト) {
            this.対象名称リスト += 対象名称
        }
    }

    /**
     *
     */
    fun エラーメッセージIDを返す() = エラーメッセージID

    /**
     *
     */
    fun エラーメッセージをセットする(エラーメッセージID: メッセージID一覧, vararg メッセージパラメータ: Any?) {
        this.エラーメッセージID = エラーメッセージID
        this.エラーメッセージ = メッセージ集積庫.メッセージを編集する(エラーメッセージID, *メッセージパラメータ)
    }

    /**
     *
     */
    fun エラーメッセージをセットする(エラーメッセージID: メッセージID一覧) {
        this.エラーメッセージID = エラーメッセージID
        this.エラーメッセージ = メッセージ集積庫.メッセージを編集する(エラーメッセージID)
    }

    /**
     *
     */
    fun 文字列化する(): String {
        return String.format("【%s】%s　（エラー対象項目：%s）", エラーメッセージID.ID文字列, エラーメッセージ, 文字列道具箱.文字列配列をカンマで接続する(対象名称リスト))
    }

    /**
     *
     */
    fun 返却値を作成する(JSONフィールド名言語: JSONフィールド名言語一覧): Map<String, Any> {
        var エラー項目 = mutableMapOf<String, Any>()
        エラー項目[レスポンスフィールド名.エラーメッセージID.名称を返す(JSONフィールド名言語)] = エラーメッセージID
        エラー項目[レスポンスフィールド名.エラーメッセージ.名称を返す(JSONフィールド名言語)] = エラーメッセージ
        return エラー項目
    }
}