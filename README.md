¿Qué es Thymeleaf?
Thymeleaf es un motor de plantillas para aplicaciones web en Java, que permite renderizar páginas HTML de forma dinámica. Es muy popular en aplicaciones Spring Boot, ya que se integra fácilmente con este framework para crear aplicaciones web robustas y mantener la separación entre la lógica del negocio y las vistas.

Características principales:
Lenguaje de plantillas HTML: Thymeleaf trabaja directamente con HTML, lo que facilita la creación de interfaces visuales y es compatible con herramientas de desarrollo web.
Renderizado del lado del servidor: Thymeleaf puede renderizar contenido dinámico en el servidor antes de enviar la respuesta HTML al cliente.
Soporte para atributos personalizados: Utiliza atributos especiales en el HTML como th:text, th:href, th:if, etc., para manipular el contenido dinámicamente.
Buena integración con Spring: Thymeleaf está diseñado para funcionar muy bien con el modelo MVC de Spring.
Instalación y configuración en Spring Boot
Dependencias Maven: Para utilizar Thymeleaf en tu proyecto Spring Boot, necesitas añadir la dependencia en tu archivo pom.xml:
xml

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
Controlador en Spring Boot: Crea un controlador en tu aplicación Spring que maneje las solicitudes HTTP y devuelva una vista Thymeleaf.
java

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "¡Bienvenido a Thymeleaf con Spring Boot!");
        return "home";
    }

}
Plantilla Thymeleaf: Crea un archivo HTML en src/main/resources/templates/home.html.
html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Thymeleaf Example</title>
</head>
<body>
    <h1 th:text="'Mensaje: ' + ${message}">Mensaje por defecto</h1>
</body>
</html>
En este ejemplo, Thymeleaf reemplazará el valor del atributo th:text con el contenido del mensaje pasado desde el controlador ("¡Bienvenido a Thymeleaf con Spring Boot!").

Funcionalidades clave de Thymeleaf
Mostrar datos dinámicos:

html
<span th:text="${nombre}">Nombre por defecto</span>
Condicionales:

html

<p th:if="${edad > 18}">Eres mayor de edad</p>
Bucles:

html

<ul>
    <li th:each="producto : ${productos}" th:text="${producto.nombre}"></li>
</ul>
Enlaces dinámicos:

html
<a th:href="@{/contacto}">Contacto</a>

¿EXPLICAR COMO FUNCIONA EL NOT? --INVESTIGACION--

<td th:if="${not (user.email !=null)}" th:text="${'N/A'}">Email</td>

@ModelAttriubte
Se usa para trabajar con datos entre el controlador y la vista. Te ayuda a preparar datos que la vista necesita o recoger datos enviados por el usuario en un formulario.
En el curso se explica que se puede pasar a todo el codigo, el ejemplo declara el modalAtrrigubte y lo manda a lamar en la vista

¿Para qué sirve @ModelAttribute?
Para enviar datos a la vista: Si quieres que ciertos datos estén disponibles en tu página (vista) antes de mostrarla, puedes usar
@ModelAttribute. Así esos datos estarán listos para ser mostrados en el formulario o en cualquier parte de la página.

Para recoger datos del formulario: Cuando un usuario llena un formulario y lo envía, los datos que ingresó se pueden guardar automáticamente en un objeto gracias a @ModelAttribute.

public class User {
private String name;
private String email;

    // Getters y setters (métodos para obtener y poner valores)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

Controlador con @ModelAttribute
@Controller
public class UserController {

    // Método para crear un objeto User vacío y pasarlo a la vista
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User(); // Creamos un objeto vacío
    }

    // Mostrar el formulario
    @GetMapping("/userForm")
    public String showForm() {
        return "userForm"; // La página donde está el formulario
    }

    // Recoger los datos del formulario y hacer algo con ellos
    @PostMapping("/submitUser")
    public String submitUser(@ModelAttribute("user") User user) {
        // Aquí, Spring recoge los datos del formulario y los pone en el objeto User
        System.out.println("Nombre: " + user.getName());
        System.out.println("Correo: " + user.getEmail());
        return "userResult"; // Después de enviar el formulario, muestra esta página
    }

}

@RequestParam
@RequestParam se usa para capturar los parámetros individuales enviados en una solicitud HTTP,
como cuando un formulario se envía con un método GET o POST.
Esto te permite extraer esos valores y usarlos en tu controlador.

¿Cómo se usa?
Obtener parámetros individuales: Puedes usar @RequestParam para obtener valores de parámetros de la URL o de un formulario.
Valor predeterminado: Puedes darle un valor predeterminado a un parámetro en caso de que no se pase.
Requerir parámetros: Puedes hacer que un parámetro sea obligatorio.

Paso 1: Controlador con @RequestParam
java
Copiar código

@Controller
public class UserController {

    // Muestra el formulario donde el usuario ingresará su nombre y correo
    @GetMapping("/userForm")
    public String showForm() {
        return "userForm";  // Vista con el formulario
    }

    // Recoge los datos del formulario usando @RequestParam
    @PostMapping("/submitUser")
    public String submitUser(@RequestParam("name") String name,
                             @RequestParam("email") String email) {
        // Los valores de name y email vienen del formulario
        System.out.println("Nombre: " + name);
        System.out.println("Correo: " + email);

        return "userResult";  // Muestra una página de resultado
    }

}

Paso 2: Vista del formulario (userForm.jsp)
El formulario en la vista pedirá el nombre y el correo electrónico.

html
Copiar código

<form action="/submitUser" method="post">
    <label for="name">Nombre:</label>
    <input type="text" id="name" name="name" />

    <label for="email">Correo electrónico:</label>
    <input type="email" id="email" name="email" />

    <button type="submit">Enviar</button>

