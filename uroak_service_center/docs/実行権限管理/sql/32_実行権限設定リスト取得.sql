SELECT
	-- =============================================================
	-- 利用者側
	-- =============================================================
	jkst.利用者種別										AS 利用者種別,
	CASE jkst.利用者種別
		WHEN 1 THEN '会員'
		WHEN 2 THEN '会員目録'
		WHEN 3 THEN '会員グループ'
		WHEN 4 THEN '管理者グループ'
		ELSE	'不明'
	END													AS 利用者種別名称,
	-- 利用者会員
	jkst.利用者ID										AS 利用者会員識別子,
	IF(kkt.識別子 IS NULL,0,1)							AS 利用者会員存在フラグ,
	kkt.名称											AS 利用者会員名称,
	kkt.目録識別子										AS 利用者会員親目録識別子,
	IF(kmkt_kkt.識別子 IS NULL,0,1)						AS 利用者会員親目録存在フラグ,
	kmkt_kkt.名称										AS 利用者会員親目録名称,
	IF(syskgm.識別子 IS NULL,0,1)						AS 利用者会員システム管理者フラグ,
	IF(svckgm.識別子 IS NULL,0,1)						AS 利用者会員サービス管理者フラグ,
	kkt.備考											AS 利用者会員備考,
	-- 利用者会員目録
	kmkt.識別子											AS 利用者会員目録識別子,
	kmkt.名称											AS 利用者会員目録名称,
	kmkt.親目録識別子									AS 利用者会員目録親目録識別子,
	IF(kmkt_kmkt.識別子 IS NULL,0,1)					AS 利用者会員目録親目録存在フラグ,
	kmkt_kmkt.名称										AS 利用者会員目録親目録名称,
	kmkt_kmkt.備考										AS 利用者会員目録親目録備考,
	kmkt.備考											AS 利用者会員目録備考,
	-- 利用者会員グループ
	kgkt.識別子											AS 利用者会員グループ識別子,
	kgkt.名称											AS 利用者会員グループ名称,
	kgkt.備考											AS 利用者会員グループ備考,
	-- 管理者グループ
	mgrkt.識別子										AS グループ識別子,
	mgrkt.名称											AS グループ名称,
	mgrkt.備考											AS グループ備考,
	-- =============================================================
	-- 手続き側
	-- =============================================================
	jkst.利用対象種別									AS 利用対象種別,
	CASE jkst.利用対象種別
		WHEN 1 THEN '手続き'
		WHEN 2 THEN '手続き目録'
		WHEN 3 THEN '手続きグループ'
		ELSE	'不明'
	END													AS 利用対象種別名称,
	-- 対象手続き
	jkst.利用対象ID										AS 対象手続き識別子,
	IF(tkt.識別子 IS NULL,0,1)							AS 対象手続き存在フラグ,
	tkt.名称											AS 対象手続き名称,
	tkt.処理種別										AS 対象手続き処理種別,
	tkt.目録識別子										AS 対象手続き親目録識別子,
	IF(tmkt.識別子 IS NULL,0,1)							AS 対象手続き親目録存在フラグ,
	tmkt.名称											AS 対象手続き親目録名称,
	tmkt.コントローラクラス識別子						AS 対象手続きコントローラデータ識別子,
	IF(tmkt.コントローラクラス識別子 IS NULL,0,1)		AS 対象手続きコントローラデータ存在フラグ,
	ckt_kkt_tmkt.識別子									AS 対象手続きコントローラ識別子,
	ckt_kkt_tmkt.名称									AS 対象手続きコントローラ名称,
	ckt_kkt_tmkt.URLパス								AS 対象手続きコントローラURLパス,
	ckt_kkt_tmkt.備考									AS 対象手続きコントローラ備考,
	tkt.手続きコード									AS 対象手続きコード,
	tkt.手続き補助コード								AS 対象手続き補助コード,
	tkt.手続き補助コード2								AS 対象手続き補助コード2,
	tkt.備考											AS 対象手続き備考,
	-- 対象手続き目録
	tmkt_tmkt.識別子									AS 対象手続き目録識別子,
	tmkt_tmkt.名称										AS 対象手続き目録名称,
	tmkt_tmkt.コントローラクラス識別子					AS 対象手続き目録コントローラデータ識別子,
	IF(tmkt_tmkt.コントローラクラス識別子 IS NULL,0,1)	AS 対象手続き目録コントローラデータ存在フラグ,
	ckt_tmkt.識別子										AS 対象手続き目録コントローラ識別子,
	ckt_tmkt.名称										AS 対象手続き目録コントローラ名称,
	ckt_tmkt.URLパス									AS 対象手続き目録コントローラURLパス,
	ckt_tmkt.DIコンポーネント名							AS 対象手続き目録コントローラDIコンポーネント名,
	ckt_tmkt.クラス名									AS 対象手続き目録コントローラクラス名,
	ckt_tmkt.クラスパッケージパス						AS 対象手続き目録コントローラクラスパッケージパス,
	ckt_tmkt.備考										AS 対象手続き目録コントローラ備考,
	tmkt_tmkt.親目録識別子								AS 対象手続き目録親目録識別子,
	IF(tmkt_tmkt2.識別子 IS NULL,0,1)					AS 対象手続き目録親目録存在フラグ,
	tmkt_tmkt2.名称										AS 対象手続き目録親目録名称,
	tmkt_tmkt2.備考										AS 対象手続き目録親目録備考,
	tmkt_tmkt.備考										AS 対象手続き目録備考,
	-- 対象手続きグループ
	tgkt.識別子											AS 対象手続きグループ識別子,
	tgkt.名称											AS 対象手続きグループ名称,
	tgkt.備考											AS 対象手続きグループ備考,
	-- =============================================================
	-- 実行権限
	-- =============================================================
	jkst.権限											AS 実行権限ビットセット,
	IF(jkst.権限 &  1 != 0,1,0)							AS 実行権限_読込,
	IF(jkst.権限 &  2 != 0,1,0)							AS 実行権限_登録,
	IF(jkst.権限 &  4 != 0,1,0)							AS 実行権限_更新_論理削除,
	IF(jkst.権限 &  8 != 0,1,0)							AS 実行権限_物理削除,
	IF(jkst.権限 & 16 != 0,1,0)							AS 実行権限_インポート,
	IF(jkst.権限 & 32 != 0,1,0)							AS 実行権限_エクスポート,
	-- =============================================================
	-- 登録・更新日時
	-- =============================================================
	jkst.登録日時										AS 実行権限データ登録日時,
	jkst.更新日時										AS 実行権限データ更新日時
