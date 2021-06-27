CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  book_name VARCHAR(250) NOT NULL,
  book_author VARCHAR(250) NOT NULL,
   created DATE,
    updated  DATE
);