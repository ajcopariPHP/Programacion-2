package Ejercicio3;
import java.util.Scanner;
	public class ConModularidad {
	    
	    // Método para calcular promedio
	    public static double promedio(double[] datos) {
	        double suma = 0;
	        for (double x : datos) {
	            suma += x;
	        }
	        return suma / datos.length;
	    }

	    // Método para calcular desviación estándar
	    public static double desviacion(double[] datos) {
	        double prom = promedio(datos);
	        double suma = 0;
	        for (double x : datos) {
	            suma += Math.pow(x - prom, 2);
	        }
	        return Math.sqrt(suma / (datos.length - 1));
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        double[] numeros = new double[10];
	        System.out.println("Ingrese 10 numeros: ");
	        for (int i = 0; i < numeros.length; i++) {
	            numeros[i] = sc.nextDouble();
	        }

	        double prom = promedio(numeros);
	        double desv = desviacion(numeros);

	        System.out.printf("El promedio es %.2f%n", prom);
	        System.out.printf("La desviacion estandar es %.5f%n", desv);
        }
}