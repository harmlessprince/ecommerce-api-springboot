CREATE TABLE IF NOT EXISTS addresses
(
    id                  INT                  NOT NULL AUTO_INCREMENT,
    city                VARCHAR(255)         NULL,
    is_default          TINYINT(1) DEFAULT 0 NULL,
    postal_code         VARCHAR(255)         NULL,
    street              VARCHAR(255)         NULL,
    street_number       VARCHAR(255)         NULL,
    local_government_id INT                  NULL,
    state_id            INT                  NULL,
    user_id             INT                  NULL,
    created_date        datetime             NULL,
    last_modified_date  datetime             NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS addresses_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS brands
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255) NULL,
    slug               VARCHAR(255) NOT NULL,
    logo               VARCHAR(255) NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS brands_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS categories
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255) NOT NULL,
    parent_id          INT          NULL,
    slug               VARCHAR(255) NOT NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categories_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS countries
(
    id                 INT                  NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255)         NOT NULL,
    status             TINYINT(1) DEFAULT 1 NULL,
    created_date       datetime             NULL,
    last_modified_date datetime             NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS countries_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS files
(
    id                 INT                  NOT NULL AUTO_INCREMENT,
    created_date       datetime             NULL,
    custom_id          VARCHAR(255)         NULL,
    last_modified_date datetime             NULL,
    mime_type          VARCHAR(255)         NOT NULL,
    name               VARCHAR(255)         NOT NULL,
    provider           VARCHAR(255)         NOT NULL,
    status             TINYINT(1) DEFAULT 1 NOT NULL,
    type               VARCHAR(255)         NOT NULL,
    url                VARCHAR(255)         NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS files_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS local_governments
(
    id                 INT                  NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255)         NOT NULL,
    status             TINYINT(1) DEFAULT 1 NULL,
    state_id           INT                  NULL,
    created_date       datetime             NULL,
    last_modified_date datetime             NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS  hibernate_sequences
(
    sequence_name VARCHAR(255) NOT NULL,
    next_val      INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS local_governments_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS payment_methods
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255) NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS payment_methods_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS product_categories
(
    product_id  INT NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (product_id, category_id)
);

CREATE TABLE IF NOT EXISTS product_images
(
    id                 INT      NOT NULL AUTO_INCREMENT,
    product_id         INT      NULL,
    created_date       datetime NULL,
    last_modified_date datetime NULL,
    file_id            INT      NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_images_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS product_item_variations
(
    product_item_id     INT NOT NULL,
    variation_option_id INT NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (product_item_id, variation_option_id)
);

CREATE TABLE IF NOT EXISTS product_items
(
    id                 INT            NOT NULL AUTO_INCREMENT,
    price              DECIMAL(10, 2) NULL,
    quantity_in_stock  INT            NULL,
    sale_price         DECIMAL(10, 2) NULL,
    sku                VARCHAR(255)   NULL,
    product_id         INT            NULL,
    created_date       datetime       NULL,
    last_modified_date datetime       NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_items_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    `description`      LONGTEXT     NULL,
    image_url          LONGTEXT     NULL,
    name               VARCHAR(255) NULL,
    brand_id           INT          NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS states
(
    id         INT                  NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255)         NOT NULL,
    status     TINYINT(1) DEFAULT 1 NULL,
    country_id INT                  NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS states_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    address            VARCHAR(255) NULL,
    created_date       datetime     NULL,
    email              VARCHAR(255) NOT NULL,
    full_name          VARCHAR(255) NULL,
    last_modified_date datetime     NULL,
    password           VARCHAR(255) NOT NULL,
    phone_number       VARCHAR(255) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS variation_options
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    slug               VARCHAR(255) NOT NULL,
    value              VARCHAR(255) NULL,
    variation_id       INT          NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS variation_options_seq
(
    next_val BIGINT NULL
);

CREATE TABLE IF NOT EXISTS variations
(
    id                 INT          NOT NULL AUTO_INCREMENT,
    name               VARCHAR(255) NULL,
    slug               VARCHAR(255) NOT NULL,
    category_id        INT          NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS variations_seq
(
    next_val BIGINT NULL
);

ALTER TABLE countries
    ADD CONSTRAINT countries_uq_name UNIQUE (name);

ALTER TABLE variation_options
    ADD CONSTRAINT variation_options_uq_slug UNIQUE (slug);

ALTER TABLE users
    ADD CONSTRAINT users_email_uq UNIQUE (email);

ALTER TABLE variations
    ADD CONSTRAINT variations_slug_uq UNIQUE (slug);

ALTER TABLE states
    ADD CONSTRAINT states_uq_name UNIQUE (name);

ALTER TABLE categories
    ADD CONSTRAINT categories_slug_uq UNIQUE (slug);

ALTER TABLE brands
    ADD CONSTRAINT brands_slug_uq UNIQUE (slug);

ALTER TABLE local_governments
    ADD CONSTRAINT local_governments_name_uq UNIQUE (name);

ALTER TABLE categories
    ADD CONSTRAINT categories_name_uq UNIQUE (name);

CREATE INDEX idx_name ON products (name);

CREATE INDEX idx_parent_id ON categories (parent_id);

ALTER TABLE addresses
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION;

CREATE INDEX idx_user_id ON addresses (user_id);

ALTER TABLE addresses
    ADD CONSTRAINT fk_local_government_id FOREIGN KEY (local_government_id) REFERENCES local_governments (id) ON DELETE NO ACTION;

CREATE INDEX idx_local_government_id ON addresses (local_government_id);

ALTER TABLE product_items
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE NO ACTION;

CREATE INDEX idx_product_id ON product_items (product_id);

ALTER TABLE product_item_variations
    ADD CONSTRAINT fk_product_item_id FOREIGN KEY (product_item_id) REFERENCES product_items (id) ON DELETE NO ACTION;

ALTER TABLE variation_options
    ADD CONSTRAINT fk_variation_id FOREIGN KEY (variation_id) REFERENCES variations (id) ON DELETE NO ACTION;

CREATE INDEX idx_variation_id ON variation_options (variation_id);

ALTER TABLE variations
    ADD CONSTRAINT fk_category_id_on_variations FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE NO ACTION;

CREATE INDEX idx_category_id ON variations (category_id);

ALTER TABLE products
    ADD CONSTRAINT fk_brand_id FOREIGN KEY (brand_id) REFERENCES brands (id) ON DELETE NO ACTION;

CREATE INDEX idx_brand_id ON products (brand_id);

ALTER TABLE product_categories
    ADD CONSTRAINT fk_category_id_on_product_categories FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE;

CREATE INDEX idx_category_id ON product_categories (category_id);

ALTER TABLE local_governments
    ADD CONSTRAINT fk_state_id_for_local_governments FOREIGN KEY (state_id) REFERENCES states (id) ON DELETE NO ACTION;

CREATE INDEX idx_state_id ON local_governments (state_id);

ALTER TABLE product_images
    ADD CONSTRAINT fk_file_id FOREIGN KEY (file_id) REFERENCES files (id) ON DELETE NO ACTION;

CREATE INDEX idx_file_id ON product_images (file_id);

ALTER TABLE product_categories
    ADD CONSTRAINT fk_product_id_for_product_categories FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

ALTER TABLE product_item_variations
    ADD CONSTRAINT fk_variation_option_id FOREIGN KEY (variation_option_id) REFERENCES variation_options (id) ON DELETE NO ACTION;

CREATE INDEX idx_variation_option_id ON product_item_variations (variation_option_id);

ALTER TABLE addresses
    ADD CONSTRAINT fk_state_id_for_addresses FOREIGN KEY (state_id) REFERENCES states (id) ON DELETE NO ACTION;

CREATE INDEX idx_state_id ON addresses (state_id);

ALTER TABLE product_images
    ADD CONSTRAINT fk_product_id_for_product_images FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

CREATE INDEX idx_product_id ON product_images (product_id);

ALTER TABLE states
    ADD CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES countries (id) ON DELETE SET NULL;

CREATE INDEX idx_country_id ON states (country_id);