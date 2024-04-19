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

CREATE TABLE IF NOT EXISTS facebook_user(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 email text not null unique,
 facebook_id text,
 facebook_name text
);

CREATE INDEX idx__facebook_user__id
    ON facebook_user (id);

CREATE INDEX idx__facebook_user__email
    ON facebook_user (email);

CREATE TABLE IF NOT EXISTS google_user(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 google_email text not null unique,
 google_name text,
 google_user_attributes text
);

CREATE INDEX idx__google_user__id
    ON google_user (id);

CREATE INDEX idx__google_user__email
    ON google_user (google_email);