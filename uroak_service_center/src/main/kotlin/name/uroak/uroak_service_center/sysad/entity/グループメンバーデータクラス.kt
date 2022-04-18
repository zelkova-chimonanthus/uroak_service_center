package name.uroak.uroak_service_center.sysad.entity

import name.uroak.uroak_service_center.sysad.utils.会員メンバー種別一覧
import name.uroak.uroak_service_center.sysad.utils.手続きメンバー種別一覧

/**
 *
 */
open class グループメンバーデータクラス(
    /**グループメンバーデータの識別子ではなく、メンバー（手続き、手続き目録、手続きグループ、会員、会員目録、会員グループ）の識別子*/
    val メンバー識別子: Int
)

/**
 *
 */
class 会員グループメンバーデータクラス : グループメンバーデータクラス {
    val メンバー種別: 会員メンバー種別一覧

    constructor(メンバー種別: 会員メンバー種別一覧, メンバー識別子: Int) : super(メンバー識別子) {
        this.メンバー種別 = メンバー種別
    }
}

/**
 *
 */
class 手続きグループメンバーデータクラス : グループメンバーデータクラス {
    val メンバー種別: 手続きメンバー種別一覧

    constructor(メンバー種別: 手続きメンバー種別一覧, メンバー識別子: Int) : super(メンバー識別子) {
        this.メンバー種別 = メンバー種別
    }
}

