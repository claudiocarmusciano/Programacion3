import java.util.ArrayList;


public class ejer3 {

    //Implemente un algoritmo recursivo que convierta un número en notación decimal a su
    //equivalente en notación binaria.

    public static void main(String[] args) {
        int numero = 4;
     System.out.println(convertirABinario(numero));
    }

    private static String convertirABinario(int numero) {
        if (numero < 2) {
            return Integer.valueOf(numero).toString();
        } else {
            return convertirABinario(numero / 2) + numero % 2;
            }
        }
}
