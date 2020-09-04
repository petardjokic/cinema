insert into seat_types(id, name) values(1, 'Classic');
insert into seat_types(id, name) values(2, 'VIP');
insert into seat_types(id, name) values(3, 'Love');


insert into halls(id, name) values(1, 'Hall of Legends');
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(1, 1, 1, 1, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(2, 1, 1, 1, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(3, 1, 1, 1, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(4, 1, 1, 1, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(5, 1, 1, 1, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(6, 1, 1, 1, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(7, 1, 1, 1, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(8, 1, 1, 1, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(9, 1, 1, 1, 9);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(10, 1, 1, 1, 10);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(11, 1, 1, 1, 11);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(12, 1, 1, 1, 12);

insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(13, 1, 1, 2, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(14, 1, 1, 2, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(15, 1, 1, 2, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(16, 1, 1, 2, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(17, 1, 1, 2, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(18, 1, 3, 2, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(19, 1, 3, 2, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(20, 1, 1, 2, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(21, 1, 1, 2, 9);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(22, 1, 1, 2, 10);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(23, 1, 1, 2, 11);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(24, 1, 1, 2, 12);


insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(25, 1, 1, 3, 1);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(26, 1, 1, 3, 2);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(27, 1, 2, 3, 3);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(28, 1, 2, 3, 4);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(29, 1, 2, 3, 5);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(30, 1, 2, 3, 6);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(31, 1, 2, 3, 7);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(32, 1, 1, 3, 8);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(33, 1, 1, 3, 9);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(34, 1, 1, 3, 10);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(35, 1, 1, 3, 11);
insert into hall_seats(id, hall_id, seat_type_id, seat_row, seat_column) values(36, 1, 1, 3, 12);


insert into display_categories(id, name) values(1, 'Premiere');
insert into category_prices(id, category_id, seat_type_id, price) values(1, 1, 1, 500);
insert into category_prices(id, category_id, seat_type_id, price) values(2, 1, 2, 800);
insert into category_prices(id, category_id, seat_type_id, price) values(3, 1, 3, 900);

insert into display_categories(id, name) values(2, 'Blockbuster');
insert into category_prices(id, category_id, seat_type_id, price) values(4, 2, 1, 600);
insert into category_prices(id, category_id, seat_type_id, price) values(5, 2, 2, 900);
insert into category_prices(id, category_id, seat_type_id, price) values(6, 2, 3, 1000);

insert into display_categories(id, name) values(3, 'Regular');
insert into category_prices(id, category_id, seat_type_id, price) values(7, 3, 1, 300);
insert into category_prices(id, category_id, seat_type_id, price) values(8, 3, 2, 450);
insert into category_prices(id, category_id, seat_type_id, price) values(9, 3, 3, 550);

insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10000, 10001, 1, 1, TO_DATE('2020/08/31 21:00:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10001, 10002, 1, 2, TO_DATE('2020/09/02 21:00:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10002, 10003, 1, 2, TO_DATE('2020/09/03 18:15:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10003, 10004, 1, 1, TO_DATE('2020/09/03 21:15:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10004, 10005, 1, 3, TO_DATE('2020/09/04 20:00:00', 'yyyy/mm/dd hh24:mi:ss'), 0);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10005, 10006, 1, 2, TO_DATE('2020/09/05 15:30:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10006, 10007, 1, 1, TO_DATE('2020/09/05 19:00:00', 'yyyy/mm/dd hh24:mi:ss'), 1);
insert into displays(id, movie_id, hall_id, category_id, starts_at, active) values(10007, 10008, 1, 1, TO_DATE('2020/09/05 21:30:00', 'yyyy/mm/dd hh24:mi:ss'), 1);



insert into invoices(id, issued_at, active, total_price) values(10000, TO_DATE('2020/09/01 11:02:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 1000);
insert into tickets(id, invoice_id, display_id, seat_id, active, price) values(10000, 10000, 10001, 2, 1, 200);
insert into tickets(id, invoice_id, display_id, seat_id, active, price) values(10001, 10000, 10001, 3, 1, 200);
insert into tickets(id, invoice_id, display_id, seat_id, active, price) values(10002, 10000, 10002, 3, 1, 200);
insert into tickets(id, invoice_id, display_id, seat_id, active, price) values(10003, 10000, 10002, 4, 1, 200);
insert into tickets(id, invoice_id, display_id, seat_id, active, price) values(10004, 10000, 10002, 5, 1, 200);

insert into invoices(id, issued_at, active, total_price) values(10001, TO_DATE('2020/09/01 11:03:00', 'yyyy/mm/dd hh24:mi:ss'), 0, 700);
insert into invoices(id, issued_at, active, total_price) values(10002, TO_DATE('2020/09/01 11:37:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 2200);
insert into invoices(id, issued_at, active, total_price) values(10003, TO_DATE('2020/09/01 13:18:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 1300);
insert into invoices(id, issued_at, active, total_price) values(10004, TO_DATE('2020/09/01 14:09:00', 'yyyy/mm/dd hh24:mi:ss'), 0, 900);
insert into invoices(id, issued_at, active, total_price) values(10005, TO_DATE('2020/09/01 15:57:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 350);
insert into invoices(id, issued_at, active, total_price) values(10006, TO_DATE('2020/09/02 11:19:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 1000);
insert into invoices(id, issued_at, active, total_price) values(10007, TO_DATE('2020/09/02 16:48:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 550);
insert into invoices(id, issued_at, active, total_price) values(10008, TO_DATE('2020/09/02 17:01:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 850);
insert into invoices(id, issued_at, active, total_price) values(10009, TO_DATE('2020/09/02 18:33:00', 'yyyy/mm/dd hh24:mi:ss'), 1, 3600);

