CREATE TABLE users (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255),
                      password VARCHAR(255),
                      name VARCHAR(255),
                      birth_date DATE
);

CREATE TABLE wishlist (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          user_id INT
);

CREATE TABLE items (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255),
                       price DOUBLE,
                       link VARCHAR(255),
                       image VARCHAR(255),
                       wishlist_id INT
);