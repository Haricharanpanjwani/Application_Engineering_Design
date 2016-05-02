use DBHospital;

select * from patient;

select patientID, patientName
from patient
where releaseDate is NULL;

select receptionistName
from Receptionist
where gender = 'M'
LIMIT 10;

select * 
from Bill
LIMIT 1, 20;

select name, price
from Medicine
where quantity > 44
order by(price);

select doctorName, specialization
from doctor
group by (specialization)
having specialization like 'D%'
ORDER by (DoctorName);


select count(roomID), roomType from Room
where status like 'Empty'
group by(roomType)
order by(roomType)