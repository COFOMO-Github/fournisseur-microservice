
CREATE TABLE IF NOT EXISTS  FOURNISSEUR(

    ID SERIAL AUTO_INCREMENT PRIMARY KEY ,
    NAME varchar(255),
    REFERENCE varchar(255),
    COUNTRY varchar(255)
);

INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Apple', 'Maroc', 'REF_APPLE_STORE_1');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Apple', 'Maroc', 'REF_APPLE_STORE_2');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Apple', 'Maroc', 'REF_APPLE_STORE_3');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Apple', 'Maroc', 'REF_APPLE_STORE_4');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Samsung', 'Maroc', 'REF_Samsung_STORE_1');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Samsung', 'Maroc', 'REF_Samsung_STORE_2');
INSERT INTO FOURNISSEUR (NAME, COUNTRY, REFERENCE) VALUES ('Samsung', 'Maroc', 'REF_Samsung_STORE_3');

