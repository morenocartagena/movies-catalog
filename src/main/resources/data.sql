INSERT INTO `users` (`name`,`email`,`password`,`user_role`) 
VALUES (
    'Mario Moreno',
    'morenocartagena@outlook.com',
    '1234',
    'ROLE_ADMIN'
); 
INSERT INTO `users` (`name`,`email`,`password`,`user_role`) 
VALUES (
    'Guest',
    'guest@mail.com',
    '1234',
    'ROLE_GUESS'
); 
INSERT INTO `users` (`name`,`email`,`password`,`user_role`) 
VALUES (
    'User',
    'registered_user@mail.com',
    '1234',
    'ROLE_USER'
); 


-- INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
VALUES (
    'Alien Romulus',
    2024,
    4,
    'While scavenging the deep ends of a derelict space station, a group of young space colonists come face to face with the most terrifying life form in the universe.',
    'Thriller',
    '2024-08-23',
    'https://upload.wikimedia.org/wikipedia/en/c/cb/Alien_Romulus_2024_%28poster%29.jpg',
    1
); 

INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
VALUES (
    'Deadpool & Wolverine',
    2024,
    4.6,
    'Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority.',
    'Action',
    '2024-08-23',
    'https://cdn.marvel.com/content/1x/dp3_1sht_intl_digital_srgb_ka_blades_v2_resized.jpg',
    1
);

INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`)  
VALUES (
    'Despicable Me 4',
    2024,
    3.5,
    'Gru, Lucy, Margo, Edith, and Agnes welcome a new member to the family.',
    'Animation',
    '2024-08-23',
    'https://image.tmdb.org/t/p/original/hoJDI4mkP2w9WK2po5aZx3YIcLP.jpg',
    1
);

INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
VALUES (
    'Lord of the Rings',
    2001,
    5,
    'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.',
    'Adventure',
    '2024-08-23',
    'https://image.tmdb.org/t/p/original/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg',
    1
);

INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
VALUES (
    'Avengers End Game',
    2019,
    4.5,
    'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins.',
    'Superhero',
    '2024-08-23',
    'https://media.themoviedb.org/t/p/w220_and_h330_face/jhS6f1ynxdADs92B1bRGwCMb0Eu.jpg',
    1
);

INSERT INTO `movies` (`name`,`releaseyear`,`rating`,`synopsis`,`category`,`created_date`,`poster_url`,`creator`) 
VALUES (
    'Star Wars: Episode VI - Return of the Jedi',
    1983,
    4.7,
    'After rescuing Han Solo from Jabba the Hutt, the Rebel Alliance attempts to destroy the second Death Star.',
    'Adventure',
    '2024-08-23',
    'https://media.themoviedb.org/t/p/w220_and_h330_face/oMPtyvqDz6U8CYzRF7DAgzwZwow.jpg',
    1
);
