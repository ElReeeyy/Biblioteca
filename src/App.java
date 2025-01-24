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
    
        return teclado.nextLine();
    }

    public static void main(String[] args) throws Exception {
        boolean salir = false;

        Usuarios usuario = new Usuarios("admin", "admin", true);

        do {
            switch (menu()) {
                case "1" -> usuario.iniciarSesion();
                case "2" -> {
                    salir = true;
                    System.out.println("Gracias por usar nuestra aplicación.");
                }
            }
        } while(!salir);
    }
}
