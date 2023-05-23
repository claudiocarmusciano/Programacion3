package ejer9;

public class Ejer9Main {
	
	 public static boolean esCapicua(String cadena,int num){

	        if(num>cadena.length()/2){//length/2 es el caso de corte, solo recorro la mitad de la frase
	            return true;
	        }
	        else{
	            if (cadena.charAt(num) == cadena.charAt(cadena.length() -1- num)){
	                return esCapicua(cadena,num+1);
	            }
	        }
	        return false;
	    }

	 public static void main(String[] args) {

	        String variable= "arroz a l a zorra";
	        int num=0;
	  //      System.out.println(variable.length()/2);
	        System.out.println(esCapicua(variable,num));

	    }

}
