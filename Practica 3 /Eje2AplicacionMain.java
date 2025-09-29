package Practica3eje2;
public class Aplicacion {
	public static void main(String[] args) {
		// Instancias de cada tipo de juego con 3 vidas
        JuegoAdivinaNum juego1 = new JuegoAdivinaNum(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);
        System.out.println("\n=== JUEGO 1: Adivina cualquier número ===");
        juego1.juega();
        System.out.println("\n=== JUEGO 2: Adivina un número PAR ===");
        juego2.juega();
        System.out.println("\n=== JUEGO 3: Adivina un número IMPAR ===");
        juego3.juega();
	}
}