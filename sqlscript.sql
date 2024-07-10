CREATE DATABASE library;

CREATE USER 'library'@'localhost' IDENTIFIED BY 'library';

GRANT ALL PRIVILEGES ON library.* TO 'library'@'localhost';

FLUSH PRIVILEGES;
-- Comment lines above if already created

--DROP TABLE library.authors;
--DROP TABLE library.books;

-- Use lines above to drop tables if table resetting is needed

CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);


INSERT INTO library.authors (name) VALUES ('J.K. Rowling');
INSERT INTO library.authors (name) VALUES ('George R.R. Martin');
INSERT INTO library.authors (name) VALUES ('J.R.R. Tolkien');

INSERT INTO library.books (title, genre, author_id) VALUES ('Harry Potter and the Philosopher\'s Stone', 'Fantasy', 1);
INSERT INTO library.books (title, genre, author_id) VALUES ('A Game of Thrones', 'Fantasy', 2);
INSERT INTO library.books (title, genre, author_id) VALUES ('The Hobbit', 'Fantasy', 3);

