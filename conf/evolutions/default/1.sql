# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                        integer auto_increment not null,
  steps                     integer,
  email_id                  varchar(255),
  constraint pk_user primary key (id))
;

create table user_img (
  id                        integer auto_increment not null,
  imgpath                   varchar(255),
  constraint pk_user_img primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user;

drop table user_img;

SET FOREIGN_KEY_CHECKS=1;

