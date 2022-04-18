-- Project Name : 株取引管理
-- Date/Time    : 2022/02/08 21:57:04
-- Author       : uchida
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

-- 入出金履歴
DROP TABLE if exists `入出金履歴` CASCADE;

CREATE TABLE `入出金履歴` (
  `登録連番` INT NOT NULL AUTO_INCREMENT COMMENT '登録連番'
  , `入出金日` DATETIME NOT NULL COMMENT '入出金日'
  , `金額` DECIMAL(10,0) NOT NULL COMMENT '金額'
  , `入出金種別` TINYINT NOT NULL COMMENT '入出金種別:1:入金、2:出金'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `入出金履歴_PKC` PRIMARY KEY (`登録連番`)
) COMMENT '入出金履歴' ;

-- 六大州マスタ
DROP TABLE if exists `六大州マスタ` CASCADE;

CREATE TABLE `六大州マスタ` (
  `コード` CHAR(1) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(10) NOT NULL COMMENT '名称'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `六大州マスタ_PKC` PRIMARY KEY (`コード`)
) COMMENT '六大州マスタ:アジア、ヨーロッパ、アフリカ、北アメリカ、南アメリカ、オセアニア' ;

-- 国の地域マスタ
DROP TABLE if exists `国の地域マスタ` CASCADE;

CREATE TABLE `国の地域マスタ` (
  `コード` CHAR(2) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(50) NOT NULL COMMENT '名称'
  , `六大州コード` CHAR(1) NOT NULL COMMENT '六大州コード'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `国の地域マスタ_PKC` PRIMARY KEY (`コード`)
) COMMENT '国の地域マスタ:世界の国々を地域別に分類する際に使用する地域の一覧。' ;

-- 国マスタ
DROP TABLE if exists `国マスタ` CASCADE;

CREATE TABLE `国マスタ` (
  `コード＿数字3桁` CHAR(3) NOT NULL COMMENT 'コード＿数字3桁:ISO 3166-1 numeric'
  , `コード＿英字3文字` CHAR(3) COMMENT 'コード＿英字3文字:ISO 3166-1 alpha-3'
  , `コード＿英字2文字` CHAR(2) COMMENT 'コード＿英字2文字:ISO 3166-1 alpha-2'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `正式名称` VARCHAR(100) COMMENT '正式名称'
  , `名称＿英語` VARCHAR(100) COMMENT '名称＿英語'
  , `正式名称＿英語` VARCHAR(100) COMMENT '正式名称＿英語'
  , `地域コード` CHAR(2) COMMENT '地域コード'
  , `首都名称` VARCHAR(100) COMMENT '首都名称'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `国マスタ_PKC` PRIMARY KEY (`コード＿数字3桁`)
) COMMENT '国マスタ:国情報を管理する。ISO 3166-1 numeric: 数字3桁コード。' ;

CREATE UNIQUE INDEX idx_alpha3
  ON `国マスタ`(`コード＿英字3文字`);

CREATE UNIQUE INDEX idx_alpha2
  ON `国マスタ`(`コード＿英字2文字`);

-- 地方マスタ
DROP TABLE if exists `地方マスタ` CASCADE;

CREATE TABLE `地方マスタ` (
  `コード` CHAR(1) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(20) NOT NULL COMMENT '名称'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `地方マスタ_PKC` PRIMARY KEY (`コード`)
) COMMENT '地方マスタ:国内の地方。北海道、東北、関東、中部、関西、中国、四国、九州・沖縄' ;

-- 日本標準産業分類細分類
DROP TABLE if exists `日本標準産業分類細分類` CASCADE;

CREATE TABLE `日本標準産業分類細分類` (
  `コード` CHAR(4) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `小分類コード` CHAR(3) NOT NULL COMMENT '小分類コード'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `日本標準産業分類細分類_PKC` PRIMARY KEY (`コード`)
) COMMENT '日本標準産業分類細分類:日本標準産業分類とは、日本の公的統計における産業分類を定めた総務省告示であり、統計調査の結果を産業別に表示する場合の統計基準。' ;

-- 証券市場マスタ
DROP TABLE if exists `証券市場マスタ` CASCADE;

CREATE TABLE `証券市場マスタ` (
  `識別番号` INT NOT NULL AUTO_INCREMENT COMMENT '識別番号'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称:国内市場の場合は、日本取引所グループではなく、個々の市場を登録する。'
  , `略称` VARCHAR(20) NOT NULL COMMENT '略称'
  , `所在地＿国籍` CHAR(3) COMMENT '所在地＿国籍'
  , `所在地＿都市` VARCHAR(50) COMMENT '所在地＿都市'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `証券市場マスタ_PKC` PRIMARY KEY (`識別番号`)
) COMMENT '証券市場マスタ' ;

