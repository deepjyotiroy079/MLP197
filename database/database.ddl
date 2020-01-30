-- change this to your team id
use MLP197;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table
create table EMPLOYEE (EMP_ID int primary key);


-- EMPLOYEE TABLE TO CONTAIN DATA OF ALL EMPLOYEE
CREATE TABLE EMPLOYEES(
	EMP_ID INT(5) AUTO_INCREMENT,
  EMP_FULL_NAME VARCHAR(25) NOT NULL,
  EMP_EMAIL VARCHAR(25),
  EMP_MOBILE BIGINT(10),
  EMP_DATE_OF_JOINING DATE NOT NULL,
  EMP_DESIGNATION VARCHAR(10) NOT NULL,
  EMP_DEPARTMENT VARCHAR(25) NOT NULL,
  EMP_LEAVE_BALANCE INT(10) UNSIGNED NOT NULL,
  EMP_MANAGER_ID INT(5),
  CONSTRAINT EMP_ID_PK PRIMARY KEY (EMP_ID),
  CONSTRAINT EMP_MANAGER_ID_FK FOREIGN KEY (EMP_MANAGER_ID) REFERENCES EMPLOYEES(EMP_ID),
  CONSTRAINT EMP_EMAIL_UQ UNIQUE (EMP_EMAIL),
  CONSTRAINT EMP_MOBILE_UQ UNIQUE (EMP_MOBILE)
);

-- LEAVE TABLE TO CONTAIN LEAVE DETAILS
CREATE TABLE LEAVE_DETAILS(
	LEAVE_ID INT AUTO_INCREMENT,
  LEAVE_START_DATE DATE NOT NULL,
  LEAVE_END_DATE DATE NOT NULL,
  LEAVE_TYPE ENUM('EARNED_LEAVE', 'OPTIONAL_LEAVE', 'SICK_LEAVE') NOT NULL,
  LEAVE_REASON TEXT,
  LEAVE_STATUS ENUM('PENDING','APPROVED','DENIED') NOT NULL DEFAULT 'PENDING',
  LEAVE_APPLIED_ON DATETIME DEFAULT CURRENT_TIMESTAMP,
  EMP_ID INT NOT NULL,
  LEAVE_COMMENT TEXT,
  CONSTRAINT LEAVE_ID_PK PRIMARY KEY (LEAVE_ID),
  CONSTRAINT EMP_ID_PK FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEES(EMP_ID)
);


