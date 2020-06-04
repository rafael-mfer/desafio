--DROPS
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS profiles;


--DROP SEQUENCE IF EXISTS x;

CREATE TABLE roles
(
    id_role 		INTEGER 	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role 			VARCHAR(15)	NOT NULL
);

CREATE TABLE profiles
(
    id_profile 		INTEGER 	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    profile 		VARCHAR(15) NOT NULL
);

CREATE TABLE users (
    id_user			INTEGER 	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name			VARCHAR(50)	NOT NULL,
    cpf				VARCHAR(14)	NOT NULL UNIQUE,
    birth_date		DATE		NOT NULL,
    id_role 		INTEGER		NOT NULL,
    CONSTRAINT 		fk_id_role FOREIGN KEY (id_role) REFERENCES roles (id_role),
	id_profile 		INTEGER		NOT NULL,
    CONSTRAINT 		fk_id_profile FOREIGN KEY (id_profile) REFERENCES profiles (id_profile)
);

--CREATE SEQUENCES