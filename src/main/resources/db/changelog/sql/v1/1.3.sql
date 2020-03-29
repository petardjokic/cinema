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


insert into displays(id, movie_id, hall_id, starts_at) values((select sq_displays.nextval from dual), 1,1, current_timestamp);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 1, 1, 100);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 1, 2, 200);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 1, 3, 150);

insert into displays(id, movie_id, hall_id, starts_at) values((select sq_displays.nextval from dual), 2,1, current_timestamp);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 2, 1, 100);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 2, 2, 200);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 2, 3, 150);

insert into displays(id, movie_id, hall_id, starts_at) values((select sq_displays.nextval from dual), 3,1, current_timestamp);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 3, 1, 100);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 3, 2, 200);
insert into display_prices(id, display_id, seat_type_id, price) values((select sq_display_prices.nextval from dual), 3, 3, 150);

insert into invoices(id, issued_at, active) values((select sq_invoices.nextval from dual), current_timestamp, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 1, 2, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 1, 3, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 3, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 4, 1);
insert into tickets(id, invoice_id, display_id, seat_id, active) values((select sq_tickets.nextval from dual), 1, 2, 5, 1);

