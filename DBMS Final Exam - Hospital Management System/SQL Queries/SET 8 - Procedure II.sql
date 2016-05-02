use Hospital;

set sql_safe_updates = 0; 

delimiter //
create procedure generateBill(
IN patientID INT)
BEGIN
DECLARE releaseDat date;
DECLARE quant int;
DECLARE volume int;
DECLARE amount int;

select patient.releaseDate into @releaseDat from patient where patient.patientID = patientID;

if releaseDat = NULL
then

Update patient set patient.releaseDate = (cast(CURDATE() as Date))
where patient.patientID = patientID;

select quantity into @quant 
from medicine 
where medicine.patientID = patientID;

select price into @volume 
from medicine 
where medicine.patientID = patientID;

insert into bill values (@amount, quant * volume);
end if;
end;//
delimiter ;

SET @patientID := 33;
call generateBill (patientID);

select * from bill where patientID = 33;

select * from patient where patientID = 33;