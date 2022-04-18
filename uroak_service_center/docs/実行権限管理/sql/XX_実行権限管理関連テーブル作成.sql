-- Project Name : 実行権限
-- Date/Time    : 2022/02/19 17:52:15
-- Author       : uchida
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- コントローラ管理テーブル
DROP TABLE if exists `コントローラ管理テーブル` CASCADE;

CREATE TABLE `コントローラ管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `URLパス` VARCHAR(50) NOT NULL COMMENT 'URLパス:手続きをアクセスする際のURLに付与するパス。'
  , `DIコンポーネント名` VARCHAR(100) NOT NULL COMMENT 'DIコンポーネント名:コントローラオブジェクトのDIコンポーネントとしての名称。'
  , `クラス名` VARCHAR(100) COMMENT 'クラス名:コントローラクラスのクラス名。'
  , `クラスパッケージパス` VARCHAR(300) COMMENT 'クラスパッケージパス:コントローラクラスのパッケージ。'
  , `使用中止` BIT(1) DEFAULT 0 NOT NULL COMMENT '使用中止:一時的に使用中止にする場合に1にしておく'
  , `システム管理用` BIT(1) DEFAULT 0 NOT NULL COMMENT 'システム管理用:システム管理手続き用のコントローラかどうかを示す'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `コントローラ管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT 'コントローラ管理テーブル:コントローラクラスを管理する。' ;

CREATE UNIQUE INDEX `idx_URLパス`
  ON `コントローラ管理テーブル`(`URLパス`);

ALTER TABLE `コントローラ管理テーブル` ADD UNIQUE `idx_DIコンポーネント名` (`DIコンポーネント名`) ;

-- サービス管理者グループメンバー管理テーブル
DROP TABLE if exists `サービス管理者グループメンバー管理テーブル` CASCADE;

CREATE TABLE `サービス管理者グループメンバー管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `会員ID` INT NOT NULL COMMENT '会員ID'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `サービス管理者グループメンバー管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT 'サービス管理者グループメンバー管理テーブル:システム管理手続き（権限管理関連など）以外の全ての手続きを実行できる会員のグループ。' ;

CREATE UNIQUE INDEX `idx_メンバー`
  ON `サービス管理者グループメンバー管理テーブル`(`会員ID`);

-- システム管理者グループメンバー管理テーブル
DROP TABLE if exists `システム管理者グループメンバー管理テーブル` CASCADE;

CREATE TABLE `システム管理者グループメンバー管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `会員ID` INT NOT NULL COMMENT '会員ID'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `システム管理者グループメンバー管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT 'システム管理者グループメンバー管理テーブル' ;

CREATE UNIQUE INDEX `idx_メンバー`
  ON `システム管理者グループメンバー管理テーブル`(`会員ID`);

-- ユーザ認証テーブル
DROP TABLE if exists `ユーザ認証テーブル` CASCADE;

CREATE TABLE `ユーザ認証テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `利用者名` VARCHAR(200) NOT NULL COMMENT '利用者名'
  , `利用者パスワード` VARCHAR(200) NOT NULL COMMENT '利用者パスワード'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `ユーザ認証テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT 'ユーザ認証テーブル:HTTPヘッダーに設定されている利用者認証情報が有効なものかどうかをチェックするためのテーブル。' ;

CREATE UNIQUE INDEX `idx_利用者名`
  ON `ユーザ認証テーブル`(`利用者名`);

-- ユーザ＿会員変換テーブル
DROP TABLE if exists `ユーザ＿会員変換テーブル` CASCADE;

CREATE TABLE `ユーザ＿会員変換テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `システム種別` VARCHAR(100) NOT NULL COMMENT 'システム種別:どのシステムのユーザかを表す種別名。'
  , `ユーザID` VARCHAR(100) NOT NULL COMMENT 'ユーザID'
  , `パスワード` VARCHAR(100) NOT NULL COMMENT 'パスワード'
  , `認証用利用者名` VARCHAR(200) NOT NULL COMMENT '認証用利用者名'
  , `認証用パスワード` VARCHAR(200) NOT NULL COMMENT '認証用パスワード'
  , `認証キー` VARCHAR(500) NOT NULL COMMENT '認証キー'
  , `会員識別トークン` VARCHAR(100) NOT NULL COMMENT '会員識別トークン:サービス会員を識別するトークン文字列。'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT NOT NULL COMMENT '登録者:0'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT NOT NULL COMMENT '更新者:0'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `ユーザ＿会員変換テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT 'ユーザ＿会員変換テーブル:サービスAPIにアクセスしようとするユーザのIDから、サービスAPIにアクセス可能なセンター会員識別文字列に変換するためのテーブル。' ;

