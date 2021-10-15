delete from user_role;
delete from usr;

insert into usr(id, activation_code, active, email, password, username) values
(1, '123', 1, 'melov71462@wii999.com', '$12$9Bx1/5BEhAtlKpP0Nk8lt.lpTpXTC6ctuj9O1ZTGcv.nrmUj9sQsm', 'admin'),
(2, '123', 1, 'melov71462@wii999.com', '$12$9Bx1/5BEhAtlKpP0Nk8lt.lpTpXTC6ctuj9O1ZTGcv.nrmUj9sQsm', 'mike');

insert into user_role(user_id, roles) values
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');

