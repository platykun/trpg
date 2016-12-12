create table if not exists scenario (ID int NOT NULL AUTO_INCREMENT, TITLE varchar(20), OUTLINE varchar(20), TEXT varchar(5000));
create table if not exists related_character (ID int NOT NULL AUTO_INCREMENT, SCENARIO_ID int, CHARACTER_INFO_ID int, CATEGORY int);
create table if not exists character_info (ID int NOT NULL AUTO_INCREMENT, NAME  varchar(20), SCHOOL  varchar(20), COME_FROM  varchar(20), MENTAL_DISORDER  varchar(20), SEX  varchar(20), AGE int, STR int, INTELLIGENCE int, APP int, SIZ int, DEX int, CON int, POW int, EDU int, SANITY_POINT int, MAGIC_POINT int, DURABILITY int);
create table if not exists session_info(ID int NOT NULL AUTO_INCREMENT, SCENARIO_ID int, STATUS int);

insert into related_character(SCENARIO_ID, CHARACTER_INFO_ID, CATEGORY) values(1, 1, 1);
insert into related_character(SCENARIO_ID, CHARACTER_INFO_ID, CATEGORY) values(1, 2, 2);
insert into related_character(SCENARIO_ID, CHARACTER_INFO_ID, CATEGORY) values(1, 3, 2);
insert into character_info (NAME, SCHOOL, COME_FROM, MENTAL_DISORDER, SEX, AGE, STR, INTELLIGENCE, APP, SIZ, DEX, CON, POW, EDU, SANITY_POINT, MAGIC_POINT, DURABILITY) values('testCharacter', 'test', 'test', 'test', 'test', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
insert into character_info (NAME, SCHOOL, COME_FROM, MENTAL_DISORDER, SEX, AGE, STR, INTELLIGENCE, APP, SIZ, DEX, CON, POW, EDU, SANITY_POINT, MAGIC_POINT, DURABILITY) values('enemy', 'test', 'test', 'test', 'test', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
insert into character_info (NAME, SCHOOL, COME_FROM, MENTAL_DISORDER, SEX, AGE, STR, INTELLIGENCE, APP, SIZ, DEX, CON, POW, EDU, SANITY_POINT, MAGIC_POINT, DURABILITY) values('enemy2', 'hoge', 'hoge', 'hoge', 'hoge', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
insert into session_info (SCENARIO_ID, STATUS) values(1, 0);



insert into Scenario (TITLE, OUTLINE, TEXT) values ('ここにタイトルが入る', '概要です', '# サンプルシナリオ' || CHAR(10) ||  '## はじめに' || CHAR(10) ||  '推奨プレイ人数：2~3人' || CHAR(10) ||  '## 導入' || CHAR(10) ||  'とあるIT企業に務めるサラリーマンが上司から土日出勤を命じられる。   ' || CHAR(10) ||  'プロジェクトメンバーである探索者が出社したところから始まる。' || CHAR(10) ||  '## イベント１' || CHAR(10) ||  'サーバールームからアラート音がなる。' || CHAR(10) ||  '## サーバールーム' || CHAR(10) ||  '聞き耳→サーバーのファンが非常に高速に回転している音が聞こえる。' || CHAR(10) ||  '## ・・・' || CHAR(10) ||  'といった感じでシナリオを書いていく。');
