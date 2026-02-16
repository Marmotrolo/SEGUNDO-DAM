CREATE DATABASE eventoia;
-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'parradito3'@'%' IDENTIFIED BY 'parradito3';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `eventoia`.* TO 'parradito3'@'%';
--  Refrescar
FLUSH PRIVILEGES;
