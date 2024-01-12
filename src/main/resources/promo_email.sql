CREATE TABLE IF NOT EXISTS promo_email(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 email text not null unique
);

CREATE TABLE IF NOT EXISTS promo_feedback(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 topic text,
 name text,
 email text,
 message text
);