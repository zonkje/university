USE master;
GO

-- CREATE DATABASE
IF DB_ID (N'BlogSocialAPP') IS NOT NULL
DROP DATABASE BlogSocialAPP;
GO
CREATE DATABASE BlogSocialAPP;
GO

USE BlogSocialAPP;
GO

-- REMOVE TABLES
DROP TABLE IF EXISTS Users_Groups;
DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS Posts;
DROP TABLE IF EXISTS Groups;
DROP TABLE IF EXISTS Group_Access_Level;
DROP TABLE IF EXISTS Users;

-- CREATE TABLES
CREATE TABLE Users(
    id INT IDENTITY(1,1),
    fist_name NVARCHAR(40) NOT NULL,
    last_name NVARCHAR(60) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    CONSTRAINT PK_Users PRIMARY KEY(id)
);

CREATE TABLE Group_Access_Level(
    id TINYINT,
    type_of_access NVARCHAR(10) NOT NULL,
    CONSTRAINT PK_Group_Access_Level PRIMARY KEY(id)
);

CREATE TABLE Groups(
    id INT IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(200) NULL,
    access_id TINYINT,
    creation_date DATETIME NOT NULL DEFAULT GETDATE(),
    CONSTRAINT PK_Groups PRIMARY KEY(id),
    CONSTRAINT FK_Groups_Group_Access_Level FOREIGN KEY(access_id) REFERENCES Group_Access_Level(id),
);

CREATE TABLE Posts(
    id INT IDENTITY(1,1),
    category NVARCHAR(40),
    title NVARCHAR(100) NOT NULL,
    content NVARCHAR(300) NULL,
    creation_date DATETIME NOT NULL DEFAULT GETDATE(),
    user_id INT,
    CONSTRAINT PK_Posts PRIMARY KEY(id),
    CONSTRAINT FK_Posts_User FOREIGN KEY(user_id) REFERENCES Users(id)
);

CREATE TABLE Comments(
    id BIGINT IDENTITY(1,1),
    content NVARCHAR(200) NULL,
    creation_date DATETIME NOT NULL DEFAULT GETDATE(),
    user_id INT,
    post_id INT,
    CONSTRAINT PK_Comments PRIMARY KEY(id),
    CONSTRAINT FK_Comments_User FOREIGN KEY(user_id) REFERENCES Users(id),
    CONSTRAINT FK_Comments_Post FOREIGN KEY(post_id) REFERENCES Posts(id)
);

CREATE TABLE Users_Grup(
    id INT IDENTITY(1,1),
    user_id INT,
    group_id INT,
    CONSTRAINT PK_Users_Grup PRIMARY KEY(id),
    CONSTRAINT FK_Users_Grup_Users FOREIGN KEY(user_id) REFERENCES Users(id),
    CONSTRAINT FK_Users_Grup_Groups FOREIGN KEY(group_id) REFERENCES Groups(id)
);

-- INIT DATA
INSERT INTO Users VALUES
    (N'Szymon', N'Radziszewski', '1993-09-30', 'szymonradziszewski93@gmail.com'),
    (N'Alex', N'Bee', '1981-01-22', 'alexb54@gmail.com'),
    (N'John', N'Geen', '1992-11-28', 'jgee36@gmail.com'),
    (N'Paul', N'De Vrij', '1967-05-12', 'pdvrij6343@gmail.com'),
    (N'Kevin', N'Meow', '2003-04-21', 'kmeow13@gmail.com'),
    (N'Sergio', N'Aguero', '2004-09-11', 'skunague654@gmail.com'),
    (N'Mike', N'Mill', '2008-12-24', 'mikmill756@gmail.com'),
    (N'Chris', N'Fern', '2009-05-26', 'chrfern4352@gmail.com'),
    (N'Polina', N'Musk', '2018-01-06', 'polmusk12356@gmail.com'),
    (N'Bob', N'Ross', '2013-02-03', 'bobrosss65234@gmail.com');

INSERT INTO Group_Access_Level VALUES 
    (1, N'Private'),
    (2, N'Public');

