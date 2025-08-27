package Ejercicio1;
public class EcuacionLineal {

	private double a, b, c, d, e, f;

    // Constructor
    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    // Verifica si hay solución
    public boolean tieneSolucion() {
        return (a * d - b * c) != 0;
    }

    // Calcula x
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    // Calcula y
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}
// EL MAIN
package Ejercicio1;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Pedir datos al usuario
        System.out.println("Ingrese a, b, c, d, e, f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        // Crear objeto
        EcuacionLineal eq = new EcuacionLineal(a, b, c, d, e, f);

        // Verificar si tiene solución
        if (eq.tieneSolucion()) {
            System.out.println("x = " + eq.getX() + ", y = " + eq.getY());
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }

    }
}