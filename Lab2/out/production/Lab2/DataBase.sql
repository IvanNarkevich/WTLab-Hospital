CREATE DATABASE IF NOT EXISTS hospital;
USE hospital;

CREATE TABLE IF NOT EXISTS
  departments
(
  id               INT(4) PRIMARY KEY NOT NULL,
  name             VARCHAR(255)       NOT NULL
);
CREATE TABLE IF NOT EXISTS
  doctors
(
  id               INT(4) PRIMARY KEY NOT NULL,
  name             VARCHAR(255),
  birthdate        VARCHAR(10),
  departmentID     INT(4),
  FOREIGN KEY (departmentID) REFERENCES departments (id) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS
  nurses
(
  id               INT(4) PRIMARY KEY NOT NULL,
  name             VARCHAR(255),
  birthdate        VARCHAR(10),
  departmentID     INT(4),
  FOREIGN KEY (departmentID) REFERENCES departments (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS
  patients
(
  id               INT(4) PRIMARY KEY NOT NULL,
  name             VARCHAR(255),
  birthdate        VARCHAR(10),
  admissiondate    VARCHAR(10),
  diagnosis        VARCHAR(255),
  treatment        VARCHAR(255),
  departmentID     INT(4),
  doctorID         INT(4),
  FOREIGN KEY (departmentID) REFERENCES departments (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (doctorID)     REFERENCES doctors (id)     ON DELETE RESTRICT ON UPDATE CASCADE
);