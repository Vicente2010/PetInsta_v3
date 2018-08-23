# IMPORTANTE: Pon tu correo y contraseña en la clase ContactoActivity linea 55 56 y 58, sino no funcionará la parte de mandar el correo
JavaMail

# PetInsta 3 - Base de Datos

Tarea 5 - Curso3

Review criteria
Tomando como punto de partida la funcionalidad que generaste para mostrar las ultimas 5 mascotas, es momento de dar persistencia a esta información.

Estas 5 mascotas estarán cambiando conforme el usuario da rating a una o varias, mascotas. En el POJO que estas manejando para la entidad mascota genera un identificador el cuál deberá ser único y te permita diferenciar una mascota de otra.

Crea un modelo de base de datos que contenga una tabla llamada mascota esta debe ser idéntica al POJO de mascota, de tal forma que cuando una persona de rating a una foto puedas guardar los datos completos de la entidad en la base de datos. Para fines de este ejercicio tu tabla solo estará guardando las últimas 5 mascotas con rating.

Entegables:

Pantallazos de la aplicación, modelo de base de datos y enlace al proyecto en GitHub


# Tarea anterior
Partiendo de tu proyecto anterior deberás agregarle Menús y Fragments.

AGREGANDO MENÚS:

Crea un menú de opciones que muestre el Item “Contacto” y el Item “Acerca De”

Contacto deberá:

Llevarte a una pantalla con un formulario en el que solicites el nombre, el correo y su mensaje (utiliza los EditText de Material Design),
Además habrá un botón de “Enviar Comentario” el cual tomará la información recopilada y con ayuda de la librería JavaMail envíe un mail con el comentario del contacto.
Este es el enlace con la documentación de JavaMail: https://java.net/projects/javamail/pages/Android

Acerca De, deberá llevarte a una pantalla con la Bio del desarrollador.

FRAGMENTS

A partir de la siguiente imagen de maqueta:

Modulariza el proyecto anterior en Fragments para que estos puedan ser mostrados en un ViewPager.

2. Crea un Fragment Adicional que muestre el perfil de nuestra mascota. Tendrá su foto de perfil, su nombre y un RecyclerView en donde se mostrarán todas las fotos que ha subido se acomodarán en forma de Grid.

3. Cada ítem deberá contener la foto y la cantidad de raits que se le han dado representado por huesos. Recuerda que todos los datos son dummy.

Puedes utilizar esta librería para generar una imagen redonda como foto de perfil de la mascota: https://github.com/lopspower/CircularImageView
