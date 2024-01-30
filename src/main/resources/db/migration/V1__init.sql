CREATE SCHEMA IF NOT EXISTS util_sch AUTHORIZATION mekanapp_user;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.places
(
    place_id                  uuid DEFAULT uuid_generate_v4(),
    place_name                VARCHAR NOT NULL,
    place_address             VARCHAR NOT NULL,
    place_phone_number        VARCHAR NOT NULL,
    status                    VARCHAR,
    PRIMARY KEY (place_id),
    CONSTRAINT places_phone_number_key UNIQUE (place_phone_number)
);
