INSERT INTO account (
    username, user_id, password,
    email, phone_number, created_at, last_login_at
) VALUES (
    'Martin', 'root', '$2a$10$yAKZQeVhJ1wmIxTCj/5WkelrZufjbqP4y9s67Fl5gOV8bUJrZUpLG',
    'sample@martin.co.kr', '010-1234-5678', CURRENT_DATE, null
);

INSERT INTO reference (title, content, created_at, modified_at, written_by, is_deleted) VALUES ('제목', '내용', CURRENT_DATE, CURRENT_DATE, 1, false);

INSERT INTO reference_file_link (link, r_id) VALUES ('https://naver.com', 1);
