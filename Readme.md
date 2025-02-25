Нужно собрать таблицу в postgreSQL
CREATE TABLE my_table (
id SERIAL PRIMARY KEY,
faculty VARCHAR(255),
fio VARCHAR(255),
sum_points INTEGER,
some_code VARCHAR
);

Запустить проект - mvn spring-boot:run

Нужно поменять: 1.src\main\resources\application.properties (надо вставить свое название бд и пароль) 2.src\main\java\com\converter\pdf\PdfApplication.java (надо указать свой путь до файла пдф)
