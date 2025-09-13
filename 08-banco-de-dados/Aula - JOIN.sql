CREATE TABLE tb_cliente(
	id BIGINT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	idade INTEGER NOT NULL CONSTRAINT check_idade CHECK (idade > 0 and idade <120),
	genero VARCHAR(1) NOT NULL CHECK (genero IN ('M','F')),
	id_estado BIGINT,
	cpf BIGINT NOT NULL,
	CONSTRAINT pk_id_cliente PRIMARY KEY (id)
	--CONSTRAINT fk_id_estado_pessoa FOREIGN KEY(id_estado) REFERENCES tb_estado(id)
);

ALTER TABLE tb_cliente
ADD CONSTRAINT uq_cpf_cliente UNIQUE(cpf);

CREATE TABLE tb_estado(
	id BIGINT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	sigla VARCHAR(2) NOT NULL,
	CONSTRAINT pk_id_estado PRIMARY KEY(id)
);

ALTER TABLE tb_cliente
ADD CONSTRAINT fk_id_estado_pessoa FOREIGN KEY(id_estado) REFERENCES tb_estado(id);

SELECT * FROM tb_cliente;

DROP TABLE tb_cliente;
TRUNCATE tb_estado;

SELECT *FROM tb_estado;

INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(1,'Carlos', 22, 'M',2,4028922);
INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(2,'Bianca', 19, 'F',3,4256578);
--INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(3,'Bianca', 19, 'F',3,4256578);

CREATE SEQUENCE sq_cliente
START 1
INCREMENT 1
OWNED BY tb_cliente.id;

CREATE SEQUENCE sq_estado
START 1
INCREMENT 1
OWNED BY tb_estado.id;


INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(nextval('sq_cliente'),'Carlos', 22, 'M',3,4028922);
INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(nextval('sq_cliente'),'Bianca', 19, 'F',4,4256578);
	INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(nextval('sq_cliente'),'Joana', 19, 'F',4,4246578);
	INSERT INTO tb_cliente(id,nome,idade,genero,id_estado,cpf) VALUES(nextval('sq_cliente'),'Pedro', 22, 'M',null,4046922);


SELECT * FROM tb_cliente;

INSERT INTO tb_estado(id,nome,sigla) VALUES (nextval('sq_estado'), 'São Paulo','SP');
INSERT INTO tb_estado(id,nome,sigla) VALUES (nextval('sq_estado'), 'Minas Gerais','MG');
INSERT INTO tb_estado(id,nome,sigla) VALUES (nextval('sq_estado'), 'Espirito Santo','ES');
SELECT * FROM tb_estado;

SELECT currval('sq_cliente');

--------------------------------INNER JOIN--------------------------------
SELECT * FROM tb_cliente p, tb_estado e
WHERE p.id_estado = e.id;

SELECT p.nome AS Cliente,e.nome AS Estado FROM tb_cliente AS p, tb_estado AS e
WHERE p.id_estado = e.id;

SELECT cliente.id, cliente.nome, estado.nome AS estado,cliente.cpf 
FROM tb_cliente AS cliente INNER JOIN tb_estado AS estado ON cliente.id_estado= estado.id;
--------------------------------LEFT JOIN--------------------------------
--OS campos da esquerda vem, e os da direita sem referencia vem como null

SELECT * FROM tb_cliente p
LEFT JOIN tb_estado e
ON e.id = p.id_estado;

SELECT cliente.id, cliente.nome, estado.nome AS estado,cliente.cpf 
FROM tb_cliente AS cliente LEFT JOIN tb_estado AS estado ON cliente.id_estado= estado.id;

--------------------------------RIGHT JOIN--------------------------------
--OS campos da direita vem, e os da esquerda sem referencia vem como null
SELECT cliente.id, cliente.nome, estado.nome AS estado,cliente.cpf 
FROM tb_cliente AS cliente RIGHT JOIN tb_estado AS estado ON cliente.id_estado= estado.id;

--------------------------------FULL JOIN--------------------------------
--Junta toda a tabela e os campos que nao batem ficam vazios

SELECT cliente.id, cliente.nome, estado.nome AS estado,cliente.cpf 
FROM tb_cliente AS cliente FULL JOIN tb_estado AS estado ON cliente.id_estado= estado.id;

--------------------------------FULL JOIN--------------------------------
--Tipo uma distributiva com cada valor da esquerda com o da direita
SELECT cliente.id, cliente.nome, estado.nome AS estado,cliente.cpf 
FROM tb_cliente AS cliente CROSS JOIN tb_estado AS estado;




