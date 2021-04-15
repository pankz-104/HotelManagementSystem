# HotelManagementSystem

   This is just an overview of management in hotels. It manages and maintains the records of customers, rooms, employees and drivers in the hotel. The project is aimed to 
maintain the day-to-day state of admission/vacation of Residents, List of employees, room details etc. Main objective of this project is to provide solution for hotel to 
manage most there work using computerized process. This software application will help admin to handle customer information, room allocation details, Payment details etc. 


Database 

create database hms;

use hms;

create table login(username varchar(30), password varchar(30));

insert into login values('admin', '12345');

    create table customer(id varchar(15), number varchar(20), name varchar(30), gender varchar(10), country varchar(30),room varchar(10), status varchar(30), deposit varchar(10));

    create table room(room_number varchar(10), available varchar(20), status varchar(30), price varchar(10), bed_type varchar(30));

    create table employee(name varchar(30), age varchar(10), gender varchar(15), job varchar(40), salary varchar(10), phone varchar(15), aadhar varchar(15), email varchar(30));

    create table driver(name varchar(30), age varchar(10), gender varchar(15), car_company varchar(30), car_brand varchar(30), available varchar(15), location varchar(30));

create table department(department varchar(30), budget varchar(15));

insert into department values('Marketing', '2000000');

insert into department values('Transport', '300000');

insert into department values('Service', '1000000');

insert into department values('Security', '400000');
