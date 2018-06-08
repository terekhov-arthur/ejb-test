create table STUDENT
(
  ID        NUMBER        not null
    primary key,
  FULL_NAME NVARCHAR2(25) not null
)

INSERT INTO LOCAL.STUDENT (ID, FULL_NAME) VALUES (1, 'Rick Sanchez');
INSERT INTO LOCAL.STUDENT (ID, FULL_NAME) VALUES (2, 'Morty Smith');