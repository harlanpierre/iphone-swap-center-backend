-- Create table product_variant
CREATE TABLE IF NOT EXISTS product_variant (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     color VARCHAR(20),
     serie VARCHAR(50),
     imei VARCHAR(20),
     product_id UUID NOT NULL,
     CONSTRAINT fk_product_variant_product FOREIGN KEY(product_id) REFERENCES product(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_product_variant_product_id ON product_variant(product_id);