USE movies_db;

-- 1. Adicione um filme à tabela de filmes.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES
('Bartados Inglórios', 10.1, 2, '2018-04-09', 200, '3'); 

-- 2. Adicione um gênero à tabela de gêneros.
SELECT * FROM genres;
INSERT INTO genres (name, ranking, active)
VALUES
('Cult', 13, 1);

-- 3. Associe o filme do ponto 1. com o gênero criado no ponto 2.
UPDATE movies SET genre_id = 2 WHERE movies.id = 1;

-- 4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado
-- no ponto 1 como favorito.
UPDATE actors SET favorite_movie_id = 1 WHERE actors.id = 1;

-- 5. Crie uma tabela temporária da tabela filmes.
create temporary table movies_temp select * from movies;

-- 6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
DELETE FROM movies_temp WHERE awards > 5;

-- 7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
SELECT genres.name, COUNT(movies.genre_id) as total_movies 
FROM genres INNER JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING total_movies > 0;
-- 8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
SELECT actors.first_name, movies.title, movies.awards FROM actors INNER JOIN movies ON movies.id = actors.favorite_movie_id WHERE movies.awards > 3;

-- 9. Crie um índice no nome na tabela de filmes.
CREATE INDEX index_movies ON movies (id, title, rating, awards, release_date, length, genre_id);

-- 10. Verifique se o índice foi criado corretamente.
SHOW INDEX from movies;

-- 11. No banco de dados movies, haveria uma melhoria notável na criação de índices?
-- Analise e justifique a resposta.
-- 12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta