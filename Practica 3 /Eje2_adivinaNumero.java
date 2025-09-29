package Practica3eje2;
import java.util.Random;
import java.util.Scanner;
public class JuegoAdivinaNum extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNum(int numeroDeVidas) {
        super(numeroDeVidas);
    }
    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }
    public void juega() {
        reiniciaPartida();
        Random random = new Random();
        numeroAAdivinar = random.nextInt(11); // número aleatorio 0-10
        Scanner sc = new Scanner(System.in);
        System.out.println("🎮 Adivina un número entre 0 y 10!");
        while (true) {
            System.out.print("👉 Ingresa tu número: ");
            int intento = sc.nextInt();

            if (!validaNumero(intento)) {
                System.out.println("❌ Número inválido. Debe estar entre 0 y 10.");
                continue; // vuelve a pedir
            }
            if (intento == numeroAAdivinar) {
                System.out.println("✅ ¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("😢 Has perdido. El número era: " + numeroAAdivinar);
                    break;
                } else {
                    if (intento < numeroAAdivinar) {
                        System.out.println("🔼 El número es mayor. Intenta de nuevo.");
                    } else {
                        System.out.println("🔽 El número es menor. Intenta de nuevo.");
                    }
                }
            }
        }
    }
}