DROP TABLE IF EXISTS billionaires;

CREATE TABLE essen (
  id_essen INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  art VARCHAR(20) NOT NULL,
  price int NOT NULL
);

CREATE TABLE essensplan (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  wochentag VARCHAR(50) NOT NULL,
  essen VARCHAR(20) NOT NULL,
  art VARCHAR(20) NOT NULL,
  price int NOT NULL
);

CREATE TABLE essensplan_pro_woche (
  id_woche INT AUTO_INCREMENT  PRIMARY KEY,
  wochentag VARCHAR(50) NOT NULL,
  essen VARCHAR(20) NOT NULL,
  art VARCHAR(20) NOT NULL,
  price int NOT NULL
);
