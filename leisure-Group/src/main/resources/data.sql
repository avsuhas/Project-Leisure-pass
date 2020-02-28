DROP TABLE IF EXISTS Customer;
 
CREATE TABLE Customer (
  pass_id integer NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  home_city VARCHAR(15),
  pass_city VARCHAR(15),
  issued_date timestamp,
  expiry_date timestamp,
  status VARCHAR(10) NOT NULL,
  vendor_id VARCHAR(10),
  primary key(pass_id)
);

--Loading dummy data for demo
INSERT INTO Customer values (1,'Bob','Pinciotti','Point place','Wisconsin',sysdate-20,sysdate+10,'CANCELLED','01c12');
INSERT INTO Customer values (2,'Donna','Pinciotti','Fair Haven','Austria',sysdate-40,sysdate-5,'EXPIRED','9750c');
INSERT INTO Customer values (3,'Midge','Pinciotti','Achusnet','Nantucket',sysdate,sysdate+30,'ACTIVE','c1e0f');
INSERT INTO Customer values (4,'Eric','Forman','Highland','Stow',sysdate-5,sysdate+25,'ACTIVE','176d0');
INSERT INTO Customer values (5,'Red','Forman','New Bedford','Vermont',sysdate,sysdate+30,'ACTIVE','37ff0');
 