FROM
	実行権限設定テーブル AS jkst
	-- =============================================================
	-- 利用者側
	-- =============================================================
	-- 利用者会員
	LEFT OUTER JOIN 
	会員管理テーブル AS kkt
		ON jkst.利用者種別 = 1
			AND jkst.利用者ID = kkt.識別子
			AND kkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt_kkt
		ON kkt.目録識別子 = kmkt_kkt.識別子
			AND kmkt_kkt.削除済み = 0
	LEFT OUTER JOIN 
	システム管理者グループメンバー管理テーブル AS syskgm
		ON kkt.識別子 = syskgm.会員ID
			AND syskgm.削除済み = 0
	LEFT OUTER JOIN 
	サービス管理者グループメンバー管理テーブル AS svckgm
		ON kkt.識別子 = svckgm.会員ID
			AND svckgm.削除済み = 0
	-- 利用者会員目録
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt
		ON jkst.利用者種別 = 2 
			AND jkst.利用者ID = kmkt.識別子
			AND kmkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt_kmkt
		ON kmkt.親目録識別子 = kmkt_kmkt.識別子
			AND kmkt_kmkt.削除済み = 0
	-- 利用者会員グループ
	LEFT OUTER JOIN 
	会員グループ管理テーブル AS kgkt
		ON jkst.利用者種別 = 3
			AND jkst.利用者ID = kgkt.識別子
			AND kgkt.削除済み = 0
	-- 管理者グループ
	LEFT OUTER JOIN 
	管理者グループ管理テーブル AS mgrkt
		ON jkst.利用者種別 = 4
			AND jkst.利用者ID = mgrkt.識別子
			AND mgrkt.削除済み = 0
	-- =============================================================
	-- 手続き側
	-- =============================================================
	-- 対象手続き
	LEFT OUTER JOIN 
	手続き管理テーブル AS tkt
		ON jkst.利用対象種別 = 1
			AND jkst.利用対象ID = tkt.識別子
			AND tkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt
		ON tkt.目録識別子 = tmkt.識別子
			AND tmkt.削除済み = 0
	LEFT OUTER JOIN 
	コントローラ管理テーブル AS ckt_kkt_tmkt
		ON tmkt.コントローラクラス識別子 = ckt_kkt_tmkt.識別子
			AND ckt_kkt_tmkt.削除済み = 0
	-- 対象手続き目録
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt_tmkt
		ON jkst.利用対象種別 = 2
			AND jkst.利用対象ID = tmkt_tmkt.識別子
			AND tmkt_tmkt.削除済み = 0
	LEFT OUTER JOIN 
	コントローラ管理テーブル AS ckt_tmkt
		ON tmkt_tmkt.コントローラクラス識別子 = ckt_tmkt.識別子
			AND ckt_tmkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt_tmkt2
		ON tmkt_tmkt.親目録識別子 = tmkt_tmkt2.識別子
			AND tmkt_tmkt2.削除済み = 0
	-- 対象手続きグループ
	LEFT OUTER JOIN 
	手続きグループ管理テーブル AS tgkt
		ON jkst.利用対象種別 = 3
			AND jkst.利用対象ID = tgkt.識別子
			AND tgkt.削除済み = 0
WHERE
	jkst.削除済み = 0
ORDER BY 
	jkst.利用者種別,
	jkst.利用者ID,
	jkst.利用対象種別,
	jkst.利用対象ID
