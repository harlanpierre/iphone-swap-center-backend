-- Create table product
CREATE TABLE IF NOT EXISTS product (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     name VARCHAR(255) NOT NULL,
     stock INTEGER NOT NULL,
     priceUnit DOUBLE PRECISION NOT NULL,
     description VARCHAR(255),
     status BOOLEAN NOT NULL DEFAULT TRUE,
     brand VARCHAR(50),
     create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     update_at TIMESTAMP,
     user_id UUID NOT NULL,
     user_update_id UUID NOT NULL,
     company_id UUID NOT NULL,
     CONSTRAINT fk_product_user FOREIGN KEY(user_id) REFERENCES "user"(id),
     CONSTRAINT fk_product_user_update FOREIGN KEY(user_update_id) REFERENCES "user"(id),
     CONSTRAINT fk_product_company FOREIGN KEY(company_id) REFERENCES company(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_product_user_id ON product(user_id);
CREATE INDEX IF NOT EXISTS idx_product_user_update_id ON product(user_update_id);
CREATE INDEX IF NOT EXISTS idx_product_company_id ON product(company_id);