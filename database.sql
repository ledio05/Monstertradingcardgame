DROP TABLE IF EXISTS Package CASCADE;
DROP TABLE IF EXISTS Stack CASCADE;
DROP TABLE IF EXISTS Card CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS ELEMENTTYPE CASCADE;
DROP TYPE IF EXISTS CARDTYPE CASCADE;

CREATE Table users(
    username varchar(50) PRIMARY KEY ,
    password varchar(50) NOT NULL,
    elo int NOT NULL DEFAULT 100,
    coins int NOT NULL DEFAULT 20,
    isLogged boolean NOT NULL DEFAULT false
);

CREATE TYPE ELEMENTTYPE AS ENUM ('Water', 'Fire', 'Normal');

CREATE TYPE CARDTYPE AS ENUM ('Goblin', 'Wizzard', 'Dragon','Spell', 'Knights', 'Orks', 'Kraken', 'Elf');


CREATE Table Card(
    cardid SERIAL PRIMARY KEY,
    name varchar(50),
    damage int NOT NULL,
    Elementtype ELEMENTTYPE NOT NULL,
    Cardtype CARDTYPE NOT NULL
);

CREATE TABLE Stack(
    id SERIAL PRIMARY KEY,
    username varchar(50) REFERENCES users(username) NOT NULL,
    cardid INT REFERENCES Card(cardid) NOT NULL
);

CREATE TABLE Package(
    id SERIAL PRIMARY KEY,
    cardid1 INT REFERENCES Card(cardid) NOT NULL,
    cardid2 INT REFERENCES Card(cardid) NOT NULL,
    cardid3 INT REFERENCES Card(cardid) NOT NULL,
    cardid4 INT REFERENCES Card(cardid) NOT NULL,
    cardid5 INT REFERENCES Card(cardid) NOT NULL
);

CREATE TABLE Marketplace(
    id SERIAL PRIMARY KEY,
    tradeid INT NOT NULL,
    cardid INT REFERENCES Card(cardid) NOT NULL,
    mindamage INT NOT NULL,
    type varchar(50)
);


