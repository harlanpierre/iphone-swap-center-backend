-- Create table user
CREATE TABLE IF NOT EXISTS "user" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(30) NOT NULL,
    status BOOLEAN NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP,
    address_id UUID NOT NULL,
    company_id UUID NOT NULL,
    CONSTRAINT fk_user_address FOREIGN KEY(address_id) REFERENCES address(id),
    CONSTRAINT fk_user_company FOREIGN KEY(company_id) REFERENCES company(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_user_address_id ON "user"(address_id);
CREATE INDEX IF NOT EXISTS idx_user_company_id ON "user"(company_id);