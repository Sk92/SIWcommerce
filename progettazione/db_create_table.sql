CREATE TABLE customers
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    address VARCHAR(40),
    date_of_birth DATE,
    user_id NUMERIC(131089)
);
CREATE TABLE openjpa_sequence_table
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    sequence_value NUMERIC(131089)
);
CREATE TABLE order_lines
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    sell_price DOUBLE PRECISION,
    quantity NUMERIC(131089),
    product_id NUMERIC(131089),
    order_id NUMERIC(131089)
);
CREATE TABLE orders
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    created_at DATE,
    closed_at DATE,
    processed_at DATE,
    customer_id NUMERIC(131089)
);
CREATE TABLE products
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    name VARCHAR(40),
    code VARCHAR(20),
    description VARCHAR,
    price DOUBLE PRECISION,
    stock_quantity NUMERIC(131089),
    provider_id NUMERIC(131089)
);
CREATE TABLE providers
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    vat VARCHAR(40),
    phone_number VARCHAR(40),
    email VARCHAR(40),
    address VARCHAR(40)
);
CREATE TABLE users
(
    id NUMERIC(131089) PRIMARY KEY NOT NULL,
    email VARCHAR(40),
    password VARCHAR(40),
    name VARCHAR(40),
    last_name VARCHAR(40),
    created_at DATE,
    role VARCHAR(40)
);
ALTER TABLE customers ADD FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE order_lines ADD FOREIGN KEY (order_id) REFERENCES orders (id);
ALTER TABLE order_lines ADD FOREIGN KEY (product_id) REFERENCES products (id);
ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES customers (id);
ALTER TABLE products ADD FOREIGN KEY (provider_id) REFERENCES providers (id);
