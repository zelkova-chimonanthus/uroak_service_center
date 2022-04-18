SELECT
	kkt.識別子						AS 会員識別子,
	kkt.識別トークン				AS 会員識別トークン,
	kkt.名称						AS 会員名称,
	kkt.目録識別子					AS 親目録識別子,
	IF(kmkt.識別子 IS NULL,0,1)		AS 親目録存在フラグ,
	kmkt.名称						AS 親目録名称,
	IF(syskgm.識別子 IS NULL,0,1)	AS システム管理者フラグ,
	IF(svckgm.識別子 IS NULL,0,1)	AS サービス管理者フラグ,
	kkt.備考						AS 会員備考,
	kkt.登録日時					AS 登録日時,
	kkt.更新日時					AS 更新日時
FROM
	会員管理テーブル AS kkt
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
WHERE
	kkt.削除済み = 0
ORDER BY 
	IFNULL(kkt.目録識別子,0)
