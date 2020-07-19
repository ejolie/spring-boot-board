INSERT INTO account (user_name, user_id, password, email, phone, created_at)
VALUES ('Eunjeong Park', 'ejolie', '1234', 'ejolie.dev@gmail.com', '01012345678', now());

INSERT INTO account (user_name, user_id, password, email, phone, created_at)
VALUES ('Mocha', 'iammocha', '1234', 'mocha@test.com', '01011112222', now());

INSERT INTO article (title, content, account_id, created_at)
VALUES ('This is first article', 'Hello World!', 1, now());

INSERT INTO article (title, content, account_id, created_at)
VALUES ('This is second article', 'Hi!', 1, now());

INSERT INTO article (title, content, account_id, created_at)
VALUES ('Mung mung', 'Wal Wal', 2, now());