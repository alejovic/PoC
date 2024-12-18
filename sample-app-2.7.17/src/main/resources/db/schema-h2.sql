drop table if exists EMPLOYEES;

create table EMPLOYEES
(
    ID   int          not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    ROLE varchar(100) not null,
    PRIMARY KEY (ID)
);
