INSERT INTO statistics.main (name) VALUES ('MAIN');
INSERT INTO statistics.child (name, main_id) VALUES ('userTwo', (
    SELECT id from statistics.main LIMIT 1
    ));
