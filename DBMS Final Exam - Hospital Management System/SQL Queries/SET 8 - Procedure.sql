use Hospital;

set sql_safe_updates = 0; 

delimiter //
create procedure releasePatient(
IN patientID INT)
BEGIN
DECLARE releaseDat date;

select patient.releaseDate into @releaseDat from patient where patient.patientID = patientID;

if releaseDat = NULL
then

Update patient set patient.releaseDate = (cast(CURDATE() as Date))
where patient.patientID = patientID;
end if;
end;//
delimiter ;

SET @patientID := 1;
call releasePatient (patientID);
select * from patient where patientID = 1;
