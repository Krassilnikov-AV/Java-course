BEGIN
-- CASCADE - удалить все записи, которые используют запсиси данной таблицы
DROP TABLE IF EXISTS manufactures CASCADE;
CREATE TABLE manufactures(id serial PRIMARY KEY, title VARCHAR(255));
INSERT INTO manufactures (title) VALUES ('Coca Cola Company'), ('Danone');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products(id serial PRIMARY KEY,
 title VARCHAR(255),  price numeric(8, 2), manufacturer_id int, FOREIGN KEY (manufacturer_id) REFERENCES
 manufacturers (id));
INSERT INTO products (title,  manufacturer_id, price)
 VALUES ('Sprite', 1, 30.00), ('Fanta', 1, 45.00), ('Product#2', 2, 1005.00);

 DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers(id serial PRIMARY KEY, name VARCHAR(100));
INSERT INTO customers (name) VALUES ('Bob'), ('Jon'), ('Max');

 DROP TABLE IF EXISTS big_items CASCADE;
CREATE TABLE big_items(id serial PRIMARY KEY, val int, junkField, version serial);
INSERT INTO big_items (val) VALUES (10);

COMMIT;