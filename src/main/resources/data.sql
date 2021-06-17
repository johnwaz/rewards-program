DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
  id INTEGER AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS PURCHASE;

CREATE TABLE PURCHASE (
  id INTEGER AUTO_INCREMENT  PRIMARY KEY,
  total BIGINT NOT NULL,
  purchase_date DATE DEFAULT NULL,
  customer_id INTEGER
);

insert into customer(id, name) values (1, 'John Waz');
insert into customer(id, name) values (2, 'Jack Burton');
insert into customer(id, name) values (3, 'SB Enterprises');

insert into purchase(id, total, purchase_date, customer_id) values (4, 120, '2021-04-03', 1);
insert into purchase(id, total, purchase_date, customer_id) values (5, 60, '2021-05-02', 1);
insert into purchase(id, total, purchase_date, customer_id) values (6, 100, '2021-06-01', 1);

insert into purchase(id, total, purchase_date, customer_id) values (7, 80, '2021-01-01', 2);
insert into purchase(id, total, purchase_date, customer_id) values (8, 20, '2021-02-02', 2);
insert into purchase(id, total, purchase_date, customer_id) values (9, 160, '2021-03-03', 2);

insert into purchase(id, total, purchase_date, customer_id) values (10, 140, '1985-04-16', 3);
insert into purchase(id, total, purchase_date, customer_id) values (11, 180, '1985-05-15', 3);
insert into purchase(id, total, purchase_date, customer_id) values (12, 120, '1985-06-14', 3);