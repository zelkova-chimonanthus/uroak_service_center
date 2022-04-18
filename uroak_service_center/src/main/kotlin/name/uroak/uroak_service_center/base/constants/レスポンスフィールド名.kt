package name.uroak.uroak_service_center.base.constants

import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名定数クラス

object レスポンスフィールド名 {
    /***/
    val 実行状態 = JSONフィールド名定数クラス("execution_state", "実行状態")

    /***/
    val 正常終了フラグ = JSONフィールド名定数クラス("is_successful", "正常終了フラグ")

    /***/
    val エラー情報 = JSONフィールド名定数クラス("errors", "エラー情報")

    /***/
    val エラーメッセージID = JSONフィールド名定数クラス("code", "エラーメッセージID")

    /***/
    val エラーメッセージ = JSONフィールド名定数クラス("message", "エラーメッセージ")

    /***/
    val API種別 = JSONフィールド名定数クラス("operation", "手続き種別")

    /***/
    val 実行結果 = JSONフィールド名定数クラス("result", "実行結果")

    /***/
    val 実行状況 = JSONフィールド名定数クラス("state", "実行状況")

    /***/
    val 全体の件数 = JSONフィールド名定数クラス("total_quantity", "全体の件数")

    /***/
    val 処理件数 = JSONフィールド名定数クラス("processed_quantity", "処理件数")

    /***/
    val 削除件数 = JSONフィールド名定数クラス("deleted_quantity", "削除件数")

    /***/
    val 今回の返却件数 = JSONフィールド名定数クラス("current_quantity", "今回の返却件数")

    /***/
    val 一回の取得件数上限 = JSONフィールド名定数クラス("quantity_per_page", "一回の取得件数上限")

    /***/
    val 取得レコード = JSONフィールド名定数クラス("records", "取得レコード")

    /***/
    val 処理済みレコード = JSONフィールド名定数クラス("processed", "処理済みレコード")
}