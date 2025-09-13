CREATE TABLE produtos(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	valor NUMERIC(8,2) NOT NULL CONSTRAINT ck_valor CHECK (valor > 0)
);

DROP TABLE produto;
DROP TABLE cliente;

CREATE TABLE clientes(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) UNIQUE NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE nota_fiscal(
	id SERIAL PRIMARY KEY,
	cliente_id INTEGER NOT NULL,
	data DATE NOT NULL,
	CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE produtos_nota_fiscal(
	id SERIAL PRIMARY KEY,
	produto_id INTEGER NOT NULL,
	nota_fiscal_id INTEGER NOT NULL,
	quantidade INTEGER NOT NULL,

	CONSTRAINT fk_nota_fiscal FOREIGN KEY (nota_fiscal_id) REFERENCES nota_fiscal(id),
	CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produtos(id)

);

INSERT INTO produtos (nome, valor) VALUES ('Sofá', 1256.32);
INSERT INTO produtos (nome, valor) VALUES ('Geladeira', 4669.90);
INSERT INTO produtos (nome, valor) VALUES ('Fogão', 2336.50);
SELECT* FROM produtos;

INSERT INTO clientes (nome,cpf,email) VALUES ('Ana Clara Costa', '12345678901', 'ana.clara@email.com'),
('Bruno da Silva', '23456789012', 'bruno.silva@email.com'),
('Carlos Eduardo Souza', '34567890123', 'carlos.e@email.com'),
('Juliana Mendes', '45678901234', 'juliana.mendes@email.com'),
('Lucas Oliveira', '56789012345', 'lucas.o@email.com');

SELECT * FROM clientes;

INSERT INTO nota_fiscal(cliente_id, data) VALUES (1, '2025-09-10'),  -- Nota para a Ana Clara
(3, '2025-09-11'),  -- Nota para o Carlos Eduardo
(1, '2025-09-11'),  -- Outra nota para a Ana Clara
(5, '2025-09-12'),  -- Nota para o Lucas Oliveira
(2, '2025-09-12');  -- Nota para o Bruno da Silva

SELECT * FROM nota_fiscal;

INSERT INTO produtos_nota_fiscal(produto_id,nota_fiscal_id,quantidade) VALUES
(1,1,2),
(2,2,1),
(2,2,1),
(3,2,1),
(3,5,1),
(1,2,1);
SELECT * FROM produtos_nota_fiscal;
DELETE FROM produtos_nota_fiscal WHERE id = 6;
INSERT INTO produtos_nota_fiscal(produto_id,nota_fiscal_id,quantidade) 
VALUES(1,4,1);


SELECT nf.id AS numero_nota, nf.data ,
cliente.nome AS nome_cliente, 
cliente.email, produto.nome AS produto, 
produtosNf.quantidade
FROM clientes AS cliente
INNER JOIN nota_fiscal AS nf ON cliente.id = nf.cliente_id
INNER JOIN produtos_nota_fiscal AS produtosNf ON nf.id = produtosNf.nota_fiscal_id
INNER JOIN produtos AS produto ON produtosNf.produto_id = produto.id;

SELECT nf.id AS numero_nota, nf.data ,
cliente.nome AS nome_cliente, 
cliente.email, produto.nome AS produto, 
produtosNf.quantidade
FROM clientes AS cliente
INNER JOIN nota_fiscal AS nf ON cliente.id = nf.cliente_id
INNER JOIN produtos_nota_fiscal AS produtosNf ON nf.id = produtosNf.nota_fiscal_id
INNER JOIN produtos AS produto ON produtosNf.produto_id = produto.id WHERE cliente.nome != 'Carlos Eduardo Souza';


