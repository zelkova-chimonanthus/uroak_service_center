package name.uroak.uroak_service_center.base.services

import name.uroak.uroak_service_center.base.core.基盤処理実行体クラス
import name.uroak.uroak_service_center.shared.base.ret.戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.手続き実行情報クラス
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.execution.パラメータセットクラス
import name.uroak.uroak_service_center.shared.util.log.ログ
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.DefaultTransactionDefinition
import java.lang.reflect.Method

/**
 *
 */
internal enum class トランザクション種別一覧 {
    /***/
    読込専用(
        伝搬属性 = TransactionDefinition.PROPAGATION_REQUIRED,
        分離レベル = TransactionDefinition.ISOLATION_READ_COMMITTED,
        読込専用フラグ = true
    ),

    /***/
    更新可能(
        伝搬属性 = TransactionDefinition.PROPAGATION_REQUIRED,
        分離レベル = TransactionDefinition.ISOLATION_READ_COMMITTED,
        読込専用フラグ = false
    ),

    /***/
    新規更新可能(
        伝搬属性 = TransactionDefinition.PROPAGATION_REQUIRES_NEW,
        分離レベル = TransactionDefinition.ISOLATION_READ_COMMITTED,
        読込専用フラグ = false
    );

    /***/
    private val 伝搬属性: Int

    /***/
    private val 分離レベル: Int

    /***/
    private val 読込専用フラグ: Boolean

    /**
     *
     */
    constructor(伝搬属性: Int, 分離レベル: Int, 読込専用フラグ: Boolean) {
        this.伝搬属性 = 伝搬属性
        this.分離レベル = 分離レベル
        this.読込専用フラグ = 読込専用フラグ
    }

    /**
     *
     */
    fun トランザクションの状態を取得する(トランザクション管理: PlatformTransactionManager): TransactionStatus {
        val トランザクション定義 = DefaultTransactionDefinition()
        トランザクション定義.propagationBehavior = 伝搬属性
        トランザクション定義.isolationLevel = 分離レベル
        トランザクション定義.isReadOnly = 読込専用フラグ

        return トランザクション管理.getTransaction(トランザクション定義)
    }
}

/**
 * 全てのサービスクラスの親クラス
 */
abstract class サービスクラス : 基盤処理実行体クラス {

    /***/
    @Autowired
    private lateinit var トランザクション管理: PlatformTransactionManager

    /**
     *
     */
    constructor(名前: String) : super(名前) {

    }

    /**
     *
     */
    constructor() : super() {

    }

