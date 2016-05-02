/*Fuctions*/

select count(*) as Total_Count 
from patient 
where admitDate >= '2010-01-01';

select avg(amount) as Average
from bill
where patientID = 18; 

select patientID as ID, amount as Amount 
from bill
where abs(amount-9000) <= 1000;

select max(patientName) from patient;

select strcmp(p.patientName, d.doctorName) as Result
from Patient p
INNER JOIN Doctor d
ON p.patientID = d.patientID;

select * from patient 
where admitDate = (cast(curdate() as Date));

select version(), connection_id(), database(), schema();

select curdate(), now();

select year('2015-12-12') as year, quarter('2012-01-01'), hour('12:08:10');

select upper(patientName) as Upper_Name, ucase(patientName) as Name,
lower(patientName) as Lower_Name
from patient
LIMIT 10;