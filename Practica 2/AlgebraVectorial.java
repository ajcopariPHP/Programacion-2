package Ejercicio1;
public class AlgebraVectorial {

    public static boolean esPerpendicular1(Vector a, Vector b) {
        return Math.abs(a.suma(b).norma() - a.resta(b).norma()) < 1e-6;
    }
    public static boolean esPerpendicular2(Vector a, Vector b) {
        return Math.abs(a.resta(b).norma() - b.resta(a).norma()) < 1e-6;
    }
    public static boolean esPerpendicular3(Vector a, Vector b) {
        return Math.abs(a.productoPunto(b)) < 1e-6;
    }
    public static boolean esPerpendicular4(Vector a, Vector b) {
        double izq = Math.pow(a.suma(b).norma(), 2);
        double der = Math.pow(a.norma(), 2) + Math.pow(b.norma(), 2);
        return Math.abs(izq - der) < 1e-6;
    }
    public static boolean esParalelo1(Vector a, Vector b) {
        Vector cruz = a.productoCruz(b);
        return Math.abs(cruz.norma()) < 1e-6;
    }
    public static boolean esParalelo2(Vector a, Vector b) {
        return esParalelo1(a, b);
    }
    public static Vector proyeccion(Vector a, Vector b) {
        double escalar = a.productoPunto(b) / Math.pow(b.norma(), 2);
        return new Vector(b.getX() * escalar, b.getY() * escalar, b.getZ() * escalar);
    }
    public static double componente(Vector a, Vector b) {
        return a.productoPunto(b) / b.norma();
    }
}