--drop table scenario;
--drop table scene;
--drop table item;
--drop table related_character;
--drop table session_info;
--
--create table if not exists scenario (
--  ID int NOT NULL AUTO_INCREMENT, 
--  TITLE varchar(20), 
--  OUTLINE varchar(500), 
--  RECOMMEND_PLAYER varchar(10), 
--  TIME varchar(20), 
--  TEXT varchar(5000));
--  create table if not exists scene (ID INT NOT NULL AUTO_INCREMENT, 
--  SCENARIO_ID INT NOT NULL, 
--  SERIAL_NUM INT, 
--  SCENE_GROUP INT, 
--  TITLE VARCHAR(20), 
--  OUTLINE VARCHAR(400), 
--  TEXT VARCHAR(4000), 
--  APPEAR_CHARACTER1 INT, 
--  APPEAR_CHARACTER2 INT, 
--  APPEAR_CHARACTER3 INT, 
--  APPEAR_CHARACTER4 INT, 
--  APPEAR_CHARACTER5 INT, 
--  SCENE_LINK_ID1 INT, 
--  SCENE_LINK_ID2 INT, 
--  SCENE_LINK_ID3 INT, 
--  SCENE_LINK_ID4 INT, 
--  SCENE_LINK_ID5 INT
--);
--
--create table if not exists item (
--  ID INT NOT NULL AUTO_INCREMENT, 
--  SCENARIO_ID INT, 
--  SCENE_ID INT, 
--  SERIAL_NUM INT,NAME VARCHAR(20), 
--  IMG_URL VARCHAR(200), 
--  TEXT VARCHAR(500));
--  create table if not exists related_character (ID int NOT NULL AUTO_INCREMENT, 
--  SCENARIO_ID int, 
--  CHARACTER_INFO_ID int, 
--  CATEGORY int);
--  create table if not exists character_info (ID int NOT NULL AUTO_INCREMENT, 
--  NAME  varchar(20), 
--  SCHOOL  varchar(20), 
--  COME_FROM  varchar(20), 
--  MENTAL_DISORDER  varchar(20), 
--  SEX  varchar(20), 
--  AGE int, 
--  STR int, 
--  INTELLIGENCE int, 
--  APP int, 
--  SIZ int, 
--  DEX int, 
--  CON int, 
--  POW int, 
--  EDU int, 
--  SANITY_POINT int, 
--  MAGIC_POINT int, 
--  DURABILITY int, 
--  DICTIONARY int DEFAULT 5, 
--  MEDICINE int DEFAULT 5, 
--  DRIVE_CARRIAGE int DEFAULT 20, 
--  FIRST_AID int DEFAULT 30, 
--  OCCULT int DEFAULT 5, 
--  DODGE int DEFAULT 0, 
--  CHEMISTRY int DEFAULT 1, 
--  LOCKSMITH int DEFAULT 1, 
--  CONCEAL int DEFAULT 15, 
--  HIDE int DEFAULT 10, 
--  MECHANICAL_REPAIR int DEFAULT 20, 
--  LISTEN int DEFAULT 25, 
--  CTHULHU_MYTHOS int DEFAULT 0, 
--  ART int DEFAULT 5, 
--  ACCOUNTING int DEFAULT 10, 
--  ARCHAEOLOGY int DEFAULT 1, 
--  COMPUTER int DEFAULT 1, 
--  SNEAK int DEFAULT 10, 
--  PHOTOGRAPHY int DEFAULT 10, 
--  OPERATE_HVY_MACHINE int DEFAULT 1, 
--  RIDE int DEFAULT 5, 
--  CREDIT_RATING int DEFAULT 15, 
--  PSYCHOLOGY int DEFAULT 5, 
--  ANTHROPOLOGY int DEFAULT 1, 
--  SWIM int DEFAULT 25, 
--  PRODUCTION1 int DEFAULT 5, 
--  PRODUCTION2 int DEFAULT 5, 
--  PRODUCTION3 int DEFAULT 5, 
--  PSYCHOANALYSIS int DEFAULT 1, 
--  BIOLOGY int DEFAULT 1, 
--  PERSUADE int DEFAULT 15, 
--  PILOT1 int DEFAULT 1, 
--  PILOT2 int DEFAULT 1, 
--  PILOT3 int DEFAULT 1, 
--  GEOLOGY int DEFAULT 1, 
--  JUMP int DEFAULT 25, 
--  PURSUIT int DEFAULT 10, 
--  ELECTRICAL_REPAIR int DEFAULT 10, 
--  ELECTRONICS int DEFAULT 1, 
--  ASTRONOMY int DEFAULT 1, 
--  THROW_SOMETHING int DEFAULT 25, 
--  CLIMB int DEFAULT 40, 
--  LIBRARY int DEFAULT 25, 
--  NAVIGATE int DEFAULT 10, 
--  PRICE_CUT int DEFAULT 5, 
--  NATURAL_HISTORY int DEFAULT 10, 
--  PHYSICS int DEFAULT 1, 
--  DISGUISE int DEFAULT 1, 
--  LAW int DEFAULT 5, 
--  OTHER_LANGUAGE1 int DEFAULT 1, 
--  OTHER_LANGUAGE2 int DEFAULT 1, 
--  OWN_LANGUAGE int DEFAULT 0, 
--  MARTIAL int DEFAULT 1, 
--  SPOT_HIDDEN int DEFAULT 25, 
--  PHARMACY int DEFAULT 1, 
--  HISTORY1 int DEFAULT 20, 
--  HISTORY2 int DEFAULT 20, 
--  GUN int DEFAULT 20, 
--  SUB_MACHINE_GUN int DEFAULT 015, 
--  SHOTGUN int DEFAULT 30, 
--  MACHINE_GUN int DEFAULT 15, 
--  RIFLE int DEFAULT 25, 
--  KICK int DEFAULT 25, 
--  ASSEMBLY int DEFAULT 25, 
--  FIRST int DEFAULT 50, 
--  HEAD_BUTT int DEFAULT 10, 
--  HAND_WEAPON1 int DEFAULT 0, 
--  HAND_WEAPON2 int DEFAULT 0, 
--  FIREARM1 int DEFAULT 0, 
--  FIREARM2 int DEFAULT 0, 
--  FIREARM3 int DEFAULT 0, 
--  FIREARM4 int DEFAULT 0, 
--  FIREARM5 int DEFAULT 0, 
--  FIREARM6 int DEFAULT 0
--);
--
--create table if not exists session_info(
--  ID int NOT NULL AUTO_INCREMENT, 
--  SCENARIO_ID int, 
--  STATUS int
--);
--
--insert into related_character(
--  SCENARIO_ID, 
--  CHARACTER_INFO_ID, 
--  CATEGORY
--) values(1, 1, 1);
--
--insert into related_character(
--  SCENARIO_ID, 
--  CHARACTER_INFO_ID, 
--  CATEGORY
--) values(1, 2, 2);
--
--insert into related_character(
--  SCENARIO_ID, 
--  CHARACTER_INFO_ID, 
--  CATEGORY
--) values(1, 3, 2);
--
--
--insert into session_info (
--  SCENARIO_ID, 
--  STATUS
--) values(1, 0);
--
--insert into Scenario (
--  TITLE, 
--  OUTLINE, 
--  RECOMMEND_PLAYER, 
--  TIME, 
--  TEXT
--) values ('ここにタイトルが入る', 
-- '概要です', 
-- '３人', 
-- '1～１．５時間', 
-- '# サンプルシナリオ' || CHAR(10) ||  '## はじめに' || CHAR(10) ||  '推奨プレイ人数：2~3人' || CHAR(10) ||  '## 導入' || CHAR(10) ||  'とあるIT企業に務めるサラリーマンが上司から土日出勤を命じられる。   ' || CHAR(10) ||  'プロジェクトメンバーである探索者が出社したところから始まる。' || CHAR(10) ||  '## イベント１' || CHAR(10) ||  'サーバールームからアラート音がなる。' || CHAR(10) ||  '## サーバールーム' || CHAR(10) ||  '聞き耳→サーバーのファンが非常に高速に回転している音が聞こえる。' || CHAR(10) ||  '## ・・・' || CHAR(10) ||  'といった感じでシナリオを書いていく。');
--
--insert into Scene (
--  SCENARIO_ID, 
--  SERIAL_NUM, 
--  SCENE_GROUP, 
--  TITLE, 
--  OUTLINE, 
--  TEXT, 
--  APPEAR_CHARACTER1, 
--  APPEAR_CHARACTER2, 
--  APPEAR_CHARACTER3, 
--  APPEAR_CHARACTER4, 
--  APPEAR_CHARACTER5, 
--  SCENE_LINK_ID1, 
--  SCENE_LINK_ID2, 
--  SCENE_LINK_ID3, 
--  SCENE_LINK_ID4, 
--  SCENE_LINK_ID5
--) values (
--  1, 
--  1, 
--  10, 
--  '導入のシーン', 
--  '概要をここに記載', 
--  '# 内容をここに記載', 
--  2, 
--  3, 
--  0, 
--  0, 
--  0, 
--  2, 
--  3, 
--  0, 
--  0, 
--  0);
--insert into Scene (
--  SCENARIO_ID, 
--  SERIAL_NUM, 
--  SCENE_GROUP, 
--  TITLE, 
--  OUTLINE, 
--  TEXT, 
--  APPEAR_CHARACTER1, 
--  APPEAR_CHARACTER2, 
--  APPEAR_CHARACTER3, 
--  APPEAR_CHARACTER4, 
--  APPEAR_CHARACTER5, 
--  SCENE_LINK_ID1, 
--  SCENE_LINK_ID2, 
--  SCENE_LINK_ID3, 
--  SCENE_LINK_ID4, 
--  SCENE_LINK_ID5
--) values (
--  1, 
--  2, 
--  30, 
--  '場所：キッチンのシーン', 
--  'キッチン', 
--  '# キッチン内の様子を記載', 
--  2, 
--  3, 
--  0, 
--  0, 
--  0, 
--  3, 
--  0, 
--  0, 
--  0, 
--  0
--);
--
--insert into Scene (
--  SCENARIO_ID, 
--  SERIAL_NUM, 
--  SCENE_GROUP, 
--  TITLE, 
--  OUTLINE, 
--  TEXT, 
--  APPEAR_CHARACTER1, 
--  APPEAR_CHARACTER2, 
--  APPEAR_CHARACTER3, 
--  APPEAR_CHARACTER4, 
--  APPEAR_CHARACTER5, 
--  SCENE_LINK_ID1, 
--  SCENE_LINK_ID2, 
--  SCENE_LINK_ID3, 
--  SCENE_LINK_ID4, 
--  SCENE_LINK_ID5
--) values (
--  1, 
--  3, 
--  30, 
--  '場所：台所のシーン', 
--  '台所', 
--  '# 台所内の様子を記載', 
--  2, 
--  3, 
--  0, 
--  0, 
--  0, 
--  0, 
--  0, 
--  0, 
--  0, 
--  0
--);
--
--insert into Item (
--  ID,
--  SCENARIO_ID,
--  SCENE_ID,
--  SERIAL_NUM,
--  NAME, 
--  IMG_URL,
--  TEXT
--) values (
--  1, 
--  1, 
--  1, 
--  1, 
--  'アイテム名：ツイッターアイコン画像', 
--  'https://pbs.twimg.com/profile_images/550187312638738432/8qLchkDs.png', 
--  'ツイッターのアイコン画像'
--);
--


