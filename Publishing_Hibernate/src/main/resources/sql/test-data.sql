insert into CATEGORY (ID, NAME) values (1, 'Historical Fiction');
insert into CATEGORY (ID, NAME) values (2, 'Fantasy');
insert into CATEGORY (ID, NAME) values (3, 'Science Fiction');
insert into CATEGORY (ID, NAME) values (4, 'Literature"');

insert into BOOKS (TITLE, ISBN, PRICE, CATEGORY_ID) values ('A Farewell to Arms', '5813564894', 9.99, 1);
insert into BOOKS (TITLE, ISBN, PRICE, CATEGORY_ID) values ('Eragon', '4515856515', 12.99, 2);
insert into BOOKS (TITLE, ISBN, PRICE, CATEGORY_ID) values ('I Am Legend', '4787452168', 6.99, 3);
insert into BOOKS (TITLE, ISBN, PRICE, CATEGORY_ID) values ('Dress Your Family in Corduroy and Denim', '1234568521', 4.99, 4);
insert into BOOKS (TITLE, ISBN, PRICE, CATEGORY_ID) values ('Calypso', '8451234578', 15.99, 4);

insert into AUTHORS (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Ernest', 'Hemingway', 'Turn of the century existentialist.');
insert into AUTHORS (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Christopher', 'Paolini', 'Wunderkind fantasy author from Montana.');
insert into AUTHORS (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Richard', 'Matheson', 'Classic sci-fi writer.');
insert into AUTHORS (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('David', 'Sedaris', 'Humorous essayist.');

insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES ('1', '1');
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES ('2', '2');
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES ('3', '3');
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES ('4', '4');
insert into AUTHOR_BOOK (AUTHOR_ID, BOOK_ID) VALUES ('4', '5');
