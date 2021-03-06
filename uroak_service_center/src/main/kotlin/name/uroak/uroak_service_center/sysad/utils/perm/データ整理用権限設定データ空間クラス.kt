package name.uroak.uroak_service_center.sysad.utils.perm

import name.uroak.uroak_service_center.shared.base.core.ログ可能な実行体クラス
import name.uroak.uroak_service_center.shared.base.util.会員情報クラス
import name.uroak.uroak_service_center.shared.base.util.手続き情報クラス
import name.uroak.uroak_service_center.sysad.constants.権限管理定数
import name.uroak.uroak_service_center.sysad.entity.グループデータクラス
import name.uroak.uroak_service_center.sysad.entity.会員目録階層データクラス
import name.uroak.uroak_service_center.sysad.entity.手続き目録階層データクラス
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用実行権限設定データクラス
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用実行権限設定データ作成クラス
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧
import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
class データ整理用権限設定データ空間クラス : ログ可能な実行体クラス {
    /***/
    private var 会員: データ整理用会員クラス = データ整理用会員クラス(-1)

    /***/
    private var 手続き: データ整理用手続きクラス = データ整理用手続きクラス(-1)

    /***/
    private var 会員目録階層 = データ整理用会員目録階層クラス()

    /***/
    private var 手続き目録階層 = データ整理用手続き目録階層クラス()

    /***/
    private var 会員グループ群 = データ整理用会員グループ群クラス()

    /***/
    private var 手続きグループ群 = データ整理用手続きグループ群クラス()

    /***/
    private var 実行権限設定データ配列 = mutableListOf<データ整理用実行権限設定データクラス>()

    /***/
    private var 実行権限設定データ作成 = データ整理用実行権限設定データ作成クラス()

    /**
     *
     */
    constructor() : super("データ整理用権限設定データ空間")

    /**
     *
     */
    fun 会員を返す() = 会員

    /**
     *
     */
    fun 手続きを返す() = 手続き

    /**
     *
     */
    fun グループに所属メンバーをセットする() {
        会員グループに所属メンバーをセットする()
        手続きグループに所属メンバーをセットする()
    }

    /**
     *
     */
    fun 会員グループに所属メンバーをセットする() {
        会員グループ群.会員や会員目録メンバーをセットする(会員, 会員目録階層)
    }

    /**
     *
     */
    fun 手続きグループに所属メンバーをセットする() {
        手続きグループ群.手続きや手続き目録メンバーをセットする(手続き, 手続き目録階層)
    }

    /**
     *
     */
    fun 実行権限設定レコードからデータを作成する(実行権限設定レコード配列: List<Map<String, Any?>>) {
        実行権限設定データ作成.実行権限設定レコードからデータを作成する(実行権限設定レコード配列)
        実行権限設定データ作成.当事者をセットする(
            会員,
            手続き,
            会員目録階層,
            手続き目録階層,
            会員グループ群,
            手続きグループ群
        )
        実行権限設定データをセットする(実行権限設定データ作成.実行権限設定データ配列を返す())
    }

    /**
     *
     */
    fun 利用者と利用対象との間で有効な実行権限設定を取得する(): 権限属性クラス? {
        // -------------------------------------------------------------
        // 実行権限設定が取得できたところで、取得した実行権限設定を返して終了する
        // -------------------------------------------------------------
        val 手続き目録階層数 = 手続き目録階層.目録階層数を返す()

        // 1. 会員と手続きの間の実行権限設定を取得する
        実行ログを出力する("会員と手続きの間の実行権限設定を取得します。")
        if (会員.権限対象手続き_権限があるか()) {
            実行ログを出力する("取得できました。")
            return 会員.権限対象手続き_権限を返す()
        }
        実行ログを出力する("取得できませんでした。")

        // 2. 会員と、手続きが所属する手続きグループの間の実行権限設定を取得する
        実行ログを出力する("会員と、手続きが所属する手続きグループの間の実行権限設定を取得します。")
        if (会員.権限対象手続きグループ_手続き権限があるか()) {
            実行ログを出力する("取得できました。")
            return 会員.権限対象手続きグループ_手続き権限を返す()
        }
        実行ログを出力する("取得できませんでした。")

        // 3. 会員と、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得する
        実行ログを出力する("会員と、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得します。")
        for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
            if (会員.権限対象手続きグループ_階層別権限があるか(階層番号)) {
                実行ログを出力する("取得できました。")
                return 会員.権限対象手続きグループ_階層別権限を返す(階層番号)
            }
        }
        実行ログを出力する("取得できませんでした。")

