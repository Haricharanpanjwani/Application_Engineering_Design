use Hospital;

delimiter $$
create trigger vacateRoom
after update on patient
for each row
begin

declare patientID INT;
declare releaseDate date;
declare newroomId INT;

SET @patientID = old.PatientID;
set @releaseDate= new.outDate;
SET @newroomId = (select RoomID from room where room.PatientID = @patientID);
end;$$
delimiter ;

update Patient set releaseDate = (cast(curdate() as Date)) where PatientID = 18;

select @newroomId;
select @patientID;

drop trigger vacateRoom;