-- 都道府県マスタ
DROP TABLE if exists `都道府県マスタ` CASCADE;

CREATE TABLE `都道府県マスタ` (
  `コード` CHAR(2) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(10) NOT NULL COMMENT '名称'
  , `地方コード` CHAR(1) NOT NULL COMMENT '地方コード'
  , `都道府県庁所在地` VARCHAR(20) COMMENT '都道府県庁所在地'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `都道府県マスタ_PKC` PRIMARY KEY (`コード`)
) COMMENT '都道府県マスタ:都道府県。コードは、 ISO 3166-2:JP、あるいは全国地方公共団体コードの先頭2桁。' ;

-- 銘柄業種マスタ
DROP TABLE if exists `銘柄業種マスタ` CASCADE;

CREATE TABLE `銘柄業種マスタ` (
  `コード` CHAR(4) NOT NULL COMMENT 'コード'
  , `大分類名称` VARCHAR(20) NOT NULL COMMENT '大分類名称'
  , `中分類名称` VARCHAR(50) NOT NULL COMMENT '中分類名称'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `銘柄業種マスタ_PKC` PRIMARY KEY (`コード`)
) COMMENT '銘柄業種マスタ:証券コード協議会における業種' ;

-- 日本標準産業分類小分類
DROP TABLE if exists `日本標準産業分類小分類` CASCADE;

CREATE TABLE `日本標準産業分類小分類` (
  `コード` CHAR(3) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `中分類コード` CHAR(2) NOT NULL COMMENT '中分類コード'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `日本標準産業分類小分類_PKC` PRIMARY KEY (`コード`)
) COMMENT '日本標準産業分類小分類:日本標準産業分類とは、日本の公的統計における産業分類を定めた総務省告示であり、統計調査の結果を産業別に表示する場合の統計基準。' ;

-- 日本標準産業分類中分類
DROP TABLE if exists `日本標準産業分類中分類` CASCADE;

CREATE TABLE `日本標準産業分類中分類` (
  `コード` CHAR(2) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(100) NOT NULL COMMENT '名称'
  , `大分類コード` CHAR(1) NOT NULL COMMENT '大分類コード'
  , `備考` TEXT COMMENT '備考'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `日本標準産業分類中分類_PKC` PRIMARY KEY (`コード`)
) COMMENT '日本標準産業分類中分類:日本標準産業分類とは、日本の公的統計における産業分類を定めた総務省告示であり、統計調査の結果を産業別に表示する場合の統計基準。' ;

-- 日本標準産業分類大分類
DROP TABLE if exists `日本標準産業分類大分類` CASCADE;

CREATE TABLE `日本標準産業分類大分類` (
  `コード` CHAR(1) NOT NULL COMMENT 'コード'
  , `名称` VARCHAR(50) NOT NULL COMMENT '名称'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `日本標準産業分類大分類_PKC` PRIMARY KEY (`コード`)
) COMMENT '日本標準産業分類大分類:日本標準産業分類とは、日本の公的統計における産業分類を定めた総務省告示であり、統計調査の結果を産業別に表示する場合の統計基準。' ;

-- 銘柄マスタ
DROP TABLE if exists `銘柄マスタ` CASCADE;

