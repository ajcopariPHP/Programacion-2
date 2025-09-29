import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro"};
        // Crear 5 figuras aleatorias
        for (int i = 0; i < figuras.length; i++) {
            int tipo = rand.nextInt(2) + 1; // 1: Cuadrado, 2: Círculo
            String color = colores[rand.nextInt(colores.length)];
            if (tipo == 1) { // Cuadrado
                double lado = 1 + rand.nextDouble() * 9; // entre 1 y 10
                figuras[i] = new Cuadrado(lado, color);
            } else { // Círculo
                double radio = 1 + rand.nextDouble() * 9; // entre 1 y 10
                figuras[i] = new Circulo(radio, color);
            }
        }
        // Mostrar información de cada figura
        System.out.println("\n--- Lista de Figuras ---");
        for (Figura f : figuras) {
            System.out.println(f.toString());
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());

            if (f instanceof Coloreado) {
                System.out.println(((Coloreado) f).comoColorear());
            }
            System.out.println("----------------------------");
        }
    }
}