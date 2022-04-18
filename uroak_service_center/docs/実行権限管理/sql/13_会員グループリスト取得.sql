SELECT
	kgkt.識別子							AS グループ識別子,
	kgkt.名称							AS グループ名称,
	kgkt.備考							AS グループ備考,
	kgmkt.識別子						AS メンバー識別子,
	kgmkt.メンバー種別					AS メンバー種別,
	CASE kgmkt.メンバー種別
		WHEN 1 THEN '会員'
		WHEN 2 THEN '会員目録'
		WHEN 3 THEN '会員グループ'
		ELSE        '不明'
	END									AS メンバー種別名称,
	kgmkt.メンバーID					AS メンバー識別子,
	kkt.識別子							AS メンバー会員識別子,
	kkt.名称							AS メンバー会員名称,
	kkt.識別トークン					AS メンバー会員識別トークン,
	kkt.目録識別子						AS メンバー会員親目録識別子,
	IF(kmkt_kkt.識別子 IS NULL,0,1)		AS メンバー会員親目録存在フラグ,
	kmkt_kkt.名称						AS メンバー会員親目録名称,
	kkt.備考							AS メンバー会員備考,
	kmkt.識別子							AS メンバー目録識別子,
	kmkt.名称							AS メンバー目録名称,
	kmkt.親目録識別子					AS メンバー目録親目録識別子,
	IF(kmkt_kmkt.識別子 IS NULL,0,1)	AS メンバー目録親目録存在フラグ,
	kmkt_kmkt.名称						AS メンバー目録親目録名称,
	kmkt.備考							AS メンバー目録備考,
	kgkt2.識別子						AS メンバーグループ識別子,
	kgkt2.名称							AS メンバーグループ名称,
	kgkt2.備考							AS メンバーグループ備考,
	kgkt.登録日時						AS 登録日時,
	kgkt.更新日時						AS 更新日時
FROM
	会員グループ管理テーブル AS kgkt
	LEFT OUTER JOIN 
	会員グループメンバー管理テーブル AS kgmkt
		ON kgkt.識別子 = kgmkt.会員グループ識別子
			AND kgmkt.削除済み = 0
	LEFT OUTER JOIN 
	会員管理テーブル AS kkt
		ON kgmkt.メンバー種別 = 1
			AND kgmkt.メンバーID = kkt.識別子
			AND kkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt_kkt
		ON kmkt_kkt.識別子 = kkt.目録識別子
			AND kmkt_kkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt
		ON kgmkt.メンバー種別 = 2
			AND kgmkt.メンバーID = kmkt.識別子
			AND kmkt.削除済み = 0
	LEFT OUTER JOIN 
	会員目録管理テーブル AS kmkt_kmkt
		ON kmkt_kmkt.識別子 = kmkt.親目録識別子
			AND kmkt_kmkt.削除済み = 0
	LEFT OUTER JOIN 
	会員グループ管理テーブル AS kgkt2
		ON kgmkt.メンバー種別 = 3
			AND kgmkt.メンバーID = kgkt2.識別子
			AND kgkt2.削除済み = 0
WHERE
	kgkt.削除済み = 0
ORDER BY 
	kgkt.識別子,
	kgmkt.メンバー種別,
	IFNULL(kgmkt.メンバーID,0)
