create table location(
    id bigint not null auto_increment,
    city varchar(255)  not null,
    country varchar(255) not null,
    region varchar(255) not null,
    primary key (id));
