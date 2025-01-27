import java.util.Scanner;

public class Usuarios {
    private String nombre;
    private String contrasenia;
    private boolean esAdmin;

    public static final Scanner teclado = new Scanner(System.in);

    public Usuarios(String nombre, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    // METODOS

    public void iniciarSesion() {
        System.out.print("Nombre de usuario: ");
        nombre = teclado.nextLine();
        System.out.print("Contraseña: ");
        contrasenia = teclado.nextLine();

        if (esAdmin == true) {
            System.out.println("\n--- Bienvenido, " + nombre + ". Eres administrador ---");
            System.out.println("¿Qué movimientos desea realizar?");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Consultar informacion de usuarios registrados");
        } else {
            System.out.println("\n--- Bienvenido, " + nombre + "¿Qué movimientos desea realizar? ---");
        }

        teclado.close();
    }

    public void registrarUsuario() {
        System.out.print("Vas a agregar un nuevo usuario.\nIntroduzca el nombre del usuario: ");
        nombre = teclado.nextLine();
        System.out.println("Introduzca la contrasenia del usuario: ");
        contrasenia = teclado.nextLine();
        System.out.println("Usuario registrado con éxito.");
        teclado.close();
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