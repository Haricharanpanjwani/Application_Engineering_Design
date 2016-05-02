use Hospital;

drop trigger deletePatient;

delimiter $$
create trigger deletePatient
after delete on patient
for each row
begin

declare newPatId INT;
declare newroomId INT;

set @newPatientId= old.PatientID;
SET @newroomId = (select RoomID from room where room.PatientID = @newpatientID);

update room set room.Status = 'Empty',
PatientID = null where RoomID= @newroomId;

delete from medicine where medicine.PatientID = @newPatientId;

delete from bill where bill.PatientID = @newPatientId;

end;$$
delimiter ;


SET foreign_key_checks = 0; 
delete from patient where PatientID = 11;

select * from room WHERE roomID = (select @newroomId) ;
select * from medicine WHERE Medicine.PatientID = (select @newPatientId) ;
select * from bill WHERE bill.PatientID = (select @newPatientId) ;
