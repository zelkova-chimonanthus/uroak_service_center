package name.uroak.uroak_service_center.shared.constants.message

/**
 * ## メッセージのIDの一覧
 * 下記のように採番する。
 *
 * ※　NNNNは4桁の整数連番。
 *
 * ※　d：デバグ、i：情報、w：警告、e：エラー
 *
 * ※　左：列挙定数名、右：メッセージID
 * 　
 * ### 汎用的なメッセージ
 * * CMN_D_NNNN　：　cmn.d.NNNN
 * * CMN_I_NNNN　：　cmn.i.NNNN
 * * CMN_W_NNNN　：　cmn.w.NNNN
 * * CMN_E_NNNN　：　cmn.e.NNNN
 * ### 基盤処理メッセージ
 * * BAS_D_NNNN　：　bas.d.NNNN
 * * BAS_I_NNNN　：　bas.i.NNNN
 * * BAS_W_NNNN　：　bas.w.NNNN
 * * BAS_E_NNNN　：　bas.e.NNNN
 * ### データベースメッセージ
 * * DBS_D_NNNN　：　dbs.d.NNNN
 * * DBS_I_NNNN　：　dbs.i.NNNN
 * * DBS_W_NNNN　：　dbs.w.NNNN
 * * DBS_E_NNNN　：　dbs.e.NNNN
 * ### JSON変換メッセージ
 * * JSN_D_NNNN　：　jsn.d.NNNN
 * * JSN_I_NNNN　：　jsn.i.NNNN
 * * JSN_W_NNNN　：　jsn.w.NNNN
 * * JSN_E_NNNN　：　jsn.e.NNNN
 * ### 入力メッセージ
 * * INP_D_NNNN　：　inp.d.NNNN
 * * INP_I_NNNN　：　inp.i.NNNN
 * * INP_W_NNNN　：　inp.w.NNNN
 * * INP_E_NNNN　：　inp.e.NNNN
 * ### 共通処理メッセージ
 * * SHR_D_NNNN　：　shr.d.NNNN
 * * SHR_I_NNNN　：　shr.i.NNNN
 * * SHR_W_NNNN　：　shr.w.NNNN
 * * SHR_E_NNNN　：　shr.e.NNNN
 * ### アプリケーションメッセージ
 * * APP_D_NNNN　：　app.d.NNNN
 * * APP_I_NNNN　：　app.i.NNNN
 * * APP_W_NNNN　：　app.w.NNNN
 * * APP_E_NNNN　：　app.e.NNNN
 * ### ロト・ナンバーズ管理
 * * APPLOT_D_NNNN　：　applot.d.NNNN
 * * APPLOT_I_NNNN　：　applot.i.NNNN
 * * APPLOT_W_NNNN　：　applot.w.NNNN
 * * APPLOT_E_NNNN　：　applot.e.NNNN
 * ### 株取引管理
 * * APPSTK_D_NNNN　：　appstk.d.NNNN
 * * APPSTK_I_NNNN　：　appstk.i.NNNN
 * * APPSTK_W_NNNN　：　appstk.w.NNNN
 * * APPSTK_E_NNNN　：　appstk.e.NNNN
 * ### 実行権限管理
 * * APPPRM_D_NNNN　：　appprm.d.NNNN
 * * APPPRM_I_NNNN　：　appprm.i.NNNN
 * * APPPRM_W_NNNN　：　appprm.w.NNNN
 * * APPPRM_E_NNNN　：　appprm.e.NNNN
 * ### システム状態管理
 * * APPSTS_D_NNNN　：　appsts.d.NNNN
 * * APPSTS_I_NNNN　：　appsts.i.NNNN
 * * APPSTS_W_NNNN　：　appsts.w.NNNN
 * * APPSTS_E_NNNN　：　appsts.e.NNNN
 */
enum class メッセージID一覧 {
// =============================================
// 汎用的なメッセージ
// =============================================
    /**システムエラーが発生しました。*/
    CMN_E_0001("cmn.e.0001"),

    /**システムエラーが発生しました。詳細：{0}*/
    CMN_E_0002("cmn.e.0002"),

// =============================================
// 基盤処理メッセージ
// =============================================
    /**指定されたパスに対応するコントローラが見つかりません。パス：{0}*/
    BAS_E_0001("bas.e.0001"),

    /**指定されたパスに対応するコントローラデータが見つかりましたが、インスタンスが未設定です。パス：{0}*/
    BAS_E_0002("bas.e.0002"),

