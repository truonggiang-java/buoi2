create database management;
use management;

create table users(
	id int not null auto_increment,
    name varchar(50) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    is_active tinyint(1),
    phone varchar(11),
    address varchar(200),
    dob date,
    roles int not null,
    primary key(id)
);

-- insert users
--    admin/admin with both roles: ROLE_USER & ROLE_ADMIN
--    user1/user1 with role: ROLE_USER
--    user2/user2 with role: ROLE_USER
insert into users (name,email, password, roles) values
    ('admin',"admin@gmail.com", '$2a$10$mNnPVz3Z2kFdesKhIyBjjOWoD7Fpy1Ad8qfADHHA8fa8VD31jTjnu', 3),
    ('user1',"user1@gmail.com", '$2a$10$9/X3PN281mbqw7rDpaUeFezyxIZtfXRivJAM/H9HYgpg9nQyzcsCS', 2),
    ('user2',"user2@gmail.com", '$2a$10$y084f/w4MCXcVqaVKLy9nusFdrM8ZjydjdSeWbyy85yVEP9RO/bbO', 2);

create table employee(
	id int not null auto_increment,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(50) not null,
    address varchar(60) not null,
    phone varchar(11),
    sex varchar(50),
    jobTitle varchar(50),
    department_id int,
    position_id int,
    groups_id int,
    primary key(id)
);

create table department(
	id int not null auto_increment,
    name varchar(100) not null,
    SDTPB varchar(11),
    address varchar(100),
    corePB varchar(50) not null,
    primary key(id)
);

create table positionVP(
	id int not null auto_increment,
    name_position varchar(100) not null,
    primary key(id)
);


create table groupsNV(
	id int not null auto_increment,
    primary key(id),
    name varchar(50),
    create_date timestamp
    
)