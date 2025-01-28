import java.util.Scanner;

public class Libros {
    private String nombre;
    private String autor;
    private String categoria;
    private boolean prestado;

    public static final Scanner teclado = new Scanner(System.in);


    public Libros(String nombre, String autor, String categoria, boolean prestado) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.prestado = prestado;
    }    
    
    // METODOS

    public void agregarLibros() {
        System.out.println("Introduzca el nombre del libro: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca el autor del libro: ");
        String autor = teclado.nextLine();
        System.out.println("Introduzca la categoría del libro: ");
        String categoria = teclado.nextLine();
    }

    public void eliminarLibro() {
        
    }

    public void buscarLibro() {
        System.out.println("¿De qué forma quieres buscar el libro?");
        System.out.println("1. Nombre");
        System.out.println("2. Autor");
        System.out.println("3. Categoría");
        String opcion = teclado.nextLine();

    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPrestado() {
        return this.prestado;
    }

    public boolean getPrestado() {
        return this.prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
