package Practica3eje2;
public class JuegoAdivinaImpar extends JuegoAdivinaNum {
    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }
    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            return false;
        }
        if (numero % 2 != 0) {
            return true;
        } else {
            System.out.println("❌ Error: solo puedes ingresar números impares.");
            return false;
        }
    }
}