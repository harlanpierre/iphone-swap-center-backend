-- Create table junction product_seller
CREATE TABLE IF NOT EXISTS product_seller (
    product_id UUID NOT NULL,
    seller_id UUID NOT NULL,
    quantity INTEGER NOT NULL,
    date_sale TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (product_id, seller_id),
    CONSTRAINT fk_product_seller_product FOREIGN KEY(product_id) REFERENCES product(id),
    CONSTRAINT fk_product_seller_seller FOREIGN KEY(seller_id) REFERENCES seller(id)
);

-- Indexes for faster lookups
CREATE INDEX IF NOT EXISTS idx_product_seller_product_id ON product_seller(product_id);
CREATE INDEX IF NOT EXISTS idx_product_seller_seller_id ON product_seller(seller_id);