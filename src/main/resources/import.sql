create table if not exists scenario (SCENARIO_ID int, TEXT varchar(20));
create table if not exists character_info (CHARACTER_ID int, NAME  varchar(20), SCHOOL  varchar(20), COME_FROM  varchar(20), MENTAL_DISORDER  varchar(20), SEX  varchar(20), AGE int, STR int, INTELLIGENCE int, APP int, SIZ int, DEX int, CON int, POW int, EDU int, SANITY_POINT int, MAGIC_POINT int, DURABILITY int);


insert into Scenario (scenario_id, text) values (1, 'test');
insert into character_info (CHARACTER_ID, NAME, SCHOOL, COME_FROM, MENTAL_DISORDER, SEX, AGE, STR, INTELLIGENCE, APP, SIZ, DEX, CON, POW, EDU, SANITY_POINT, MAGIC_POINT, DURABILITY) values(1, 'testCharacter', 'test', 'test', 'test', 'test', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);