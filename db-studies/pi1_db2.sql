USE movies_db;

-- 1. Mostrar o título e o nome do gênero de todas as séries.
SELECT series.title, genres.name FROM series LEFT JOIN genres ON genres.id = series.genre_id;

-- 2 Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em
-- cada um deles.
SELECT episodes.title, actors.first_name, actors.last_name FROM actor_episode INNER JOIN actors ON actor_episode.actor_id = actors.id INNER JOIN episodes ON actor_episode.episode_id = episodes.id;  

-- 3. Mostrar o título de todas as séries e o número total de temporadas que cada uma
-- delas possui.
SELECT series.title, COUNT(seasons.number) as total_seasons FROM series INNER JOIN seasons ON seasons.serie_id = series.id GROUP BY seasons.serie_id;

-- 4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde
-- que seja maior ou igual a 3.
SELECT genres.name, COUNT(movies.genre_id) as total_movies FROM genres INNER JOIN movies ON genres.id = movies.genre_id GROUP BY genres.name;

-- 5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de
-- Star Wars e que estes não se repitam.
SELECT DISTINCT actors.first_name, actors.last_name FROM actor_movie INNER JOIN actors ON actor_movie.actor_id = actors.id INNER JOIN movies ON movies.id = actor_movie.movie_id WHERE movies.title LIKE 'La Guerra de las%';
