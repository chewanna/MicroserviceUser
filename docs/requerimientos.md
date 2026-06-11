# Microservicio Usuarios

Definicion de las principales funcionales del microservicio

## Atributos

- **id(long)**: es una llave primaria para la identificacion de cada usuario
- **name(String(50))**: representa el nombre del usuario que debe tener una lingitud maxima de 50
- **surname(String(100))**: representa el apellido del usuario con longitud maxima de 100
- **email(String(150))**: representa el correo electronico del usuario, longitud maxima 150
- **adress(String(200))**: representa la direccion del usuario, longitud maxima 200

## Requerimiento funcionales

- **crear usuario**: permite insertar usuario en base de datos
- **buscar usuario**: permite buscar un usuario por email
- **actualizar usuario**: permite actualizar usuario por id
- **obtener todos los usuarios**: mostrar todos los usuarios de la base de datos
- **eliminar usuario**: permite eliminar usuario por id