DROP TABLE CHARACTER_INFO;
DROP TABLE HUMAN;
DROP TABLE MONSTER;
DROP TABLE DETAIL;
DROP TABLE JOB;
DROP TABLE JOB_TO_PARAMETER;
DROP TABLE BELONGING;
DROP TABLE WEAPON;
DROP TABLE PARAMETER;

CREATE TABLE IF NOT EXISTS CHARACTER_INFO ( ID INT NOT NULL AUTO_INCREMENT,NAME VARCHAR(20) );
CREATE TABLE IF NOT EXISTS HUMAN ( ID INT NOT NULL AUTO_INCREMENT, CHARACTER_ID INT NOT NULL, JOB_ID INT, SCHOOL VARCHAR(20), COME_FROM VARCHAR(20), MENTAL_DISORDER VARCHAR(20), SEX VARCHAR(20), AGE INT, HUMAN_TYPE INT);
CREATE TABLE IF NOT EXISTS MONSTER ( ID INT NOT NULL AUTO_INCREMENT, CHARACTER_ID INT NOT NULL, ARMOR INT, LACK_OF_SANITY VARCHAR(20), REMARKS VARCHAR(200));
CREATE TABLE IF NOT EXISTS DETAIL( ID INT NOT NULL AUTO_INCREMENT, CHARACTER_ID INT, DETAIL_TYPE INT, DETAIL VARCHAR(200));
CREATE TABLE IF NOT EXISTS JOB ( ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20));
CREATE TABLE IF NOT EXISTS JOB_DETAIL ( JOB_ID INT NOT NULL, INVESTIGATE_TYPE INT );
CREATE TABLE IF NOT EXISTS BELONGING( ID INT NOT NULL AUTO_INCREMENT, CHARACTER_ID INT, BELONGING_TYPE INT, NAME VARCHAR(20), DESCRIPTION VARCHAR(200));
CREATE TABLE IF NOT EXISTS WEAPON ( ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), ACCURACY INT, DAMAGE INT, RANGE INT, REMARKS INT);
CREATE TABLE IF NOT EXISTS PARAMETER ( ID INT NOT NULL AUTO_INCREMENT, CHARACTER_ID INT, PARAMETER INT, DICE_VALUE VARCHAR(20), PARAMETER_TYPE INT, DEFAULT_VALUE INT, SUB_PARAMETER_TYPE INT);

INSERT INTO CHARACTER_INFO (NAME) VALUES('name');
INSERT INTO HUMAN (CHARACTER_ID, JOB_ID, SCHOOL, COME_FROM, MENTAL_DISORDER, SEX, AGE, HUMAN_TYPE) VALUES (1, 1, 'hoge', '', '', 'otoko', 20, 1);
INSERT INTO BELONGING(CHARACTER_ID, BELONGING_TYPE) VALUES (1,1);
INSERT INTO BELONGING(CHARACTER_ID, BELONGING_TYPE) VALUES (2,2);