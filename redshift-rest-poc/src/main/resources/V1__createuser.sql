						

create schema ischool authorization spx;


CREATE TABLE status(
  id bigint PRIMARY KEY DEFAULT nextval('serial'),
  status varchar(150) NOT NULL UNIQUE
);

INSERT INTO status VALUES(1,'Active'),
				  		 (2,'InActive'),
			 	  		 (3,'Pending'),
			 	  		 (4,'done');


CREATE TABLE schools(
  id bigint PRIMARY KEY DEFAULT nextval('serial'),
  code varchar(15) NOT NULL UNIQUE,
  sname varchar(150) NOT NULL,
  dateofestablishment datetime NOT NULL,
  timezone varchar(64) NOT NULL,
  dbname varchar(15) NOT NULL,
  statusid smallint NOT NULL REFERENCES status (id),
  url varchar(50) NOT NULL UNIQUE
);
				   
CREATE TABLE clients(
  id bigint PRIMARY KEY DEFAULT nextval('serial'),
  schoolid bigint NOT NULL REFERENCES schools(id),
  fname varchar(150) NOT NULL,
  lname varchar(150) NOT NULL,
  contactnumber bigint UNIQUE,
  emailid varchar(255) NOT NULL UNIQUE,
  password varchar(255) NOT NULL
);
	

CREATE TABLE clientaddress(
  id bigint PRIMARY KEY DEFAULT nextval('serial'),
  schoolid bigint NOT NULL REFERENCES schools (id),
  doornumber varchar(50) NOT NULL,
  street varchar(150) NOT NULL,
  city varchar(150) NOT NULL,
  state varchar(150) NOT NULL,
  country varchar(150) NOT NULL,
  pin bigint NOT NULL
);


CREATE TABLE demo(
id bigint PRIMARY KEY DEFAULT nextval('serial'),
  product varchar(150) NOT NULL,
  accounttype varchar(150) NOT NULL,
  cardtyple varchar(50) NOT NULL,
  countofprods bigint NOT NULL,
  prodprice float NOT NULL,
  totalprice float NOT NULL
);