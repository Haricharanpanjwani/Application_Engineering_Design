use Hospital;

/*Grant all access to admin for the database*/
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON Hospital.* TO 'admin'@'localhost';

/*Grant only select, insert access to the tables for developer*/
CREATE USER 'developer'@'localhost' IDENTIFIED BY 'developer';
GRANT SELECT, INSERT ON Hospital.PATIENT TO 'developer'@'localhost';


/*Grant only select, insert access to the tables for tester*/
CREATE USER 'tester'@'localhost' IDENTIFIED BY 'tester';
GRANT SELECT, INSERT ON Hospital.PATIENT TO 'tester'@'localhost';
GRANT SELECT, INSERT ON Hospital.RECEPTIONIST TO 'tester'@'localhost';

/*revoke access*/
REVOKE INSERT ON ​ALL​ FROM 'tester'@'localhost';

/*Grant only select, insert access to some columns of the tables for user*/
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';
GRANT SELECT(patientID, patientName,gender), INSERT(patientID, patientName, Dob, gender,admitDate,releaseDate) 
ON hospital.PATIENT TO 'user'@'localhost';

DROP USER 'admin'@'localhost';