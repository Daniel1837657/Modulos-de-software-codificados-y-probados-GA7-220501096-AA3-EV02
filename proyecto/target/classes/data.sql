-- Tabla products
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10,2) NOT NULL
);

-- Datos iniciales
INSERT INTO products (name, description, price) VALUES 
('Producto A', 'Descripción del Producto A', 10.50),
('Producto B', 'Descripción del Producto B', 25.00),
('Producto C', 'Descripción del Producto C', 15.75);
