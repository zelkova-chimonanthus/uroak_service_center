SELECT
	ckt.識別子										AS コントローラ識別子,
	ckt.名称										AS コントローラ名称,
	ckt.URLパス										AS コントローラURLパス,
	ckt.DIコンポーネント名							AS コントローラDIコンポーネント名,
	ckt.クラス名									AS コントローラクラス名,
	ckt.クラスパッケージパス						AS コントローラクラスパッケージパス,
	ckt.備考										AS コントローラ備考,
	IF(tmkt.識別子 IS NULL,0,1)						AS 対応目録存在フラグ,
	tmkt.識別子										AS 対応目録識別子,
	tmkt.名称										AS 対応目録名称,
	tmkt.親目録識別子								AS 対応目録親目録識別子,
	IF(tmkt2.識別子 IS NULL,0,1)					AS 対応目録親目録存在フラグ,
	tmkt2.名称										AS 対応目録親目録名称,
	tmkt2.備考										AS 対応目録親目録備考,
	tmkt.備考										AS 対応目録備考,
	ckt.登録日時									AS 登録日時,
	ckt.更新日時									AS 更新日時
FROM
	コントローラ管理テーブル AS ckt
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt
		ON tmkt.コントローラクラス識別子 = ckt.識別子
			AND tmkt.削除済み = 0
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt2
		ON tmkt.親目録識別子 = tmkt2.識別子
			AND tmkt2.削除済み = 0
WHERE
	ckt.削除済み = 0
ORDER BY
	ckt.識別子
