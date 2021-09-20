create sequence hibernate_sequence start 1 increment 1;

create table news (
    id int8 not null,
    namenews varchar(255) not null,
    prenews varchar (255) not null,
    fullnews varchar (2048) not null,
    primary key (id)
);

create table type_news (
    id int8 not null,
    nametype varchar(50) not null,
    colortype varchar(50) not null
);
alter table if exists type_news
    add constraint news_fk
    foreign key (news_id) references news;