use Hospital;

start transaction;
savepoint sp1;

update bill set amount = (amount - ((0.1) * amount))
where patientID = 5;

select * from bill where patientID = 5;

rollback to sp1;

select * from bill where patientID = 5;

update bill set amount = amount - ((0.1) * amount)
where patientID = 5;

update bill set amount = amount + ((0.1) * amount)
where patientID = 8;

commit;
--------------------------------------

LOCK table bill read;
start transaction;
savepoint sp1;

update bill set amount = (amount - ((0.1) * amount))
where patientID = 5;

rollback to sp1;

select * from bill where patientID = 5;

update bill set amount = amount + ((0.1) * amount)
where patientID = 8;

commit;

Unlock tables;