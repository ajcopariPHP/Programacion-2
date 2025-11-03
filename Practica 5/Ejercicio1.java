package Ejercicio1;
import java.time.LocalDate;
import java.util.*;

// Clases del sistema de Biblioteca Universitaria
// Clase Autor (existe independientemente -> agregación con Biblioteca)
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void mostrarInfo() {
        System.out.println("Autor: " + nombre + " | Nacionalidad: " + nacionalidad);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
// Clase Estudiante (existe independientemente -> asociación con Préstamo)
class Estudiante {
    private String codigo;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " | Código: " + codigo);
    }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "]";
    }
}
// Clase Libro - contiene Páginas (COMPOSICIÓN: páginas no existen fuera del libro)
// Además Libro puede existir por sí mismo (se puede agregar a Biblioteca -> AGREGACIÓN)
class Libro {
    private String titulo;
    private String isbn;
    // Composición: Pagina es una clase interna y las páginas son creadas dentro del constructor
    private List<Pagina> paginas;

    // Clase interna Pagina (composición Libro - Pagina)
    private class Pagina {
        private int numero;
        private String contenido;

        private Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        private void mostrarPagina() {
            System.out.println("Página " + numero + ": " + contenido);
        }

        @Override
        public String toString() {
            return "P" + numero;
        }
    }
    // Constructor recibe contenido de páginas como lista de strings
    public Libro(String titulo, String isbn, List<String> contenidosPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        for (int i = 0; i < contenidosPaginas.size(); i++) {
            // las páginas se crean aquí - no pueden existir fuera de Libro (privadas)
            this.paginas.add(new Pagina(i + 1, contenidosPaginas.get(i)));
        }
    }

    public void leer() {
        System.out.println("\nLeyendo libro: " + titulo + " | ISBN: " + isbn);
        for (Pagina p : paginas) {
            p.mostrarPagina();
        }
    }

    @Override
    public String toString() {
        return titulo + " (ISBN:" + isbn + ", páginas:" + paginas.size() + ")";
    }

    // Método para obtener el número de páginas (informativo)
    public int getNumeroPaginas() {
        return paginas.size();
    }
}
// Clase Prestamo - Asociación con Estudiante y Libro
class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante; // referencia (asociación)
    private Libro libro;           // referencia (asociación)

    public Prestamo(Estudiante estudiante, Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void mostrarInfo() {
        System.out.println("Préstamo: " + libro + " -> " + estudiante);
        System.out.println("  Fecha préstamo: " + fechaPrestamo + " | Fecha devolución: " + fechaDevolucion);
    }

    @Override
    public String toString() {
        return libro.toString() + " -> " + estudiante.toString() + " (devolución: " + fechaDevolucion + ")";
    }
}
// Clase Biblioteca - contiene libros y autores (AGREGACIÓN) y tiene Horario (COMPOSICIÓN)
class Biblioteca {
    private String nombre;
    // Agregación: libros y autores pueden existir fuera de la biblioteca
    private List<Libro> libros;
    private List<Autor> autores;
    // Prestamos activos gestionados por la biblioteca
    private List<Prestamo> prestamos;

    // Horario como clase interna: composición (no existe fuera de Biblioteca)
    class Horario {
        private String diasApertura;
        private String horaApertura;
        private String horaCierre;

        public Horario(String diasApertura, String horaApertura, String horaCierre) {
            this.diasApertura = diasApertura;
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public void mostrarHorario() {
            System.out.println("Horario: " + diasApertura + " | " + horaApertura + " - " + horaCierre);
        }

        @Override
        public String toString() {
            return diasApertura + " " + horaApertura + "-" + horaCierre;
        }
    }
    private Horario horario; // composición: horario no existe sin la biblioteca

    public Biblioteca(String nombre, String diasApertura, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        // creación del Horario dentro del constructor -> composición
        this.horario = new Horario(diasApertura, horaApertura, horaCierre);
        System.out.println("Biblioteca '" + nombre + "' creada con horario: " + horario);
    }

