-- Project Name : ロト・ナンバーズ
-- Date/Time    : 2019/04/08 23:44:44
-- Author       : ウロアックアディチャ
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- ロト７
drop table if exists loto7 cascade;

create table loto7 (
  `回別` INT not null comment '回別'
  , `抽選日` DATE comment '抽選日'
  , `本数字＿01` SMALLINT(2) not null comment '本数字＿01'
  , `本数字＿02` SMALLINT(2) not null comment '本数字＿02'
  , `本数字＿03` SMALLINT(2) not null comment '本数字＿03'
  , `本数字＿04` SMALLINT(2) not null comment '本数字＿04'
  , `本数字＿05` SMALLINT(2) not null comment '本数字＿05'
  , `本数字＿06` SMALLINT(2) not null comment '本数字＿06'
  , `本数字＿07` SMALLINT(2) not null comment '本数字＿07'
  , `ボーナス数字＿1` SMALLINT(2) not null comment 'ボーナス数字＿1'
  , `ボーナス数字＿2` SMALLINT(2) not null comment 'ボーナス数字＿2'
  , `1等＿当選口数` SMALLINT comment '1等＿当選口数'
  , `1等＿当選金額` DECIMAL(12) comment '1等＿当選金額'
  , `2等＿当選口数` SMALLINT comment '2等＿当選口数'
  , `2等＿当選金額` DECIMAL(9) comment '2等＿当選金額'
  , `3等＿当選口数` SMALLINT comment '3等＿当選口数'
  , `3等＿当選金額` DECIMAL(8) comment '3等＿当選金額'
  , `4等＿当選口数` SMALLINT comment '4等＿当選口数'
  , `4等＿当選金額` DECIMAL(6) comment '4等＿当選金額'
  , `5等＿当選口数` INT comment '5等＿当選口数'
  , `5等＿当選金額` DECIMAL(6) comment '5等＿当選金額'
  , `6等＿当選口数` INT comment '6等＿当選口数'
  , `6等＿当選金額` DECIMAL(6) comment '6等＿当選金額'
  , `販売実績額` DECIMAL(12) comment '販売実績額'
  , `キャリーオーバー` DECIMAL(12) comment 'キャリーオーバー'
  , constraint loto7_PKC primary key (`回別`)
) comment 'ロト７' ;

-- ロト６
drop table if exists loto6 cascade;

create table loto6 (
  `回別` INT not null comment '回別'
  , `抽選日` DATE comment '抽選日'
  , `本数字＿01` SMALLINT(2) not null comment '本数字＿01'
  , `本数字＿02` SMALLINT(2) not null comment '本数字＿02'
  , `本数字＿03` SMALLINT(2) not null comment '本数字＿03'
  , `本数字＿04` SMALLINT(2) not null comment '本数字＿04'
  , `本数字＿05` SMALLINT(2) not null comment '本数字＿05'
  , `本数字＿06` SMALLINT(2) not null comment '本数字＿06'
  , `ボーナス数字` SMALLINT(2) not null comment 'ボーナス数字'
  , `1等＿当選口数` SMALLINT comment '1等＿当選口数'
  , `1等＿当選金額` DECIMAL(11) comment '1等＿当選金額'
  , `2等＿当選口数` SMALLINT comment '2等＿当選口数'
  , `2等＿当選金額` DECIMAL(9) comment '2等＿当選金額'
  , `3等＿当選口数` SMALLINT comment '3等＿当選口数'
  , `3等＿当選金額` DECIMAL(8) comment '3等＿当選金額'
  , `4等＿当選口数` INT comment '4等＿当選口数'
  , `4等＿当選金額` DECIMAL(6) comment '4等＿当選金額'
  , `5等＿当選口数` INT comment '5等＿当選口数'
  , `5等＿当選金額` DECIMAL(6) comment '5等＿当選金額'
  , `販売実績額` DECIMAL(12) comment '販売実績額'
  , `キャリーオーバー` DECIMAL(10) comment 'キャリーオーバー'
  , constraint loto6_PKC primary key (`回別`)
) comment 'ロト６' ;

-- ナンバーズ４
drop table if exists numbers4 cascade;

