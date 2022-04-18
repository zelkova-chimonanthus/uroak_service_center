package name.uroak.uroak_service_center.sysad.utils

import name.uroak.uroak_service_center.shared.util.extension.Int値で取得する_NULL不可
import name.uroak.uroak_service_center.sysad.constants.取得データ名
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用利用対象クラス
import name.uroak.uroak_service_center.sysad.utils.perm.perm_data.データ整理用利用者クラス
import name.uroak.uroak_service_center.sysad.utils.実行権限利用対象種別一覧
import name.uroak.uroak_service_center.sysad.utils.実行権限利用者種別一覧
import name.uroak.uroak_service_center.sysad.utils.権限属性クラス

/**
 *
 */
class 実行権限設定クラス(
    レコード: MutableMap<String, Any?>
) {
    /***/
    private val 識別子: Int

    /***/
    private val 利用者: データ整理用利用者クラス

    /***/
    private val 利用対象: データ整理用利用対象クラス

    /***/
    private val 権限: 権限属性クラス

    init {
        識別子 = レコード.Int値で取得する_NULL不可(取得データ名.識別子)
        権限 = 権限属性クラス(レコード.Int値で取得する_NULL不可(取得データ名.権限))
        val 利用者ID = レコード.Int値で取得する_NULL不可(取得データ名.利用者ID)
        val 利用者種別 = 実行権限利用者種別一覧.JSONフィールド値を列挙定数に変換する(レコード.Int値で取得する_NULL不可(取得データ名.利用者種別))
        this.利用者 = データ整理用利用者クラス(利用者ID, 利用者種別)
        val 利用対象ID = レコード.Int値で取得する_NULL不可(取得データ名.利用対象ID)
        val 利用対象種別 = 実行権限利用対象種別一覧.JSONフィールド値を列挙定数に変換する(レコード.Int値で取得する_NULL不可(取得データ名.利用対象種別))
        this.利用対象 = データ整理用利用対象クラス(利用対象ID, 利用対象種別)
    }

    /**
     * 実行権限属性値のコピーを返す
     */
    fun 権限を返す() = 権限属性クラス(権限.権限値を返す())

}