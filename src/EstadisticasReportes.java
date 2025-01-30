public class EstadisticasReportes {
    private String[] librosPrestados;
    private int[] cantidadPrestamos;
    private String[] usuario;
    private String[] usuarios;
    private int[] prestamosPorUsuario;
    private int totalPrestamos;
    private int prestamosActivos;

    public EstadisticasReportes(String[] librosPrestados, int[] cantidadPrestamos, String[] usuarios2,
            int[] prestamosPorUsuario, int totalPrestamos, int prestamosActivos) {
        this.librosPrestados = librosPrestados;
        this.cantidadPrestamos = cantidadPrestamos;
        this.usuarios = usuario;
        this.prestamosPorUsuario = prestamosPorUsuario;
        this.totalPrestamos = totalPrestamos;
        this.prestamosActivos = prestamosActivos;
    }

    // METODOS

    public void registrarPrestamo(String libro, String usuario) {
        boolean libroExiste = false;
        boolean usuarioExiste = false;

        for (int i = 0; i < librosPrestados.length; i++) {
            if (librosPrestados[i] != null && librosPrestados[i].equals(libro)) {
                cantidadPrestamos[i]++;
                libroExiste = true;
                break;
            } else if (librosPrestados[i] == null) {
                librosPrestados[i] = libro;
                cantidadPrestamos[i] = 1;
                libroExiste = true;
                break;
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
                break;
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
}
