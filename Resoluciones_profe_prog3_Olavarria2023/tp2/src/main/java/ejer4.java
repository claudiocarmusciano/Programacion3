public class ejer4 {

    //Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
    //Fibonacci.
    //Por ej. los 9 primeros términos son: 0 1 1 2 3 5 8 13 21 ...

    public static void main(String[] args) {
        int numero = 6;
        int anterior = 0;
        int secuencia = 1;
        System.out.print(anterior);
        secuenciaFibonacci(numero,anterior,secuencia);
        //
        System.out.println();
        //
        System.out.println("Otra forma, pero mas costosa-------------");
        for (int i = 0; i < numero; i++){
            System.out.print(fibonacciRecursivo(i)+" ");
        }

    }


    // por què es màs costosa ésta forma????
    private static int fibonacciRecursivo(int numero) {
        //CASO BASE, si es cero devuelve un cero
        //Puedes poner n<=0 tamvien para incluir negativos
        if (numero ==0 ) {
            return 0;
            //CASO BASE, si es 1 devuelve un 1
        } else if (numero == 1) {
            return 1;
        } else {
            //Hago la suma
            return fibonacciRecursivo(numero - 1) + fibonacciRecursivo(numero - 2);
        }
    }


    private static void secuenciaFibonacci(int numero,int anterior, int secuencia) {

        if(numero > 1 ){
            System.out.print(" "+secuencia);
            secuenciaFibonacci(numero -1,secuencia ,secuencia +anterior);
        }
    }
}
