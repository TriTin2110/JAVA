create database Web_Ban_Hang;
use Web_Ban_Hang;
CREATE TABLE model_author (
    author_ID VARCHAR(512) primary key not null,
    author_name VARCHAR(512),
    author_description VARCHAR(512),
    author_birthday DATE
);

create table model_type_of_book(
	type_ID varchar(512) primary key not null,
    type_name nvarchar(512)
);

CREATE TABLE model_book (
    book_ID VARCHAR(512) PRIMARY KEY NOT NULL,
    book_name NVARCHAR(512),
    book_language VARCHAR(120),
    book_description TEXT,
    public_year INT,
    quantity INT,
    import_price LONG,
    price LONG,
    outport_price LONG,
    type_of_book_ID VARCHAR(512),
    author_ID VARCHAR(512),
    CONSTRAINT FK_type_ID FOREIGN KEY (type_of_book_ID)
        REFERENCES model_type_of_book (type_ID),
    CONSTRAINT FK_author_ID FOREIGN KEY (author_ID)
        REFERENCES model_author (author_ID)
);

create table model_customer(
	customer_ID varchar(512) primary key not null,
    user_name varchar(512),
    user_password varchar(512),
    customer_name nvarchar(512),
    gender nvarchar(8),
    address nvarchar(512),
    address_receiver nvarchar(512),
    address_sell nvarchar(512),
    email varchar(512),
    phone_nuber varchar(15),
    date_of_birth date,
    sign_email tinyint
);

create table model_order(
	order_id varchar(512) primary key not null,
    address_buyer nvarchar(512),
    address_receive nvarchar(512),
    status_order nvarchar(512),
    payment_order nvarchar(512),
    status_payment nvarchar(512),
    money_paid varchar(512),
    money_remain varchar(512),
    order_date date,
    ship_date date,
    customer_ID varchar(512),
    constraint FK_customer_ID foreign key (customer_ID) references model_customer(customer_ID)
);

create table model_order_detail(
	order_detail_ID varchar(512) primary key,
	book_ID varchar(512),model_author,
    cover_price long,
    discount long,
    sell_price long,
    VAT long,
    total long,
    quantity int,
    order_ID varchar(512),
    constraint FK_order_ID foreign key (order_ID) references model_order(order_ID)
);