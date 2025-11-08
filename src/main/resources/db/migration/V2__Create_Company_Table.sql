CREATE TABLE companies (
    cnpj VARCHAR(14) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(255),
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    is_Active BOOLEAN DEFAULT TRUE,
    company_Name VARCHAR(100) NOT NULL,
    contact_Person VARCHAR(100),
    account_Type VARCHAR(50)
);