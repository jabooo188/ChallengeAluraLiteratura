# ChallengeAluraLiteratura
Segundo proyecto para Alura con el fin de poner en practica lo aprendido en la modalidad Backend 

# Descripción

Este proyecto es el segundo de los 3 que conforman este modulo dentro de la modalidad Backend. El software desarrollado permite al usuario interactuar con un menú el cual ofrece 5 diferentes opciones para buscar libros, todo esto consumiendo la API GutendexAPI, que nos permite consultar distintos datos relacionados a una obra literaria.
El proyecto trabaja solicitando al usuario seleccionar una de las 5 opciones mediante una interfaz de menú las cuales van desde buscar un libro nuevo a travez del api y almacenarlo en nuestra base de datos, consultar libros y autores en nuestra base de datos o buscarlos por idioma.

# Tecnologias

### Lenguajes:
- Java.
### Dependencias
- Jackson.
- Spring Data JPA.
- PostgreSQL Driver.
### Entorno de desarrollo:
- IntelliJ IDE, entorno de desarrollo integrado.
### API´s:
- GutendexAPI.

# Funcionalidad

### Clase Principal
Esta clase incluye la logica principal como la fincionalidad de nuestro menú de opción multiple mostrado en la terminal y metodos principales de las opciones.

### Clases y records paquete modelo
- Libro: contiene todas las variables de los datos que almacenará nuesta base de datos y los constructores.
- Autor: contiene todas las variables de los datos que almacenará nuesta base de datos y los constructores.
- Generos: Contiene un listado de los posibles generos de las obras almacenadas.
- DatosLibro: Record con el mapeo de datos necesario para el almacenamiento de libros.
- record/Autores: Record con el mapeo de datos necesario para el almacenamiento de los autores.
- ResultadosAPIBusqueda: Clase que retorna el Json resultante de la consulta.

### Repositorios
- LibrosRepository: Esta interfaz del tipo repositorio nos permite almacenar Querry´s especiales que son gestionadas por la dependencia Spring Data JPA para solicitudes a nuestra base de datos. 
- AutoresRepository: Al igual que el repositorio de Libros, este tambien almacena Query´s pero para las solicitudes de los autores.

### Service
- ConsumoAPI: Clase dedicada a establecer conexion con el API a consumir.
- ConvertirDatos: Se encarga de gestionar la conversion del JSON mapenadolo como un Objeto Java para su posterior uso en la aplicación.
- IConvertirDatos: Clase generica para la recepción de un archivo JSON.

### ChallengeAluraLiteratura
Esta es la clase raiz proporcionada por nuestro iniciador del SpringBoot, contiene una instancia de la clase Principal para iniciar el proyecto.

# Instrucciones

- Clonar el repositorio a tu PC.
- Agregar las dependencias Spring Data JPA, Jackson y PostgreSQL Driver en el archivo pom.xml.
- Descargar e instalar PostgreSQL
- Crear una base de datos en PostgreSQL
- Actualizar las variables de entorno (si se tiene) dentro de nuestro archivo aplication.properties de la carpeta resources.
- Abrir la clase Principal y ejecutar el programa.

## Desarrollado por:

#### Javier Emilio Chua Camarena.
