package name.uroak.uroak_service_center.sysad.utils

import name.uroak.uroak_service_center.shared.base.core.ログ可能な実行体クラス
import name.uroak.uroak_service_center.shared.base.util.会員情報クラス
import name.uroak.uroak_service_center.shared.base.util.手続き情報クラス
import name.uroak.uroak_service_center.sysad.entity.グループデータクラス
import name.uroak.uroak_service_center.sysad.entity.会員目録階層データクラス
import name.uroak.uroak_service_center.sysad.entity.手続き目録階層データクラス
import name.uroak.uroak_service_center.sysad.utils.perm.データ整理用権限設定データ空間クラス

/**
 *
 */
class 実行権限チェック道具箱クラス : ログ可能な実行体クラス {
    /***/
    private var 会員情報 = 会員情報クラス()

    /***/
    private var 手続き情報 = 手続き情報クラス()

    /***/
    private val 権限設定データ空間 = データ整理用権限設定データ空間クラス()

    /**
     *
     */
    constructor() : super("実行権限チェック道具箱")

    /**
     *
     */
    fun 対象手続きが実行可能かチェックする(権限属性: 権限属性クラス): Boolean {
        return 権限属性.実行可能かチェックする(手続き情報.手続き処理種別を返す())
    }

    /**
     *
     */
    fun 対象限定管理者としての実行権限をチェックする(対象限定管理者実行権限設定データ配列: MutableList<実行権限設定クラス>): 権限属性クラス? {
        if (対象限定管理者実行権限設定データ配列.isNotEmpty()) {

            実行ログを出力する("利用者の会員は管理者（対象限定管理者）でした。")

            // 3-1. 登録されていて、かつ実行権限設定データがあった場合
            for (実行権限設定データ in 対象限定管理者実行権限設定データ配列) {
                // 3-2. 実行権限設定データがあり、１つでも「実行可能」属性が１になっているデータがあれば実行可能とする。そのほかの権限属性は無視する。
                if (実行権限設定データ.権限を返す().実行可能属性があるかチェックする()) {

                    実行ログを出力する("利用者の会員は管理者（対象限定管理者）で且つ対象手続きに対して実行可能な実行権限が登録されていたので実行可能と判断します。")

                    // 3-3. 権限データを登録し、終了する。（登録する権限データは全ての権限属性を１にすること）
                    return 権限属性クラス.全ての権限を持つ権限属性を返す()
                }
            }
            // 実行可能と判定できなかったら、引き続き、チェックを行っていく
        } else {
            実行ログを出力する("利用者の会員は管理者（対象限定管理者）ではありません。")
        }
        return null
    }

    /**
     * - グループに所属メンバーをセットする
     * - 実行権限設定レコードからデータを作成する
     */
    fun 利用者と利用対象との間で有効な実行権限設定を取得するための準備をする(実行権限設定レコード配列: List<Map<String, Any?>>) {
        実行ログを出力する("グループに所属メンバーをセットします。")
        権限設定データ空間.グループに所属メンバーをセットする()

        実行ログを出力する("実行権限設定レコードからデータを作成します。")
        権限設定データ空間.実行権限設定レコードからデータを作成する(実行権限設定レコード配列)
    }

    /**
     *
     */
    fun 利用者と利用対象との間で有効な実行権限設定を取得する(): 権限属性クラス? {
        実行ログを出力する("利用者と利用対象との間で有効な実行権限設定を取得します。")
        return 権限設定データ空間.利用者と利用対象との間で有効な実行権限設定を取得する()
    }

    /**
     *
     */
    fun 会員情報を返す() = 会員情報

    /**
     *
     */
    fun 手続き情報を返す() = 手続き情報

    /**
     *
     */
    fun 会員と手続きをセットする(会員情報: 会員情報クラス, 手続き情報: 手続き情報クラス) {
        this.会員情報 = 会員情報
        this.手続き情報 = 手続き情報
        権限設定データ空間.会員と手続きをセットする(会員情報, 手続き情報)
    }

    /**
     *
     */
    fun 会員目録階層配列からデータをセットする(会員目録階層配列: MutableList<会員目録階層データクラス>) {
        権限設定データ空間.会員目録階層を作成する(会員目録階層配列)
    }

    /**
     *
     */
    fun 手続き目録階層配列からデータをセットする(手続き目録階層配列: MutableList<手続き目録階層データクラス>) {
        権限設定データ空間.手続き目録階層を作成する(手続き目録階層配列)
    }

    /**
     *
     */
    fun 会員グループ群からデータをセットする(会員グループデータ配列: MutableList<グループデータクラス>) {
        権限設定データ空間.会員グループ群をセットする(会員グループデータ配列)
    }

    /**
     *
     */
    fun 手続きグループ群からデータをセットする(手続きグループデータ配列: MutableList<グループデータクラス>) {
        権限設定データ空間.手続きグループ群をセットする(手続きグループデータ配列)
    }

    /**
     *
     */
    fun 会員目録識別子配列を返す() = 権限設定データ空間.会員目録識別子配列を返す()

    /**
     *
     */
    fun 手続き目録識別子配列を返す() = 権限設定データ空間.手続き目録識別子配列を返す()

    /**
     *
     */
    fun 会員グループ識別子配列を返す() = 権限設定データ空間.会員グループ識別子配列を返す()

    /**
     *
     */
    fun 手続きグループ識別子配列を返す() = 権限設定データ空間.手続きグループ識別子配列を返す()

    /**
     *
     */
    fun 会員を返す() = 権限設定データ空間.会員を返す()

    /**
     *
     */
    fun 手続きを返す() = 権限設定データ空間.手続きを返す()

    /**
     *
     */
    fun 会員識別子を返す() = 権限設定データ空間.会員識別子を返す()

    /**
     *
     */
    fun 手続き識別子を返す() = 権限設定データ空間.手続き識別子を返す()

    /**
     *
     */
    fun 会員情報の詳細を文字列化する(): String {
        return 会員情報.詳細情報を文字列化する()
    }

    /**
     *
     */
    fun 手続き情報の詳細を文字列化する(): String {
        return 手続き情報.詳細情報を文字列化する()
    }

    /**
     * 実行不可と判定された場合に返す結果。（処理でエラーが発生したときは例外をスローする）
     */
    fun エラーチェック結果を作成する(): 実行権限チェック結果データクラス {
        return チェック結果を作成する(false)
    }

    /**
     * 実行可能と判定された場合に返す結果
     */
    fun 正常チェック結果を作成する(): 実行権限チェック結果データクラス {
        return チェック結果を作成する(true)
    }

    /**
     *
     */
    private fun チェック結果を作成する(実行可能: Boolean): 実行権限チェック結果データクラス {
        return 実行権限チェック結果データクラス(実行可能, 会員情報, 手続き情報)
    }
}