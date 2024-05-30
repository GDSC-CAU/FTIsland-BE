-- islandinfo
INSERT INTO islandinfo (id, name) VALUES
(1, '지혜'), (2, '기쁨'), (3, '행복'), (4, '용기'), (5, '희망'), (6, '미지');


-- bookinfo
INSERT INTO bookinfo (id, title, description, category, country, total_page, image, island_id) VALUES
(1, '금도끼 은도끼', '성실한 나무꾼은 과연 어떻게 금도끼를 갖게 되었을까요?', '교훈', '한국', 18, 'https://storage.googleapis.com/ft-island-image/goldsilver0.webp', 1),
(2, '그림자 괴물', '그림자 괴물이 생겨난 이유가 궁금하지 않아?', '모험', '한국', 5, 'https://storage.googleapis.com/ft-island-image/shadow0.webp', 1),
(3, '당나귀 알', '당나귀 알을 부화시키려는 어리석은 농부의 이야기', '교훈', '한국', 6, 'https://storage.googleapis.com/ft-island-image/dangegg0.webp', 1),
(4, '별 왕자', '하늘 위의 별 왕자님이 땅 구경을 하러 내려갔어요! 과연 어떤 일이 벌어질까요?', '모험', '러시아', 4, 'https://storage.googleapis.com/ft-island-image/starprince0.webp', 1);
