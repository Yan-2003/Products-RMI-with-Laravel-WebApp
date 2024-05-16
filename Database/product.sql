CREATE TABLE product_db (
    id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    quantity INT,
    retailPrice DOUBLE,
    storePrice DOUBLE,
    PRIMARY KEY(id)
);
/* this is the model schema of the products use a MySQL database. */