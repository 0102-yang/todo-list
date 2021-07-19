drop table if exists user;
# drop table if exists remind_time;
drop table if exists remind;

create table user
(
    user_id  int primary key auto_increment,
    username varchar(40)  not null unique,
    email    varchar(40)  not null,
    password varchar(108) not null
);

create table remind
(
    remind_id   int primary key auto_increment,
    user_id     int          not null,
    title       varchar(100) not null,
    description varchar(1024),
    email       varchar(40)  not null,
    priority    int,
    create_time datetime,
    remind_time datetime,
    constraint UID foreign key (user_id) references user (user_id) on delete cascade
);
#
# create table remind_time
# (
#     remind_time_id varchar(20) primary key auto_increment,
#     remind_id      varchar(20) not null,
#     remind_time    datetime,
#     is_remind      bool,
#     constraint RID foreign key (remind_id) references remind (remind_id) on delete cascade
# );
