delete from message;

insert into message(id, filename, tag, text, user_id) values
(1, 'file', 'my-tag', 'first', 1),
(2, 'file', 'hello', 'first', 1),
(3, 'file', 'my-tag', 'first', 1),
(4, 'file', 'good', 'first', 1);

ALTER TABLE message AUTO_INCREMENT=10;