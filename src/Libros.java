import java.util.ArrayList;
import java.util.Scanner;

public class Libros {
    private String nombre;
    private String autor;
    private Categoria categoria;
    private boolean prestado;

    public ArrayList<Libros> listaLibros = new ArrayList<>();
    
    public static final Scanner teclado = new Scanner(System.in);


    public Libros(String nombre, String autor, Categoria categoria, boolean prestado) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.prestado = prestado;
    }
    
    
    // METODOS

    public void agregarLibros(Libros libro) {
        System.out.println("Introduzca el nombre del libro: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca el autor del libro: ");
        String autor = teclado.nextLine();
        System.out.println("Introduzca la categoría del libro: ");
        String categoria = teclado.nextLine();

        if (nombre.equals(this.nombre)) {
            System.out.println("El libro ya existe");
        } else {
            System.out.println("Libro añadido con éxito");
            listaLibros.add(libro);
        }
    }

    public void eliminarLibro() {
        System.out.println("Introduzca el nombre del libro que desea eliminar: ");
        String nombre = teclado.nextLine();

        if (nombre.equals(this.nombre)) {
            listaLibros.remove(this);
            System.out.println("Libro eliminado con éxito");
        } else {
            System.out.println("El libro no existe");            
        }
    }

    public void buscarLibro() {
        System.out.println("¿De qué forma quieres buscar el libro?");
        System.out.println("1. Nombre");
        System.out.println("2. Autor");
        System.out.println("3. Categoría");
        String opcion = teclado.nextLine();
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", autor='" + getAutor() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", prestado='" + isPrestado() + "'" +
            "}";
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

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
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
