--SELECIONANDO (RIGHT JOIN) PESSOA E CONTATO CORRESPONDENTE
SELECT P.NOME,
	   C.NUMERO	
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.CONTATO C ON P.ID_PESSOA = C.ID_PESSOA;


--SELECIONANDO (RIGHT JOIN) O NOME DA PESSOA, CUJO ID É CORRESPONDENTE AO ENDEREÇO
SELECT P.NOME,
	   PPE.ID_PESSOA,
	   EP.*
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA = PPE.ID_PESSOA
RIGHT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO;

--SELECIONANDO (RIGHT JOIN) DADOS CORRESPONDENTES EM TODAS AS TABELAS 
SELECT P.NOME,	   		
	   C.NUMERO,
	   PPE.ID_PESSOA,
	   EP.*
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.CONTATO C ON P.ID_PESSOA = C.ID_PESSOA
RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA = PPE.ID_PESSOA
RIGHT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO;

--FULL JOIN DE PESSOA E CONTATO
SELECT *
FROM VEM_SER.PESSOA P
LEFT JOIN VEM_SER.CONTATO C  ON P.ID_PESSOA  = C.ID_PESSOA 

UNION

SELECT *
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.CONTATO C  ON P.ID_PESSOA  = C.ID_PESSOA;

--FUKK JOIN PESSOA, PESSOA X PESSOA_ENDEREÇO E ENDEREÇO_PESSOA
SELECT *
FROM VEM_SER.PESSOA P
LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA  = PPE.ID_PESSOA 
LEFT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO

UNION

SELECT *
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA  = PPE.ID_PESSOA 
RIGHT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO;

--FULL JOIN TODOS OS DADOS
SELECT *
FROM VEM_SER.PESSOA P
LEFT JOIN VEM_SER.CONTATO C ON P.ID_PESSOA = C.ID_PESSOA
LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA = PPE.ID_PESSOA
LEFT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO

UNION

SELECT *
FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.CONTATO C ON P.ID_PESSOA = C.ID_PESSOA
RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA = PPE.ID_PESSOA
RIGHT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO;

--PESSOAS QUE TEM ENDEREÇO
SELECT *
FROM VEM_SER.PESSOA P
WHERE EXISTS (
    SELECT 1
    FROM VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE 
    WHERE P.ID_PESSOA  = PPE.ID_PESSOA);
    
--ID, NOME DA TABELA 
   SELECT P.ID_PESSOA,
   		  P.NOME,
   		  EP.ID_ENDERECO,
   		  EP.LOGRADOURO	
   FROM VEM_SER.PESSOA P
RIGHT JOIN VEM_SER.CONTATO C ON P.ID_PESSOA = C.ID_PESSOA
RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO PPE ON P.ID_PESSOA = PPE.ID_PESSOA
RIGHT JOIN VEM_SER.ENDERECO_PESSOA EP ON PPE.ID_ENDERECO = EP.ID_ENDERECO;