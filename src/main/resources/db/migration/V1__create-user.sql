CREATE TABLE USERS (
    id TEXT PRIMARY KEY NOT NULL UNIQUE,
    name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    birthday TEXT NOT NULL,
    role TEXT NOT NULL UNIQUE,
    created_at TEXT NOT NULL,
    updated_at TEXT
);