import java.util.ArrayList;
import java.util.List;

public class Linea {
    private String color;
    private List<Persona> filaPersonas;       // fila general (si hace falta)
    private List<Cabina> cabinas;
    private int cantidadCabinas;

    public Linea(String color, int cantidadCabinasInicial) {
        this.color = color;
        this.filaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();
        this.cantidadCabinas = 0;
        for (int i = 0; i < cantidadCabinasInicial; i++) agregarCabina(); // crea cabinas iniciales
    }

    public String getColor() { return color; }
    public List<Cabina> getCabinas() { return cabinas; }

    public void agregarCabina() {
        cantidadCabinas++;
        Cabina c = new Cabina(cantidadCabinas);
        cabinas.add(c);
    }
    // agrega persona a la primera cabina que cumpla requisitos (búsqueda secuencial)
    public boolean agregarPersona(Persona p) {
        for (Cabina c : cabinas) {
            if (c.agregarPersona(p)) return true;
        }
        return false;
    }

    // método para agregar persona explícitamente a una cabina por nro (si cumple reglas)
    public boolean agregarPersonaACabinaNro(int nroCabina, Persona p) {
        for (Cabina c : cabinas) {
            if (c.getNroCabina() == nroCabina) {
                return c.agregarPersona(p);
            }
        }
        return false;
    }

    // verifica que todas las cabinas cumplan reglas: max 10 y peso <= 850
    public boolean verificarReglasCabinas() {
        for (Cabina c : cabinas) {
            if (c.getCantidadPersonas() > Cabina.MAX_PERSONAS) return false;
            if (c.calcularPesoTotal() > Cabina.MAX_PESO) return false;
        }
        return true;
    }
    // calcular ingreso total (ambas tarifas)
    // tarifa regular = 3 bs (edad entre 25 y 60 inclusive)
    // tarifa preferencial = 1.5 bs (edad < 25 o > 60)
    public float calcularIngresoTotal() {
        float total = 0f;
        for (Cabina c : cabinas) {
            for (Persona p : c.getPersonas()) {
                if (esPreferencia(p)) total += 1.5f;
                else total += 3.0f;
            }
        }
        return total;
    }

    // ingreso solo por tarifa regular (edad 25..60 inclusive)
    public float calcularIngresoRegular() {
        float total = 0f;
        for (Cabina c : cabinas) {
            for (Persona p : c.getPersonas()) {
                if (!esPreferencia(p)) total += 3.0f;
            }
        }
        return total;
    }
    private boolean esPreferencia(Persona p) {
        int edad = p.getEdad();
        return (edad < 25) || (edad > 60);
    }

    @Override
    public String toString() {
        return "Linea " + color + " (cabinas=" + cabinas.size() + ", ingresoTotal=" + calcularIngresoTotal() + ")";
    }
}