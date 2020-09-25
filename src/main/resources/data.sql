INSERT INTO item (item_nbr, name, description, price) values
(1111, 'Purani Jeans', 'You try to rid it yourself, but never mind', 10.0);
INSERT INTO item (item_nbr, name, description, price) values
(2222, 'Hover Board', 'Jump high off the ground!', 34.50);

INSERT INTO orders(order_id, customer_id, delivery_address, order_date, status, total) values
(1, 3, 'Mordor', '2019-06-10', 0, 11.0);
INSERT INTO orders(order_id, customer_id, delivery_address, order_date, status, total) values
(2, 1, 'Gotham City', '2019-06-11', 1, 46.50);