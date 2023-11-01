CREATE TABLE IF NOT EXISTS promo_email(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 email text not null unique
);