CREATE DATABASE band_tracker;
\c band_tracker;
CREATE TABLE bands (id serial PRIMARY KEY, name varchar);
CREATE TABLE venues (id serial PRIMARY KEY, name varchar);
CREATE TABLE bands_venues (id serial PRIMARY KEY, band_id int, venue_id int);
CREATE DATABASE band_tracker_java WITH TEMPLATE band_tracker;
