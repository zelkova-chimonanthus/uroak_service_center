-- Project Name : ���g�E�i���o�[�Y
-- Date/Time    : 2019/04/08 23:44:44
-- Author       : �E���A�b�N�A�f�B�`��
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable�^�����߂��t������Ă��܂��B
  ����ɂ��Adrop table, create table ����f�[�^���c��܂��B
  ���̋@�\�͈ꎞ�I�� $$TableName �̂悤�Ȉꎞ�e�[�u�����쐬���܂��B
*/

-- ���g�V
drop table if exists loto7 cascade;

create table loto7 (
  `���` INT not null comment '���'
  , `���I��` DATE comment '���I��'
  , `�{�����Q01` SMALLINT(2) not null comment '�{�����Q01'
  , `�{�����Q02` SMALLINT(2) not null comment '�{�����Q02'
  , `�{�����Q03` SMALLINT(2) not null comment '�{�����Q03'
  , `�{�����Q04` SMALLINT(2) not null comment '�{�����Q04'
  , `�{�����Q05` SMALLINT(2) not null comment '�{�����Q05'
  , `�{�����Q06` SMALLINT(2) not null comment '�{�����Q06'
  , `�{�����Q07` SMALLINT(2) not null comment '�{�����Q07'
  , `�{�[�i�X�����Q1` SMALLINT(2) not null comment '�{�[�i�X�����Q1'
  , `�{�[�i�X�����Q2` SMALLINT(2) not null comment '�{�[�i�X�����Q2'
  , `1���Q���I����` SMALLINT comment '1���Q���I����'
  , `1���Q���I���z` DECIMAL(12) comment '1���Q���I���z'
  , `2���Q���I����` SMALLINT comment '2���Q���I����'
  , `2���Q���I���z` DECIMAL(9) comment '2���Q���I���z'
  , `3���Q���I����` SMALLINT comment '3���Q���I����'
  , `3���Q���I���z` DECIMAL(8) comment '3���Q���I���z'
  , `4���Q���I����` SMALLINT comment '4���Q���I����'
  , `4���Q���I���z` DECIMAL(6) comment '4���Q���I���z'
  , `5���Q���I����` INT comment '5���Q���I����'
  , `5���Q���I���z` DECIMAL(6) comment '5���Q���I���z'
  , `6���Q���I����` INT comment '6���Q���I����'
  , `6���Q���I���z` DECIMAL(6) comment '6���Q���I���z'
  , `�̔����ъz` DECIMAL(12) comment '�̔����ъz'
  , `�L�����[�I�[�o�[` DECIMAL(12) comment '�L�����[�I�[�o�['
  , constraint loto7_PKC primary key (`���`)
) comment '���g�V' ;

-- ���g�U
drop table if exists loto6 cascade;

create table loto6 (
  `���` INT not null comment '���'
  , `���I��` DATE comment '���I��'
  , `�{�����Q01` SMALLINT(2) not null comment '�{�����Q01'
  , `�{�����Q02` SMALLINT(2) not null comment '�{�����Q02'
  , `�{�����Q03` SMALLINT(2) not null comment '�{�����Q03'
  , `�{�����Q04` SMALLINT(2) not null comment '�{�����Q04'
  , `�{�����Q05` SMALLINT(2) not null comment '�{�����Q05'
  , `�{�����Q06` SMALLINT(2) not null comment '�{�����Q06'
  , `�{�[�i�X����` SMALLINT(2) not null comment '�{�[�i�X����'
  , `1���Q���I����` SMALLINT comment '1���Q���I����'
  , `1���Q���I���z` DECIMAL(11) comment '1���Q���I���z'
  , `2���Q���I����` SMALLINT comment '2���Q���I����'
  , `2���Q���I���z` DECIMAL(9) comment '2���Q���I���z'
  , `3���Q���I����` SMALLINT comment '3���Q���I����'
  , `3���Q���I���z` DECIMAL(8) comment '3���Q���I���z'
  , `4���Q���I����` INT comment '4���Q���I����'
  , `4���Q���I���z` DECIMAL(6) comment '4���Q���I���z'
  , `5���Q���I����` INT comment '5���Q���I����'
  , `5���Q���I���z` DECIMAL(6) comment '5���Q���I���z'
  , `�̔����ъz` DECIMAL(12) comment '�̔����ъz'
  , `�L�����[�I�[�o�[` DECIMAL(10) comment '�L�����[�I�[�o�['
  , constraint loto6_PKC primary key (`���`)
) comment '���g�U' ;

-- �i���o�[�Y�S
drop table if exists numbers4 cascade;

create table numbers4 (
  `���` INT not null comment '���'
  , `���I��` DATE comment '���I��'
  , `���I����` CHAR(4) not null comment '���I����'
  , `�X�g���[�g�Q���I����` SMALLINT comment '�X�g���[�g�Q���I����'
  , `�X�g���[�g�Q���I���z` DECIMAL(9) comment '�X�g���[�g�Q���I���z'
  , `�{�b�N�X�Q���I����` SMALLINT comment '�{�b�N�X�Q���I����'
  , `�{�b�N�X�Q���I���z` DECIMAL(8) comment '�{�b�N�X�Q���I���z'
  , `�Z�b�g�Q�X�g���[�g�Q���I����` SMALLINT comment '�Z�b�g�Q�X�g���[�g�Q���I����'
  , `�Z�b�g�Q�X�g���[�g�Q���I���z` DECIMAL(8) comment '�Z�b�g�Q�X�g���[�g�Q���I���z'
  , `�Z�b�g�Q�{�b�N�X�Q���I����` SMALLINT comment '�Z�b�g�Q�{�b�N�X�Q���I����'
  , `�Z�b�g�Q�{�b�N�X�Q���I���z` DECIMAL(8) comment '�Z�b�g�Q�{�b�N�X�Q���I���z'
  , `�̔����ъz` DECIMAL(11) comment '�̔����ъz'
  , constraint numbers4_PKC primary key (`���`)
) comment '�i���o�[�Y�S' ;

-- �~�j���g
drop table if exists miniloto cascade;

create table miniloto (
  `���` INT not null comment '���'
  , `���I��` DATE comment '���I��'
  , `�{�����Q01` SMALLINT(2) not null comment '�{�����Q01'
  , `�{�����Q02` SMALLINT(2) not null comment '�{�����Q02'
  , `�{�����Q03` SMALLINT(2) not null comment '�{�����Q03'
  , `�{�����Q04` SMALLINT(2) not null comment '�{�����Q04'
  , `�{�����Q05` SMALLINT(2) not null comment '�{�����Q05'
  , `�{�[�i�X����` SMALLINT(2) not null comment '�{�[�i�X����'
  , `1���Q���I����` SMALLINT comment '1���Q���I����'
  , `1���Q���I���z` DECIMAL(9) comment '1���Q���I���z'
  , `2���Q���I����` SMALLINT comment '2���Q���I����'
  , `2���Q���I���z` DECIMAL(8) comment '2���Q���I���z'
  , `3���Q���I����` SMALLINT comment '3���Q���I����'
  , `3���Q���I���z` DECIMAL(7) comment '3���Q���I���z'
  , `4���Q���I����` INT comment '4���Q���I����'
  , `4���Q���I���z` DECIMAL(6) comment '4���Q���I���z'
  , `�̔����ъz` DECIMAL(11) comment '�̔����ъz'
  , constraint miniloto_PKC primary key (`���`)
) comment '�~�j���g' ;

-- �i���o�[�Y�R
drop table if exists numbers3 cascade;

create table numbers3 (
  `���` INT not null comment '���'
  , `���I��` DATE comment '���I��'
  , `���I����` CHAR(3) not null comment '���I����'
  , `�X�g���[�g�Q���I����` SMALLINT comment '�X�g���[�g�Q���I����'
  , `�X�g���[�g�Q���I���z` DECIMAL(8) comment '�X�g���[�g�Q���I���z'
  , `�{�b�N�X�Q���I����` SMALLINT comment '�{�b�N�X�Q���I����'
  , `�{�b�N�X�Q���I���z` DECIMAL(8) comment '�{�b�N�X�Q���I���z'
  , `�Z�b�g�Q�X�g���[�g�Q���I����` SMALLINT comment '�Z�b�g�Q�X�g���[�g�Q���I����'
  , `�Z�b�g�Q�X�g���[�g�Q���I���z` DECIMAL(8) comment '�Z�b�g�Q�X�g���[�g�Q���I���z'
  , `�Z�b�g�Q�{�b�N�X�Q���I����` SMALLINT comment '�Z�b�g�Q�{�b�N�X�Q���I����'
  , `�Z�b�g�Q�{�b�N�X�Q���I���z` DECIMAL(8) comment '�Z�b�g�Q�{�b�N�X�Q���I���z'
  , `�~�j�Q���I����` SMALLINT comment '�~�j�Q���I����'
  , `�~�j�Q���I���z` DECIMAL(8) comment '�~�j�Q���I���z'
  , `�̔����ъz` DECIMAL(11) comment '�̔����ъz'
  , constraint numbers3_PKC primary key (`���`)
) comment '�i���o�[�Y�R' ;
