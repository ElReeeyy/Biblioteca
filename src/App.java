import java.util.Scanner;

public class App {
    /**
     * @author Alejandro Rey Tostado
     * @author Alberto Garcia Izquierdo
     */

     public static final Scanner teclado = new Scanner(System.in);

     public static String menu() {
        System.out.println("--- BIENVENIDO A SU BIBLIOTECA FAVORITA ---");
        System.out.println("1. INICIAR SESION");
        System.out.println("2. SALIR");

        if (teclado.hasNextLine()) {
            return teclado.nextLine();
        } else {
            System.out.println("No se encontró una línea para leer.");
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        boolean salir = false;

        // CREACION DE USUARIOS
        Usuarios usuario = new Usuarios("Alejandro", "admin", true);
        Usuarios usuario2 = new Usuarios("Alberto", "1234", false);
        Usuarios usuario3 = new Usuarios("Pepe", "1234", false);
        Usuarios usuario4 = new Usuarios("Miguel", "1234", false);
        Usuarios usuario5 = new Usuarios("Jose Antonio", "1234", false);

        // CREACION DE LIBROS
        Libros libro1 = new Libros("El señor de los anillos", "J.R.R. Tolkien", Categoria.NOVELA, false);
        Libros libro2 = new Libros("It", "Stephen King", Categoria.TERROR, false);
        Libros libro3 = new Libros("La guerra de los mundos", "H.G. Wells", Categoria.CIENCIA_FICCION, true);
        Libros libro4 = new Libros("La historia interminable", "Michael Ende", Categoria.INFANTIL, true);
        Libros libro5 = new Libros("El principito", "Antoine de Saint-Exupéry", Categoria.JUVENIL, false);

        do {
            switch (menu()) {
                case "1" -> usuario.iniciarSesion(teclado);
                case "2" -> {
                    salir = true;
                    System.out.println("Gracias por usar nuestra aplicación.");
                }
            }
        } while(!salir);
    }
}
