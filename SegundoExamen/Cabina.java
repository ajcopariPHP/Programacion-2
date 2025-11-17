import java.util.ArrayList;
import java.util.List;

public class Cabina {
    private int nroCabina;
    private List<Persona> personasAbordo;

    public static final int MAX_PERSONAS = 10;
    public static final float MAX_PESO = 850.0f;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public int getNroCabina() { return nroCabina; }
    public List<Persona> getPersonas() { return personasAbordo; }
    public int getCantidadPersonas() { return personasAbordo.size(); }

    // intenta agregar persona si no supera limites; retorna true si se pudo
    public boolean agregarPersona(Persona p) {
        if (personasAbordo.size() >= MAX_PERSONAS) return false;
        if ((calcularPesoTotal() + p.getPeso()) > MAX_PESO) return false;
        personasAbordo.add(p);
        return true;
    }

    public float calcularPesoTotal() {
        float total = 0f;
        for (Persona pe : personasAbordo) total += pe.getPeso();
        return total;
    }
    @Override
    public String toString() {
        return "Cabina " + nroCabina + " [personas=" + personasAbordo.size() + ", peso=" + calcularPesoTotal() + "kg]";
    }
}