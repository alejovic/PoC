drop table if exists EMPLOYEES;

create table EMPLOYEES
(
    ID   int          not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    PRIMARY KEY (ID)
);

insert into EMPLOYEES values (1, 'Andres');
insert into EMPLOYEES values (2, 'Carlos');
insert into EMPLOYEES values (3, 'Maria');
insert into EMPLOYEES values (4, 'Juan');
