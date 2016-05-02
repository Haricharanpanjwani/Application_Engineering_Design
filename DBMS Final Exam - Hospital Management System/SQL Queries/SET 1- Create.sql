create database Hospital;

drop database Hospital;

use Hospital;

create table Doctor (
doctorID int  NOT NULL PRIMARY KEY,
doctorName varchar(50),
Dob date,
gender varchar(1),
specialization varchar(50),
patientID int,
CONSTRAINT fk_patient FOREIGN KEY (patientID) 
REFERENCES Patient(patientID)
);

create table Patient (
patientID int  NOT NULL PRIMARY KEY,
patientName varchar(50),
Dob date,
gender varchar(1),
admitDate date,
releaseDate date,
receptionistID int,
CONSTRAINT fk_rec FOREIGN KEY (receptionistID) 
REFERENCES Receptionist(receptionistID)
);

create table Room (
roomID int  NOT NULL PRIMARY KEY,
roomType varchar(50),
status varchar(25),
patientID int,
CONSTRAINT fk_patientRoom FOREIGN KEY (patientID) 
REFERENCES Patient(patientID)
);

create table Nurse (
staffID int  NOT NULL PRIMARY KEY,
staffName varchar(50),
gender varchar(1),
roomID int,
CONSTRAINT fk_room FOREIGN KEY (roomID) 
REFERENCES Room(roomID)
);

create table Receptionist (
receptionistID int  NOT NULL PRIMARY KEY,
receptionistName varchar(50),
gender varchar(1)
);

create table Bill (
billNo int  NOT NULL PRIMARY KEY,
amount decimal(10,2),
patientID int,
CONSTRAINT fk_patientBill FOREIGN KEY (patientID) 
REFERENCES Patient(patientID)
);

create table Medicine (
medicineCode int  NOT NULL PRIMARY KEY,
name varchar(200),
quantity int,
price int,
patientID int,
CONSTRAINT fk_patientMedicine FOREIGN KEY (patientID) 
REFERENCES Patient(patientID)
);