        // 4. 会員と、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得する
        実行ログを出力する("会員と、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得します。")
        for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
            if (会員.権限対象手続き目録_階層別権限があるか(階層番号)) {
                実行ログを出力する("取得できました。")
                return 会員.権限対象手続き目録_階層別権限を返す(階層番号)
            }
        }
        実行ログを出力する("取得できませんでした。")

        // 5. 会員が所属する会員グループと手続きの間の実行権限設定を取得する
        実行ログを出力する("会員が所属する会員グループと手続きの間の実行権限設定を取得します。")
        if (会員.所属グループの権限対象が手続きの場合の権限属性があるか()) {
            実行ログを出力する("取得できました。")
            return 会員.所属グループの権限対象が手続きの場合の権限属性を返す()
        }
        実行ログを出力する("取得できませんでした。")

        // 6. 会員が所属する会員グループと、手続きが所属する手続きグループの間の実行権限設定を取得する
        実行ログを出力する("会員が所属する会員グループと、手続きが所属する手続きグループの間の実行権限設定を取得します。")
        if (会員.所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性があるか()) {
            実行ログを出力する("取得できました。")
            return 会員.所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性を返す()
        }
        実行ログを出力する("取得できませんでした。")

        // 7. 会員が所属する会員グループと、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得する
        実行ログを出力する("会員が所属する会員グループと、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得します。")
        for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
            if (会員.所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性があるか(階層番号)) {
                実行ログを出力する("取得できました。")
                return 会員.所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性を返す(階層番号)
            }
        }
        実行ログを出力する("取得できませんでした。")

        // 8. 会員が所属する会員グループと、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得する
        実行ログを出力する("会員が所属する会員グループと、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得します。")
        for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
            if (会員.所属グループの権限対象が手続き目録の場合の権限属性があるか(階層番号)) {
                実行ログを出力する("取得できました。")
                return 会員.所属グループの権限対象が手続き目録の場合の権限属性を返す(階層番号)
            }
        }
        実行ログを出力する("取得できませんでした。")

        // 9. 下記を会員目録階層の下層から上層へ繰り返す
        実行ログを出力する("会員目録を起点とした実行権限設定データの取得を、会員目録階層の下層から上層へ遡りながら試みます。")
        for (階層番号 in 権限管理定数.目録階層番号開始値..会員目録階層.目録階層数を返す()) {

            val 会員目録 = 会員目録階層.指定された階層の目録を返す(階層番号)
            実行ログを出力する("階層番号（$階層番号）の会員目録に対して処理を行います。")

            // 9-1. 会員目録と手続きの間の実行権限設定を取得する
            実行ログを出力する("会員目録と手続きの間の実行権限設定を取得します。")
            if (会員目録.権限対象手続き_権限があるか()) {
                実行ログを出力する("取得できました。")
                return 会員目録.権限対象手続き_権限を返す()
            }
            実行ログを出力する("取得できませんでした。")

            // 9-2. 会員目録と、手続きが所属する手続きグループの間の実行権限設定を取得する
            実行ログを出力する("会員目録と、手続きが所属する手続きグループの間の実行権限設定を取得します。")
            if (会員目録.権限対象手続きグループ_手続き権限があるか()) {
                実行ログを出力する("取得できました。")
                return 会員目録.権限対象手続きグループ_手続き権限を返す()
            }
            実行ログを出力する("取得できませんでした。")

            // 9-3. 会員目録と、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得する
            実行ログを出力する("会員目録と、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得します。")
            for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
                if (会員目録.権限対象手続きグループ_階層別権限があるか(階層番号)) {
                    実行ログを出力する("取得できました。")
                    return 会員目録.権限対象手続きグループ_階層別権限を返す(階層番号)
                }
            }
            実行ログを出力する("取得できませんでした。")

            // 9-4. 会員目録と、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得する
            実行ログを出力する("会員目録と、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得します。")
            for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
                if (会員目録.権限対象手続き目録_階層別権限があるか(階層番号)) {
                    実行ログを出力する("取得できました。")
                    return 会員目録.権限対象手続き目録_階層別権限を返す(階層番号)
                }
            }
            実行ログを出力する("取得できませんでした。")

            // 9-5. 会員目録が所属する会員グループと手続きの間の実行権限設定を取得する
            実行ログを出力する("会員目録が所属する会員グループと手続きの間の実行権限設定を取得します。")
            if (会員目録.所属グループの権限対象が手続きの場合の権限属性があるか()) {
                実行ログを出力する("取得できました。")
                return 会員目録.所属グループの権限対象が手続きの場合の権限属性を返す()
            }
            実行ログを出力する("取得できませんでした。")

            // 9-6. 会員目録が所属する会員グループと、手続きが所属する手続きグループの間の実行権限設定を取得する
            実行ログを出力する("会員目録が所属する会員グループと、手続きが所属する手続きグループの間の実行権限設定を取得します。")
            if (会員目録.所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性があるか()) {
                実行ログを出力する("取得できました。")
                return 会員目録.所属グループの権限対象が手続きグループで所属メンバーが手続きの場合の権限属性を返す()
            }
            実行ログを出力する("取得できませんでした。")

            // 9-7. 会員目録が所属する会員グループと、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得する
            実行ログを出力する("会員目録が所属する会員グループと、手続き目録（階層を下層から上層へ）が所属する手続きグループの間の実行権限設定を取得します。")
            for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
                if (会員目録.所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性があるか(階層番号)) {
                    実行ログを出力する("取得できました。")
                    return 会員目録.所属グループの権限対象が手続きグループで所属メンバーが手続き目録の場合の権限属性を返す(階層番号)
                }
            }
            実行ログを出力する("取得できませんでした。")

            // 9-8. 会員目録が所属する会員グループと、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得する
            実行ログを出力する("会員目録が所属する会員グループと、手続き目録（階層を下層から上層へ）の間の実行権限設定を取得します。")
            for (階層番号 in 権限管理定数.目録階層番号開始値..手続き目録階層数) {
                if (会員目録.所属グループの権限対象が手続き目録の場合の権限属性があるか(階層番号)) {
                    実行ログを出力する("取得できました。")
                    return 会員目録.所属グループの権限対象が手続き目録の場合の権限属性を返す(階層番号)
                }
            }
            実行ログを出力する("取得できませんでした。")
        }

        実行ログを出力する("採用するべき実行権限設定データがありませんでした。")

        return null
    }

    /**
     *
     */
    private fun 実行権限設定データをセットする(実行権限設定データ配列: MutableList<データ整理用実行権限設定データクラス>) {

        this.実行権限設定データ配列 = 実行権限設定データ配列.subList(0, 実行権限設定データ配列.size)

        実行権限設定データ配列.forEach {
            when (it.利用者種別を返す()) {
                実行権限利用者種別一覧.会員 -> {
                    会員.権限データを追加する(it)
                }
                実行権限利用者種別一覧.会員目録 -> {
                    会員目録階層.目録を返す(it.利用者IDを返す())?.権限データを追加する(it)
                }
                実行権限利用者種別一覧.会員グループ -> {
                    会員グループ群.グループを返す(it.利用者IDを返す())?.権限データを追加する(it)
                }
                else -> {}
            }
            when (it.利用対象種別を返す()) {
                実行権限利用対象種別一覧.手続き -> {
                    手続き.権限データを追加する(it)
                }
                実行権限利用対象種別一覧.手続き目録 -> {
                    手続き目録階層.目録を返す(it.利用対象IDを返す())?.権限データを追加する(it)
                }
                実行権限利用対象種別一覧.手続きグループ -> {
                    手続きグループ群.グループを返す(it.利用対象IDを返す())?.権限データを追加する(it)
                }
                else -> {}
            }
        }

        会員.実行権限設定データを整理する(手続き目録階層)
        会員目録階層.実行権限設定データを整理する(手続き目録階層)
        会員グループ群.実行権限設定データを整理する(手続き目録階層)

        会員.所属グループの権限設定を利用対象ごとにまとめる(手続き目録階層)
        会員目録階層.所属グループの権限設定を利用対象ごとにまとめる(手続き目録階層)
    }

    /**
     *
     */
    fun 会員と手続きをセットする(会員情報: 会員情報クラス, 手続き情報: 手続き情報クラス) {
        会員をセットする(会員情報)
        手続きをセットする(手続き情報)
    }

    /**
     *
     */
    fun 目録階層を作成する(会員目録階層データ: MutableList<会員目録階層データクラス>, 手続き目録階層データ: MutableList<手続き目録階層データクラス>) {
        会員目録階層を作成する(会員目録階層データ)
        手続き目録階層を作成する(手続き目録階層データ)
    }

    /**
     *
     */
    fun グループ群をセットする(会員グループデータ配列: MutableList<グループデータクラス>, 手続きグループデータ配列: MutableList<グループデータクラス>) {
        会員グループ群をセットする(会員グループデータ配列)
        手続きグループ群をセットする(手続きグループデータ配列)
    }

    /**
     *
     */
    fun 利用者側をセットする(会員情報: 会員情報クラス, 会員目録階層データ: MutableList<会員目録階層データクラス>, 会員グループデータ配列: MutableList<グループデータクラス>) {
        会員をセットする(会員情報)
        会員目録階層を作成する(会員目録階層データ)
        会員グループ群をセットする(会員グループデータ配列)
    }

    /**
     *
     */
    fun 利用対象側をセットする(手続き情報: 手続き情報クラス, 手続き目録階層データ: MutableList<手続き目録階層データクラス>, 手続きグループデータ配列: MutableList<グループデータクラス>) {
        手続きをセットする(手続き情報)
        手続き目録階層を作成する(手続き目録階層データ)
        手続きグループ群をセットする(手続きグループデータ配列)
    }

    /**
     *
     */
    fun 会員をセットする(会員情報: 会員情報クラス) {
        会員 = データ整理用会員クラス(会員情報.会員識別子を返す())
    }

    /**
     *
     */
    fun 手続きをセットする(手続き情報: 手続き情報クラス) {
        手続き = データ整理用手続きクラス(手続き情報.手続き識別子を返す())
    }

    /**
     *
     */
    fun 会員目録階層を作成する(会員目録階層データ: MutableList<会員目録階層データクラス>) {
        会員目録階層.目録配列をセットする(会員目録階層データ)
    }

    /**
     *
     */
    fun 手続き目録階層を作成する(手続き目録階層データ: MutableList<手続き目録階層データクラス>) {
        手続き目録階層.目録配列をセットする(手続き目録階層データ)
    }

    /**
     *
     */
    fun 会員グループ群をセットする(会員グループデータ配列: MutableList<グループデータクラス>) {
        会員グループ群.グループ群をセットする(会員グループデータ配列)
    }

    /**
     *
     */
    fun 手続きグループ群をセットする(手続きグループデータ配列: MutableList<グループデータクラス>) {
        手続きグループ群.グループ群をセットする(手続きグループデータ配列)
    }

    /**
     *
     */
    fun 会員目録識別子配列を返す() = 会員目録階層.目録識別子配列を返す()

    /**
     *
     */
    fun 手続き目録識別子配列を返す() = 手続き目録階層.目録識別子配列を返す()

    /**
     *
     */
    fun 会員グループ識別子配列を返す() = 会員グループ群.グループ識別子配列を返す()

    /**
     *
     */
    fun 手続きグループ識別子配列を返す() = 手続きグループ群.グループ識別子配列を返す()


    /**
     *
     */
    fun 会員識別子を返す() = 会員.識別子を返す()

    /**
     *
     */
    fun 手続き識別子を返す() = 手続き.識別子を返す()
}