create table numbers4 (
  `回別` INT not null comment '回別'
  , `抽選日` DATE comment '抽選日'
  , `抽選数字` CHAR(4) not null comment '抽選数字'
  , `ストレート＿当選口数` SMALLINT comment 'ストレート＿当選口数'
  , `ストレート＿当選金額` DECIMAL(9) comment 'ストレート＿当選金額'
  , `ボックス＿当選口数` SMALLINT comment 'ボックス＿当選口数'
  , `ボックス＿当選金額` DECIMAL(8) comment 'ボックス＿当選金額'
  , `セット＿ストレート＿当選口数` SMALLINT comment 'セット＿ストレート＿当選口数'
  , `セット＿ストレート＿当選金額` DECIMAL(8) comment 'セット＿ストレート＿当選金額'
  , `セット＿ボックス＿当選口数` SMALLINT comment 'セット＿ボックス＿当選口数'
  , `セット＿ボックス＿当選金額` DECIMAL(8) comment 'セット＿ボックス＿当選金額'
  , `販売実績額` DECIMAL(11) comment '販売実績額'
  , constraint numbers4_PKC primary key (`回別`)
) comment 'ナンバーズ４' ;

-- ミニロト
drop table if exists miniloto cascade;

create table miniloto (
  `回別` INT not null comment '回別'
  , `抽選日` DATE comment '抽選日'
  , `本数字＿01` SMALLINT(2) not null comment '本数字＿01'
  , `本数字＿02` SMALLINT(2) not null comment '本数字＿02'
  , `本数字＿03` SMALLINT(2) not null comment '本数字＿03'
  , `本数字＿04` SMALLINT(2) not null comment '本数字＿04'
  , `本数字＿05` SMALLINT(2) not null comment '本数字＿05'
  , `ボーナス数字` SMALLINT(2) not null comment 'ボーナス数字'
  , `1等＿当選口数` SMALLINT comment '1等＿当選口数'
  , `1等＿当選金額` DECIMAL(9) comment '1等＿当選金額'
  , `2等＿当選口数` SMALLINT comment '2等＿当選口数'
  , `2等＿当選金額` DECIMAL(8) comment '2等＿当選金額'
  , `3等＿当選口数` SMALLINT comment '3等＿当選口数'
  , `3等＿当選金額` DECIMAL(7) comment '3等＿当選金額'
  , `4等＿当選口数` INT comment '4等＿当選口数'
  , `4等＿当選金額` DECIMAL(6) comment '4等＿当選金額'
  , `販売実績額` DECIMAL(11) comment '販売実績額'
  , constraint miniloto_PKC primary key (`回別`)
) comment 'ミニロト' ;

-- ナンバーズ３
drop table if exists numbers3 cascade;

create table numbers3 (
  `回別` INT not null comment '回別'
  , `抽選日` DATE comment '抽選日'
  , `抽選数字` CHAR(3) not null comment '抽選数字'
  , `ストレート＿当選口数` SMALLINT comment 'ストレート＿当選口数'
  , `ストレート＿当選金額` DECIMAL(8) comment 'ストレート＿当選金額'
  , `ボックス＿当選口数` SMALLINT comment 'ボックス＿当選口数'
  , `ボックス＿当選金額` DECIMAL(8) comment 'ボックス＿当選金額'
  , `セット＿ストレート＿当選口数` SMALLINT comment 'セット＿ストレート＿当選口数'
  , `セット＿ストレート＿当選金額` DECIMAL(8) comment 'セット＿ストレート＿当選金額'
  , `セット＿ボックス＿当選口数` SMALLINT comment 'セット＿ボックス＿当選口数'
  , `セット＿ボックス＿当選金額` DECIMAL(8) comment 'セット＿ボックス＿当選金額'
  , `ミニ＿当選口数` SMALLINT comment 'ミニ＿当選口数'
  , `ミニ＿当選金額` DECIMAL(8) comment 'ミニ＿当選金額'
  , `販売実績額` DECIMAL(11) comment '販売実績額'
  , constraint numbers3_PKC primary key (`回別`)
) comment 'ナンバーズ３' ;
