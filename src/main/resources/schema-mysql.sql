CREATE TABLE account (
    account_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    user_id VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    created_at DATETIME,
    last_login_at DATETIME
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE article (
    article_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    modified_at DATETIME,
    author INT(11) NOT NULL,
    CONSTRAINT FOREIGN KEY (author) REFERENCES account (account_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
