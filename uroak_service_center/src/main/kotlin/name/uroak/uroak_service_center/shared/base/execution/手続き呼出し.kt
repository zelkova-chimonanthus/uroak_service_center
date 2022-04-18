package name.uroak.uroak_service_center.shared.base.execution

import name.uroak.uroak_service_center.shared.base.util.手続き処理種別一覧


/**
 *サービスクラスで手続きとして実行対象となるメソッドに付与する
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class 手続き呼出し(
    /***/
    val 手続きコード: String = "",
    /***/
    val 手続きコード補助コード: String = "",
    /***/
    val 手続きコード補助コード2: String = "",
    /***/
    val 処理種別: 手続き処理種別一覧 = 手続き処理種別一覧.検索
)
