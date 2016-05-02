/*Sub-queries*/
select receptionistID, receptionistName
from receptionist
where receptionistID IN (select receptionistID from patient where patientID = 7)
order by (receptionistID);

select patientID, patientName
from patient
where patientID IN (select patientID from bill where amount > 80000)
order by (patientID);

select doctorName
from doctor
where patientID IN (select patientID from bill
					where amount = (select max(amount) from bill));                    
                    
select patientName
from patient
where patientID < ANY (select patientID from doctor);