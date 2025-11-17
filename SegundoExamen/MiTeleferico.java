import java.util.ArrayList;
import java.util.List;

public class MiTeleferico {
    private Linea[] lineas;
    private float cantidadIngresos; 

    public MiTeleferico() {
        // Según nota: solo hay 3 líneas: Amarillo, Rojo y Verde (crear con X cabinas iniciales)
        lineas = new Linea[3];
        lineas[0] = new Linea("Amarillo", 5);
        lineas[1] = new Linea("Rojo", 5);
        lineas[2] = new Linea("Verde", 5);
        cantidadIngresos = 0f;
    }

    // buscar linea por nombre (color)
    public Linea buscarLinea(String color) {
        for (Linea l : lineas) {
            if (l.getColor().equalsIgnoreCase(color)) return l;
        }
        return null;
    }
    // agregar persona a fila de la linea (usa Linea.agregarPersona)
    public boolean agregarPersonaFila(Persona p, String colorLinea) {
        Linea l = buscarLinea(colorLinea);
        if (l == null) return false;
        boolean ok = l.agregarPersona(p);
        if (ok) {
        }
        return ok;
    }

    public void agregarCabina(String colorLinea) {
        Linea l = buscarLinea(colorLinea);
        if (l != null) l.agregarCabina(); 
    }

    // a) Implementar un método para agregar la primera persona a la cabina nroX
    public boolean agregarPrimeraPersonaACabina(int nroCabina, Persona p) {
        for (Linea l : lineas) {
            // intentar en cada linea si existe la cabina nroX (según interpretación)
            boolean added = l.agregarPersonaACabinaNro(nroCabina, p);
            if (added) return true;
        }
        return false;
    }

    // b) verificar que todas las cabinas cumplan las reglas en todas las lineas
    public boolean verificarReglasTodasLineas() {
        for (Linea l : lineas) {
            if (!l.verificarReglasCabinas()) return false;
        }
        return true;
    }

    // c) calcular ingreso total de todas las lineas
    public float calcularIngresoTotalTodasLineas() {
        float total = 0f;
        for (Linea l : lineas) total += l.calcularIngresoTotal();
        return total;
    }

    // d) mostrar la linea con mas ingreso solo con tarifa regular
    public Linea lineaConMasIngresoRegular() {
        Linea mejor = null;
        float max = -1f;
        for (Linea l : lineas) {
            float ingresoReg = l.calcularIngresoRegular();
            if (ingresoReg > max) {
                max = ingresoReg;
                mejor = l;
            }
        }
        return mejor;
    }
    public void mostrarResumen() {
        System.out.println("Resumen MiTeleferico:");
        for (Linea l : lineas) {
            System.out.println(l.toString());
        }
        System.out.println("Ingreso total (todas lineas): " + calcularIngresoTotalTodasLineas());
        Linea mejor = lineaConMasIngresoRegular();
        if (mejor != null) System.out.println("Linea con mayor ingreso regular: " + mejor.getColor() + " ingresoRegular=" + mejor.calcularIngresoRegular());
    }
}