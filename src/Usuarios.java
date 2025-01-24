import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    private String nombre;
    private String contrasenia;
    private boolean esAdmin;

    private ArrayList<String> listaUsuarios = new ArrayList<String>();  // ArrayList para almacenar los usuarios registrados

    public Usuarios(String nombre, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    public void iniciarSesion() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        nombre = teclado.nextLine();
        System.out.print("Contrasenia: ");
        contrasenia = teclado.nextLine();

        if (esAdmin) {
            esAdmin = true;
            System.out.println("Bienvenido, " + nombre + ". Usted es administrador.");
            System.out.println("¿Qué movimientos desea realizar?");
            registrarUsuario();
        } else {
            esAdmin = false;
            System.out.println("Bienvenido, " + nombre + "¿Qué movimientos desea realizar?");
        }

        teclado.close();
    }

    public void registrarUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del usuario: ");
        nombre = teclado.nextLine();
        listaUsuarios.add(nombre);
        System.out.println("Introduzca la contrasenia del usuario: ");
        contrasenia = teclado.nextLine();
        listaUsuarios.add(contrasenia);
        System.out.println("Usuario registrado con éxito.");
        teclado.close();
    }

}
