SELECT
	kmkt.識別子							AS 目録識別子,
	kmkt.名称							AS 目録名称,
	kmkt.親目録識別子					AS 親目録識別子,
	IF(kmkt2.識別子 IS NULL,0,1)		AS 親目録存在フラグ,
	kmkt2.名称							AS 親目録名称,
	kmkt2.備考							AS 親目録備考,
	kmkt.備考							AS 目録備考,
	IFNULL(kkt_children.登録会員数,0)	AS 登録会員数,
	IFNULL(kmkt_children.登録目録数,0)	AS 登録目録数,
	IFNULL(kkt_children.登録会員数,0)
	 + IFNULL(kmkt_children.登録目録数,0)	AS 全登録数,
	kmkt.登録日時						AS 登録日時,
	kmkt.更新日時						AS 更新日時
FROM
	会員目録管理テーブル AS kmkt
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt2
		ON kmkt.親目録識別子 = kmkt2.識別子
			AND kmkt2.削除済み = 0
	LEFT OUTER JOIN 
	(
		SELECT
			kkt_child.目録識別子,
			COUNT(*)	AS 登録会員数
		FROM
			会員管理テーブル AS kkt_child
		WHERE
			kkt_child.削除済み = 0
		GROUP BY 
			kkt_child.目録識別子
	) AS kkt_children
		ON kkt_children.目録識別子 = kmkt.識別子
	LEFT OUTER JOIN 
	(
		SELECT
			kmkt_child.親目録識別子,
			COUNT(*)	AS 登録目録数
		FROM
			会員目録管理テーブル AS kmkt_child
		WHERE
			kmkt_child.削除済み = 0
		GROUP BY 
			kmkt_child.親目録識別子
	) AS kmkt_children
		ON kmkt_children.親目録識別子 = kmkt.識別子
WHERE
	kmkt.削除済み = 0
