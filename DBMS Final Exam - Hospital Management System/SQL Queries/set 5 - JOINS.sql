use Hospital;

/*INNER_JOIN*/
select p.patientID, p.patientName, m.name, m.price
from patient p
INNER JOIN Medicine m
ON p.patientID = m.patientID
where m.price > 7000
order by(patientID);

select p.patientID, p.patientName, p.admitDate, r.roomID
from patient p
INNER JOIN Room r
ON p.patientID = r.patientID
where r.roomType like 'Semi Private'
and p.admitDate >= '2005-01-01'
group by (p.patientID);

/*--LEFT_OUTER_JOIN;*/
select staffID, staffName, n.roomID, roomType
from Nurse n
LEFT OUTER JOIN Room r
ON n.roomID = r.roomID
where gender = 'M';

select  n.roomID, staffID, staffName,roomType
from Room r
LEFT OUTER JOIN Nurse n
ON n.roomID = r.roomID
where roomType = 'Emergency';

/*--RIGHT_OUTER_JOIN*/
select m.name as Medicine_Name, p.patientID, p.patientName as Patient_Name, m.price
from medicine m
RIGHT OUTER JOIN Patient p
ON m.patientID = p.patientID
where admitDate >= '2014-01-01';

select p.patientID, p.patientName as Patient_Name, admitDate, d.doctorName as Doctor_Name, d.specialization
from Patient p
RIGHT OUTER JOIN Doctor d
ON p.patientID = d.patientID
order by (p.patientID);

/*--FULL JOIN*/
select *
from Nurse n 
LEFT OUTER JOIN Room r
ON n.roomID = r.roomID
UNION
select *
from Nurse n 
RIGHT OUTER JOIN Room r
ON n.roomID = r.roomID;

/*--CROSS JOIN*/
select *
from Patient p, Doctor d