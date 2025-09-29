package Practica3eje2;
public class JuegoAdivinaPar extends JuegoAdivinaNum {
    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }
    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            return false;
        }
        if (numero % 2 == 0) {
            return true;
        } else {
            System.out.println("❌ Error: solo puedes ingresar números pares.");
            return false;
        }
    }
}