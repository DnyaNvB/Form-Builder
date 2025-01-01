INSERT INTO form (name, is_published, submit_method, submit_url) VALUES
('Sample Form', false, 'POST', '/submit');

INSERT INTO field (name, label, type, default_value, form_id) VALUES
('username', 'Username', 'TEXT', '', 1),
('age', 'Age', 'NUMBER', '18', 1),
('subscribe', 'Subscribe to newsletter', 'BOOLEAN', 'false', 1),
('birthdate', 'Birth Date', 'DATE', '', 1);