CREATE TABLE `銘柄マスタ` (
  `登録番号` INT NOT NULL AUTO_INCREMENT COMMENT '登録番号:銘柄を一意に識別する番号。'
  , `銘柄コード` VARCHAR(4) COMMENT '銘柄コード:4桁の整数。国内株のみ設定する。将来、英字が含まれる可能性あり。上場廃止企業の銘柄コードの再利用はないので重複はない。'
  , `ISINコード` VARCHAR(12) COMMENT 'ISINコード:ISINコード（ISO-6166）。外国株の場合は必須。外国株の場合は、それぞれの国でISINコードの規則に従って割り振られる。'
  , `証券コード` VARCHAR(9) COMMENT '証券コード:日本証券コード協会が割り振るコード。新証券コードとも呼ばれる。国内株の場合はISINコードの3桁目以降の9桁、外国株の場合は日本証券コード協会が独自に割り振る。'
  , `銘柄名称` TEXT NOT NULL COMMENT '銘柄名称:証券会社で使用されている名称'
  , `日本標準産業分類＿大分類` CHAR(1) COMMENT '日本標準産業分類＿大分類:日本標準産業分類の大分類（1文字の英字）'
  , `日本標準産業分類＿中分類` CHAR(2) COMMENT '日本標準産業分類＿中分類:日本標準産業分類の中分類（2桁の数字）'
  , `業種コード` CHAR(4) COMMENT '業種コード:証券コード協議会における業種コード（4桁の数字）'
  , `企業名` TEXT COMMENT '企業名:企業の正式名称。外国株の場合は、現地の言葉での名称。'
  , `企業名＿通称` VARCHAR(70) COMMENT '企業名＿通称:企業の通称。外国株の場合は、現地の言葉での名称。'
  , `本社所在地＿国籍コード` CHAR(3) COMMENT '本社所在地＿国籍コード:企業の国籍（ISO 3166-1の国コード［3桁の数字］で指定する）。外資企業の場合は海外市場の場合は海外での国籍、日本国内の市場の場合は日本国籍として扱う。'
  , `本社所在地＿都道府県コード` CHAR(2) COMMENT '本社所在地＿都道府県コード:企業の本社が存在する都道府県（都道府県コードで指定する）。'
  , `本社所在地＿市区町村` VARCHAR(50) COMMENT '本社所在地＿市区町村:企業の本社が存在する市区町村（特別区、あるいは市町村）の名称。特別区以外の区は「本社所在地＿住所」に含める。'
  , `本社所在地＿住所` VARCHAR(100) COMMENT '本社所在地＿住所:企業の本社が存在する行政区、町名、番地など。但し、建物は含めない。'
  , `本社所在地＿建物` VARCHAR(100) COMMENT '本社所在地＿建物:ビルの特定のフロアのみを占有する場合は、ビル名とフロアを登録する。'
  , `本社所在地` TEXT COMMENT '本社所在地:本社所在地の住所を現地の言葉、現地の書き方で記述する。国内の場合は未設定も可。'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `銘柄マスタ_PKC` PRIMARY KEY (`登録番号`)
) COMMENT '銘柄マスタ:銘柄の情報を管理する。' ;

CREATE UNIQUE INDEX `idx_銘柄コード `
  ON `銘柄マスタ`(`銘柄コード`);

CREATE UNIQUE INDEX `idx_ISINコード `
  ON `銘柄マスタ`(`ISINコード`);

CREATE UNIQUE INDEX `idx_証券コード `
  ON `銘柄マスタ`(`証券コード`);

-- 取引履歴
DROP TABLE if exists `取引履歴` CASCADE;

CREATE TABLE `取引履歴` (
  `登録連番` INT NOT NULL AUTO_INCREMENT COMMENT '登録連番'
  , `受渡日` DATETIME COMMENT '受渡日'
  , `約定日` DATETIME COMMENT '約定日'
  , `銘柄コード` CHAR(4) COMMENT '銘柄コード'
  , `口座区分` CHAR(2) COMMENT '口座区分'
  , `預り区分` CHAR(2) COMMENT '預り区分'
  , `市場コード` INT COMMENT '市場コード'
  , `売買区分` CHAR(1) COMMENT '売買区分'
  , `商品区分` CHAR(2) COMMENT '商品区分'
  , `取引区分` CHAR(2) COMMENT '取引区分'
  , `約定数量` DECIMAL(7,0) COMMENT '約定数量'
  , `約定単価` DECIMAL(7,1) COMMENT '約定単価'
  , `約定代金` DECIMAL(10,0) COMMENT '約定代金'
  , `手数料＿税込` DECIMAL(6,0) COMMENT '手数料＿税込'
  , `受渡金額` DECIMAL(10,0) COMMENT '受渡金額'
  , `建市場` INT COMMENT '建市場'
  , `建日` DATETIME COMMENT '建日'
  , `建単価` DECIMAL(7,1) COMMENT '建単価'
  , `建手数料＿税込` DECIMAL(6,0) COMMENT '建手数料＿税込'
  , `管理費＿税込` DECIMAL(7,0) COMMENT '管理費＿税込'
  , `支払利息` DECIMAL(7,0) COMMENT '支払利息'
  , `受取利息` DECIMAL(7,0) COMMENT '受取利息'
  , `名義書換料＿税込` DECIMAL(7,0) COMMENT '名義書換料＿税込'
  , `実現損益` DECIMAL(10,0) COMMENT '実現損益'
  , `税引前金額` DECIMAL(10,0) COMMENT '税引前金額'
  , `所得税` DECIMAL(10,0) COMMENT '所得税'
  , `地方税` DECIMAL(10,0) COMMENT '地方税'
  , `登録日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '登録日時'
  , `登録者` INT DEFAULT 0 NOT NULL COMMENT '登録者'
  , `更新日時` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '更新日時'
  , `更新者` INT DEFAULT 0 NOT NULL COMMENT '更新者'
  , `削除済み` BIT(1) DEFAULT 0 NOT NULL COMMENT '削除済み'
  , CONSTRAINT `取引履歴_PKC` PRIMARY KEY (`登録連番`)
) COMMENT '取引履歴:個々の株取引を記録する。' ;

