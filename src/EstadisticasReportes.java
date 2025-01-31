import java.util.Scanner;

public class EstadisticasReportes {
    private String[] librosPrestados;
    private int[] cantidadPrestamos;
    private String[] usuario;
    private String[] usuarios;
    private int[] prestamosPorUsuario;
    private int totalPrestamos;
    private int prestamosActivos;

    public EstadisticasReportes(String[] librosPrestados, int[] cantidadPrestamos, String[] usuarios,
            int[] prestamosPorUsuario, int totalPrestamos, int prestamosActivos) {
        this.librosPrestados = librosPrestados;
        this.cantidadPrestamos = cantidadPrestamos;
        this.usuarios = usuarios;
        this.prestamosPorUsuario = prestamosPorUsuario;
        this.totalPrestamos = totalPrestamos;
        this.prestamosActivos = prestamosActivos;
    }

    // METODOS
    public void menuEstadisticas(Scanner teclado) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Estadísticas ---");
            System.out.println("1. Mostrar número de préstamos");
            System.out.println("2. Listar libros más prestados");
            System.out.println("3. Mostrar usuario con más préstamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = teclado.nextLine();

            switch (opcion) {
                case "1" -> mostrarNumeroPrestamos();
                case "2" -> listarLibrosMasPrestados();
                case "3" ->  mostrarUsuarioMasPrestamos();
                case "0" -> {
                    salir = true;
                    System.out.println("Saliendo del menú de estadísticas...");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    public void registrarPrestamo(String libro, String usuario) {
        boolean libroExiste = false;
        boolean usuarioExiste = false;

        for (int i = 0; i < librosPrestados.length; i++) {
            // Registrar libro si no existe en la lista
            if (librosPrestados[i] != null && librosPrestados[i].equals(libro)) {
                cantidadPrestamos[i]++;
                libroExiste = true;
            } else if (librosPrestados[i] == null) {
                librosPrestados[i] = libro;
                cantidadPrestamos[i] = 1;
                libroExiste = true;
            }
        }
    }


    public void devolverPrestamo(String libro) {
        boolean libroEncontrado = false;
        for (int i = 0; i < librosPrestados.length; i++) {
            if (librosPrestados[i] != null && librosPrestados[i].equals(libro)) {
                libroEncontrado = true;
                prestamosActivos--;
                System.out.println("El libro '" + libro + "' ha sido devuelto.");
            }
        }
        if (!libroEncontrado) {
            System.out.println("El libro '" + libro + "' no se encuentra en la lista de préstamos activos.");
        }
    }


    public void mostrarNumeroPrestamos() {
        System.out.println("Número total de préstamos: " + totalPrestamos);
        System.out.println("Número de préstamos activos: " + prestamosActivos);
    }


    public void listarLibrosMasPrestados() {
        int maxPrestamos = 0;
        String libroMasPrestado = "";

        for (int i = 0; i < cantidadPrestamos.length; i++) {
            if (cantidadPrestamos[i] > maxPrestamos) {
                maxPrestamos = cantidadPrestamos[i];
                libroMasPrestado = librosPrestados[i];
            }
        }

        if (maxPrestamos > 0) {
            System.out.println("El libro más prestado es '" + libroMasPrestado + "' con " + maxPrestamos + " préstamos.");
        } else {
            System.out.println("No hay registros de préstamos.");
        }
    }

    public void mostrarUsuarioMasPrestamos() {
        int maxPrestamos = 0;
        String usuarioMasPrestamos = "";

        for (int i = 0; i < prestamosPorUsuario.length; i++) {
            if (prestamosPorUsuario[i] > maxPrestamos) {
                maxPrestamos = prestamosPorUsuario[i];
                usuarioMasPrestamos = usuarios[i];
            }
        }

        if (maxPrestamos > 0) {
            System.out.println("El usuario con más préstamos activos es " + usuarioMasPrestamos + " con " + maxPrestamos + " préstamos.");
        } else {
            System.out.println("No hay usuarios con préstamos activos.");
        }
    }

    // GETTERS Y SETTERS
    public String[] getLibrosPrestados() {
        return this.librosPrestados;
    }

    public void setLibrosPrestados(String[] librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public int[] getCantidadPrestamos() {
        return this.cantidadPrestamos;
    }

    public void setCantidadPrestamos(int[] cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }

    public String[] getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String[] usuario) {
        this.usuario = usuario;
    }

    public String[] getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(String[] usuarios) {
        this.usuarios = usuarios;
    }

    public int[] getPrestamosPorUsuario() {
        return this.prestamosPorUsuario;
    }

    public void setPrestamosPorUsuario(int[] prestamosPorUsuario) {
        this.prestamosPorUsuario = prestamosPorUsuario;
    }

    public int getTotalPrestamos() {
        return this.totalPrestamos;
    }

    public void setTotalPrestamos(int totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

    public int getPrestamosActivos() {
        return this.prestamosActivos;
    }

    public void setPrestamosActivos(int prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

}
