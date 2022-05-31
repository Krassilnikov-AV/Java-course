CREATE TABLE customers_1 (
id serial PRIMARY KEY,
name text UNIQUE NOT NULL
);

CREATE TABLE products_1 (
id serial PRIMARY KEY,
name text UNIQUE NOT NULL,
price double precision NOT NULL
);

CREATE TABLE customer_product_1 (

customer_id INT(11) NOT NULL,
product_id INT(11) NOT NULL,
product_price double precision NOT NULL,

PRIMARY KEY (customer_id, product_id, product_price)

CONSTRAINT fk_customer FOREIGN KEY (customer_id)
REFERENCES customers(id)
ON DELETE NO ACTION ON UPDATE NO ACTION,

CONSTRAINT fk_product FOREIGN KEY (product_id)
REFERENCES products (id)
ON DELETE NO ACTION ON UPDATE NO ACTION,
);
