-- ************************************************************
-- 会員
-- ************************************************************
DELETE FROM 会員管理テーブル WHERE 登録者 = 500;
INSERT INTO 会員管理テーブル(識別子,識別トークン,目録識別子,名称,ログイン不可,備考,登録者,更新者) VALUES
(5001,'d0e31d1d91331f20bed4f4eed0a3f4f9',5001,'テスト会員p1',0,'',500,500),
(5002,'d987c34b0238acb983826224d54f285a',5002,'テスト会員p2',0,'',500,500),
(5003,'748a6ee538fec95217bc3fa79edd6227',5003,'テスト会員p3',0,'',500,500),
(5004,'34172f75de3a511c5f30bb61a3b46963',5004,'テスト会員p4',0,'',500,500)
;

-- ************************************************************
-- 会員目録
-- ************************************************************
DELETE FROM 会員目録管理テーブル WHERE 登録者 = 500;
INSERT INTO 会員目録管理テーブル(識別子,名称,親目録識別子,備考,登録者,更新者) VALUES
(5001,'テスト目録p1',null,'',500,500),
(5002,'テスト目録p2',null,'',500,500),
(5003,'テスト目録p3',null,'',500,500),
(5004,'テスト目録p4',null,'',500,500)
;


-- ************************************************************
-- 会員グループ
-- ************************************************************
DELETE FROM 会員グループ管理テーブル WHERE 登録者 = 500;
INSERT INTO 会員グループ管理テーブル(識別子,名称,備考,登録者,更新者) VALUES
(5001,'会員グループp3_1','',500,500),
(5002,'会員グループp3_2','',500,500),
(5003,'会員グループp3_3','',500,500),
(5004,'会員グループp4_1','',500,500),
(5005,'会員グループp4_2','',500,500),
(5006,'会員グループp4_3','',500,500),
(5007,'会員グループp3_1_目録','',500,500),
(5008,'会員グループp3_2_目録','',500,500),
(5009,'会員グループp3_3_目録','',500,500),
(5010,'会員グループp4_1_目録','',500,500),
(5011,'会員グループp4_2_目録','',500,500),
(5012,'会員グループp4_3_目録','',500,500)
;

-- ************************************************************
-- 会員グループメンバー
-- メンバー種別:メンバーの種類。1:会員、2:会員目録、3:会員グループ
-- ************************************************************
DELETE FROM 会員グループメンバー管理テーブル WHERE 登録者 = 500;
INSERT INTO 会員グループメンバー管理テーブル(識別子,会員グループ識別子,メンバー種別,メンバーID,登録者,更新者) VALUES
(5001,5001,1,5003,500,500),
(5002,5001,2,5003,500,500),
(5003,5002,1,5003,500,500),
(5004,5002,2,5003,500,500),
(5005,5003,1,5003,500,500),
(5006,5003,2,5003,500,500),
(5007,5004,1,5004,500,500),
(5008,5004,2,5004,500,500),
(5009,5005,1,5004,500,500),
(5010,5005,2,5004,500,500),
(5011,5006,1,5004,500,500),
(5012,5006,2,5004,500,500),
(5013,5007,1,5003,500,500),
(5014,5007,2,5003,500,500),
(5015,5008,1,5003,500,500),
(5016,5008,2,5003,500,500),
(5017,5009,1,5003,500,500),
(5018,5009,2,5003,500,500),
(5019,5010,1,5004,500,500),
(5020,5010,2,5004,500,500),
(5021,5011,1,5004,500,500),
(5022,5011,2,5004,500,500),
(5023,5012,1,5004,500,500),
(5024,5012,2,5004,500,500)
;

-- ************************************************************
-- 手続き
-- 処理種別:1:検索、2:登録、3:更新、4:登録・更新、5:論理削除、6:物理削除、7:インポート、8:エクスポート、9:その他（DB操作なし）
-- ************************************************************
DELETE FROM 手続き管理テーブル WHERE 登録者 = 500;
INSERT INTO 手続き管理テーブル(識別子,手続きコード,手続き補助コード,手続き補助コード2,名称,目録識別子,処理種別,備考,登録者,更新者) VALUES
(5001,'case03','pattern1','','テスト手続きp1',5002,1,'',500,500),
(5002,'case03','pattern2','','テスト手続きp2',5004,1,'',500,500),
(5003,'case03','pattern3','','テスト手続きp3',5006,1,'',500,500),
(5004,'case03','pattern4','','テスト手続きp4',5008,1,'',500,500)
;

-- ************************************************************
-- 手続き目録
-- ************************************************************
DELETE FROM 手続き目録管理テーブル WHERE 登録者 = 500;
INSERT INTO 手続き目録管理テーブル(識別子,名称,親目録識別子,コントローラクラス識別子,備考,登録者,更新者) VALUES
(5001,'テスト目録p1_1',null,null,'',500,500),
(5002,'テスト目録p1_2',5001,5000,'',500,500),
(5003,'テスト目録p2_1',null,null,'',500,500),
(5004,'テスト目録p2_2',5003,5000,'',500,500),
(5005,'テスト目録p3_1',null,null,'',500,500),
(5006,'テスト目録p3_2',5005,5000,'',500,500),
(5007,'テスト目録p4_1',null,null,'',500,500),
(5008,'テスト目録p4_2',5007,5000,'',500,500)
;

