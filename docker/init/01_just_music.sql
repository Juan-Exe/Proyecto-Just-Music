CREATE DATABASE IF NOT EXISTS `just_music` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `just_music`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `users` (`correo`, `contraseña`) VALUES
('juandiegoarrietaherrera@gmail.com', '200404Juan'),
('JovaniV45@gmail.com', '123456'),
('JMario12@gmail.com', '123456'),
('Said05@gmail.com', '123456'),
('ValeOje98@gmail.com', '123456'),
('DayannaKaroll88@gmail.com', '123456'),
('Manrrique04@gmail.com', '123456'),
('SamuelElias@gmail.com', '123456');

CREATE TABLE `users_artista` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `users_artista` (`correo`, `contraseña`) VALUES
('Samuel05@gmail.com', '123456');

CREATE USER IF NOT EXISTS 'just_music_user'@'%' IDENTIFIED BY 'justmusic2024';
CREATE USER IF NOT EXISTS 'just_music_user'@'localhost' IDENTIFIED BY 'justmusic2024';
GRANT ALL PRIVILEGES ON just_music.* TO 'just_music_user'@'%';
GRANT ALL PRIVILEGES ON just_music.* TO 'just_music_user'@'localhost';
FLUSH PRIVILEGES;
