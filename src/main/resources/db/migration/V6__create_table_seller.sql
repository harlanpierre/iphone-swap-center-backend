-- Create table seller
CREATE TABLE IF NOT EXISTS seller (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    value_liquid DOUBLE PRECISION NOT NULL,
    value_gross DOUBLE PRECISION NOT NULL,
    discount DOUBLE PRECISION,
    percent_disc DOUBLE PRECISION,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id UUID NOT NULL,
    client_id UUID NOT NULL,
    company_id UUID NOT NULL,
    CONSTRAINT fk_seller_user FOREIGN KEY(user_id) REFERENCES "user"(id),
    CONSTRAINT fk_seller_client FOREIGN KEY(client_id) REFERENCES client(id),
    CONSTRAINT fk_seller_company FOREIGN KEY(company_id) REFERENCES company(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_seller_user_id ON seller(user_id);
CREATE INDEX IF NOT EXISTS idx_seller_client_id ON seller(client_id);
CREATE INDEX IF NOT EXISTS idx_seller_company_id ON seller(company_id);