<h1>Introduction</h1>
Web Application which have job portal features

<h2>Outline</h2>
1. Java EE 7
2. Spring MVC 3.2.4

<h2>Setup</h2>
TODO
# create table appuser ( id bigserial primary key, uuid varchar(36), first_name varchar(50) NOT NULL, last_name varchar(50), email varchar(100) NOT NULL);


# create table job_seeker(id bigserial not null primary key, first_name varchar(50), last_name varchar(50),email varchar(100), address varchar(2000), college_code varchar(10),edu_background varchar(2000), mobile_num varchar(11), photo bytea, resume bytea);



export DATABASE_URL=postgres://username:pwd@hostname:port/db