</form>

HttpServletRequest

En Spring Framework, HttpServletRequest es una interfaz de la especificación Servlet de Java que se utiliza para
representar una solicitud HTTP que llega al servidor. Esta interfaz proporciona métodos para acceder a toda la
información relevante sobre la solicitud, como los parámetros, las cabeceras, el cuerpo de la solicitud y otros
detalles relacionados con la comunicación HTTP.

En el contexto de Spring, HttpServletRequest se utiliza comúnmente dentro de los controladores (controllers) y otras
capas de la aplicación para manejar las solicitudes entrantes y extraer la información necesaria.

Usos comunes de HttpServletRequest en Spring:
Obtener parámetros de la solicitud: Puedes acceder a los parámetros de la solicitud (por ejemplo, los valores enviados en la URL o en un formulario) mediante el método getParameter().

java
Copiar código
@GetMapping("/saludar")
public String saludar(HttpServletRequest request) {
String nombre = request.getParameter("nombre");
return "Hola, " + nombre;
}
Obtener atributos de la solicitud: Puedes almacenar y recuperar atributos que puedan ser necesarios durante la duración de la solicitud. Los atributos son generalmente objetos que puedes usar para compartir información entre diferentes partes de la aplicación durante la solicitud.

java
Copiar código
request.setAttribute("miAtributo", "valor");
String atributo = (String) request.getAttribute("miAtributo");
Acceder a cabeceras HTTP: Las cabeceras HTTP son metadatos que acompañan la solicitud, como el tipo de contenido, la autenticación, el idioma, etc.

java
Copiar código
String userAgent = request.getHeader("User-Agent");
Obtener la URL completa de la solicitud: Puedes acceder a la URL completa que se utilizó para realizar la solicitud, incluyendo el protocolo (http/https), el dominio y la ruta.

java
Copiar código
String url = request.getRequestURL().toString();
Obtener información sobre el método HTTP: HttpServletRequest te permite saber si la solicitud fue realizada con un método HTTP como GET, POST, PUT, DELETE, etc.

java
Copiar código
String metodo = request.getMethod(); // "GET", "POST", etc.
Acceder al cuerpo de la solicitud (para POST, PUT, etc.): Si necesitas leer el contenido enviado en el cuerpo de la solicitud (por ejemplo, en solicitudes POST o PUT), puedes hacerlo a través de request.getInputStream().

Uso de HttpServletRequest en un c

Anotacion @PathVaribale

@PathVariable en Spring:

Qué es: Permite capturar valores de las variables en la URL de una solicitud HTTP.
Uso común: Para obtener datos de una URL dinámica, como identificadores de recursos.
Ejemplo básico:

@GetMapping("/usuarios/{id}")
public String obtenerUsuario(@PathVariable Long id) {
return "Usuario con ID: " + id;
}
Si la URL es /usuarios/123, id será 123.

Múltiples variables:
@GetMapping("/productos/{categoria}/{id}")
public String obtenerProducto(@PathVariable String categoria, @PathVariable Long id) {
return "Producto en " + categoria + " con ID: " + id;
}

Map y HashMap en Java:

1. Map:
   Qué es: Es una interfaz que define una estructura de datos que almacena pares clave-valor.
   Métodos comunes:
   put(K key, V value): Agrega un par clave-valor.
   get(Object key): Obtiene el valor asociado con la clave.
   containsKey(Object key): Verifica si una clave existe.
   remove(Object key): Elimina el par clave-valor.
   Ejemplo de uso:

Map<String, Integer> mapa = new HashMap<>();
mapa.put("a", 1);
mapa.put("b", 2);
System.out.println(mapa.get("a")); // Imprime 1

2. HashMap:
   Qué es: Es una implementación de la interfaz Map. Usa una tabla hash para almacenar los elementos y permite acceder a los valores rápidamente a través de las claves.

Características:

No garantiza el orden de los elementos.
Permite claves nulas (solo una clave null).
Rendimiento rápido en operaciones get() y put(), generalmente O(1).
Ejemplo de uso:

HashMap<String, Integer> mapa = new HashMap<>();
mapa.put("a", 1);
mapa.put("b", 2);
mapa.put("c", 3);
System.out.println(mapa.get("b")); // Imprime 2

@RequestBody en Spring:

Qué es: Es una anotación que se usa para vincular el cuerpo de la solicitud HTTP con un parámetro del método del controlador. Sirve para recibir datos en el cuerpo de la solicitud, generalmente en formato JSON o XML, y convertirlos a un objeto Java.

Uso común: Se utiliza principalmente en métodos POST, PUT, o PATCH donde los datos se envían en el cuerpo de la solicitud.

Ejemplo básico:
java
Copiar código
@PostMapping("/usuarios")
public String crearUsuario(@RequestBody Usuario usuario) {
// usuario contiene los datos del cuerpo de la solicitud (JSON)
return "Usuario creado: " + usuario.getNombre();
}
Si envías una solicitud POST con un cuerpo JSON:

json
Copiar código
{
"nombre": "Juan",
"edad": 30
}
Spring convierte automáticamente el JSON en un objeto Usuario y lo pasa al parámetro usuario.

Notas clave:
Deserialización automática: Spring usa bibliotecas como Jackson para convertir el cuerpo JSON a un objeto Java.
Uso típico: En solicitudes POST y PUT donde los datos se envían en el cuerpo (en vez de en parámetros de la URL).
Resumen:
@RequestBody: Captura el contenido del cuerpo de la solicitud HTTP y lo convierte en un objeto Java. Es útil para recibir datos complejos (como JSON) en una solicitud.
