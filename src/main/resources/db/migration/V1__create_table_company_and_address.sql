CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Create table address
CREATE TABLE IF NOT EXISTS address (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cep VARCHAR(10) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(2),
    district VARCHAR(50)
);

-- Create table company
CREATE TABLE IF NOT EXISTS company (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(30) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP,
    address_id UUID NOT NULL,
    CONSTRAINT fk_address FOREIGN KEY(address_id) REFERENCES address(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_company_address_id ON company(address_id);