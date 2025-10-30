CREATE TABLE users (
    id CHAR(11) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(255),
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    isActive BOOLEAN NOT NULL DEFAULT FALSE,
    civilStatus VARCHAR(20),
    profession VARCHAR(50),
    gender CHAR(1)
);