INSERT INTO CLASSROOM(id, trainer) VALUES (1, 'Bob');
INSERT INTO TRAINEE(traineeid, id, traineename) VALUES (1, LAST_INSERT_ID(), 'Tazzz')

INSERT INTO CLASSROOM(id, trainer) VALUES (2, 'Betty');
INSERT INTO TRAINEE(traineeid, id, traineename) VALUES (2, LAST_INSERT_ID(), 'Tes')

INSERT INTO CLASSROOM(id, trainer) VALUES (3, 'Ridel');
INSERT INTO TRAINEE(traineeid, id, traineename) VALUES (3, LAST_INSERT_ID(), 'Ivan')