Select * from Person;

Select * from UserAccounts;

Select * from Enterprises;

SELECT * FROM forensic.Drugs;

SELECT * FROM forensic.WorkRequests;

update Drug set quantity = 0 where enterpriseId = 4;

delete from person where personID = 2;

update WorkRequest set status = 'Sent By Dispenser' where requestId = 2;

insert into Person values (1, 'Boston', 'admin@gmail.com', 'admin', 'admin');

select workreques0_.requestId as requestI1_4_, workreques0_.drugName as drugName2_4_, workreques0_.receiverId as receiver5_4_, workreques0_.senderId as senderId6_4_, workreques0_.quantity as quantity3_4_, workreques0_.status as status4_4_ from WorkRequests workreques0_ where workreques0_.receiverId=3;

insert into UserAccounts values ('admin', 'Admin', 'admin', 1, 1);

insert into enterprises values (1, 'SurvellianceApp', 'admin');

insert into UserAccount values (1, 'Boston', 'abc@yahoo.com', 'hari', 'panjwani', 'ManufacturerLogout', 'neu', 'manufacturer', 'neu', 'adminMenu', 1);

use forensic;

create database  forensic;

truncate workrequest;

