BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, addresses, landmarks, hotels, routes, routes_landmarks;

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

CREATE TABLE landmarks (
    id serial PRIMARY KEY,
    address_id int REFERENCES addresses(id),
	name varchar,
    type varchar NOT NULL,
	description varchar NOT NULL,
	average_rating int,
    img_URL varchar NOT NULL
);


CREATE TABLE hotels (
    id serial PRIMARY KEY,
    address_id int REFERENCES addresses(id),
    star_rating int NOT NULL,
    name varchar
);

CREATE TABLE routes (
    id serial PRIMARY KEY,
    user_id int REFERENCES users(user_id),
    hotel_id int NOT NULL,
    created_date date NOT NULL,
	name varchar
);

CREATE TABLE routes_landmarks(
    route_id int NOT NULL,
    landmark_id int NOT NULL,
    PRIMARY KEY(route_id, landmark_id)
);

COMMIT TRANSACTION;
