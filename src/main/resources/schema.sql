--Napravite svoju tabelu u zavisnosti od baze
--ovo je za postgres i dodajte nesto u nju rucno
CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    department TEXT NOT NULL
);

