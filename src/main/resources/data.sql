INSERT INTO USER_TBL VALUES ('100', '29', 'vivek.png','Vivek Agrawal');
INSERT INTO USER_TBL VALUES ('101', '30', 'brad_pitt_avatar.jpg','Rahul Gupta');
INSERT INTO USER_TBL VALUES ('102', NULL, 'BBC-News-Avatar.png','BBC News');
INSERT INTO USER_TBL VALUES ('103', NULL, 'fox-news.jpg','Fox News');


INSERT INTO RELATIONSHIP_TBL VALUES ('1000', '100', '101');
INSERT INTO RELATIONSHIP_TBL VALUES ('1001', '100', '102');
INSERT INTO RELATIONSHIP_TBL VALUES ('1002', '100', '103');


INSERT INTO FEED_TBL VALUES (99, 'Work from Home Continues in India', '1', CURRENT_TIMESTAMP(), 100); --TODO need to enter proper dates
INSERT INTO FEED_TBL VALUES (100, 'India won the match by 5 wickets.Virat Kohli was adjusted man of the match.', '1', CURRENT_TIMESTAMP(), 101);
INSERT INTO FEED_TBL VALUES (101, 'Spain saw one of the most draconian Covid-19 lockdowns in Europe, but two months after it was lifted, the virus is spreading faster than in any neighbouring nation.', '2', CURRENT_TIMESTAMP(), 102);
INSERT INTO FEED_TBL VALUES (102, 'US President Donald Trump is to visit the city in Wisconsin which has seen widespread unrest since a black man was shot in the back and seriously injured by a policeman ', '2', CURRENT_TIMESTAMP(), 103);


INSERT INTO COMMENT_TBL VALUES ('555',	'I have heard that it will continue till December',	CURRENT_TIMESTAMP,	'101',	'99');