CREATE UNIQUE INDEX `idx_ユーザ`
  ON `ユーザ＿会員変換テーブル`(`システム種別`,`ユーザID`);

-- 会員グループメンバー管理テーブル
DROP TABLE if exists `会員グループメンバー管理テーブル` CASCADE;

CREATE TABLE `会員グループメンバー管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `会員グループ識別子` INT NOT NULL COMMENT '会員グループ識別子'
  , `メンバーID` INT NOT NULL COMMENT 'メンバーID'
  , `メンバー種別` TINYINT NOT NULL COMMENT 'メンバー種別:メンバーの種類。1:会員、2:会員目録、3:会員グループ'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `会員グループメンバー管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '会員グループメンバー管理テーブル' ;

CREATE UNIQUE INDEX `idx_メンバー`
  ON `会員グループメンバー管理テーブル`(`会員グループ識別子`,`メンバー種別`,`メンバーID`);

-- 会員グループ管理テーブル
DROP TABLE if exists `会員グループ管理テーブル` CASCADE;

CREATE TABLE `会員グループ管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `会員グループ管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '会員グループ管理テーブル' ;

-- 会員目録管理テーブル
DROP TABLE if exists `会員目録管理テーブル` CASCADE;

CREATE TABLE `会員目録管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `親目録識別子` INT COMMENT '親目録識別子:この目録が所属する親目録の識別子。親目録がない場合（ルート目録の場合）はNULL。'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `会員目録管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '会員目録管理テーブル:Uroakサービスセンター会員の目録を管理する。目録は階層化可能である。' ;

-- 会員管理テーブル
DROP TABLE if exists `会員管理テーブル` CASCADE;

CREATE TABLE `会員管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `識別トークン` VARCHAR(300) NOT NULL COMMENT '識別トークン'
  , `目録識別子` INT COMMENT '目録識別子:目録は必須ではない。'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `ログイン不可` BIT(1) DEFAULT 0 NOT NULL COMMENT 'ログイン不可:ログイン不可とするユーザ。ログイン不可なのでいかなる手続きも実行できない。直接データ投入時のデータ登録者、データ更新者用の会員などを想定している。'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `会員管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '会員管理テーブル' ;

CREATE UNIQUE INDEX `idx_トークン`
  ON `会員管理テーブル`(`識別トークン`);

CREATE UNIQUE INDEX `idx_名称`
  ON `会員管理テーブル`(`名称`);

-- 実行権限テーブル
DROP TABLE if exists `実行権限テーブル` CASCADE;

CREATE TABLE `実行権限テーブル` (
  `会員識別子` INT NOT NULL COMMENT '会員識別子'
  , `手続き識別子` INT NOT NULL COMMENT '手続き識別子'
  , `権限` BIT(8) NOT NULL COMMENT '権限'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , CONSTRAINT `実行権限テーブル_PKC` PRIMARY KEY (`会員識別子`,`手続き識別子`)
) COMMENT '実行権限テーブル:実行権限の設定データをもとに各会員の手続き実行権限を保持する。常に設定されている実行権限データ全てが反映されているとは限らない。実行時に、設定データから反映される場合もあり得る。このテーブルに直接設定してはいけない。必ず、設定データから導出した権限データをセットする。' ;

-- 実行権限設定テーブル
DROP TABLE if exists `実行権限設定テーブル` CASCADE;

CREATE TABLE `実行権限設定テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `利用者ID` INT NOT NULL COMMENT '利用者ID'
  , `利用者種別` TINYINT NOT NULL COMMENT '利用者種別:1:会員、2:会員目録、3:会員グループ、4:管理者グループ（対象限定管理者グループに限る）'
  , `利用対象ID` INT NOT NULL COMMENT '利用対象ID'
  , `利用対象種別` TINYINT NOT NULL COMMENT '利用対象種別:1:手続き、2:手続き目録、3:手続きグループ'
  , `権限` BIT(8) NOT NULL COMMENT '権限:各ビットの意味＞1:読込、2:登録、3:更新（論理削除）、4:物理削除、5:インポート、6:エクスポート'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `実行権限設定テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '実行権限設定テーブル' ;

