USE bootcamp;

DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS departamento;

CREATE TABLE IF NOT EXISTS departamento (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome_depto VARCHAR(50),
localizacao VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS funcionario (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR(50) NOT NULL,
cargo VARCHAR(50) NOT NULL,
data_alta DATE NOT NULL,
salario BIGINT NOT NULL,
comissao BIGINT NOT NULL,
depto_nro INT NOT NULL,
FOREIGN KEY (depto_nro) REFERENCES departamento (id)
);

INSERT INTO departamento (nome_depto, localizacao)
VALUES
('Software', 'Los Tigres'),
('Sistemas', 'Guadalupe'),
('Contabilidade', 'La Roca'),
('Vendas', 'Plata');

INSERT INTO funcionario (nome, sobrenome, cargo, data_alta, salario, comissao, depto_nro)
VALUES
('César', 'Piñero', 'Vendedor', '20180512', '80000', '15000', 4),
('Yosep', 'Kowaleski', 'Analista', '20150714', '140000', '0', 2),
('Mariela', 'Barrios', 'Diretor', '20140605', '185000', '0', 3),
('Jonathan', 'Aguilera', 'Vendedor', '20150306', '85000', '10000', 4),
('Daniel', 'Brezezicki', 'Vendedor', '20180303', '83000', '10000', 4),
('Mito', 'Barchuk', 'Presidente', '20140605', '190000', '0', 3),
('Emílio', 'Galarza', 'Desenvolvedor', '20140802', '60000', '15000', 1);

-- É necessário obter as seguintes consultas:
-- 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores
-- trabalham.
SELECT funcionario.nome, funcionario.cargo, departamento.localizacao FROM funcionario INNER JOIN departamento ON funcionario.depto_nro = departamento.id WHERE depto_nro LIKE 4;

-- 2. Visualize departamentos com mais de cinco funcionários.
SELECT departamento.nome_depto, COUNT(funcionario.depto_nro) as total_func FROM departamento INNER JOIN funcionario ON funcionario.depto_nro = departamento.id GROUP BY funcionario.depto_nro HAVING total_func > 2;

-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo
-- cargo que 'Mito Barchuk'.
SELECT funcionario.nome, funcionario.salario, departamento.nome_depto FROM funcionario INNER JOIN departamento ON funcionario.depto_nro = departamento.id WHERE funcionario.cargo IN (
SELECT funcionario.cargo FROM funcionario WHERE funcionario.nome = 'Mito');

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade,
-- ordenados por nome.
SELECT funcionario.nome, funcionario.sobrenome, funcionario.salario, funcionario.comissao, funcionario.cargo FROM funcionario INNER JOIN
departamento ON funcionario.depto_nro = departamento.id WHERE departamento.nome_depto LIKE 'Contabilidade' ORDER BY funcionario.nome DESC;

-- 5. Mostre o nome do funcionário que tem o menor salário.
SELECT funcionario.nome, funcionario.sobrenome, funcionario.salario FROM funcionario ORDER BY funcionario.salario DESC LIMIT 1;

-- 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
SELECT funcionario.nome, funcionario.sobrenome, funcionario.salario FROM funcionario WHERE funcionario.depto_nro LIKE 4 ORDER BY funcionario.salario DESC LIMIT 1;


