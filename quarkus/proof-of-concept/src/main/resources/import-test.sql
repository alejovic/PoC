drop table if exists EMPLOYEES;

create table EMPLOYEES
(
    ID   int          not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    PRIMARY KEY (ID)
);

insert into EMPLOYEES values (1, 'Test Andres');
insert into EMPLOYEES values (2, 'Test Carlos');
insert into EMPLOYEES values (3, 'Test Maria');
insert into EMPLOYEES values (4, 'Test Juan');
