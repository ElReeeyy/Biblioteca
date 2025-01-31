import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    private String nombre;
    private String contrasenia;
    private boolean esAdmin;
    
    public static  ArrayList<Usuarios> listaUsuarios = new ArrayList<>();

    public Usuarios(String nombre, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    // METODOS
    public void menuAdmin(Scanner teclado, EstadisticasReportes estadisticas, Libros libros) {
        if (this.esAdmin) {
            System.out.println("\n--- Bienvenido, " + this.nombre + ". Eres ADMINISTRADOR ---");
            System.out.println("¿Qué movimientos desea realizar?");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Consultar información de usuarios registrados");
            System.out.println("0. SALIR");
            String opcion = teclado.nextLine();
            
            if (opcion.equals("1")) {
                registrarUsuario(teclado);
            } else if (opcion.equals("2")) {
                consultarUsuarios();
            } else if (opcion.equals("0")) {
                System.out.println("Saliendo...");
            } else System.out.println("Opción no válida.");
        } else {
            System.out.println("\n--- Bienvenido, " + this.nombre + " ---");
            boolean salir = false;
            while (!salir) {
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Buscar libros por categoría");
                System.out.println("2. Buscar libros por título");
                System.out.println("3. Buscar libros por autor");
                System.out.println("4. Mostrar todos los libros disponibles");
                System.out.println("5. Realizar préstamo de libro");
                System.out.println("6. Devolver libro prestado");
                System.out.println("0. SALIR");
                String opcion = teclado.nextLine();

                switch (opcion) {
                    case "1" -> {
                        System.out.println("Introduzca la categoría del libro: ");
                        String categoria = teclado.nextLine();
                        libros.buscarLibrosPorCategoria(categoria);
                    }
                    case "2" -> {
                        System.out.println("Introduzca el título del libro: ");
                        String titulo = teclado.nextLine();
                        libros.buscarLibrosPorTitulo(titulo);
                    }
                    case "3" -> {
                        System.out.println("Introduzca el autor del libro: ");
                        String autor = teclado.nextLine();
                        libros.buscarLibrosPorAutor(autor);
                    }
                    case "4" -> libros.buscarLibro();
                    case "5" -> {
                        System.out.println("Introduzca el título del libro a prestar: ");
                        String libroPrestar = teclado.nextLine();
                        estadisticas.registrarPrestamo(libroPrestar, this.nombre);
                    }
                    case "6" -> {
                        System.out.println("Introduzca el título del libro a devolver: ");
                        String libroDevolver = teclado.nextLine();
                        estadisticas.devolverPrestamo(libroDevolver);
                    }
                    case "0" -> {
                        salir = true;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida.");
                }
            }
        }
    }

    public void registrarUsuario(Scanner teclado) {
        System.out.println("Vas a agregar un nuevo usuario.");
        System.out.print("Introduzca el nombre del usuario: ");
        String nombre = teclado.nextLine();
        System.out.print("Introduzca la contrasenia del usuario: ");
        String contrasenia = teclado.nextLine();
        System.out.print("¿Es administrador? (s/n): ");
        String respuesta = teclado.nextLine();
        boolean esAdmin = respuesta.equalsIgnoreCase("s");
        Usuarios nuevoUsuario = new Usuarios(nombre, contrasenia, esAdmin);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");

        teclado.close();
    }

    public void consultarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuarios usuario : listaUsuarios) {
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Contrasenia: " + usuario.getContrasenia());
            System.out.println("Es administrador: " + usuario.isEsAdmin());
            System.out.println("-------------------------");
        }
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEsAdmin() {
        return this.esAdmin;
    }

    public boolean getEsAdmin() {
        return this.esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}