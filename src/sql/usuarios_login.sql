USE levelup_arcade;

DELETE FROM usuario
WHERE nombre IN ('admin', 'empleado');

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('admin', SHA2('admin', 256), 'ADMIN');

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('empleado', SHA2('empl123', 256), 'EMPLEADO');
