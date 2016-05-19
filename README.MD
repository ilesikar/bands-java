# Bands and Venues

#### _A website where the user can enter Bands and Venues and have each band show which venues they've performed at. Bands are able to be edited and deleted._

#### By _**Ian Lesikar**_

## Description

This website will ask the user to input a string of characters into an input-text form.

This website code contains:
* Properly named databases and tables
* Thorough passing tests for all methods and website paths
* Tests that were written and failed before passing
* Band class has full CRUD functionality
* All bands and their venues are showing correctly
* A working many-to-many relationship
* Instructions for setting up the database in PSQL

## Setup/Installation Requirements

1. Download ZIP folder
2. Extract ZIP folder
3. Install Git Bash, Gradle, PSQL
4. Type into PSQL:
```sql
CREATE DATABASE band_tracker;
\c band_tracker;
CREATE TABLE bands (id serial PRIMARY KEY, name varchar);
CREATE TABLE venues (id serial PRIMARY KEY, name varchar);
CREATE TABLE bands_venues (id serial PRIMARY KEY, band_id int, venue_id int);
CREATE DATABASE band_tracker_test WITH TEMPLATE band_tracker;
```
4. In Git Bash, navigate to bands-java
5. Type "gradle run"
6. Go to [localhost:4567](http://localhost:4567/) in your web browser

Contact me if you have any issues.

## Known Bugs

_Report any bugs to the contacts below_

## Support and contact details

Contact me anytime at ilesikar@gmail.com if you have any questions or comments.

## Technologies Used

* [Atom](https://atom.io/)
* [Sublime Text](https://www.sublimetext.com/)
* [Bootstrap](http://getbootstrap.com/)
* [Spark Framework](http://sparkjava.com/)
* [Gradle](https://gradle.org/)
* [Apache Velocity](https://velocity.apache.org/engine/releases/velocity-1.5/index.html)
* [Dillinger](http://dillinger.io/)
* [PSQL](http://www.postgresql.org/)

### License

The MIT License (MIT)
Copyright (c) 2016 Ian Lesikar