-- ************************************************************
-- コントローラ
-- ************************************************************
DELETE FROM コントローラ管理テーブル WHERE 登録者 = 500;
INSERT INTO コントローラ管理テーブル(識別子,名称,URLパス,DIコンポーネント名,クラスパッケージパス,クラス名,使用中止,システム管理用,備考,登録者,更新者) VALUES 
(5000,'実行テストcase03','uc_test_case03','テスト用コントローラcase03','name.uroak.uroak_service_center.test.controllers','テスト用コントローラcase03クラス',0,0,'',500,500)
;

-- ************************************************************
-- 手続きグループ
-- ************************************************************
DELETE FROM 手続きグループ管理テーブル WHERE 登録者 = 500;
INSERT INTO 手続きグループ管理テーブル(識別子,名称,備考,登録者,更新者) VALUES
(5001,'手続きグループp2_1','',500,500),
(5002,'手続きグループp2_2','',500,500),
(5003,'手続きグループp2_3','',500,500),
(5004,'手続きグループp4_1','',500,500),
(5005,'手続きグループp4_2','',500,500),
(5006,'手続きグループp4_3','',500,500)
;


-- ************************************************************
-- 手続きグループメンバー
-- ************************************************************
DELETE FROM 手続きグループメンバー管理テーブル WHERE 登録者 = 500;
INSERT INTO 手続きグループメンバー管理テーブル(識別子,手続きグループ識別子,メンバー種別,メンバーID,登録者,更新者) VALUES
(5001,5001,2,5003,500,500),
(5002,5002,1,5002,500,500),
(5003,5002,2,5003,500,500),
(5004,5002,2,5004,500,500),
(5005,5003,1,5002,500,500),
(5006,5003,2,5003,500,500),
(5007,5004,2,5007,500,500),
(5008,5005,1,5004,500,500),
(5009,5005,2,5007,500,500),
(5010,5005,2,5008,500,500),
(5011,5006,1,5004,500,500),
(5012,5006,2,5007,500,500)
;

-- ************************************************************
-- 実行権限設定
-- 利用種別:1:会員、2:会員目録、3:会員グループ、4:管理者グループ（対象限定管理者グループに限る）
-- 利用対象種別:1:手続き、2:手続き目録、3:手続きグループ
-- 権限:各ビットの意味＞1:実行可能、2:読込、3:登録、4:更新（論理削除）、5:物理削除、6:インポート、7:エクスポート
-- ************************************************************
DELETE FROM 実行権限設定テーブル WHERE 登録者 = 500;
INSERT INTO 実行権限設定テーブル (識別子,利用者種別,利用者ID,利用対象種別,利用対象ID,権限,登録者,更新者) VALUES
(5001,1,5001,2,5001,3,500,500),
(5002,1,5001,2,5002,5,500,500),
(5003,1,5001,1,5001,9,500,500),
(5004,2,5001,2,5001,17,500,500),
(5005,2,5001,2,5002,33,500,500),
(5006,2,5001,1,5001,65,500,500),
(5007,1,5002,3,5001,3,500,500),
(5008,1,5002,3,5002,5,500,500),
(5009,1,5002,3,5003,9,500,500),
(5010,2,5002,3,5001,17,500,500),
(5011,2,5002,3,5002,33,500,500),
(5012,2,5002,3,5003,65,500,500),
(5013,3,5001,2,5005,3,500,500),
(5014,3,5001,1,5003,5,500,500),
(5015,3,5002,2,5006,9,500,500),
(5016,3,5002,1,5003,17,500,500),
(5017,3,5003,2,5005,33,500,500),
(5018,3,5003,1,5003,65,500,500),
(5019,3,5007,2,5005,3,500,500),
(5020,3,5007,1,5003,5,500,500),
(5021,3,5008,2,5006,9,500,500),
(5022,3,5008,1,5003,17,500,500),
(5023,3,5009,2,5005,33,500,500),
(5024,3,5009,1,5003,65,500,500),
(5025,3,5004,3,5004,3,500,500),
(5026,3,5004,3,5005,5,500,500),
(5027,3,5005,3,5005,9,500,500),
(5028,3,5005,3,5006,17,500,500),
(5029,3,5006,3,5004,33,500,500),
(5030,3,5006,3,5006,65,500,500),
(5031,3,5010,3,5004,3,500,500),
(5032,3,5010,3,5005,5,500,500),
(5033,3,5011,3,5005,9,500,500),
(5034,3,5011,3,5006,17,500,500),
(5035,3,5012,3,5004,33,500,500),
(5036,3,5012,3,5006,65,500,500)
;
