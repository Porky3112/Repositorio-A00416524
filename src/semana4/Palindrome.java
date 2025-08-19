import java.util.Scanner;
public class Palindrome{

       public static void isPalindrome(String word){
                boolean palindromo = true;
                String palabra=word.toUpperCase();

                for (int i = 0; i < palabra.length() && palindromo==true; i++) {
                        char izq = palabra.charAt(i);
                        int derIndex = palabra.length() - 1 - i;
                        char der = palabra.charAt(derIndex);
                        if (izq != der) {
                                palindromo = false;
                        }
                }

                if (palindromo) {
                System.out.println("La palabra "+word+ " es palíndroma");
                } else {
                System.out.println("La palabra "+word+ " no es palíndroma");
                }
       }


       public static void main(String[] args) {
        String palabra = "tuPalabra"; // Reemplaza "tuPalabra" por la palabra que quieras comprobar
        isPalindrome(palabra);
        isPalindrome("sometemos");
        isPalindrome("Anita lava la tina");
        
    }
}