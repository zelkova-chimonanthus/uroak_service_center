package name.uroak.uroak_service_center.shared.repository

import org.springframework.stereotype.Repository

@Repository
interface 汎用データ操作リポジトリ {
    /**
     * LIMIT句で取得行数上限を設定してクエリを実行した際の全体行数を返す。
     * 但し、直前に実行するクエリを「SELECT SQL_CALC_FOUND_ROWS ・・・」としておかないと当SQLは正しく機能しない。
     */
    fun 全体行数を取得する():Int
}