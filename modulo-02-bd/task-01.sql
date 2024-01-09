CREATE TABLE ESTUDANTE (
   id_estudante NUMBER PRIMARY KEY,
   nome VARCHAR2(200) NOT NULL,
   data_nascimento DATE NOT NULL,
   nr_matricula NUMBER(10) NOT NULL UNIQUE,
   ativo CHAR(1) CHECK (ativo IN ('S', 'N')) NOT NULL
);

CREATE SEQUENCE SEQ_ESTUDANTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE NOCYCLE;


INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'João Silva', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 1234567890, 'S');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Maria Oliveira', TO_DATE('1992-05-15', 'YYYY-MM-DD'), 2345678901, 'S');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Carlos Santos', TO_DATE('1995-08-20', 'YYYY-MM-DD'), 3456789012, 'N');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Ana Souza', TO_DATE('1988-11-10', 'YYYY-MM-DD'), 4567890123, 'S');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Roberto Lima', TO_DATE('1993-04-25', 'YYYY-MM-DD'), 5678901234, 'N');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Fernanda Costa', TO_DATE('1997-09-30', 'YYYY-MM-DD'), 6789012345, 'S');

INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Amanda Pereira', TO_DATE('1991-02-15', 'YYYY-MM-DD'), 7890123456, 'N');

select * from ESTUDANTE;