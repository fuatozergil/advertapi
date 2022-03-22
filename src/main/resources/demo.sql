
DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  approved BOOLEAN DEFAULT FALSE,
  expired_weeks INT NOT NULL
);
INSERT INTO category (category,approved,expired_weeks) VALUES
  ('Emlak','FALSE',4),
  ('Vasıta','FALSE',3),
  ('Alışveriş','TRUE',8),
  ('Diğer','FALSE',8);
