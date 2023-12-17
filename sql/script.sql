-- DDL Script (Create Table)
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    creation_date DATE NOT NULL
);

-- DML Script (Insert Data)
INSERT INTO Products (product_id, product_name, description, price, stock_quantity, is_available, creation_date)
VALUES
    (1, 'Bike', 'Description A', 19.99, 100, true, '2023-01-01'),
    (2, 'Quad', 'Description B', 29.99, 50, false, '2023-01-02'),
    (3, 'Motocross', 'Description C', 39.99, 75, true, '2023-01-03'),
    (4, 'Skateboard', 'Description D', 49.99, 30, true, '2023-01-04'),
    (5, 'VTT', 'Description E', 59.99, 20, false, '2023-01-05');
