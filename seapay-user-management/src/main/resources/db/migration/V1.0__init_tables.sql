CREATE TABLE customers
(
    id serial PRIMARY KEY,
    name int NOT NULL,
    username VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50),
    phone_number VARCHAR(20),
    loyalty_level int
);

CREATE TABLE merchants
(
    id serial PRIMARY KEY,
    name int NOT NULL,
    username VARCHAR(50),
    password VARCHAR(50),
    store_name VARCHAR(50),
    description VARCHAR(100)
);

CREATE TABLE admins
(
    id serial PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO customers (name, username, password, email, phone_number, loyalty_level) VALUES ('Mathisa', 'mathias', 'password', 'aa@g.com', '62828', 0);
INSERT INTO merchants (name, username, password, store_name, description) VALUES ('Compfest', 'compfest', 'password', 'Compfest', 'Toko compfest');
INSERT INTO admins (username, password) VALUES ('admin', 'admin');
