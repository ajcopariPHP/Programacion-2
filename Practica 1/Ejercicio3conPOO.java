package Ejercicio3;
public class Estadistica {

	private double[] datos;

    // Constructor
    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    // Calcular promedio
    public double promedio() {
        double suma = 0;
        for (double x : datos) {
            suma += x;
        }
        return suma / datos.length;
    }

    // Calcular desviación estándar
    public double desviacion() {
        double prom = promedio();
        double suma = 0;
        for (double x : datos) {
            suma += Math.pow(x - prom, 2);
        }
        return Math.sqrt(suma / (datos.length - 1));
    }
}
// EL MAIN
package Ejercicio3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        double[] numeros = new double[10];
        System.out.println("Ingrese 10 numeros: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextDouble();
        }

        Estadistica est = new Estadistica(numeros);

        System.out.printf("El promedio es %.2f%n", est.promedio());
        System.out.printf("La desviacion estandar es %.5f%n", est.desviacion());
    }
}