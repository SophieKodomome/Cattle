DROP SEQUENCE OmbyIdSeq;
DROP SEQUENCE OlonaIdSeq;
DROP TABLE Omby;
DROP TABLE Olona;

/*CREATE OR REPLACE TRIGGER ombyIdAutoIncrement
BEFORE INSERT ON Omby
FOR EACH ROW
BEGIN
  SELECT OmbyIdSeq.NEXTVAL INTO :new.ombyId FROM DUAL
END;
/*/

CREATE SEQUENCE ombyIdSeq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE OlonaIdSeq START WITH 1 INCREMENT BY 1;

CREATE TABLE Olona(
    Id NUMBER,
    CONSTRAINT OlonaPK PRIMARY KEY(Id),
    nom VARCHAR(20),
    credit NUMBER
);

CREATE TABLE Omby(
    Id NUMBER NOT NULL,
    CONSTRAINT OmbyPK PRIMARY KEY(Id),
    nom VARCHAR(20) NOT NULL,
    price NUMBER NOT NULL,
    weight NUMBER(*,2) NOT NULL,
    IdOwner NUMBER NOT NULL,
    Constraint OwnerFK FOREIGN KEY (IdOwner) REFERENCES Olona(ID),
    etat CHAR(1)
);

/*CREATE TABLE Tsena(
    OlonaId NUMBER NOT NULL ,
    CONSTRAINT OlonaFK FOREIGN KEY(OlonaId) REFERENCES Olona(Id),
    OmbyId NUMBER NOT NULL,
    CONSTRAINT OmbyFK FOREIGN KEY(OmbyId) REFERENCES Omby(Id),
    CONSTRAINT OmbyUnique UNIQUE (OmbyId)
);*/
INSERT INTO Olona VALUES(OlonaIdSeq.NEXTVAL,'Jean-Mafana',5000000);
INSERT INTO Olona VALUES(OlonaIdSeq.NEXTVAL,'Jean-Glace',3000000);

INSERT INTO Omby VALUES(OmbyIdSeq.NEXTVAL,'Meu meu',100000,500.23,2,1);
INSERT INTO Omby VALUES(OmbyIdSeq.NEXTVAL,'Mu mu',250000,700,2,1);
INSERT INTO Omby VALUES(OmbyIdSeq.NEXTVAL,'Moo moo',145000,650.12,2,1);
INSERT INTO Omby VALUES(OmbyIdSeq.NEXTVAL,'Ma ma',290000,880,3,0);

INSERT INTO Tsena VALUES(2,2);
INSERT INTO Tsena VALUES(2,3);
INSERT INTO Tsena VALUES(2,4);
INSERT INTO Tsena VALUES(3,5);