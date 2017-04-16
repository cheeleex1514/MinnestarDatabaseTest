-- Chee M. Lee
-- Project step: 3
CREATE DATABASE db_minnestar;

USE db_minnestar;

-- Phone table [1]
CREATE TABLE phone_number(
	phone_id 						varchar(10),
  area_code 					int,
  prefix_line_number 	int,
  creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (phone_id)
);

-- State table [2]
CREATE TABLE state(
	state_code_id       varchar(10),
  state_abreviation   varchar(2),
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (state_code_id)
);

-- Address table [3]
CREATE TABLE address(
	address_id         varchar(10),
  house_number       int,
  street_name        varchar(20),
  city_name          varchar(20),
  state_code_id      varchar(10),
  zip_code           int,
  apt_number         int,
	creation_date 		 datetime default current_timestamp,
  update_date 			 datetime on update current_timestamp default current_timestamp,
	primary key (address_id),
	CONSTRAINT FK_address_state_code_id FOREIGN KEY (state_code_id) REFERENCES state(state_code_id)
);

-- Branch table [4]
CREATE TABLE branch(
  branch_id 					varchar(10),
  branch_name 				varchar(50),
  address_id 					varchar(10),
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (branch_id),
	CONSTRAINT FK_branch_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

-- Employee_type table [5]
CREATE TABLE employee_type(
  emp_type_id 				varchar(10),
  emp_type						varchar(50),
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (emp_type_id)
);

-- Employee table [6]
CREATE TABLE employee(
	emp_id		           varchar(10),
	emp_first_name		   varchar(20),
	emp_middle_name		   char,
	emp_last_name		     varchar(20),
	emp_ssn							 varchar(9),
	address_id           varchar(10),
  phone_id             varchar(10),
  emp_type_id          varchar(10),
  branch_id            varchar(10),
	creation_date 			 datetime default current_timestamp,
  update_date 				 datetime on update current_timestamp default current_timestamp,
	primary key (emp_id),
	CONSTRAINT FK_emp_address_id FOREIGN KEY (address_id) REFERENCES address(address_id),
	CONSTRAINT FK_emp_phone_id FOREIGN KEY (phone_id) REFERENCES phone_number(phone_id),
	CONSTRAINT FK_emp_emp_type_id FOREIGN KEY (emp_type_id) REFERENCES employee_type(emp_type_id),
	CONSTRAINT FK_emp_branch_id FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
);

-- Account_type table [7]
CREATE TABLE account_type(
  account_type_id 		varchar(10),
  account_type 				varchar(10),
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (account_type_id)
);

-- Account table [8]
CREATE TABLE account(
  account_id 					varchar(10),
  account_type_id 		varchar(10),
	account_balance			int,
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (account_id),
	CONSTRAINT FK_acct_account_type_id FOREIGN KEY (account_type_id) REFERENCES account_type(account_type_id)
);

-- Client table [9]
CREATE TABLE client(
  client_id 					varchar(10),
  client_first_name   varchar (20),
  client_middle_name  char,
  client_last_name    varchar (20),
	client_gender				char,
  client_email        varchar(50),
  address_id          varchar(10),
  phone_id            varchar(10),
  branch_id           varchar(10),
  emp_id              varchar(10),
  account_id 					varchar(10),
	creation_date 			datetime default current_timestamp,
  update_date 				datetime on update current_timestamp default current_timestamp,
	primary key (client_id),
	CONSTRAINT FK_client_address_id FOREIGN KEY (address_id) REFERENCES address(address_id),
	CONSTRAINT FK_client_phone_id FOREIGN KEY (phone_id) REFERENCES phone_number(phone_id),
	CONSTRAINT FK_client_branch_id FOREIGN KEY (branch_id) REFERENCES branch(branch_id),
	CONSTRAINT FK_client_emp_id FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
	CONSTRAINT FK_client_account_id FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Asset table [10]
CREATE TABLE asset(
	asset_id		     varchar(10),
	asset_maker		   varchar(20),
	asset_type		   varchar(20),
	emp_id	         varchar(10),
	creation_date 	 datetime default current_timestamp,
  update_date 		 datetime on update current_timestamp default current_timestamp,
	primary key (asset_id)
);

-- Insert Phone table [1]
INSERT INTO phone_number VALUES('ph001', 612, 7662233, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph002', 612, 2213322, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph003', 612, 4422220, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph004', 763, 5252145, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph005', 763, 7890967, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph006', 763, 5783449, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph007', 651, 8985432, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph008', 651, 4442424, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph009', 612, 9300009, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph010', 612, 5014351, DEFAULT, DEFAULT);

INSERT INTO phone_number VALUES('ph011', 612, 2342342, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph012', 612, 2523552, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph013', 612, 4637324, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph014', 763, 9767435, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph015', 763, 7758965, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph016', 763, 6542451, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph017', 651, 0987654, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph018', 651, 2756894, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph019', 612, 4279555, DEFAULT, DEFAULT);
INSERT INTO phone_number VALUES('ph020', 612, 3325667, DEFAULT, DEFAULT);

-- Insert State table [2]
INSERT INTO state VALUES('ST01','MN', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST02','WI', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST03','NH', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST04','NM', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST05','NY', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST06','GA', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST07','CA', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST08','WA', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST09','FL', DEFAULT, DEFAULT);
INSERT INTO state VALUES('ST10','VT', DEFAULT, DEFAULT);

-- Insert Address table [3]
INSERT INTO address VALUES('add001', 111, 'Blakes Street', 'Ramsey', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add002', 222, 'Jeans Street', 'St. Paul', 'ST01', 55443, 205, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add003', 131, 'Growd Street', 'Anoka', 'ST01', 55443, 301, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add004', 444, 'Lakes Street', 'Blaine', 'ST01', 55443, 222, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add005', 555, 'Jared Street', 'Ramsey', 'ST01', 55443, 100, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add006', 666, 'Fulton Street', 'St. Paul', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add007', 901, 'Bellvue Street', 'Ramsey', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add008', 209, 'Lenard Street', 'Minneapolis', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add009', 671, 'Grace Street', 'Minneapolis', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add010', 777, 'Pleasant Street', 'Ramsey', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
-- branches
INSERT INTO address VALUES('add011', 888, 'Johnson Street', 'Ramsey', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add012', 999, 'Creed Street', 'Anoka', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add013', 234, 'Lowrt Street', 'Minneapolis', 'ST01', 55443, 302, DEFAULT, DEFAULT);

INSERT INTO address VALUES('add014', 678, 'Peaks Avenue', 'Anoka', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add015', 932, 'Jefferson Circle', 'Anoka', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add016', 933, 'Boomer Avenue', 'Coon Rapids', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add017', 339, 'Headers Lane', 'Maple Grove', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add018', 383, 'Peaches Valley Road', 'St. Paul', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add019', 776, 'Butternut Street', 'St. Paul', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add020', 102, 'Larson Lane', 'St. Cloud', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add021', 566, 'Penn Avenue', 'Bloomington', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add022', 1023, 'First Avenue', 'Edina', 'ST01', 55443, NULL, DEFAULT, DEFAULT);
INSERT INTO address VALUES('add023', 2334, '3rd Street North', 'Eden Prarie', 'ST01', 55443, NULL, DEFAULT, DEFAULT);

-- Insert Branch table [4]
INSERT INTO branch VALUES('BR001','Ramsey Minnestar Emotional Health Services', 'add011', DEFAULT, DEFAULT);
INSERT INTO branch VALUES('BR002','Anoka Minnestar Emotional Health Services', 'add012', DEFAULT, DEFAULT);
INSERT INTO branch VALUES('BR003','Minneapolis Minnestar Emotional Health Services', 'add013', DEFAULT, DEFAULT);

-- Insert Employee_type table [5]
INSERT INTO employee_type VALUES('ET001', 'Branch Manager', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET002', 'Physical Therapist', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET003', 'Psychologist', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET004', 'Psychiatric Director', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET005', 'IT Director', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET006', 'Pharmacist', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET007', 'Front Desk Administrator', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET008', 'Facilities Engineer', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET009', 'Accountant', DEFAULT, DEFAULT);
INSERT INTO employee_type VALUES('ET010', 'Desktop Support', DEFAULT, DEFAULT);

-- Insert Employee table [6]
INSERT INTO employee VALUES('emp001', 'Jim', 'C', 'Kans', '007080099', 'add014', 'ph011', 'ET004', 'BR001', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp002', 'Jared', 'L', 'Ives', '007776543','add015', 'ph012', 'ET002', 'BR001', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp003', 'Josh', 'M', 'Parson', '007776542', 'add016', 'ph013', 'ET005', 'BR001', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp004', 'Jessica', 'C', 'Danes', '008776543', 'add017', 'ph014', 'ET002', 'BR002', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp005', 'Janis', 'E', 'Lee', '007776541', 'add018', 'ph015', 'ET009', 'BR002', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp006', 'Jill', 'P', 'Lomes', '007776522', 'add019', 'ph016', 'ET009', 'BR002', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp007', 'Judy', 'O', 'Gonzales', '007776333', 'add020', 'ph017', 'ET010', 'BR003', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp008', 'James', 'Y', 'Pho', '007776512', 'add021',  'ph018', 'ET001', 'BR003', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp009', 'Jordan', 'B', 'Deets', '007776500', 'add022',  'ph019', 'ET003', 'BR003', DEFAULT, DEFAULT);
INSERT INTO employee VALUES('emp010', 'Jarvis', 'N', 'Beardman', '007772789', 'add023', 'ph020', 'ET003', 'BR001', DEFAULT, DEFAULT);

-- -- Insert Account_type table [7]
INSERT INTO account_type VALUES('AT001', 'Client', DEFAULT, DEFAULT);

-- Insert Account table [8]
INSERT INTO account VALUES('ACCT101','AT001',350,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT102','AT001',1105,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT103','AT001',2000,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT104','AT001',25,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT105','AT001',545,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT106','AT001',299,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT107','AT001',99,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT108','AT001',89,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT109','AT001',465,DEFAULT,DEFAULT);
INSERT INTO account VALUES('ACCT201','AT001',900,DEFAULT,DEFAULT);

-- -- Insert Client table [9]
INSERT INTO client VALUES('CL111', 'Cherry', 'C', 'Prime', 'F', 'cprime@aol.com', 'add001', 'ph001', 'BR001', 'emp009', 'ACCT101', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL222', 'Claire', 'A', 'Walters', 'F', 'cwalters@yahpp.com', 'add002', 'ph002', 'BR001', 'emp009', 'ACCT102', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL333', 'Clarence', 'B', 'Avian', 'M', 'this_guy@aol.com', 'add003', 'ph003', 'BR001', 'emp009', 'ACCT103', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL444', 'Carly', 'D', 'Travis', 'F', 'sweetBaloons@altavista.com', 'add004', 'ph004', 'BR001', 'emp009', 'ACCT104', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL555', 'David', 'L', 'Mountain', 'M', 'greekGuy@altavista.com', 'add005', 'ph005', 'BR001', 'emp009', 'ACCT101', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL666', 'Lance', 'D', 'Ives', 'M', 'ivory@gmail.com', 'add006', 'ph006', 'BR002', 'emp009', 'ACCT106', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL777', 'Alan', 'Z', 'Zaynes', 'M', 'prettyBoi@gmail.com', 'add007', 'ph007', 'BR002', 'emp009', 'ACCT107', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL888', 'Zachery', 'Q', 'Memphis', 'M', 'doubleTrouble@hotmail.com', 'add008', 'ph008', 'BR002', 'emp010', 'ACCT108', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL999', 'MaryAnn', 'J', 'Williams', 'F', 'flowersRUs@gmail.com', 'add009', 'ph009', 'BR002', 'emp010', 'ACCT109', DEFAULT, DEFAULT);
INSERT INTO client VALUES('CL1111', 'Vincent', 'H', 'Holmes', 'M', 'holmes_construction@cc.com', 'add010', 'ph010', 'BR003', 'emp010', 'ACCT201', DEFAULT, DEFAULT);

-- Insert Asset table [10]
INSERT INTO asset VALUES('AS1001','Nokia','cellphone','emp001',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1002','Dell','laptop','emp002',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1003','Dell','laptop','emp003',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1004','HP','laptop','emp004',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1005','Asus','laptop','emp005',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1006','Apple','cellphone','emp006',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1007','Samsung','cellphone','emp007',DEFAULT,DEFAULT);
INSERT INTO asset VALUES('AS1008','Motorola','cellphone','emp008',DEFAULT,DEFAULT);

commit;