BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, addresses, types, landmarks, hotels, routes, routes_landmarks, review;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE addresses (
    id serial PRIMARY KEY,
    long_lat varchar,
    street varchar,
    city varchar,
    state varchar,
    zip int
);
CREATE TABLE types(
    id serial PRIMARY KEY,
    name varchar
);
CREATE TABLE landmarks (
    id serial PRIMARY KEY,
    address_id int REFERENCES addresses(id),
	name varchar,
    type int REFERENCES types(id),
	description varchar NOT NULL,
	likes int,
    img_URL varchar NOT NULL
);
CREATE TABLE hotels (
    id serial PRIMARY KEY,
    address_id int REFERENCES addresses(id),
    name varchar
);
CREATE TABLE routes (
    id serial PRIMARY KEY,
    user_id int REFERENCES users(user_id),
    start_id int REFERENCES addresses(id),
    created_date date NOT NULL,
	name varchar
);
CREATE TABLE routes_landmarks(
    route_id int NOT NULL,
    landmark_id int NOT NULL,
    PRIMARY KEY(route_id, landmark_id)
);

CREATE TABLE review(
    id serial PRIMARY KEY,
    landmark_id int REFERENCES landmarks(id),
    user_id int REFERENCES users(user_id),
    description varchar
);

COMMIT TRANSACTION;
