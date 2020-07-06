DROP DATABASE IF EXISTS prices;
CREATE DATABASE IF NOT EXISTS prices;
USE prices;

DROP TABLE IF EXISTS prices;

-- Create a temporal table
CREATE TABLE prices (
    id int PRIMARY KEY AUTO_INCREMENT,
    product_id  varchar(24) NOT NULL,
    price double NOT NULL,

    start_timestamp TIMESTAMP(6) GENERATED ALWAYS AS ROW START,
    end_timestamp TIMESTAMP(6) GENERATED ALWAYS AS ROW END,
    PERIOD FOR SYSTEM_TIME(start_timestamp, end_timestamp),

    CONSTRAINT prices_unique UNIQUE (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 WITH SYSTEM VERSIONING;

insert into prices (product_id, price) values ('507f1f77bcf86cd799439011', 99.99);
insert into prices (product_id, price) values ('507f191e810c19729de860ea', 25.90);
insert into prices (product_id, price) values ('581d772dfed7620ee89936de', 100);
