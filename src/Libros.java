import java.util.ArrayList;
import java.util.Scanner;

public class Libros {
    private String nombre;
    private String autor;
    private Categoria categoria;
    private boolean prestado;

    public static ArrayList<Libros> listaLibros = new ArrayList<>();

    public Libros(String nombre, String autor, Categoria categoria, boolean prestado) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.prestado = prestado;
    }
    
    
    // METODOS

    public void agregarLibros(Libros libro) {
        Scanner teclado = new Scanner(System.in);

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
        Scanner teclado = new Scanner(System.in);

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
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("¿De qué forma quieres buscar el libro?");
        System.out.println("1. Nombre");
        System.out.println("2. Autor");
        System.out.println("3. Categoría");
        String opcion = teclado.nextLine();

        switch (opcion) {
            case "1" -> {
                System.out.println("Introduzca el nombre del libro: ");
                String nombre = teclado.nextLine();
                buscarLibrosPorTitulo(nombre);
            }
            case "2" -> {
                System.out.println("Introduzca el autor del libro: ");
                String autor = teclado.nextLine();
                buscarLibrosPorAutor(autor);
            }
            case "3" -> {
                System.out.println("Introduzca la categoría del libro: ");
                String categoria = teclado.nextLine();
                buscarLibrosPorCategoria(categoria);
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    public void buscarLibrosPorCategoria(String categoria) {
        System.out.println("Libros en la categoría '" + categoria + "':");
        for (Libros libro : listaLibros) {
            if (libro.getCategoria().equals(categoria)) {
                System.out.println("Título: " + libro.getNombre() + ", Autor: " + libro.getAutor());
            }
        }
    }

    public void buscarLibrosPorTitulo(String titulo) {
        System.out.println("Buscando libros con el título '" + titulo + "':");
        for (Libros libro : listaLibros) {
            if (libro.getNombre().equals(titulo)) {
                System.out.println("Título: " + libro.getNombre() + ", Autor: " + libro.getAutor() + ", Categoría: " + libro.getCategoria());
            }
        }
    }

    public void buscarLibrosPorAutor(String autor) {
        System.out.println("Libros del autor '" + autor + "':");
        for (Libros libro : listaLibros) {
            if (libro.getAutor().equals(autor)) {
                System.out.println("Título: " + libro.getNombre() + ", Categoría: " + libro.getCategoria());
            }
        }
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