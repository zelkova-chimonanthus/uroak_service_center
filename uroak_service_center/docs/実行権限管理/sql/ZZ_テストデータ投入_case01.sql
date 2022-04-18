-- ************************************************************
-- 会員
-- ************************************************************
DELETE FROM 会員管理テーブル WHERE 登録者 = 100;
INSERT INTO 会員管理テーブル(識別子,識別トークン,目録識別子,名称,ログイン不可,備考,登録者,更新者) VALUES
(2000,'12bd92c031ea671739eb20a64f02137f',7,'テストユーザcase01',0,'テスト用ユーザ。',100,100)
;

-- ************************************************************
-- 会員グループ
-- ************************************************************
DELETE FROM 会員グループ管理テーブル WHERE 登録者 = 100;
INSERT INTO 会員グループ管理テーブル(識別子,名称,備考,登録者,更新者) VALUES
(1020,'テスト用グループcase01-1','読込、登録、更新。',100,100),
(1021,'テスト用グループcase01-2','エクスポート、読込。',100,100),
(1022,'テスト用グループcase01-3','読込。',100,100),
(1023,'テスト用グループcase01-4','読込。',100,100),
(1024,'テスト用グループcase01-5','読込、更新。',100,100)
;

-- ************************************************************
-- 会員グループメンバー
-- メンバー種別:メンバーの種類。1:会員、2:会員目録、3:会員グループ
-- ************************************************************
DELETE FROM 会員グループメンバー管理テーブル WHERE 登録者 = 100;
INSERT INTO 会員グループメンバー管理テーブル(識別子,会員グループ識別子,メンバー種別,メンバーID,登録者,更新者) VALUES
(2000,1020,2,5,100,100),
(2001,1021,2,5,100,100),
(2002,1022,2,5,100,100),
(2003,1023,2,7,100,100),
(2004,1024,1,2000,100,100)
;

-- ************************************************************
-- 手続きグループ
-- ************************************************************
DELETE FROM 手続きグループ管理テーブル WHERE 登録者 = 100;
INSERT INTO 手続きグループ管理テーブル(識別子,名称,備考,登録者,更新者) VALUES
(1020,'テスト用グループcase01-1','',100,100),
(1021,'テスト用グループcase01-2','',100,100)
;


-- ************************************************************
-- 手続きグループメンバー
-- ************************************************************
DELETE FROM 手続きグループメンバー管理テーブル WHERE 登録者 = 100;
INSERT INTO 手続きグループメンバー管理テーブル(識別子,手続きグループ識別子,メンバー種別,メンバーID,登録者,更新者) VALUES
(2000,1020,2,2,100,100),
(2001,1021,1,2005,100,100)
;

-- ************************************************************
-- 実行権限設定
-- 利用種別:1:会員、2:会員目録、3:会員グループ、4:管理者グループ（対象限定管理者グループに限る）
-- 利用対象種別:1:手続き、2:手続き目録、3:手続きグループ
-- 権限:各ビットの意味＞1:実行可能、2:読込、3:登録、4:更新（論理削除）、5:物理削除、6:インポート、7:エクスポート
-- ************************************************************
DELETE FROM 実行権限設定テーブル WHERE 登録者 = 100;
INSERT INTO 実行権限設定テーブル (識別子,利用者種別,利用者ID,利用対象種別,利用対象ID,権限,登録者,更新者) VALUES
(2000,3,1020,3,1020,15,100,100),
(2001,3,1021,3,1020,67,100,100),
(2002,3,1022,2,6,3,100,100),
(2003,3,1023,2,6,3,100,100),
(2004,3,1024,3,1021,11,100,100),
(2005,1,2000,1,2005,35,100,100)
;
