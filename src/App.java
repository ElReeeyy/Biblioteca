import java.util.Scanner;

public class App {
    /**
     * @author Alejandro Rey Tostado
     * @author Alberto Garcia Izquierdo
     */

     public static String menu(Scanner teclado) {
        System.out.println(" ---- BIENVENIDO A LA CASA DE LOS LIBROS  ---- ");
        System.out.println("|           1. INICIAR SESION                 |");
        System.out.println("|           2. ESTADISTICAS Y REPORTES        |");
        System.out.println("|           0. SALIR                          |");
        System.out.println(" -------------------------------------------- ");

        if (teclado.hasNextLine()) { // verifica si hay una línea disponible para leer
            return teclado.nextLine();
        } else {
            System.out.println("No se encontró una línea para leer.");
            return "";
        }
    }

    public static void iniciarSesion(Scanner teclado, EstadisticasReportes estadisticas) {
        System.out.print("Nombre de usuario: ");
        String nombreIngresado = teclado.nextLine();
        System.out.print("Contraseña: ");
        String contraseniaIngresada = teclado.nextLine();

        for (Usuarios user : Usuarios.listaUsuarios) {
            if (user != null && user.getNombre().equals(nombreIngresado) && user.getContrasenia().equals(contraseniaIngresada)) {
                user.menuAdmin(teclado, estadisticas, new Libros(null, null, null, false));
                return;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        // CREACION DE USUARIOS
        Usuarios usuario = new Usuarios("Alejandro", "admin", true);
        Usuarios usuario2 = new Usuarios("Alberto", "1234", false);
        Usuarios usuario3 = new Usuarios("Pepe", "1234", false);
        Usuarios usuario4 = new Usuarios("Miguel", "1234", false);
        Usuarios usuario5 = new Usuarios("Jose Antonio", "1234", false);

        // Añadir usuarios a la lista
        Usuarios.listaUsuarios.add(usuario);
        Usuarios.listaUsuarios.add(usuario2);
        Usuarios.listaUsuarios.add(usuario3);
        Usuarios.listaUsuarios.add(usuario4);
        Usuarios.listaUsuarios.add(usuario5);

        // CREACION DE LIBROS
        Libros libro1 = new Libros("El señor de los anillos", "J.R.R. Tolkien", Categoria.NOVELA, false);
        Libros libro2 = new Libros("It", "Stephen King", Categoria.TERROR, false);
        Libros libro3 = new Libros("La guerra de los mundos", "H.G. Wells", Categoria.CIENCIA_FICCION, true);
        Libros libro4 = new Libros("La historia interminable", "Michael Ende", Categoria.INFANTIL, true);
        Libros libro5 = new Libros("El principito", "Antoine de Saint-Exupéry", Categoria.JUVENIL, false);
        Libros.listaLibros.add(libro1);
        Libros.listaLibros.add(libro2);
        Libros.listaLibros.add(libro3);
        Libros.listaLibros.add(libro4);
        Libros.listaLibros.add(libro5);

        // Inicializar EstadisticasReportes
        String[] librosPrestados = new String[100];
        int[] cantidadPrestamos = new int[100];
        String[] usuarios = new String[100];
        int[] prestamosPorUsuario = new int[100];
        EstadisticasReportes estadisticas = new EstadisticasReportes(librosPrestados, cantidadPrestamos, usuarios, prestamosPorUsuario, 0, 0);

        do {
            switch (menu(teclado)) {
                case "1" -> iniciarSesion(teclado, estadisticas);
                case "2" -> estadisticas.menuEstadisticas(teclado);
                case "0" -> {
                    salir = true;
                    System.out.println("Gracias por usar nuestra aplicación.");
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (!salir);

        teclado.close();

    }
}    
