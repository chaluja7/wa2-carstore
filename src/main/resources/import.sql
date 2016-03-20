-- noinspection SqlNoDataSourceInspectionForFile
TRUNCATE persons CASCADE;
ALTER SEQUENCE persons_id_seq RESTART WITH 1;
INSERT INTO persons(name, surname) VALUES('Jakub', 'Chalupa');
INSERT INTO persons(name, surname) VALUES('Tomas', 'Fuk');
INSERT INTO persons(name, surname) VALUES('Jiri', 'Amend');
INSERT INTO persons(name, surname) VALUES('Lukas', 'Ignis');
INSERT INTO persons(name, surname) VALUES('Petr', 'Kuchar');

TRUNCATE addresses CASCADE;
ALTER SEQUENCE addresses_id_seq RESTART WITH 1;
INSERT INTO addresses(city, street, number, note, personid) VALUES('Praha 10', 'Brnenska', '10', 'private', 1);
INSERT INTO addresses(city, street, number, note, personid) VALUES('Praha 6', 'Plzenska', '29', 'public', 1);
INSERT INTO addresses(city, street, number, note, personid) VALUES('Hradec', 'Jarni', '8', 'private', 2);
INSERT INTO addresses(city, street, number, note, personid) VALUES('Kamenice', 'Prima', '888', 'private', 3);
INSERT INTO addresses(city, street, number, note, personid) VALUES('Praha 1', 'Vejvodska', '6', 'private', 4);

TRUNCATE phones CASCADE;
ALTER SEQUENCE phones_id_seq RESTART WITH 1;
INSERT INTO phones(phonenumber, note, personid) VALUES('+420123456789', 'mobile', 1);
INSERT INTO phones(phonenumber, note, personid) VALUES('384355398', 'home', 1);
INSERT INTO phones(phonenumber, note, personid) VALUES('458741236', 'mobile', 2);
INSERT INTO phones(phonenumber, note, personid) VALUES('+420589632145', 'mobile', 3);
INSERT INTO phones(phonenumber, note, personid) VALUES('478963254', 'mobile', 4);

TRUNCATE manufacturers CASCADE;
ALTER SEQUENCE manufacturers_id_seq RESTART WITH 1;
INSERT INTO manufacturers(name) VALUES('VW');
INSERT INTO manufacturers(name) VALUES('Saab');
INSERT INTO manufacturers(name) VALUES('Suzuki');
INSERT INTO manufacturers(name) VALUES('Karosa');
INSERT INTO manufacturers(name) VALUES('Mercedes');
INSERT INTO manufacturers(name) VALUES('Volvo');

TRUNCATE suppliers CASCADE;
ALTER SEQUENCE suppliers_id_seq RESTART WITH 1;
INSERT INTO suppliers(name) VALUES('Supplier 1');
INSERT INTO suppliers(name) VALUES('Supplier 2');
INSERT INTO suppliers(name) VALUES('Supplier 3');
INSERT INTO suppliers(name) VALUES('Supplier 4');
INSERT INTO suppliers(name) VALUES('Supplier 5');
INSERT INTO suppliers(name) VALUES('Supplier 6');

TRUNCATE manufacturer_supplier CASCADE;
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(1, 1);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(1, 2);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(1, 4);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(2, 1);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(3, 3);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(3, 4);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(4, 1);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(4, 6);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(5, 5);
INSERT INTO manufacturer_supplier(manufacturerid, supplierid) VALUES(6, 5);

TRUNCATE warehouses CASCADE;
ALTER SEQUENCE warehouses_id_seq RESTART WITH 1;
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 1', 1);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 2', 1);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 3', 1);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 4', 2);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 5', 3);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 6', 4);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 7', 5);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 8', 6);
INSERT INTO warehouses(name, supplierid) VALUES('Warehouse 9', 6);

TRUNCATE cars CASCADE;
ALTER SEQUENCE cars_id_seq RESTART WITH 1;
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('car', 'VW Passat', null, 1);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('car', 'VW Pollo', null, 1);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('car', 'Saab 2', null, 2);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('car', 'Suzuki SX4', null, 3);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('truck', 'Karosa XC', 500.4, 4);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('truck', 'Mercedes TRS', 570.6, 5);
INSERT INTO cars(type, name, weight, manufacturerid) VALUES('truck', 'Volvo 3', 490.0, 6);

TRUNCATE orders CASCADE;
ALTER SEQUENCE orders_id_seq RESTART WITH 1;
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(1, 1, '2016-01-01', '2016-01-03');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(1, 3, '2016-01-02', '2016-01-03');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(1, 4, '2016-01-02', '2016-01-04');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(1, 5, '2016-01-03', '2016-01-04');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(1, 6, '2016-01-04', '2016-01-05');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(2, 7, '2016-01-05', '2016-01-06');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(3, 2, '2016-01-06', '2016-01-07');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(4, 1, '2016-01-07', '2016-01-08');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(4, 3, '2016-01-08', '2016-01-09');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(4, 5, '2016-01-09', '2016-01-10');
INSERT INTO orders(personid, carid, datefrom, dateto) VALUES(5, 1, '2016-01-10', '2016-01-11');