    /**手続きメソッドの戻り値の型が仕様と違います。実際の型：{0}*/
    BAS_E_0003("bas.e.0003"),

    /**手続きメソッドのパラメータの数が１つではありません。実際のパラメータ数：{0}*/
    BAS_E_0004("bas.e.0004"),

    /**手続きメソッドのパラメータの型が仕様と違います。実際の型：{0}*/
    BAS_E_0005("bas.e.0005"),

    /**手続きメソッドが仕様と違います。メソッド：{0}*/
    BAS_E_0006("bas.e.0006"),

    /**指定された手続きメソッドが見つかりません。手続きコード：{0}、手続き補助コード：{1}、手続き補助コード2：{2}*/
    BAS_E_0007("bas.e.0007"),

    /**bas.e.0008=パラメータに会員識別トークンがありません。JSONフィールド名：{0}*/
    BAS_E_0008("bas.e.0008"),

    /**bas.e.0009=パラメータにモードデータがありません。JSONフィールド名：{0}*/
    BAS_E_0009("bas.e.0009"),

    /**bas.e.0010=パラメータに対象テーブル構成種別がありません。JSONフィールド名：{0}*/
    BAS_E_0010("bas.e.0010"),

    /**bas.e.0011=パラメータに処理種別がありません。JSONフィールド名：{0}*/
    BAS_E_0011("bas.e.0011"),

    /**bas.e.0012=１つの条件カラム指定に比較演算子が2つ以上あります。JSONフィールド名：{0}*/
    BAS_E_0012("bas.e.0012"),

    /**bas.e.0013=１つの条件カラム指定にカラム名が2つ以上あります。JSONフィールド名：{0}*/
    BAS_E_0013("bas.e.0013"),

    /**bas.e.0014=無効な集合関数が指定されています。JSONフィールド名：{0}、指定された文字列：{1}*/
    BAS_E_0014("bas.e.0014"),

    /**bas.e.0015=無効な比較演算子が指定されています。JSONフィールド名：{0}、指定された文字列：{1}*/
    BAS_E_0015("bas.e.0015"),

    /**bas.e.0016=無効なソート種別が指定されています。JSONフィールド名：{0}、指定された文字列：{1}*/
    BAS_E_0016("bas.e.0016"),

    /**bas.e.0017=パラメータに返却項目の指定がありません。JSONフィールド名：{0}*/
    BAS_E_0017("bas.e.0017"),

    /**bas.e.0018=パラメータに、カラム名の指定のないソート項目があります。JSONフィールド名：{0}*/
    BAS_E_0018("bas.e.0018"),

    /**bas.e.0019=パラメータに、カラム名の指定が２つ以上あるソート項目があります。JSONフィールド名：{0}*/
    BAS_E_0019("bas.e.0019"),

    /**bas.e.0020=パラメータに、カラム名の指定のない条件指定があります。JSONフィールド名：{0}*/
    BAS_E_0020("bas.e.0020"),

    /**bas.e.0021=パラメータに登録更新項目の指定がありません。JSONフィールド名：{0}*/
    BAS_E_0021("bas.e.0021"),

    /**bas.e.0026=手続き実行前の処理でエラーがありました。*/
    BAS_E_0026("bas.e.0026"),

    /**bas.e.0027=手続き実行後の処理でエラーがありました。*/
    BAS_E_0027("bas.e.0027"),

    /**bas.e.0028=手続き処理でエラーがありました。*/
    BAS_E_0028("bas.e.0028"),

    /**bas.e.0029=API認証でエラーがありました。*/
    BAS_E_0029("bas.e.0029"),

    /**bas.e.0030=API認証でエラーが発生しています。詳細情報＞＞　{0}*/
    BAS_E_0030("bas.e.0030"),

    /**bas.e.0031=トランザクション種別が「不明」のままになっています。コントローラ名：{0}、手続きコード：{1}、手続き補助コード：{2}、手続き補助コード2：{3}*/
    BAS_E_0031("bas.e.0031"),

    /**bas.e.0032=対象テーブル構成種別が不明になっています。*/
    BAS_E_0032("bas.e.0032"),

    /**bas.e.0033=無効なCSVデータ形式が指定されています。JSONフィールド名：{0}、指定された文字列：{1}*/
    BAS_E_0033("bas.e.0033"),

    /**bas.e.0034=指定された手続きメソッドを実装しているサービスクラスがありません。手続きコード：{0}、手続き補助コード：{1}、手続き補助コード2：{2}*/
    BAS_E_0034("bas.e.0034"),

