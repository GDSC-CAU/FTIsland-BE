-- islandinfo
INSERT INTO islandinfo (id, name) VALUES
(1, '지혜'), (2, '기쁨'), (3, '행복'), (4, '용기'), (5, '희망'), (6, '미지');


-- bookinfo
INSERT INTO bookinfo (id, title, description, category, country, total_page, image, island_id) VALUES
(1, '금도끼 은도끼', '성실한 나무꾼은 과연 어떻게 금도끼를 갖게 되었을까요?', '교훈', '한국', 18, 'https://storage.googleapis.com/ft-island-image/goldsilver0.webp', 1),
(2, '그림자 괴물', '그림자 괴물이 생겨난 이유가 궁금하지 않아?', '모험', '한국', 5, 'https://storage.googleapis.com/ft-island-image/shadow0.webp', 1),
(3, '당나귀 알', '당나귀 알을 부화시키려는 어리석은 농부의 이야기', '교훈', '한국', 6, 'https://storage.googleapis.com/ft-island-image/dangegg0.webp', 1),
(4, '별 왕자', '하늘 위의 별 왕자님이 땅 구경을 하러 내려갔어요! 과연 어떤 일이 벌어질까요?', '모험', '러시아', 4, 'https://storage.googleapis.com/ft-island-image/starprince0.webp', 1);

-- bookcontent
INSERT INTO bookcontent (book_id, page, kor_contents, image) VALUES
(1, 0, '옛날 어느 마을에 정직하고 마음씨 착한 나무꾼이 살고 있었어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver0.webp'),
(1, 1, '어느 날 나무꾼이 나무를 베고 있었는데, 도끼가 연못에 빠지고 말았어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver1.webp'),
(1, 2, '그때였어요. 연못에서 갑자기 하얀 연기가 일더니 하얀 옷을 입은 산신령이 나타났어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver2.webp'),
(1, 3, '산신령은 도끼를 잃어버려 울고 있는 나무꾼에게 도끼를 찾아준다고 했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver2.webp'),
(1, 4, '산신령은 금도끼를 보여주며 물었어요. "이 도끼가 네 도끼냐"', 'https://storage.googleapis.com/ft-island-image/goldsilver3.webp'),
(1, 5, '나무꾼은 산신령이 보여주는 금도끼, 은도끼 모두 자신의 것이 아니라고 했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver3.webp'),
(1, 6, '산신령은 물었어요. "이 낡은 쇠도끼가 네 도끼냐"', 'https://storage.googleapis.com/ft-island-image/goldsilver4.webp'),
(1, 7, '나무꾼은 환하게 웃으며 자신의 도끼가 맞다고 했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver4.webp'),
(1, 8, '산신령은 말했어요. "하하하! 참으로 정직한 나무꾼이로구나. 내가 선물로 금도끼, 은도끼를 선물로 주겠다."', 'https://storage.googleapis.com/ft-island-image/goldsilver4.webp'),
(1, 9, '나무꾼은 금도끼와 은도끼를 팔아 마을 최고의 부자가 되었어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver5.webp'),
(1, 10, '이 소식을 들은 욕심쟁이 나무꾼은 샘이 났어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver5.webp'),
(1, 11, '욕심쟁이 나무꾼은 일부러 쇠도끼를 빠뜨렸어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver6.webp'),
(1, 12, '그때 산신령이 나타났고, 욕심쟁이 나무꾼은 재빠르게 도끼를 찾아달라고 부탁했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver7.webp'),
(1, 13, '산신령은 금도끼를 보여주며 물었어요. "이 도끼가 네 도끼냐." 욕심쟁이 나무꾼은 맞다고 했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver8.webp'),
(1, 14, '산신령은 은도끼를 보여주며 물었어요. "이 도끼가 네 도끼냐." 욕심쟁이 나무꾼은 이번에도 맞다고 했어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver9.webp'),
(1, 15, '욕심쟁이 나무꾼은 금도끼, 은도끼, 쇠도끼 모두 가질 생각에 신이 났어요.', 'https://storage.googleapis.com/ft-island-image/goldsilver10.webp'),
(1, 16, '그때 산신령이 크게 화를 내며 말했어요. "네 이놈! 거짓말 치는 욕심쟁이에겐 쇠도끼도 어림없다!"', 'https://storage.googleapis.com/ft-island-image/goldsilver11.webp'),
(1, 17, '욕심쟁이 나무꾼은 잘못된 욕심 때문에 크게 혼이 나고 쇠도끼도 잃어버렸답니다.', 'https://storage.googleapis.com/ft-island-image/goldsilver11.webp'),
(2, 0, '마을 근처 숲에는 무시무시한 그림자 괴물이 살고 있었어요.', 'https://storage.googleapis.com/ft-island-image/shadow0.webp'),
(2, 1, '어느 날 마을에 살고 있던 작은 아이 치치는 그림자 괴물이 궁금했어요.', 'https://storage.googleapis.com/ft-island-image/shadow1.webp'),
(2, 2, '살금 살금 그림자를 따라가보니... 늑대가 그림자로 장난을 치고 있었어요!', 'https://storage.googleapis.com/ft-island-image/shadow1.webp'),
(2, 3, '친화력이 좋은 치치는 늑대와 바로 친해졌고, 함께 그림자 놀이를 하며 놀았어요.', 'https://storage.googleapis.com/ft-island-image/shadow2.webp'),
(2, 4, '여우를 사냥하려고 숲 주변에 있던 사냥꾼이, 치치와 늑대의 그림자를 보고 줄행랑 쳤답니다!', 'https://storage.googleapis.com/ft-island-image/shadow3.webp');