CREATE UNIQUE INDEX `idx_利用者利用対象`
  ON `実行権限設定テーブル`(`利用者種別`,`利用者ID`,`利用対象種別`,`利用対象ID`);

-- 手続きグループメンバー管理テーブル
DROP TABLE if exists `手続きグループメンバー管理テーブル` CASCADE;

CREATE TABLE `手続きグループメンバー管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `手続きグループ識別子` INT NOT NULL COMMENT '手続きグループ識別子'
  , `メンバーID` INT NOT NULL COMMENT 'メンバーID'
  , `メンバー種別` TINYINT NOT NULL COMMENT 'メンバー種別:メンバーの種類。1:手続き、2:手続き目録、3:手続きグループ'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `手続きグループメンバー管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '手続きグループメンバー管理テーブル' ;

CREATE UNIQUE INDEX `idx_メンバー`
  ON `手続きグループメンバー管理テーブル`(`手続きグループ識別子`,`メンバー種別`,`メンバーID`);

-- 手続きグループ管理テーブル
DROP TABLE if exists `手続きグループ管理テーブル` CASCADE;

CREATE TABLE `手続きグループ管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `手続きグループ管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '手続きグループ管理テーブル' ;

-- 手続き目録管理テーブル
DROP TABLE if exists `手続き目録管理テーブル` CASCADE;

CREATE TABLE `手続き目録管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `親目録識別子` INT COMMENT '親目録識別子:この目録が所属する親目録の識別子。親目録がない場合（ルート目録の場合）はNULL。'
  , `コントローラクラス識別子` INT COMMENT 'コントローラクラス識別子:対応するコントローラクラスのデータ。コントローラクラスと対応していない場合はNULL。'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `手続き目録管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '手続き目録管理テーブル:手続きの目録。目録は階層化可能である。' ;

-- 手続き管理テーブル
DROP TABLE if exists `手続き管理テーブル` CASCADE;

CREATE TABLE `手続き管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `手続きコード` VARCHAR(50) NOT NULL COMMENT '手続きコード:アクセスする際にURLに付与する文字列。'
  , `手続き補助コード` VARCHAR(50) DEFAULT '' NOT NULL COMMENT '手続き補助コード:アクセスする際にURLに付与する文字列。'
  , `手続き補助コード2` VARCHAR(50) DEFAULT '' NOT NULL COMMENT '手続き補助コード2:アクセスする際にURLに付与する文字列。'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称:手続きの名称。'
  , `目録識別子` INT COMMENT '目録識別子:手続きが所属する目録。この目録は、通常は、手続きが実装されているコントローラクラスに対応する。通常とは異なる実装に対応するため、必須とはしていない。'
  , `処理種別` TINYINT NOT NULL COMMENT '処理種別:1:検索、2:登録、3:更新、4:登録・更新、5:論理削除、6:物理削除、7:インポート、8:エクスポート、9:その他（DB操作なし）'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `手続き管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '手続き管理テーブル' ;

CREATE UNIQUE INDEX `idx_手続き識別データ`
  ON `手続き管理テーブル`(`目録識別子`,`手続きコード`,`手続き補助コード`,`手続き補助コード2`);

-- 管理者グループメンバー管理テーブル
DROP TABLE if exists `管理者グループメンバー管理テーブル` CASCADE;

CREATE TABLE `管理者グループメンバー管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `管理者グループ識別子` INT NOT NULL COMMENT '管理者グループ識別子'
  , `会員ID` INT NOT NULL COMMENT '会員ID'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `管理者グループメンバー管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '管理者グループメンバー管理テーブル' ;

CREATE UNIQUE INDEX `idx_メンバー`
  ON `管理者グループメンバー管理テーブル`(`管理者グループ識別子`,`会員ID`);

-- 管理者グループ管理テーブル
DROP TABLE if exists `管理者グループ管理テーブル` CASCADE;

CREATE TABLE `管理者グループ管理テーブル` (
  `識別子` INT NOT NULL AUTO_INCREMENT COMMENT '識別子'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `管理者グループ管理テーブル_PKC` PRIMARY KEY (`識別子`)
) COMMENT '管理者グループ管理テーブル' ;

