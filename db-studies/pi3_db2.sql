CREATE DATABASE IF NOT EXISTS biblioteca;

USE biblioteca;

DROP TABLE IF EXISTS livro_autor;
DROP TABLE IF EXISTS emprestimo;
DROP TABLE IF EXISTS autor;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS livro;
DROP TABLE IF EXISTS emprestimo;

CREATE TABLE IF NOT EXISTS livro (
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100) NOT NULL,
editora VARCHAR(50) NOT NULL,
area VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS autor (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
nacionalidade VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS aluno (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR(50) NOT NULL,
endereco VARCHAR(255) NOT NULL,
carreira VARCHAR(50) NOT NULL,
idade INT NOT NULL
);

CREATE TABLE IF NOT EXISTS livro_autor (
livro_id INT NOT NULL,
autor_id INT NOT NULL,
FOREIGN KEY (livro_id) REFERENCES livro (id),
FOREIGN KEY (autor_id) REFERENCES autor (id)
);

CREATE TABLE IF NOT EXISTS emprestimo (
livro_id INT NOT NULL,
aluno_id INT NOT NULL,
data_emprestimo DATE,
data_devolucao DATE,
retornou BOOLEAN,
FOREIGN KEY (livro_id) REFERENCES livro(id),
FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

INSERT INTO livro (titulo, editora, area)
VALUES
("Harry Potter e a Pedra Filosofal", "Rocco", "Infanto Juvenil"),
("Harry Potter e o prisioneiro de Azkaban", "Rocco", "Infanto Juvenil"),
("Game of Thrones", "Leya", "Infanto Juvenil"),
("A riqueza das nações", "Madras", "Filosofia"),
("O Iluminado", "Objetiva", "Infanto Juvenil"),
("Crônicas de Nárnia", "Leya", "Infanto Juvenil"),
("Sangue e Fogo", "Leya", "Ficção"),
("As origems do totalitarismo", "Martin Claret", "Filosofia"),
("Banco de Dados", "Malheiros", "Banco de Dados"),
("O universo: Guia de Viagem", "Salamandra", "Ciência"),
("Estrutura de Dados em Java Script", "Goya", "Internet");

INSERT INTO autor (nome, nacionalidade)
VALUES
("J K Rowling", "Britânica"),
("Stephen King", "Americana"),
("George G G Martin", "Americana"),
("Adam Smith", "Britânica"),
("Hannah Arendt", "Alemã"),
("Juan Martinez", "Argentina"),
("Bene Napoli", "Italiana"),
("C S Lewis", "Britânica"),
("Loiane Grooner", "Brasileira");

INSERT INTO livro_autor(livro_id, autor_id)
VALUES
(1, 1),
(2, 1),
(3, 3),
(4, 4),
(5, 2),
(6, 8),
(7, 3),
(8, 5),
(9, 6),
(10, 7),
(11, 9);

INSERT INTO aluno (nome, sobrenome, endereco, carreira, idade)
VALUES
("Gustavo", "Barretto", "Salvador", "Informática", 30),
("Rodrigo", "Paczkovski", "Joinville", "Informática", 25),
("Caio", "Motta", "Florianópolis", "Informática", 31),
("Felippo", "Galli", "Buenos Aires", "Saúde", 29),
("Vinicius", "Porto", "São Paulo", "Informática", 22);

INSERT INTO emprestimo (livro_id, aluno_id, data_emprestimo, data_devolucao, retornou)
VALUES
(1, 1, 20220403, 20220418, false),
(2, 1, 20210403, 20210716, false),
(5, 4, 20210401, 20210716, false),
(9, 4, 20220401, 20220425, false);

-- Com base nele, gere as consultas SQL para resolver os seguintes questões:

-- 1. Listar os dados dos autores.
SELECT * FROM autor;
-- 2. Listar nome e idade dos alunos
SELECT aluno.nome, aluno.idade FROM aluno;
-- 3. Quais alunos pertencem à carreira de informática?
SELECT aluno.nome FROM aluno WHERE aluno.carreira LIKE 'Informática';

-- 4. Quais autores são de nacionalidade francesa ou italiana?
SELECT autor.nome FROM autor WHERE autor.nacionalidade LIKE 'Italiana' OR autor.nacionalidade LIKE 'Alemã';

-- 5. Que livros não são da área da internet?
SELECT livro.titulo FROM livro WHERE livro.area LIKE 'Internet';

-- 6. Listar os livros da editora Salamandra.
SELECT livro.titulo FROM livro WHERE livro.editora LIKE 'Salamandra';

-- 7. Listar os dados dos alunos cuja idade é maior que a média.
SELECT AVG(aluno.idade) as media_idade FROM aluno;
SELECT aluno.nome, aluno.sobrenome, aluno.idade FROM aluno WHERE aluno.idade > (SELECT AVG(aluno.idade) FROM aluno);

-- 8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.
SELECT aluno.nome FROM aluno WHERE aluno.nome LIKE "G%";

-- 9. Listar os autores do livro "O Universo: Guia de Viagem". (Apenas nomes
-- devem ser listados.)
SELECT autor.nome FROM autor INNER JOIN livro_autor ON autor.id = livro_autor.autor_id INNER JOIN livro ON livro.id = livro_autor.livro_id WHERE livro.titulo LIKE "O Uni%"; 

-- 10. Listar autores que tenham nacionalidade italiana ou argentina.
SELECT autor.nome FROM autor WHERE autor.nacionalidade LIKE 'Italiana' OR autor.nacionalidade LIKE 'Argentina';

-- 11. Que livros foram emprestados ao leitor “Filippo Galli”?
SELECT livro.titulo FROM livro INNER JOIN emprestimo ON emprestimo.livro_id = livro.id INNER JOIN aluno ON emprestimo.aluno_id = aluno.id WHERE aluno.nome LIKE "Felippo%";

-- 12. Listar o nome do aluno mais novo.
SELECT aluno.nome FROM aluno WHERE aluno.idade LIKE (SELECT min(aluno.idade) FROM aluno);

-- 13. Listar os nomes dos alunos a quem os livros de Banco de Dados foram
-- emprestados.
SELECT aluno.nome FROM aluno INNER JOIN emprestimo ON emprestimo.aluno_id = aluno.id INNER JOIN livro ON emprestimo.livro_id = livro.id WHERE livro.titulo LIKE 'Banco de Dados';

-- 14. Listar os livros que pertencem ao autor J.K. Rowling.
SELECT livro.titulo FROM livro INNER JOIN livro_autor ON livro_autor.livro_id = livro.id INNER JOIN autor ON autor.id = livro_autor.autor_id WHERE autor.nome LIKE 'J K%';

-- 15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.
SELECT * FROM emprestimo;
SELECT livro.titulo FROM livro INNER JOIN emprestimo ON livro.id = emprestimo.livro_id WHERE emprestimo.data_devolucao LIKE '2021-07-16' AND emprestimo.retornou LIKE false;



