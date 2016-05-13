CREATE DATABASE bands_java;
\c bands_java;
CREATE TABLE bands (id serial PRIMARY KEY, name varchar);
CREATE TABLE venues (id serial PRIMARY KEY, name varchar);
CREATE TABLE bands_venues (id serial PRIMARY KEY, band_id int, venue_id int);
CREATE DATABASE bands_java_test WITH TEMPLATE bands_java;
