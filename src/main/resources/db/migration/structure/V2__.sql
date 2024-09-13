ALTER TABLE files
    ADD owner_id INT NULL;

ALTER TABLE files
    ADD owner_type VARCHAR(255) NULL;

ALTER TABLE brands
    ADD CONSTRAINT uc_brands_name UNIQUE (name);

CREATE INDEX idx_ownerId ON files (owner_id);

CREATE INDEX idx_ownerIdOwnerType ON files (owner_id, owner_type);

CREATE INDEX idx_ownerType ON files (owner_type);

DROP TABLE addresses_seq;

DROP TABLE brands_seq;

DROP TABLE categories_seq;

DROP TABLE countries_seq;

DROP TABLE files_seq;

DROP TABLE local_governments_seq;

DROP TABLE payment_methods_seq;

DROP TABLE product_images_seq;

DROP TABLE product_items_seq;

DROP TABLE products_seq;

DROP TABLE states_seq;

DROP TABLE users_seq;

DROP TABLE variation_options_seq;

DROP TABLE variations_seq;

ALTER TABLE brands
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE categories
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE countries
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE files
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE local_governments
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE payment_methods
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE product_images
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE product_items
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE products
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE states
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE users
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE variation_options
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE variations
    MODIFY id INT AUTO_INCREMENT;

ALTER TABLE brands
    MODIFY name VARCHAR(255) NOT NULL;