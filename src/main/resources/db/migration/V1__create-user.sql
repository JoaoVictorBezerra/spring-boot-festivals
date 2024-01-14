CREATE TABLE USERS (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    full_name TEXT NOT NULL,
    birthday TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    created_at TEXT NOT NULL,
    updated_at TEXT
);


