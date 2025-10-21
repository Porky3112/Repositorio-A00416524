package ui;
import java.util.Scanner;

public class CanoaApp{

    CanoaAppController controller;
    Scanner scan;

    public CanoaApp(CanoaAppController contro, Scanner sc){

        this.controller = contro;
        this.scan = sc;
    }

    public void menu(){

        int election; 

        do{

            System.out.println("~~~~~~~ Bienvenido a canoa App ~~~~~~~");
            System.out.println("______________________________________");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar ticket a usuario");
            System.out.println("3. Consultar el valor a pagar de un pasaje");
            System.out.println("4. Mostrar todos los usuarios");
            System.out.println("5. Usuarios que tienen descuento superior a 10%");
            System.out.println("6. Salir");

            election = scan.nextInt();
            scan.nextLine();

            switch(){

                case 1:
                    break; 

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break

                default:
            }

        }while();
    }

    public void ()






    public static void main(String[] args){

        controller = new CanoaAppController("Canoa");
        scan = new Scanner(System.in);

        CanoaApp canoa = new CanoaApp(controller, scan);

        canoa.menu();
    }
}