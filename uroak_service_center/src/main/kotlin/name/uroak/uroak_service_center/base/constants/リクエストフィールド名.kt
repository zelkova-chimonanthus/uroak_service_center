package name.uroak.uroak_service_center.base.constants

import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名定数クラス

object リクエストフィールド名 {
    /**フィールド名: process_mode, 実行モード*/
    val モード = JSONフィールド名定数クラス("process_mode", "実行モード")

    /**フィールド名: table_unit, 対象テーブル構成種別*/
    val 対象テーブル構成種別 = JSONフィールド名定数クラス("table_unit", "対象テーブル構成種別")

    /**フィールド名: category, 処理種別*/
    val 処理種別 = JSONフィールド名定数クラス("category", "処理種別")

    /**フィールド名: response_language, 返信言語*/
    val 返信言語 = JSONフィールド名定数クラス("response_language", "返信言語")

    /**フィールド名: parameter_data,パラメータデータ*/
    val パラメータデータ = JSONフィールド名定数クラス("parameter_data", "パラメータデータ")

    /**フィールド名: %tbl*/
    const val 単一テーブル_対象テーブル名 = "%tbl"

    /**フィールド名: %tcnd*/
    const val 単一テーブル_条件一覧 = "%tcnd"

    /**フィールド名: %tcmp*/
    const val 単一テーブル_比較演算子 = "%tcmp"

    /**フィールド名: %tslc*/
    const val 単一テーブル_返却項目一覧 = "%tslc"

    /**フィールド名: %tclm*/
    const val 単一テーブル_返却カラム = "%tclm"

    /**フィールド名: %tsrt*/
    const val 単一テーブル_ソート指定一覧 = "%tsrt"

    /**フィールド名: %tgrp*/
    const val 単一テーブル_グルーピング指定一覧 = "%tgrp"

    /**フィールド名: %thvg*/
    const val 単一テーブル_グルーピング結果条件指定一覧 = "%thvg"

    /**フィールド名: %tinp*/
    const val 単一テーブル_登録更新項目一覧 = "%tinp"

    /**フィールド名: %tcsv*/
    const val 単一テーブル_CSV = "%tcsv"

    /**フィールド名: %tfmt*/
    const val 単一テーブル_CSV_形式 = "%tfmt"

    /**フィールド名: %tdata*/
    const val 単一テーブル_CSV_データ = "%tdata"

    /**フィールド名: %cnd*/
    const val 条件一覧 = "%cnd"

    /**フィールド名: %inp*/
    const val 登録更新項目一覧 = "%inp"

    /**フィールド名: %csv*/
    const val CSV = "%csv"

    /**フィールド名: %fmt*/
    const val CSV_形式 = "%fmt"

    /**フィールド名: %data*/
    const val CSV_データ = "%data"}