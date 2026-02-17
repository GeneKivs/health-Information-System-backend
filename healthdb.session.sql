create database healthdb;
CREATE TABLE healthPrograms(
   health_Programid iNT NOT NULL auto_increment,
   health_Program_Name varchar(50),
   description varchar(255),
   createdAt timestamp DEFAULT CURRENT_TIMESTAMP not null,
   updatedAT timestamp default current_timestamp not null,
  PRIMARY KEY (health_Programid)
);


CREATE TABLE clients(
    clientid INT NOT NULL AUTO_INCREMENT,
    first_Name VARCHAR(50),
    last_Name VARCHAR(50),
    age INT,
    phone_Number VARCHAR(15),
	createdAt timestamp DEFAULT CURRENT_TIMESTAMP not null,
	updatedAT timestamp default current_timestamp not null,
    PRIMARY KEY (clientid)

);

create table enrollments(
enrollmentid bigint not null auto_increment,
clientid int not null,
health_Programid int not null,
createdAt timestamp DEFAULT CURRENT_TIMESTAMP not null,
updatedAT timestamp default current_timestamp not null,
primary key (enrollmentid),
foreign key (clientid) references clients(clientid),
foreign key (health_Programid) references healthPrograms(health_Programid)

);
