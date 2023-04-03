CREATE table if not exists animal
(
    "id"   serial      not null UNIQUE,
    "name" varchar(20) not null default '',
    CONSTRAINT animal_pkey PRIMARY KEY (id)
);

CREATE table if not exists country
(
    "id"   serial      not null UNIQUE,
    "name" varchar(20) not null default '',
    CONSTRAINT country_pkey PRIMARY KEY (id)
);

CREATE table if not exists statistic
(
    "id"   serial      not null UNIQUE,
    "animal_id" integer not null,
    "country_id" integer not null,
    "qty"           integer      not null,
    CONSTRAINT statistic_pkey PRIMARY KEY (id),
    CONSTRAINT fk_animal_id FOREIGN KEY (animal_id) REFERENCES animal (id),
    CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES country (id)
);
