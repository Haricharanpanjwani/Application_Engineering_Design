use Hospital;

DELIMITER $$
CREATE TRIGGER getRoom 
AFTER INSERT 
on Patient 
For each row
BEGIN
IF EXISTS (SELECT * FROM Patient where admitDate = (cast(CURDATE() as Date)))
THEN
update room set patientID = new.patientID, status = 'Filled'
where status = 'Empty' LIMIT 1;
END IF;
END; $$
DELIMITER ;

insert into patient (patientID, patientName, dob, gender, admitDate) value 
(51, 'Shivam', '1989-04-19', 'M', CURDATE());

select * from patient where patientID = 51;

select * from room where patientID = 51;

select * from nurse where roomID = 4;
