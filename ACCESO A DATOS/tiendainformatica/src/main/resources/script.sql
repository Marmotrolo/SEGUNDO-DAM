create database tiendainformatica;
-- Crear el usuario (si ya existe, esto dará error, puedes usar IF NOT EXISTS)
CREATE USER IF NOT EXISTS 'parradito'@'%' IDENTIFIED BY 'parradito';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `tiendainformatica`.* TO 'parradito'@'%';
--  Refrescar
FLUSH PRIVILEGES;
