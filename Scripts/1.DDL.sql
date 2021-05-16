

-- 1.ddl.sql
drop database mybatis_dev;
create database if not exists mybatis_study;

-- 2.grant.sql (user_mybatis_study localhost, % 계정 추가)
drop user if exists 'user_mybatis_study'@'localhost';
grant all privileges on mybatis_study.* 
to 'user_mybatis_study'@'localhost' identified by 'rootroot';
grant all privileges on mybatis_study.* to 'user_mybatis_study'@'%' identified by 'rootroot';

/*성별 칼럼 추가*/

alter table students add gender tinyint unsigned;

/*longblob, longtext*/
create table user_pics( id int(11) not null auto_increment COMMENT 'id',
name varchar(50) not null COMMENT 'name',
pic longblob COMMENT 'pic',
bio longtext collate utf8_unicode_ci COMMENT 'bio',
primary key (id) )





-- 3.ddl.sql

-- 4.dml.sql
-- 5.test.sql

-- 6.procedure.sql