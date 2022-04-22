
CREATE TABLE IF NOT EXISTS  FOURNISSEUR(

    ID SERIAL AUTO_INCREMENT PRIMARY KEY ,
    NAME varchar(255),
    REFERENCE varchar(255)
);

INSERT INTO FOURNISSEUR (NAME, REFERENCE) VALUES ('Apple', 'REF_APPLE_STORE_1');
INSERT INTO FOURNISSEUR (NAME, REFERENCE) VALUES ('Apple', 'REF_APPLE_STORE_2');
INSERT INTO FOURNISSEUR (NAME, REFERENCE) VALUES ('Apple', 'REF_APPLE_STORE_3');

