ALTER TABLE tb_pessoa ADD COLUMN cpf bigint;

SELECT * FROM tb_pessoa;

DELETE FROM tb_pessoa WHERE id = 5;

ALTER TABLE tb_pessoa ADD COLUMN id_estado bigint;


UPDATE tb_pessoa SET cpf = 10000 WHERE id = 1;
UPDATE tb_pessoa SET cpf = 20000 WHERE id = 2;
UPDATE tb_pessoa SET cpf = 30000 WHERE id = 3;
UPDATE tb_pessoa SET cpf = 40000 WHERE id = 4;


UPDATE tb_pessoa SET id_estado = 10 WHERE id = 1;
UPDATE tb_pessoa SET id_estado = 20 WHERE id = 2;
UPDATE tb_pessoa SET id_estado = 30 WHERE id = 3;
UPDATE tb_pessoa SET id_estado = 40 WHERE id = 4

ALTER TABLE tb_pessoa
ADD PRIMARY KEY (id);

--indices é para consultas que estao demorando, mas deixa inserção mais lenta

SELECT * FROM tb_pessoa WHERE cpf = 10000;
CREATE INDEX idx_cpf_pessoa ON tb_pessoa(cpf);






