create view doctor_specialization AS
select doctorID, doctorName, specialization
from doctor
where specialization = 'Cardiologist';

select * from doctor_specialization;


create view Room_View AS
select  n.roomID, staffID, staffName,roomType
from Room r
LEFT OUTER JOIN Nurse n
ON n.roomID = r.roomID
where roomType = 'Emergency'
and status = 'Empty';

select * from room_view;

create view Doctor_View AS
select doctorID as ID, doctorName as Name
from doctor
where patientID IN (select patientID from bill
					where amount >= (select avg(amount) from bill));

select * from doctor_view;