CREATE TABLE tb_pessoa(
	id bigint,
	nome varchar(50),
	idade integer
);

ALTER TABLE tb_pessoa 
ADD COLUMN genero char(1);

ALTER TABLE tb_pessoa 
ADD COLUMN genero varchar(1);

--renomeia a coluna
ALTER TABLE tb_pessoa RENAME COLUMN nome_m TO nome_mae;

--altera o tipo do campo
ALTER TABLE tb_pessoa ALTER COLUMN nome_mae TYPE varchar(30);

--adiciona um valor default aos campos
ALTER TABLE tb_pessoa ALTER COLUMN nome_mae SET DEFAULT 'NULO';
ALTER TABLE tb_pessoa ALTER COLUMN nome_mae DROP DEFAULT;

--adiciona uma caracteristica ao campo nou remove
ALTER TABLE tb_pessoa ALTER COLUMN nome_mae SET NOT NULL;
ALTER TABLE tb_pessoa ALTER COLUMN nome_mae DROP NOT NULL;

--adiciona uma condição
ALTER TABLE tb_pessoa
ADD CHECK (idade > 0);

--remove uma condição
ALTER TABLE tb_pessoa
DROP CONSTRAINT tb_pessoa_idade_check;

--renomeia a tabela
ALTER TABLE tb_pessoa_1
RENAME TO tb_pessoa;

--apaga uma coluna
ALTER TABLE tb_pessoa
DROP COLUMN genero;


--limpa as informações da tabela, deixando-a vazia (PERIGOSO DEMAIS);
TRUNCATE TABLE tb_pessoa;

--apaga a tabela, extremamente periogoso
DROP TABLE tb_pessoa_1;

SELECT * FROM tb_pessoa;

ALTER TABLE tb_pessoa_1 ALTER COLUMN TYPE varchar(1);

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (1,'Carlos', 22, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (2,'Selton', 21, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (3,'Lucas', 19, 'M');


UPDATE tb_pessoa SET nome ='Carlos Brito' WHERE id = 1;
UPDATE tb_pessoa SET nome = 'Selton Batista', idade = 21 WHERE id =2;

DELETE FROM tb_pessoa WHERE id = 3;

ALTER TABLE tb_pessoa
ADD CONSTRAINT check_idade
CHECK (
	idade > 0
	and idade < 100
);


CREATE TABLE tb_pessoa(
	id bigint NOT NULL,
	nome varchar(50)NOT NULL,
	idade integer CONSTRAINT check_idade CHECK (idade > 0),
	genero varchar(1) NOT NULL
);

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (1,'Carlos', 22, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (2,'Selton', 21, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (3,'Lucas', 19, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (4,'Bianca', 19, 'F');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (5,'Jonas', 0, 'M');

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (5,'Jonas', 21, NULL);

INSERT INTO tb_pessoa (id, nome, idade, genero)
VALUES (5,'Carlos', 22, 'M');

drop table tb_pessoa;

SELECT * FROM tb_pessoa WHERE nome LIKE('Carlos');
SELECT * FROM tb_pessoa WHERE nome LIKE('%os');
SELECT * FROM tb_pessoa WHERE nome LIKE('%nca');
SELECT * FROM tb_pessoa WHERE nome LIKE('%s');
SELECT * FROM tb_pessoa WHERE nome LIKE('%os'); --posso usar para buscar por sobrenome
SELECT * FROM tb_pessoa WHERE nome LIKE('_a%');
SELECT * FROM tb_pessoa WHERE nome NOT LIKE('_arlos');
SELECT * FROM tb_pessoa WHERE nome NOT LIKE('%s');
SELECT nome FROM tb_pessoa;
SELECT UPPER(nome) FROM tb_pessoa;
SELECT * FROM tb_pessoa WHERE idade > 19 and idade < 30;
SELECT * FROM tb_pessoa WHERE idade > 21 or nome LIKE('%ton');

SELECT * FROM tb_pessoa ORDER BY nome;
SELECT * FROM tb_pessoa ORDER BY nome desc;
SELECT * FROM tb_pessoa ORDER BY idade desc;
SELECT DISTINCT (nome) FROM tb_pessoa;

SELECT * FROM tb_pessoa WHERE nome IN ('Bianca','Lucas'); --pesado usar o in
SELECT * FROM tb_pessoa WHERE idade BETWEEN 20 and 30;



