    /**bas.e.0035=パラメータにパラメータデータがありません。JSONフィールド名：{0}*/
    BAS_E_0035("bas.e.0035"),

    /**bas.e.0036=パラメータで指定された対象テーブル構成種別の値が空か誤っています。JSONフィールド名：{0}、値：{1}*/
    BAS_E_0036("bas.e.0036"),

    /**bas.e.0037=パラメータで指定された処理種別の値が空か誤っています。JSONフィールド名：{0}、値：{1}*/
    BAS_E_0037("bas.e.0037"),

    /**bas.e.0038=パラメータで指定された返信言語の値が空か誤っています。JSONフィールド名：{0}、値：{1}*/
    BAS_E_0038("bas.e.0038"),

    /**bas.e.0040=対象手続きを実行する権限がなかったので処理を中止します。*/
    BAS_E_0040("bas.e.0040"),


// =============================================
// データベースメッセージ
// =============================================

// =============================================
// JSON変換メッセージ
// =============================================
    /** オブジェクトをJSON文字列に変換する際にエラーが発生しました。オブジェクトのクラス：{0} */
    JSN_E_0001("jsn.e.0001"),

    /** JSON文字列をオブジェクトに変換する際にエラーが発生しました。オブジェクトのクラス：{0} */
    JSN_E_0002("jsn.e.0002"),

// =============================================
// 入力メッセージ
// =============================================

// =============================================
// 共通処理メッセージ
// =============================================
    /**指定されたマップに、指定されたキー名の値がありません。キー名：{0}*/
    SHR_E_0001("shr.e.0001"),

    /**指定されたマップに、指定されたキー名で登録されている値が整数型ではありません。キー名：{0}、対象値の型：{1}*/
    SHR_E_0002("shr.e.0002"),

    /**指定されたマップに、指定されたキー名で登録されている値が文字列型ではありません。キー名：{0}、対象値の型：{1}*/
    SHR_E_0003("shr.e.0003"),

    /**指定されたマップに、指定されたキー名で登録されている値がマップ型ではありません。キー名：{0}、対象値の型：{1}*/
    SHR_E_0004("shr.e.0004"),

    /**文字列値を指定の書式でDateに変換するのに失敗しました。文字列値：{0}、書式：{1}*/
    SHR_E_0005("shr.e.0005"),

    /**文字列値を指定の書式でLongに変換するのに失敗しました。文字列値：{0}、書式：{1}*/
    SHR_E_0006("shr.e.0006"),

    /**文字列値を指定の書式でDoubleに変換するのに失敗しました。文字列値：{0}、書式：{1}*/
    SHR_E_0007("shr.e.0007"),

    /**文字列値を指定の書式でBigDecimalに変換するのに失敗しました。文字列値：{0}、書式：{1}*/
    SHR_E_0008("shr.e.0008"),

    /**Intに変換できない型です。型名：{0}*/
    SHR_E_0009("shr.e.0009"),

    /**Longに変換できない型です。型名：{0}*/
    SHR_E_0010("shr.e.0010"),

    /**BigDecimalに変換できない型です。型名：{0}*/
    SHR_E_0011("shr.e.0011"),

    /**UtilDateに変換できない型です。型名：{0}*/
    SHR_E_0012("shr.e.0012"),

    /**SqlDateに変換できない型です。型名：{0}*/
    SHR_E_0013("shr.e.0013"),

    /**SqlTimeに変換できない型です。型名：{0}*/
    SHR_E_0014("shr.e.0014"),

    /**Timestampに変換できない型です。型名：{0}*/
    SHR_E_0015("shr.e.0015"),

    /**LocalDateに変換できない型です。型名：{0}*/
    SHR_E_0016("shr.e.0016"),

    /**LocalTimeに変換できない型です。型名：{0}*/
    SHR_E_0017("shr.e.0017"),

    /**LocalDateTimeに変換できない型です。型名：{0}*/
    SHR_E_0018("shr.e.0018"),

    /**shr.e.0019=登録・更新処理の処理済みレコードのキー値をセットする際、キー値の数が不足していません。本来のキー数：{0}、セットするキー数：{1}*/
    SHR_E_0019("shr.e.0019"),

    /**shr.e.0020=ログ出力の際にエラー情報もメッセージIDも渡されていません。*/
    SHR_E_0020("shr.e.0020"),