    // Agregar libro existente (agregación)
    public void agregarLibro(Libro libro) {
        if (!libros.contains(libro)) {
            libros.add(libro);
            System.out.println("+ Libro agregado: " + libro);
        } else {
            System.out.println("Libro ya registrado: " + libro);
        }
    }

    // Agregar autor existente (agregación)
    public void agregarAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
            System.out.println("+ Autor registrado: " + autor);
        } else {
            System.out.println("Autor ya registrado: " + autor);
        }
    }

    // Crear un préstamo (asociación entre préstamo, estudiante y libro)
    public void prestarLibro(Estudiante estudiante, Libro libro) {
        if (!libros.contains(libro)) {
            System.out.println("El libro no está disponible en esta biblioteca: " + libro);
            return;
        }
        LocalDate hoy = LocalDate.now();
        LocalDate devolucion = hoy.plusDays(14); // por ejemplo 14 días
        Prestamo p = new Prestamo(estudiante, libro, hoy, devolucion);
        prestamos.add(p);
        System.out.println("+ Préstamo creado: " + p);
    }

    public void mostrarEstado() {
        System.out.println("\n=== Estado de la Biblioteca: " + nombre + " ===");
        System.out.println("- Horario: ");
        horario.mostrarHorario();
        System.out.println("- Autores registrados (" + autores.size() + "):");
        for (Autor a : autores) {
            System.out.println("  * " + a);
        }
        System.out.println("- Libros disponibles (" + libros.size() + "):");
        for (Libro l : libros) {
            System.out.println("  * " + l);
        }
        System.out.println("- Préstamos activos (" + prestamos.size() + "):");
        for (Prestamo pr : prestamos) {
            System.out.println("  * " + pr);
        }
    }

    // Cerrar biblioteca: mensaje y los préstamos dejan de existir (se limpian)
    public void cerrarBiblioteca() {
        System.out.println("\nCERRANDO la biblioteca: " + nombre);
        // eliminar préstamos activos (simula que ya no existen)
        prestamos.clear();
        System.out.println("Todos los préstamos han sido finalizados/eliminados.");
    }
}
// Clase principal con pruebas
public class Eje1 {
    public static void main(String[] args) {
        // Crear autores y libros fuera de la biblioteca (demuestra AGREGACIÓN)
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Isaac Asimov", "Estadounidense");

        List<String> contenido1 = Arrays.asList(
                "Era el mejor de los tiempos...",
                "Segunda página con más texto...",
                "Tercera página concluyendo el capítulo."
        );
        Libro libro1 = new Libro("Cien Años de Soledad", "ISBN-0001", contenido1);

        List<String> contenido2 = Arrays.asList(
                "Fundación abrió con una idea...",
                "Segunda página de Fundación..."
        );
        Libro libro2 = new Libro("Fundación", "ISBN-0002", contenido2);

        // Crear biblioteca (tiene su Horario -> composición)
        Biblioteca bib = new Biblioteca("Biblioteca UMSA", "Lun-Vie", "08:00", "18:00");

        // Registrar autores y agregar libros (agregación: objetos creados fuera se agregan)
        bib.agregarAutor(autor1);
        bib.agregarAutor(autor2);
        bib.agregarLibro(libro1);
        bib.agregarLibro(libro2);

        // Mostrar estado actual
        bib.mostrarEstado();

        // Crear estudiante (existe por fuera)
        Estudiante est1 = new Estudiante("2025001", "Ana Pérez");

        // Prestar libro (crea Prestamo que asocia Estudiante con Libro -> asociación)
        bib.prestarLibro(est1, libro1);

        // Mostrar estado actualizado
        bib.mostrarEstado();

        // Leer un libro (muestra las páginas - composición Libro-Pagina)
        libro1.leer();

        // Cerrar biblioteca: los préstamos se eliminan (simulación)
        bib.cerrarBiblioteca();

        // Mostrar estado final (sin préstamos)
        bib.mostrarEstado();
    }
}
