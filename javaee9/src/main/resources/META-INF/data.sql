CREATE TABLE IF NOT EXISTS PRODUCT (ID BIGINT AUTO_INCREMENT PRIMARY KEY, DESCRIPTION VARCHAR(255), NAME VARCHAR(255), PRICE DECIMAL(10, 2) );

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE) VALUES (1, 'Laptop', 'High-performance laptop', 999.99);
INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE) VALUES (2, 'Smartphone', 'Latest smartphone model', 599.99);
INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE) VALUES (3, 'Headphones', 'Noise-cancelling headphones', 199.99);
