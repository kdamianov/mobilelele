INSERT INTO users (id, active, email, first_name, last_name, password)
VALUES (1, 1, 'admin@example.com', 'Admin', 'Adminov',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
       (2, 1, 'user@example.com', 'User', 'Userov',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');


INSERT INTO roles (`id`, `role`)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES (1, 1),
       (1, 2),
       (2, 2);


INSERT INTO `brands` (`id`, `name`)
VALUES (1, 'Toyota'),
       (2, 'Ford'),
       (3, 'Trabant');

INSERT INTO `models` (`id`, `category`, `brand_id`, `name`)
VALUES (1, 'CAR', 1, 'Camry'),
       (2, 'CAR', 1, 'Corolla'),
       (3, 'CAR', 2, 'Focus'),
       (4, 'CAR', 2, 'Fiesta'),
       (5, 'CAR', 3, 'P601');


INSERT INTO `offers` (id, description, engine, image_url, mileage, price, transmission, uuid, year, model_id)
VALUES
    (1, 'Trabi monster!', 'PETROL', 'http://tuning.im/wp-content/uploads/2014/03/Trabant-601-Tuning-3.jpg', 245000, 2000.00, 'MANUAL', '082ca57a-ee16-4d2c-9dd3-d9a0ca8b21bf', 1976, 5),
    (2, 'Trabi monster!', 'PETROL', 'https://scontent.fsof8-1.fna.fbcdn.net/v/t39.30808-6/276265740_5344746485557509_3760738885886882566_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=AR2sV4S38IwAX8k8x7f&_nc_ht=scontent.fsof8-1.fna&oh=00_AfCjUHyca6suAYSlStB0CMEZ7iTDwfA7VGgR8oDBj80TAg&oe=654C073B', 245001, 2001.00, 'MANUAL', '082ca57a-ee16-4d2c-9dd3-d9a0ca8b21bf', 1975, 5),
    (3, 'Trabi monster!', 'PETROL', 'https://imgr1.auto-motor-und-sport.de/Trabant-Trabbi-Kleinwagen-Tuning-169FullWidth-edb897a0-913123.jpg', 245002, 2002.00, 'MANUAL', '082ca57a-ee16-4d2c-9dd3-d9a0ca8b21bf', 1974, 5),
    (4, 'Trabi monster!', 'PETROL', 'https://www.capitan.bg/wp-content/uploads/2018/05/tuning-trabant.jpg', 245003, 2003.00, 'MANUAL', '082ca57a-ee16-4d2c-9dd3-d9a0ca8b21bf', 1973, 5),
    (5, 'Trabi monster!', 'PETROL', 'https://cdn.pixabay.com/photo/2019/11/20/20/12/trabant-4641045_1280.jpg', 245004, 2004.00, 'MANUAL', '082ca57a-ee16-4d2c-9dd3-d9a0ca8b21bf', 1972, 5);
