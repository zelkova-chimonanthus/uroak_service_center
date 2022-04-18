SELECT
	jkt.会員識別子									AS 利用者会員識別子,
	IF(kkt.識別子 IS NULL,0,1)						AS 利用者会員存在フラグ,
	kkt.名称										AS 利用者会員名称,
	kkt.目録識別子									AS 利用者会員親目録識別子,
	IF(kmkt.識別子 IS NULL,0,1)						AS 利用者会員親目録存在フラグ,
	kmkt.名称										AS 利用者会員親目録名称,
	IF(syskgm.識別子 IS NULL,0,1)					AS 利用者会員システム管理者フラグ,
	IF(svckgm.識別子 IS NULL,0,1)					AS 利用者会員サービス管理者フラグ,
	kkt.備考										AS 利用者会員備考,
	jkt.手続き識別子								AS 対象手続き識別子,
	IF(tkt.識別子 IS NULL,0,1)						AS 対象手続き存在フラグ,
	tkt.名称										AS 対象手続き名称,
	tkt.処理種別									AS 対象手続き処理種別,
	tkt.目録識別子									AS 対象手続き親目録識別子,
	IF(tmkt.識別子 IS NULL,0,1)						AS 対象手続き親目録存在フラグ,
	tmkt.名称										AS 対象手続き親目録名称,
	tmkt.コントローラクラス識別子					AS 対象手続きコントローラデータ識別子,
	IF(tmkt.コントローラクラス識別子 IS NULL,0,1)	AS 対象手続きコントローラデータ存在フラグ,
	ckt.識別子										AS 対象手続きコントローラ識別子,
	ckt.名称										AS 対象手続きコントローラ名称,
	ckt.URLパス										AS 対象手続きコントローラURLパス,
	ckt.備考										AS 対象手続きコントローラ備考,
	tkt.手続きコード								AS 対象手続きコード,
	tkt.手続き補助コード							AS 対象手続き補助コード,
	tkt.手続き補助コード2							AS 対象手続き補助コード2,
	tkt.備考										AS 対象手続き備考,
	jkt.権限										AS 実行権限ビットセット,
	IF(jkt.権限 &  1 != 0,1,0)						AS 実行権限_読込,
	IF(jkt.権限 &  2 != 0,1,0)						AS 実行権限_登録,
	IF(jkt.権限 &  4 != 0,1,0)						AS 実行権限_更新_論理削除,
	IF(jkt.権限 &  8 != 0,1,0)						AS 実行権限_物理削除,
	IF(jkt.権限 & 16 != 0,1,0)						AS 実行権限_インポート,
	IF(jkt.権限 & 32 != 0,1,0)						AS 実行権限_エクスポート,
	jkt.登録日時									AS 実行権限データ登録日時,
	jkt.更新日時									AS 実行権限データ更新日時
FROM
	実行権限テーブル AS jkt
	LEFT OUTER JOIN 
	会員管理テーブル AS kkt
		ON jkt.会員識別子 = kkt.識別子
			AND kkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt
		ON kkt.目録識別子 = kmkt.識別子
			AND kmkt.削除済み = 0
	LEFT OUTER JOIN 
	システム管理者グループメンバー管理テーブル AS syskgm
		ON kkt.識別子 = syskgm.会員ID
			AND syskgm.削除済み = 0
	LEFT OUTER JOIN 
	サービス管理者グループメンバー管理テーブル AS svckgm
		ON kkt.識別子 = svckgm.会員ID
			AND svckgm.削除済み = 0
	LEFT OUTER JOIN 
	手続き管理テーブル AS tkt
		ON jkt.手続き識別子 = tkt.識別子
			AND tkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt
		ON tkt.目録識別子 = tmkt.識別子
			AND tmkt.削除済み = 0
	LEFT OUTER JOIN 
	コントローラ管理テーブル AS ckt
		ON tmkt.コントローラクラス識別子 = ckt.識別子
			AND ckt.削除済み = 0
ORDER BY 
	jkt.会員識別子,
	jkt.手続き識別子
