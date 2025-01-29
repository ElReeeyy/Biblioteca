import java.util.Scanner;

public class Usuarios {
    private String nombre;
    private String contrasenia;
    private boolean esAdmin;

    public Usuarios(String nombre, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    // METODOS

    public void iniciarSesion(Scanner teclado) {
        System.out.print("Nombre de usuario: ");
        String nombreIngresado = teclado.nextLine();

        System.out.print("Contraseña: ");
        String contraseniaIngresada = teclado.nextLine();

        if (this.nombre.equals(nombreIngresado) && this.contrasenia.equals(contraseniaIngresada)) {
            if (this.esAdmin) {
                System.out.println("\n--- Bienvenido, " + this.nombre + ". Eres ADMINISTRADOR ---");
                System.out.println("¿Qué movimientos desea realizar?");
                System.out.println("1. Registrar nuevo usuario");
                System.out.println("2. Consultar información de usuarios registrados");
            } else {
                System.out.println("\n--- Bienvenido, " + this.nombre + " ¿Qué movimientos desea realizar? ---");
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    public void registrarUsuario(String nombre, String contrasenia, boolean esAdmin, Usuarios admin) {
        Scanner teclado = new Scanner(System.in);

        if (admin.esAdmin) {
            System.out.println("Vas a agregar un nuevo usuario.");
            System.out.print("Introduzca el nombre del usuario: ");
            nombre = teclado.nextLine();
            System.out.print("Introduzca la contrasenia del usuario: ");
            contrasenia = teclado.nextLine();
            System.out.print("¿Es administrador? (s/n): ");
            String respuesta = teclado.nextLine();
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("No tienes permisos para registrar un nuevo usuario.");
        }

        teclado.close();
    }

    public void consultarUsuarios(Usuarios admin) {
        if (admin.esAdmin) {
            System.out.println("Usuarios registrados:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Contrasenia: " + contrasenia);
            System.out.println("Es administrador: " + esAdmin);
        } else {
            System.out.println("No tienes permisos para consultar los usuarios registrados.");
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