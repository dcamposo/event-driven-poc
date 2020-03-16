DROP TABLE IF EXISTS invetory;

CREATE TABLE invetory (
  id VARCHAR(250)  PRIMARY KEY,
  festivalName VARCHAR(250) NOT NULL,
  qtyAvailable INT NOT NULL,
);

CREATE TABLE reserve (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customerId VARCHAR(250) NOT NULL,
  id_invetory VARCHAR(250)  NOT NULL,
  amount DECIMAL NOT NULL,
  FOREIGN KEY (id_invetory) REFERENCES invetory(id) ,
  );


