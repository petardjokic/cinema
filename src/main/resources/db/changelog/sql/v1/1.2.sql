insert into genres(id, name) values((select sq_genres.nextval from dual), 'Absurdist');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Action');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Adventure');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Comedy');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Crime');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Drama');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Fantasy');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Historical');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Historical fiction');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Magical realism');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Mystery');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Paranoid fiction');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Philosophical');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Political');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Romance');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Saga');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Satire');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Science fiction');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Social');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Speculative');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Thriller');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Urban');
insert into genres(id, name) values((select sq_genres.nextval from dual), 'Western');

insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Universal Pictures');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Warner Bros');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Sony Pictures Motion Picture Group');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Walt Disney Studios');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), '20th Century Fox');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Paramount Pictures');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Lionsgate Films');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'The Weinstein Company');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'Metro-Goldwyn-Mayer Studios');
insert into production_companies(id, name) values((select sq_production_companies.nextval from dual), 'DreamWorks Pictures');

insert into movies(id, title, trailer_uri, description, duration, release_year) values((select sq_movies.nextval from dual), 'Basic Instinct', 'b_20N7t-umo', 'A violent police detective investigates a brutal murder that might involve a manipulative and seductive novelist.', 129, 1992);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 1, 1);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 1, 2);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 1, 3);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 1, 1);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 1, 2);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 1, 3);

insert into movies(id, title, trailer_uri, description, duration, release_year) values((select sq_movies.nextval from dual), 'The Shawshank Redemption', '6hB3S9bIaco', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 142, 1994);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 2, 4);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 2, 5);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 2, 6);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 2, 4);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 2, 5);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 2, 6);

insert into movies(id, title, trailer_uri, description, duration, release_year) values((select sq_movies.nextval from dual), 'Pulp Fiction', 's7EdQ4FqbhY', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 154, 1994);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 3, 7);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 3, 8);
insert into movie_genres(id, movie_id, genre_id) values((select sq_movie_genres.nextval from dual), 3, 9);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 3, 7);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 3, 8);
insert into movie_production_companies(id, movie_id, production_company_id) values((select sq_production_companies.nextval from dual), 3, 9);
