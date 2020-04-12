insert into seat_types(id, name) values((select sq_seat_types.nextval from dual), 'Classic');
insert into seat_types(id, name) values((select sq_seat_types.nextval from dual), 'VIP');
insert into seat_types(id, name) values((select sq_seat_types.nextval from dual), 'Love');


insert into halls(id, name) values((select sq_halls.nextval from dual), 'Hall of Legends');
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 1, 9);

insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 3, 2, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 3, 2, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 2, 9);

insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 3, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 3, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 2, 3, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 2, 3, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 2, 3, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 2, 3, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 2, 3, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 3, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values((select sq_hall_seats.nextval from dual), 1, 1, 3, 9);

insert into display_categories(id, name) values((select sq_display_categories.nextval from dual), 'Premiere');
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 1, 1, 500);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 1, 2, 800);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 1, 3, 900);

insert into display_categories(id, name) values((select sq_display_categories.nextval from dual), 'Blockbuster');
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 2, 1, 600);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 2, 2, 900);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 2, 3, 1000);

insert into display_categories(id, name) values((select sq_display_categories.nextval from dual), 'Regular');
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 3, 1, 300);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 3, 2, 450);
insert into category_prices(id, category_id, seat_type_id, price) values((select sq_category_prices.nextval from dual), 3, 3, 550);

insert into displays(id, movie_id, hall_id, category_id, starts_at) values((select sq_displays.nextval from dual), 1, 1, 1, current_timestamp);
insert into displays(id, movie_id, hall_id, category_id, starts_at) values((select sq_displays.nextval from dual), 2, 1, 2, current_timestamp);
insert into displays(id, movie_id, hall_id, category_id, starts_at) values((select sq_displays.nextval from dual), 3, 1, 3, current_timestamp);

insert into invoices(id, issued_at, active) values((select sq_invoices.nextval from dual), current_timestamp, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 1, 2, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 1, 3, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 3, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 4, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 5, 1);

