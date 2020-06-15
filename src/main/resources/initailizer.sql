CREATE TABLE user_permission (
    up_id INT(11) NOT NULL AUTO_INCREMENT,
    a_id INT(11),
    name VARCHAR(10),
);

CREATE TABLE account (
    a_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(10) NOT NULL,
    user_id VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    created_at DATETIME,
    last_login_at DATETIME
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE reference (
    r_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
    written_by INT(11) NOT NULL,
    is_deleted TINYINT DEFAULT 0,
    CONSTRAINT FOREIGN KEY (written_by) REFERENCES account (a_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE reference_file_link (
     rfl_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     link TEXT NOT NULL,
     r_id INT(11) NOT NULL,
     CONSTRAINT FOREIGN KEY (r_id) REFERENCES reference (r_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
