-- Create table client
CREATE TABLE IF NOT EXISTS client (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(30) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP,
    user_id UUID NOT NULL,
    user_update_id UUID NOT NULL,
    address_id UUID NOT NULL,
    company_id UUID NOT NULL,
    CONSTRAINT fk_client_user FOREIGN KEY(user_id) REFERENCES "user"(id),
    CONSTRAINT fk_client_user_update FOREIGN KEY(user_update_id) REFERENCES "user"(id),
    CONSTRAINT fk_client_address FOREIGN KEY(address_id) REFERENCES address(id),
    CONSTRAINT fk_client_company FOREIGN KEY(company_id) REFERENCES company(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_client_user_id ON client(user_id);
CREATE INDEX IF NOT EXISTS idx_client_user_update_id ON client(user_update_id);
CREATE INDEX IF NOT EXISTS idx_client_address_id ON client(address_id);
CREATE INDEX IF NOT EXISTS idx_client_company_id ON client(company_id);