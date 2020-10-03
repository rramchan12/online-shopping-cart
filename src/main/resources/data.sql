INSERT INTO customer  (customer_id, first_name, last_name, dob, add1, add2, email) values
(1, 'Tom', 'Jones', '1950-08-14', 'Glamorgan', 'Wales', 'tom@jones.com');
INSERT INTO customer  (customer_id, first_name, last_name, dob, add1, add2, email) values
(2, 'Elvis', 'Presley', '1945-10-20', 'Memphis', 'Tennessee', 'elvis@presley.com');
INSERT INTO customer  (customer_id, first_name, last_name, dob, add1, add2, email) values
(3, 'Michael', 'Jackson', '1960-05-10', 'Gary', 'Indiana', 'michael@michaeljackson.com');
INSERT INTO customer  (customer_id, first_name, last_name, dob, add1, add2, email) values
(4, 'Ravi', 'Ramchandran', '1970-09-17', 'Rogers', 'Bangalore', 'ravi@ramchandran.com');


INSERT INTO item (item_nbr, name, description, price) values
(1111, 'Purani Jeans', 'You try to rid it yourself, but never mind', 10.0);
INSERT INTO item (item_nbr, name, description, price) values
(2222, 'Hover Board', 'Jump high off the ground!', 34.50);

INSERT INTO orders(order_id, customer_id, delivery_address, order_date, status, total, discount_coupon_value) values
(1, 3, 'Mordor', '2019-06-10', 0, 11.0, 0);
INSERT INTO orders(order_id, customer_id, delivery_address, order_date, status, total, discount_coupon_value) values
(2, 1, 'Gotham City', '2019-06-11', 0, 3001, 1);
INSERT INTO orders(order_id, customer_id, delivery_address, order_date, status, total, discount_coupon_value) values
(3, 2, 'Gotham City', '2019-06-11', 1, 1500, 1);


INSERT INTO order_details(order_details_id, order_id, item_nbr, quantity) values
(1,1,1111,1);
INSERT INTO order_details(order_details_id, order_id, item_nbr, quantity) values
(2,2,1111,1);
INSERT INTO order_details(order_details_id, order_id, item_nbr, quantity) values
(3,2,2222,1);

INSERT INTO discount_coupon(coupon_id, child_coupon_id,  field_category, field_name, condition, value, coupon_calculator_code) values
(1, -1, '*','*', '*', 0, 'SALES_DISCOUNT_TYPE' );
