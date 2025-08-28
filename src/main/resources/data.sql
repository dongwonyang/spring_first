-- 15강: article 더미 데이터
INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

-- 22강: article dummy data
INSERT INTO article(title, content) VALUES('What is your life movie?', 'Leave a comment');
INSERT INTO article(title, content) VALUES('What is your soul food?', 'Leave a comment');
INSERT INTO article(title, content) VALUES('What is your hobby?', 'Leave a comment');
-- 22강: comment dummy data
---- Comments for article 4
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', 'Good Will Hunting');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', 'I Am Sam');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', 'The Shawshank Redemption');
---- Comments for article 5
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', 'Chicken');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', 'Shabu-shabu');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', 'Sushi');
---- Comments for article 6
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', 'Jogging');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', 'YouTube');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', 'Reading');