    /**
     *
     */
    protected fun 読込専用トランザクションで実行する(
        手続き実行情報: 手続き実行情報クラス,
        手続きメソッド: Method
    ): 戻り値クラス? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.読込専用,
            手続きメソッド = 手続きメソッド,
            手続き実行情報 = 手続き実行情報
        )
    }

    /**
     *
     */
    protected fun 更新可能トランザクションで実行する(
        手続き実行情報: 手続き実行情報クラス,
        手続きメソッド: Method
    ): 戻り値クラス? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.更新可能,
            手続きメソッド = 手続きメソッド,
            手続き実行情報 = 手続き実行情報
        )
    }

    /**
     *
     */
    protected fun 新規の更新可能トランザクションで実行する(
        手続き実行情報: 手続き実行情報クラス,
        手続きメソッド: Method
    ): 戻り値クラス? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.新規更新可能,
            手続きメソッド = 手続きメソッド,
            手続き実行情報 = 手続き実行情報
        )
    }

    /**
     * トランザクションを使用しないで手続きを実行する際に使用する。
     * 全手続き共通の、前処理、後処理も実行されるため、トランザクションを使用しない場合は、必ず、当メソッドを介して手続きを実行すること。
     */
    protected fun トランザクションなしで手続きを実行する(
        手続き実行情報: 手続き実行情報クラス,
        手続きメソッド: Method
    ): 戻り値クラス? {
        return 手続きを実行する(手続きメソッド, 手続き実行情報)
    }

    /**
     *
     */
    protected fun <戻り値の型> 読込専用トランザクションで実行する(
        パラメータマップ実行処理: ((パラメータセット: パラメータセットクラス?) -> 戻り値の型?)?,
        パラメータセット: パラメータセットクラス?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.読込専用,
            パラメータマップ実行処理 = パラメータマップ実行処理,
            パラメータセット = パラメータセット
        )
    }

    /**
     *
     */
    protected fun <戻り値の型> 更新可能トランザクションで実行する(
        パラメータマップ実行処理: ((パラメータセット: パラメータセットクラス?) -> 戻り値の型?)?,
        パラメータセット: パラメータセットクラス?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.更新可能,
            パラメータマップ実行処理 = パラメータマップ実行処理,
            パラメータセット = パラメータセット
        )
    }

    /**
     *
     */
    protected fun <戻り値の型> 新規の更新可能トランザクションで実行する(
        パラメータマップ実行処理: ((パラメータセット: パラメータセットクラス?) -> 戻り値の型?)?,
        パラメータセット: パラメータセットクラス?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.新規更新可能,
            パラメータマップ実行処理 = パラメータマップ実行処理,
            パラメータセット = パラメータセット
        )
    }

    /**
     *
     */
    protected fun <戻り値の型> 読込専用トランザクションで実行する(
        可変長パラメータ実行処理: Method?,
        vararg パラメータ: Any?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.読込専用,
            可変長パラメータ実行処理 = 可変長パラメータ実行処理,
            パラメータ = パラメータ
        )
    }

    /**
     *
     */
    protected fun <戻り値の型> 更新可能トランザクションで実行する(
        可変長パラメータ実行処理: Method?,
        vararg パラメータ: Any?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.更新可能,
            可変長パラメータ実行処理 = 可変長パラメータ実行処理,
            パラメータ = パラメータ
        )
    }

    /**
     *
     */
    protected fun <戻り値の型> 新規の更新可能トランザクションで実行する(
        可変長パラメータ実行処理: Method?,
        vararg パラメータ: Any?
    ): 戻り値の型? {
        return トランザクションで実行する(
            トランザクション種別 = トランザクション種別一覧.新規更新可能,
            可変長パラメータ実行処理 = 可変長パラメータ実行処理,
            パラメータ = パラメータ
        )
    }

    /**
     *
     */
    private fun <戻り値の型> トランザクションで実行する(
        トランザクション種別: トランザクション種別一覧,
        手続きメソッド: Method? = null,
        手続き実行情報: 手続き実行情報クラス? = null,
        パラメータマップ実行処理: ((パラメータセット: パラメータセットクラス?) -> 戻り値の型?)? = null,
        パラメータセット: パラメータセットクラス? = null,
        可変長パラメータ実行処理: Method? = null,
        vararg パラメータ: Any?
    ): 戻り値の型? {
        val 戻り値: 戻り値の型?

        val トランザクションの状態 = トランザクション種別.トランザクションの状態を取得する(トランザクション管理)

        try {

            戻り値 =
                if (手続きメソッド != null) {
                    if (手続き実行情報 != null)
                        手続きを実行する(手続きメソッド, 手続き実行情報) as 戻り値の型
                    else 例外をスローする(
                        メッセージID一覧.CMN_E_0002,
                        "手続きを実行しようとしましたが、手続き実行情報がNULLになっていました。"
                    )
                } else if (パラメータマップ実行処理 != null) {
                    パラメータマップ実行処理(パラメータセット)
                } else if (可変長パラメータ実行処理 != null) {
                    可変長パラメータ実行処理.invoke(this, *パラメータ) as 戻り値の型
                } else {
                    例外をスローする(メッセージID一覧.CMN_E_0002, "トランザクションで実行する際にパラメータで渡された実行処理がすべてNULLになっていました。")
                }

            トランザクション管理.commit(トランザクションの状態)

        } catch (トランザクション例外: Throwable) {
            トランザクション管理.rollback(トランザクションの状態)
            throw トランザクション例外
        }

        return 戻り値
    }

    /**
     *
     */
    private fun 手続きを実行する(
        手続きメソッド: Method,
        手続き実行情報: 手続き実行情報クラス,
    ): 戻り値クラス? {
        var 戻り値: 戻り値クラス? = null

        if (!手続き実行前の処理を行う(手続き実行情報)) {
            return 戻り値
        }

        try {
            戻り値 = 手続き処理を実行する(手続きメソッド, 手続き実行情報)
        } catch (トランザクション例外: Throwable) {
            // ここでキャッチした例外は最上層までスローし、最終的に「例外操作クラス」に処理させている
            throw トランザクション例外
        } finally {
            戻り値 = 手続き実行後の処理を行う(手続き実行情報, 戻り値)
        }

        return 戻り値
    }

    /**
     *
     */
    private fun 手続き実行前の処理を行う(手続き実行情報: 手続き実行情報クラス): Boolean {
        // 処理名称をセットする
        手続き実行情報.タスク名をセットする()

        // 開始ログを出力する
        ログ.手続き開始ログを出力する(this.javaClass, 手続き実行情報)

        return 個別の手続き実行前処理を行う(手続き実行情報)
    }

    /**
     *
     */
    protected open fun 個別の手続き実行前処理を行う(手続き実行情報: 手続き実行情報クラス): Boolean {
        return true
    }

    /**
     *
     */
    private fun 手続き処理を実行する(
        手続きメソッド: Method,
        手続き実行情報: 手続き実行情報クラス,
    ): 戻り値クラス {
        return 手続きメソッド.invoke(this, 手続き実行情報) as 戻り値クラス
    }

    /**
     *
     */
    private fun 手続き実行後の処理を行う(手続き実行情報: 手続き実行情報クラス, 戻り値: 戻り値クラス?): 戻り値クラス? {

        val 戻り値_保存 = 個別の手続き実行後処理を行う(手続き実行情報, 戻り値)

        // 終了ログを出力する
        ログ.手続き終了ログを出力する(this.javaClass, 手続き実行情報)

        return 戻り値_保存
    }

    /**
     *
     */
    protected open fun 個別の手続き実行後処理を行う(手続き実行情報: 手続き実行情報クラス, 戻り値: 戻り値クラス?): 戻り値クラス? {
        return 戻り値
    }
}