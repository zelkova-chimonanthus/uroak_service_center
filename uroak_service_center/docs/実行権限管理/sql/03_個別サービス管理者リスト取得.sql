SELECT
	kgkt.識別子					AS グループ識別子,
	kgkt.名称					AS グループ名称,
	kgkt.備考					AS グループ備考,
	kgmkt.識別子				AS メンバー識別子,
	kgmkt.会員ID				AS 会員識別子,
	kkt.名称					AS 会員名称,
	kkt.備考					AS 会員備考,
	kkt.識別トークン			AS 会員識別トークン,
	kkt.目録識別子				AS 会員親目録識別子,
	IF(kmkt.識別子 IS NULL,0,1)	AS 親目録存在フラグ,
	kmkt.名称					AS 会員親目録名称,
	kmkt.備考					AS 会員親目録備考,
	kgkt.登録日時				AS 登録日時,
	kgkt.更新日時				AS 更新日時
FROM
	管理者グループ管理テーブル AS kgkt
	LEFT OUTER JOIN 
	管理者グループメンバー管理テーブル AS kgmkt
		ON kgkt.識別子 = kgmkt.管理者グループ識別子
			AND kgmkt.削除済み = 0
	LEFT OUTER JOIN 
	会員管理テーブル AS kkt
		ON kkt.識別子 = kgmkt.会員ID
			AND kkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt
		ON kkt.目録識別子 = kmkt.識別子
			AND kmkt.削除済み = 0
WHERE
	kgkt.削除済み = 0
ORDER BY 
	kgkt.識別子,
	kgmkt.識別子
