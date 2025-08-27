package Ejercicio2;
public class EcuacionCuadratica {

	 private double a, b, c;

	    // Constructor
	    public EcuacionCuadratica(double a, double b, double c) {
	        this.a = a;
	        this.b = b;
	        this.c = c;
	    }

	    // Discriminante
	    public double getDiscriminante() {
	        return b * b - 4 * a * c;
	    }

	    // Raíz 1
	    public double getRaiz1() {
	        double d = getDiscriminante();
	        if (d < 0) return 0;  // no hay raíces reales
	        return (-b + Math.sqrt(d)) / (2 * a);
	    }

	    // Raíz 2
	    public double getRaiz2() {
	        double d = getDiscriminante();
	        if (d < 0) return 0;  // no hay raíces reales
	        return (-b - Math.sqrt(d)) / (2 * a);
	    }
}
//EL MAIN
package Ejercicio2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.println("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Crear objeto
        EcuacionCuadratica eq = new EcuacionCuadratica(a, b, c);

        // Evaluar discriminante
        double d = eq.getDiscriminante();

        if (d > 0) {
            System.out.println("La ecuacion tiene dos raices " + eq.getRaiz1() + " y " + eq.getRaiz2());
        } else if (d == 0) {
            System.out.println("La ecuacion tiene una raiz " + eq.getRaiz1());
        } else {
            System.out.println("La ecuacion no tiene raices reales");
        }
    }
}