<h1>Introduction</h1>
Web Application which have job portal features

<h2>Outline</h2>
1. Java EE 7
2. Spring MVC 3.2.4

<h2>Setup</h2>
TODO
--
 create table appuser ( id bigserial primary key, uuid varchar(36), first_name varchar(50) NOT NULL, last_name varchar(50), email varchar(100) NOT NULL,password varchar(100) NOT NULL, type varchar(50));
 alter table appuser add constraint unique_email unique(email);

 create table job_seeker(id bigserial not null primary key, first_name varchar(50), last_name varchar(50),email varchar(100), address varchar(2000), college_code varchar(10),edu_background varchar(2000), mobile_num varchar(11), photo bytea, resume bytea);



export DATABASE_URL=postgres://username:pwd@hostname:port/db

--
==> Caveats
initdb /usr/local/var/postgres -E utf8    # create a database
postgres -D /usr/local/var/postgres       # serve that database
postgres -D /usr/local/var/postgres93
PGDATA=/usr/local/var/postgres postgres   # Éalternatively

If builds of PostgreSQL 9 are failing and you have version 8.x installed,
you may need to remove the previous version first. See:
  https://github.com/mxcl/homebrew/issues/issue/2510

To migrate existing data from a previous major version (pre-9.3) of PostgreSQL, see:
  http://www.postgresql.org/docs/9.3/static/upgrading.html

When installing the postgres gem, including ARCHFLAGS is recommended:
  ARCHFLAGS="-arch x86_64" gem install pg

To install gems without sudo, see the Homebrew wiki.

To reload postgresql after an upgrade:
    launchctl unload ~/Library/LaunchAgents/homebrew.mxcl.postgresql.plist
    launchctl load ~/Library/LaunchAgents/homebrew.mxcl.postgresql.plist