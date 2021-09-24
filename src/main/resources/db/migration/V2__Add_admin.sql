insert into usr (id, username, password, active, email)
    values (1, 'admin',  '$2a$12$lzgUGQHsXb8/sBfUFnAoy.LbyyktLmbqa5KvRU2vwjKYqKUSIfkDW', true, 'higih27606@soulsuns.com');

insert into user_role(user_id, roles)
    values(1, 'USER'), (1, 'ADMIN');