SELECT
	tmkt.識別子										AS 目録識別子,
	tmkt.名称										AS 目録名称,
	tmkt.コントローラクラス識別子					AS コントローラデータ識別子,
	IF(tmkt.コントローラクラス識別子 IS NULL,0,1)	AS コントローラデータ存在フラグ,
	ckt.識別子										AS コントローラ識別子,
	ckt.名称										AS コントローラ名称,
	ckt.URLパス										AS コントローラURLパス,
	ckt.DIコンポーネント名							AS コントローラDIコンポーネント名,
	ckt.クラス名									AS コントローラクラス名,
	ckt.クラスパッケージパス						AS コントローラクラスパッケージパス,
	ckt.備考										AS コントローラ備考,
	tmkt.親目録識別子								AS 親目録識別子,
	IF(tmkt2.識別子 IS NULL,0,1)					AS 親目録存在フラグ,
	tmkt2.名称										AS 親目録名称,
	tmkt2.備考										AS 親目録備考,
	tmkt.備考										AS 目録備考,
	IFNULL(tkt_children.登録手続き数,0)				AS 登録手続き数,
	IFNULL(tmkt_children.登録目録数,0)				AS 登録目録数,
	IFNULL(tkt_children.登録手続き数,0)
	 + IFNULL(tmkt_children.登録目録数,0)			AS 全登録数,
	tmkt.登録日時									AS 登録日時,
	tmkt.更新日時									AS 更新日時
FROM
	手続き目録管理テーブル AS tmkt
	LEFT OUTER JOIN 
	コントローラ管理テーブル AS ckt
		ON tmkt.コントローラクラス識別子 = ckt.識別子
			AND ckt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt2
		ON tmkt.親目録識別子 = tmkt2.識別子
			AND tmkt2.削除済み = 0
	LEFT OUTER JOIN 
	(
		SELECT
			tkt_child.目録識別子,
			COUNT(*)	AS 登録手続き数
		FROM
			手続き管理テーブル AS tkt_child
		WHERE
			tkt_child.削除済み = 0
		GROUP BY 
			tkt_child.目録識別子
	) AS tkt_children
		ON tkt_children.目録識別子 = tmkt.識別子
	LEFT OUTER JOIN 
	(
		SELECT
			tmkt_child.親目録識別子,
			COUNT(*)	AS 登録目録数
		FROM
			手続き目録管理テーブル AS tmkt_child
		WHERE
			tmkt_child.削除済み = 0
		GROUP BY 
			tmkt_child.親目録識別子
	) AS tmkt_children
		ON tmkt_children.親目録識別子 = tmkt.識別子
WHERE
	tmkt.削除済み = 0

