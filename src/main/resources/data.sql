INSERT INTO roles (id, role_name) VALUES (1, 'admin');
INSERT INTO roles (id, role_name) VALUES (2, 'user');

INSERT INTO addresses (id, city, postal_code, street) VALUES (1, 'Poznań', '61-021', 'Główna 10');
INSERT INTO addresses (id, city, postal_code, street) VALUES (2, 'Toruń', '56-123', 'Piernikowa');
INSERT INTO addresses (id, city, postal_code, street) VALUES (3, 'Zielona Góra', '65-001', 'Makowa');
INSERT INTO addresses (id, city, postal_code, street) VALUES (4, 'Poznań', '61-896', 'Towarowa 39');
INSERT INTO addresses (id, city, postal_code, street) VALUES (5, 'Radom', '60-678', 'Szeroka 10');

INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (1, 'example@example.co', '$2a$12$fQNBQt3FVndpjDZYttKq5u8k7g1d/mRAxxrcEd4CnuNvkcihRbtfC', 'Sonic', 1, 1);
INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (2, 'maliniak1234@somewhere.com', '$2a$10$qL8N4lr2cPVooBnQ5dATzOX/Esz92D/pRiEm5pzmuj75h3F0cNDZS', 'Pikachu', 2, 2);
INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (12, 'aukcjaTest@gmail.com', '$2a$10$Aes0GzNsWlxp6GdVjDiu.u05zqGoZYc4dVsKEohlFRdvfIkKzGTpC', 'Maliniak', 3, 2);
INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (13, 'samung@gmail.com', '$2a$10$pK2vZT3KyMLx40U1hP6NRe.VUi1ZN1u/FFBaDFO7MToYJRIjozURG', 'wutang', 4, 2);
INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (14, 'kolejnyTest@gmail.com', '$2a$10$ttGQoPAzbr93llQw6HWmBu0.uHiCaTsILM5Odxv6ODc60/RqDYow6', 'flacko', 5, 2);
INSERT INTO users (id, email, password, username, address_id, role_id) VALUES (17, 'student@uep.pl', '$2a$10$75VLOOeH7qfHYEdMqoJ0SegqFw1D/IJy1sYsmshBwhj89Ga1SsmAW', 'utopia', 4, 2);

INSERT INTO categories (id, category_name, parent_category_id) VALUES (1, 'Elektronika', null);
INSERT INTO categories (id, category_name, parent_category_id) VALUES (2, 'Konsole', 1);
INSERT INTO categories (id, category_name, parent_category_id) VALUES (4, 'Laptopy', 1);

INSERT INTO delivery_options (id, delivery_company, delivery_price, description) VALUES (1, 'InPost', 14.99, 'Paczkomat');

INSERT INTO payment_methods (id, method_name) VALUES (1, 'Blik');
INSERT INTO payment_methods (id, method_name) VALUES (2, 'Przelew');


INSERT INTO items (id, brand_name, item_condition, name, weight) VALUES (1, 'Sony', 'nowy', 'Playstation 5', 2.5);
INSERT INTO items (id, brand_name, item_condition, name, weight) VALUES (2, 'Lenovo', 'używany', 'Thinkpad', 1.5);
INSERT INTO items (id, brand_name, item_condition, name, weight) VALUES (9, 'Apple', 'używany', 'Zegarek Apple Watch series SE 2 gen.', 0.2);
INSERT INTO items (id, brand_name, item_condition, name, weight) VALUES (10, 'Chlain Klein', 'Nowe', 'Oryginalne bokserki', 0.1);

INSERT INTO auctions (id, buy_now_price, current_bid_price, end_date, min_bid, name, quantity, start_price, status, adress_id, category_id, delivery_id, item_id, method_id, user_id) VALUES (8, 1000, 823, '2023-07-09', 50, 'Świetne słuchawki', 1, 600, null, null, null, null, 2, null, null);
INSERT INTO auctions (id, buy_now_price, current_bid_price, end_date, min_bid, name, quantity, start_price, status, adress_id, category_id, delivery_id, item_id, method_id, user_id) VALUES (9, 5000, 4050, '2023-07-03', 200, 'Laptop poleasingowy', 1, 3000, null, null, null, null, 1, null, null);
INSERT INTO auctions (id, buy_now_price, current_bid_price, end_date, min_bid, name, quantity, start_price, status, adress_id, category_id, delivery_id, item_id, method_id, user_id) VALUES (10, 1800, 1380, '2023-07-20', 20, 'Zegarek Smartwatch', 1, 1300, null, null, null, null, 9, null, null);
INSERT INTO auctions (id, buy_now_price, current_bid_price, end_date, min_bid, name, quantity, start_price, status, adress_id, category_id, delivery_id, item_id, method_id, user_id) VALUES (11, 100, 50, '2023-07-28', 5, 'Bielizna Chlain Klain', 3, 35, null, null, null, null, 10, null, null);

INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (1, 50, 9, 12);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (2, 60, 9, 14);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (3, 200, 9, 13);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (4, 600, 9, 17);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (5, 30, 10, 14);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (6, 50, 10, 1);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (7, 5, 11, 13);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (8, 10, 11, 1);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (9, 40, 8, 13);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (10, 23, 8, 12);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (11, 100, 9, 14);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (12, 150, 9, 2);
INSERT INTO bid (bid_id, bid_amount, auction_id, user_id) VALUES (13, 50, 8, 2);