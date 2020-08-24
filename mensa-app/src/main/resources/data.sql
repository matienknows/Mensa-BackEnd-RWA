INSERT INTO meal (name, type, price)
VALUES ('Vollkornnudeln', 'vegan', 2.30),
('Falafel', 'vegan', 1.90),
('Reishänchenpfanne', 'fleischhaltig', 2.60),
('Burger', 'fleischhaltig', 2.60),
('Kartoffelpüree', 'vegetarisch', 2.30),
('Fischfilet', 'vegetarisch', 2.90);

INSERT INTO meal_table (calendar_week)
VALUES (1),(2),(3),(4),(5),(6),(7);

INSERT INTO meal_table_meal_table_week (meal_table_id, meal_table_week_id, meal_table_week_key)
VALUES
(1, 4, 0),
(1, 3, 1),
(1, 1, 2),
(1, 5, 3),
(1, 2, 4);