    /**shr.e.0021=指定されたマップに、指定されたキー名で登録されている値が、想定されたタイプではありません。キー名：{0}、対象値の型：{1}、想定された型：{2}*/
    SHR_E_0021("shr.e.0021"),

    /**shr.e.0022=複数定数値にアクセスする際、定数配列のインデックスを超過してアクセスしようとしました。定数個数：{0}、アクセスしたインデックス：{1}*/
    SHR_E_0022("shr.e.0022"),

    /**shr.e.0023=複数定数値に定数が設定されていません。*/
    SHR_E_0023("shr.e.0023"),

// =============================================
// アプリケーションメッセージ
// =============================================

// =============================================
// ロト・ナンバーズ管理
// =============================================

// =============================================
// 株取引管理
// =============================================

// =============================================
// 実行権限管理
// =============================================
    /**appprm.e.0001=目録に所属グループを追加しようとしましたが、対象の目録は、グループのメンバーとして登録されていません。グループ識別子：{0}、目録識別子：{1}*/
    APPPRM_E_0001("appprm.e.0001"),

    /**appprm.e.0022=アクセスしたパスに該当する手続きが手続き管理テーブルに登録されていません。手続きコード:{0}、手続き補助コード:{1}、手続き補助コード2:{2}*/
    APPPRM_E_0022("appprm.e.0022"),

    /**appprm.e.0023=アクセスしたパスに該当する手続きが手続き管理テーブル複数登録されてます。手続きコード:{0}、手続き補助コード:{1}、手続き補助コード2:{2}*/
    APPPRM_E_0023("appprm.e.0023"),

    /**appprm.e.0024=指定された識別トークンに該当する会員が会員管理テーブルに登録されていません。識別トークン:{0}*/
    APPPRM_E_0024("appprm.e.0024"),

    /**appprm.e.0025=指定された識別トークンに該当する会員が会員管理テーブルに複数登録されています。識別トークン:{0}*/
    APPPRM_E_0025("appprm.e.0025"),

    /**appprm.e.0039=手続きの実行権限がありません。利用者：{0}、手続き：{1}*/
    APPPRM_E_0039("appprm.e.0039"),

    /**appprm.e.0041=会員情報の収集でエラーが発生しました。*/
    APPPRM_E_0041("appprm.e.0041"),

    /**appprm.e.0042=手続き情報の収集でエラーが発生しました。*/
    APPPRM_E_0042("appprm.e.0042"),

    /**appprm.e.0043=コントローラ情報の収集でエラーが発生しました。*/
    APPPRM_E_0043("appprm.e.0043"),

    /**appprm.e.0044=ログイン不可のユーザが手続きを実行しようとしました。*/
    APPPRM_E_0044("appprm.e.0044"),

    /**appprm.e.0045=コントローラが使用中止になっているので対象手続きは実行できません。*/
    APPPRM_E_0045("appprm.e.0045"),

    /**appprm.e.0046=システム管理用手続きはシステム管理者以外は実行できません。*/
    APPPRM_E_0046("appprm.e.0046"),

    /**appprm.e.0047=指定された会員と手続きの間の実行権限データが複数登録されています。会員識別子：{0}、手続き識別子：{1}*/
    APPPRM_E_0047("appprm.e.0047"),

    /**appprm.e.0048=実行権限データの権限属性が足りません。手続きの処理種別：{0}、権限属性：{1}*/
    APPPRM_E_0048("appprm.e.0048"),

    /**appprm.e.0049=会員と手続きの間で登録されている実行権限設定データが複数あります。会員識別子：{0}、手続き識別子：{1}*/
    APPPRM_E_0049("appprm.e.0049"),

    /**appprm.e.0050=実行権限の利用者側と利用対象側が同一の実行権限設定データが２つ以上ありました。実行権限設定データID：{0}*/
    APPPRM_E_0050("appprm.e.0050"),

    /**appprm.e.0051=指定された手続きの親目録にコントローラ識別子が未設定、あるいは設定されたコントローラ識別子が無効です。手続きコード:{0}、手続き補助コード:{1}、手続き補助コード2:{2}*/
    APPPRM_E_0051("appprm.e.0051"),

// =============================================
// システム状態管理
// =============================================

// =============================================
// その他
// =============================================
    /***/
    INVALID("invalid-message-id");

    val ID文字列: String

    /**
     *
     */
    constructor(ID文字列: String) {
        this.ID文字列 = ID文字列
    }


}