INSERT INTO Posts VALUES
    (N'Sport', N'Surprising transfer', N'Messi is moving from Barcelona to PSG for 100 million dollars', '2020-05-11 04:30:20', 1),
    (N'Health', N'Health advice', N'Doctors agree: do not take drugs or drink alcohol and you will be healthier', '2020-05-11 02:11:22', 1),
    (N'Politic', N'New polls', N'The support of the ruling party is falling, and all its members blame the opposition', '2000-10-25 12:31:23', 3),
    (N'Technology', N'The best editor', N'According to the latest research conducted among people working in the IT industry, the best text editor is Visual Studio Code', '2021-02-04 04:39:35', 2),
    (N'Food', N'Tasty cocktail - recipe', N'Kale, mango and apples - these ingredients make the cocktail energetic, nutritious and, most importantly, tasty', '2006-07-02 02:45:54', 4),
    (N'Traveling', N'The parking scandal', N'The police discovered a gang of robbers who illegally collected fees for parking spaces', '2018-12-26 09:39:45', 5),
    (N'Culture', N'A remake of a super movie', N'The latest rumors from Hollywood announce the shooting of the thirtieth Fast and the Furious movie', '2001-04-23 05:52:12', 5),
    (N'Business', N'Poland is the leader', N'Our country still remains the undisputed leader in the inflation ranking', '2012-09-11 11:23:34', 6),
    (N'Sport', N'The absence of a star', N'Kevin de Bruyne will not play in the next Premier League game. The Belgian tested positive for covid-19', '2003-10-11 04:20:20', 7),
    (N'Politic', N'UE vs Poland', N'The UE is trying to interfere in Poland''s internal affairs again. It is about the legality of the courts', '2009-09-03 02:47:52', 10);

INSERT INTO Comments VALUES
    (N'He just wants money', GETDATE(), 9, 1),
    (N'As usual', '2021-10-11 02:32:43', 2, 3),
    (N'I checked, it works','2021-10-01 01:53:25', 10, 2),
    (N'I recommend', '2021-10-09 07:44:45', 8, 2),
    (N'Good thing they kept them', DEFAULT, 8, 6),
    (N'I prefer Notepad over there', '2021-10-04 08:24:42', 3, 4),
    (N'I recommend it very tasty', '2021-10-01 09:10:04', 1, 5),
    (N'I am so proud', '2021-10-09 06:23:12', 4, 8),
    (N'Finally, I was looking forward to it', '2021-10-06 06:45:42', 7, 7),
    (N'Again', '2021-10-15 02:41:14', 6, 10);


INSERT INTO Groups VALUES
    (N'Transfers Info', N'An information group about the latest football transfer news', 2, DEFAULT),
    (N'WSB Students', N'Group for students of WSB University', 2, '2001-10-14 05:35:23'),
    (N'CS Students', N'Group for students of Computer Science', 1, '2009-11-06 01:11:41'),
    (N'BUY SALE GIVEAWAY', N'Offers to buy, sell or give away various things', 1, '2017-08-29 02:52:27'),
    (N'Traveling together 3City', N'Are you looking for transport to or from Tricity?', 1, '2014-07-30 05:55:24'),
    (N'Polish drummers', N'A group for drummers from all over Poland', 1, '2012-04-20 04:34:16'),
    (N'Concertoholic', N'News about concerts, common travel, accommodation, purchase and sale of tickets', 2, '2010-12-13 08:21:12'),
    (N'Renting an apartment - Gdansk', N'Group for placing advertisements on real estate in Gdansk', 1, '2019-03-25 05:45:23'),
    (N'Gastronomy job', N'Looking for a job or employment in the catering industry', 1, '2005-05-10 05:11:52'),
    (N'Exams - help', N'Group for the exchange of information and knowledge, tutoring offers', 1, '2014-09-27 07:54:44');

INSERT INTO Users_Grup VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 3),
    (3, 4),
    (3, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (7, 4),
    (7, 9),
    (7, 10),
    (8, 10),
    (8, 1),
    (8, 2),
    (9, 4),
    (9, 5),
    (9, 6),
    (10, 8),
    (10, 9),
    (4, 4),
    (5, 5),
    (6, 7),
    (2, 8);