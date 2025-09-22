package Practica3;
import java.util.Random;
import java.util.Scanner;
// Clase base: Juego
class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        System.out.println("🔄 Reiniciando partida...");
        this.numeroDeVidas = 3; // ejemplo: reinicia a 3 vidas
    }

    public void actualizaRecord() {
        this.record++;
        System.out.println("🏆 Nuevo record: " + this.record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        if (numeroDeVidas > 0) {
            System.out.println("⚡ Te queda(n) " + numeroDeVidas + " vida(s).");
            return true; // todavía tiene vidas
        } else {
            System.out.println("💀 No te quedan vidas.");
            return false; // ya no quedan vidas
        }
    }
}