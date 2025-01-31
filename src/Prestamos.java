public class Prestamos {
    private String[] librosPrestados;
    private int cantidadLibrosPrestados;
    private Libros libro;

    public Prestamos() {
        this.librosPrestados = new String[5];
        this.cantidadLibrosPrestados = 0;
    }

    // METODOS
    public void prestarLibro(String libro) {
        if (cantidadLibrosPrestados < 5) {
            librosPrestados[cantidadLibrosPrestados] = libro;
            cantidadLibrosPrestados++;
        } else {
            System.out.println("No se pueden prestar más de 5 libros");
        }
    }

    public void devolverLibro(String libro) {
        boolean encontrado = false;
        for (int i = 0; i < cantidadLibrosPrestados; i++) {
            if (librosPrestados[i].equals(libro)) {
                encontrado = true;
                librosPrestados[i] = null;
                cantidadLibrosPrestados--;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El libro no se encuentra prestado");
        } else {
            encontrado = false;
        }
    }

    public void mostrarLibrosPrestados(Usuarios usuario) {
        if (usuario.isEsAdmin()) {
            System.out.println("Libros prestados:");
            for (int i = 0; i < cantidadLibrosPrestados; i++) {
                System.out.println(librosPrestados[i]);
            }
        } else {
            System.out.println("No tienes permisos para consultar los libros prestados.");
        }
    }

    // GETTERS Y SETTERS
    public String[] getLibrosPrestados() {
        return this.librosPrestados;
    }

    public void setLibrosPrestados(String[] librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public int getCantidadLibrosPrestados() {
        return this.cantidadLibrosPrestados;
    }

    public void setCantidadLibrosPrestados(int cantidadLibrosPrestados) {
        this.cantidadLibrosPrestados = cantidadLibrosPrestados;
    }

    public Libros getLibro() {
        return this.libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

}
