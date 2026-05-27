# Manual de usuario - LevelUP Arcade

## 1. Descripcion del sistema

LevelUP Arcade es una aplicacion de consola para la gestion basica de una tienda de videojuegos y productos tecnologicos. El sistema permite administrar productos, clientes, categorias y proveedores, ademas de acceder a opciones de apoyo con inteligencia artificial para generar descripciones y sugerir categorias de productos.

El acceso al sistema esta protegido mediante login de usuario y contrasena.

## 2. Requisitos de instalacion

Para ejecutar la aplicacion en otro equipo se necesita:

- Java 21 instalado.
- Acceso a la base de datos MySQL `levelup_arcade`.
- La carpeta de despliegue completa, que incluye:
  - `LevelUP_Arcade.jar`
  - Carpeta `lib`
  - Archivo `ejecutar_levelup.bat`

La aplicacion usa la configuracion incluida en `config.properties` para conectarse a la base de datos:

```properties
db.url=jdbc:mysql://192.168.1.141:3306/levelup_arcade
db.user=dam
db.password=campusFP.26
openrouter.api.key=TU_API_KEY_LOCAL
```

La clave de IA tambien puede configurarse como variable de entorno con el nombre `OPENROUTER_API_KEY`.

## 3. Preparacion de la base de datos

Antes de iniciar la aplicacion, la base de datos debe estar creada con el script SQL del proyecto.

Usuarios de acceso recomendados:

```sql
DELETE FROM usuario
WHERE nombre IN ('admin', 'empleado');

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('admin', SHA2('admin', 256), 'ADMIN');

INSERT INTO usuario (nombre, contrasena, rol)
VALUES ('empleado', SHA2('empl123', 256), 'EMPLEADO');
```

Credenciales:

- Usuario: `admin` / Contrasena: `admin`
- Usuario: `empleado` / Contrasena: `empl123`

## 4. Instrucciones de ejecucion

### Opcion recomendada

1. Abrir la carpeta de despliegue.
2. Hacer doble clic en `ejecutar_levelup.bat`.
3. Introducir usuario y contrasena.
4. Usar el menu principal de la aplicacion.

### Opcion por consola

Desde la carpeta de despliegue, ejecutar:

```bat
java -jar LevelUP_Arcade.jar
```

## 5. Login

Al iniciar, el sistema solicita:

- Usuario
- Contrasena

Si los datos son correctos, aparece el mensaje de bienvenida y se muestra el menu principal. Si los datos no coinciden con la base de datos, aparece `Login incorrecto` y la aplicacion termina.

## 6. Funcionalidades principales

El menu principal contiene estas opciones:

```text
1. Gestionar productos
2. Gestionar clientes
3. Gestionar categorias
4. Gestionar proveedores
5. Inteligencia Artificial
0. Salir
```

## 7. Uso de las opciones del sistema

### Gestion de productos

Permite insertar, listar, buscar, actualizar y eliminar productos. Para crear o actualizar un producto se solicitan datos como nombre, descripcion, precio, stock, categoria y proveedor.

### Gestion de clientes

Permite insertar, listar, buscar, actualizar y eliminar clientes. El sistema solicita nombre, apellidos, email, telefono y direccion.

### Gestion de categorias

Permite insertar, listar, buscar, actualizar y eliminar categorias. Las categorias sirven para clasificar los productos.

### Gestion de proveedores

Permite insertar, listar, buscar, actualizar y eliminar proveedores. Los proveedores se asocian a los productos disponibles en la tienda.

### Inteligencia Artificial

Incluye dos opciones:

- Generar una descripcion comercial breve para un producto.
- Sugerir una categoria para un producto.

Esta funcionalidad requiere que el servicio de IA configurado en el proyecto este disponible.

## 8. Cierre de la aplicacion

Para salir del sistema, seleccionar la opcion `0` en el menu principal.

## 9. Solucion de problemas

Si aparece `Login incorrecto`, revisar que el usuario exista en la tabla `usuario` y que la contrasena este guardada con `SHA2(..., 256)`.

Tambien se puede ejecutar el archivo `usuarios_login.sql` incluido en el despliegue para recrear los usuarios de acceso.

Si aparece un error de conexion, revisar que MySQL este iniciado, que la IP `192.168.1.141` sea accesible y que las credenciales de `config.properties` sean correctas.

Si el sistema no arranca, comprobar que Java 21 este instalado ejecutando:

```bat
java -version
```
