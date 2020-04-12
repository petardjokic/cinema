create table halls(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_halls;
            
create table seat_types(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_seat_types;
            
create table hall_seats(
	id number primary key,
	hall_id number not null,
	seat_type_id number not null,
	seat_row number not null,
	seat_column number not null
);
create sequence sq_hall_seats;
alter table hall_seats add constraint fk_hall_seats_hall foreign key(hall_id) references halls on delete cascade;            
alter table hall_seats add constraint fk_hall_seats_seattype foreign key(seat_type_id) references seat_types on delete restrict;            
alter table hall_seats add constraint uq_hall_seats_hallid_row_col unique(id, seat_row, seat_column);
            
create table movies(
	id number primary key,
	title varchar2(100) not null,
	trailer_uri varchar(255) not null,
	description varchar2(255) not null,
	duration number not null,
	release_year number not null
);
create sequence sq_movies;
            
create table genres(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_genres;
            
create table movie_genres(
	id number primary key,
	movie_id number not null,
	genre_id number not null
);
create sequence sq_movie_genres;
alter table movie_genres add constraint fk_movie_genres_movie foreign key(movie_id) references movies on delete cascade;            
alter table movie_genres add constraint fk_movie_genres_genre foreign key(genre_id) references genres on delete restrict;
            
create table production_companies(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_production_companies;
            
create table movie_production_companies(
	id number primary key,
	movie_id number not null,
	production_company_id number not null
);
create sequence sq_movie_production_companies;
alter table movie_production_companies add constraint fk_movie_production_companies_movie foreign key(movie_id) references movies on delete cascade;            
alter table movie_production_companies add constraint fk_movie_production_companies_genre foreign key(production_company_id) references production_companies on delete restrict;

create table display_categories(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_display_categories;

create table category_prices(
	id number primary key,
	category_id number not null,
	seat_type_id number not null,
	price number not null
);
create sequence sq_category_prices;
alter table category_prices add constraint fk_category_prices_category foreign key(category_id) references display_categories on delete cascade;            
alter table category_prices add constraint fk_category_prices_seat_type foreign key(seat_type_id) references seat_types on delete cascade;

create table displays(
	id number primary key,
	movie_id number not null,
	hall_id number not null,
	category_id number not null,
	starts_at timestamp not null
);
create sequence sq_displays;
alter table displays add constraint fk_displays_movie foreign key(movie_id) references movies on delete restrict;            
alter table displays add constraint fk_displays_hall foreign key(hall_id) references halls on delete restrict;
alter table displays add constraint fk_displays_category foreign key(category_id) references display_categories on delete restrict;
            
create table invoices(
	id number primary key,
	issued_at timestamp not null,
	active number(1,0) not null
);
create sequence sq_invoices;
            
create table tickets(
	id number primary key,
	invoice_id number not null,
	display_id number not null,
	seat_id number not null,
	active number(1,0) not null
);
create sequence sq_tickets;
alter table tickets add constraint fk_tickets_invoice foreign key(invoice_id) references invoices on delete cascade;            
alter table tickets add constraint fk_tickets_display foreign key(display_id) references displays on delete cascade;            
alter table tickets add constraint fk_tickets_seat foreign key(seat_id) references hall_seats on delete restrict;