package name.uroak.uroak_service_center.sysad.utils.perm.perm_data

import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用利用対象クラス
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用利用者クラス
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧
import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
class データ整理用実行権限設定データクラス(
    /***/
    private var 識別子: Int,
    /***/
    private var 利用者: データ整理用利用者クラス,
    /***/
    private var 利用対象: データ整理用利用対象クラス,
    /***/
    private var 権限: 権限属性クラス
) {
    /**
     *
     */
    fun 利用者と同じか(利用者: データ整理用利用者クラス) = 利用者と同じか(利用者.利用者種別を返す(), 利用者.利用者IDを返す())

    /**
     *
     */
    fun 利用対象と同じか(利用対象: データ整理用利用対象クラス) = 利用対象と同じか(利用対象.利用対象種別を返す(), 利用対象.利用対象IDを返す())

    /**
     *
     */
    fun 利用者と同じか(利用者種別: 実行権限利用者種別一覧, 識別子: Int) = 利用者.同じ当事者か(利用者種別, 識別子)

    /**
     *
     */
    fun 利用対象と同じか(利用対象種別: 実行権限利用対象種別一覧, 識別子: Int) = 利用対象.同じ当事者か(利用対象種別, 識別子)

    /**
     * 実行権限属性値のコピーを返す
     */
    fun 権限を返す() = 権限属性クラス(権限.権限値を返す())

    /**
     *
     */
    fun 実行権限設定データの識別子を返す() = 識別子

    /**
     *
     */
    fun 利用者を返す() = 利用者

    /**
     *
     */
    fun 利用対象を返す() = 利用対象

    /**
     *
     */
    fun 利用者IDを返す() = 利用者.利用者IDを返す()

    /**
     *
     */
    fun 利用者種別を返す() = 利用者.利用者種別を返す()

    /**
     *
     */
    fun 利用対象IDを返す() = 利用対象.利用対象IDを返す()

    /**
     *
     */
    fun 利用対象種別を返す() = 利用対象.利用対象種別を返す()

}