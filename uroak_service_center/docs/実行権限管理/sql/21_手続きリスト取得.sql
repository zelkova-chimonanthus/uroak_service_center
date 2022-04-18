SELECT
	tkt.識別子										AS 手続き識別子,
	tkt.名称										AS 手続き名称,
	tkt.処理種別									AS 手続き処理種別,
	tkt.目録識別子									AS 親目録識別子,
	IF(tmkt.識別子 IS NULL,0,1)						AS 親目録存在フラグ,
	tmkt.名称										AS 親目録名称,
	tmkt.コントローラクラス識別子					AS コントローラデータ識別子,
	IF(tmkt.コントローラクラス識別子 IS NULL,0,1)	AS コントローラデータ存在フラグ,
	ckt.識別子										AS コントローラ識別子,
	ckt.名称										AS コントローラ名称,
	ckt.URLパス										AS コントローラURLパス,
	ckt.DIコンポーネント名							AS コントローラDIコンポーネント名,
	ckt.クラス名									AS コントローラクラス名,
	ckt.クラスパッケージパス						AS コントローラクラスパッケージパス,
	ckt.備考										AS コントローラ備考,
	tkt.手続きコード								AS 手続きコード,
	tkt.手続き補助コード							AS 手続き補助コード,
	tkt.手続き補助コード2							AS 手続き補助コード2,
	tkt.備考										AS 手続き備考,
	tkt.登録日時									AS 登録日時,
	tkt.更新日時									AS 更新日時
FROM
	手続き管理テーブル AS tkt
	LEFT OUTER JOIN 
	手続き目録管理テーブル AS tmkt
		ON tkt.目録識別子 = tmkt.識別子
			AND tmkt.削除済み = 0
	LEFT OUTER JOIN 
	コントローラ管理テーブル AS ckt
		ON tmkt.コントローラクラス識別子 = ckt.識別子
			AND ckt.削除済み = 0
WHERE
	tkt.削除済み = 0
ORDER BY 
	tmkt.識別子,
	tkt.識別子

