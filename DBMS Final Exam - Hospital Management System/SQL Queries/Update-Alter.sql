use Hospital;

/*Update*/
update nurse set roomID = NULL
where roomID  IN (select roomID from room where status = 'Empty');

select * from Nurse;

update room set patientID = NULL
where status = 'Empty';

select * from room;


/*Alter*/
alter table bill
add column doctorID INT;

select * from bill;

alter table bill
drop column doctorID;

select * from bill;
