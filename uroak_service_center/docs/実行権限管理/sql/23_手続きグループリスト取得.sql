SELECT
	tgkt.識別子							AS グループ識別子,
	tgkt.名称							AS グループ名称,
	tgkt.備考							AS グループ備考,
	tgmkt.識別子						AS メンバー識別子,
	tgmkt.メンバー種別					AS メンバー種別,
	CASE tgmkt.メンバー種別
		WHEN 1 THEN '手続き'
		WHEN 2 THEN '手続き目録'
		WHEN 3 THEN '手続きグループ'
		ELSE        '不明'
	END									AS メンバー種別名称,
	tgmkt.メンバーID					AS メンバー識別子,
	tkt.識別子							AS メンバー手続き識別子,
	tkt.名称							AS メンバー手続き名称,
	tkt.目録識別子						AS メンバー手続き親目録識別子,
	IF(tmkt_tkt.識別子 IS NULL,0,1)		AS メンバー手続き親目録存在フラグ,
	tmkt_tkt.名称						AS メンバー手続き親目録名称,
	tkt.備考							AS メンバー手続き備考,
	tmkt.識別子							AS メンバー目録識別子,
	tmkt.名称							AS メンバー目録名称,
	tmkt.親目録識別子					AS メンバー目録親目録識別子,
	IF(tmkt_tmkt.識別子 IS NULL,0,1)	AS メンバー目録親目録存在フラグ,
	tmkt_tmkt.名称						AS メンバー目録親目録名称,
	tmkt.備考							AS メンバー目録備考,
	tgkt2.識別子						AS メンバーグループ識別子,
	tgkt2.名称							AS メンバーグループ名称,
	tgkt2.備考							AS メンバーグループ備考,
	tgkt.登録日時						AS 登録日時,
	tgkt.更新日時						AS 更新日時
FROM
	手続きグループ管理テーブル AS tgkt
	LEFT OUTER JOIN 
	手続きグループメンバー管理テーブル AS tgmkt
		ON tgkt.識別子 = tgmkt.手続きグループ識別子
			AND tgmkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き管理テーブル AS tkt
		ON tgmkt.メンバー種別 = 1
			AND tgmkt.メンバーID = tkt.識別子
			AND tkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt_tkt
		ON tmkt_tkt.識別子 = tkt.目録識別子
			AND tmkt_tkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt
		ON tgmkt.メンバー種別 = 2
			AND tgmkt.メンバーID = tmkt.識別子
			AND tmkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt_tmkt
		ON tmkt_tmkt.識別子 = tmkt.親目録識別子
			AND tmkt_tmkt.削除済み = 0
	LEFT OUTER JOIN 
	手続きグループ管理テーブル AS tgkt2
		ON tgmkt.メンバー種別 = 3
			AND tgmkt.メンバーID = tgkt2.識別子
			AND tgkt2.削除済み = 0
WHERE
	tgkt.削除済み = 0
ORDER BY 
	tgkt.識別子,
	tgmkt.メンバー種別,
	IFNULL(tgmkt.メンバーID,0)
