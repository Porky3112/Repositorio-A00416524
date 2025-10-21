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

    public String validString(){

        String stringByUser = scan.nextLine();

        while(stringByUser.trim().isEmpty()){

            System.out.println("Este espacio no puede estar vacio. Vuelve a intentarlo");
            stringByUser = scan.nextLine();
        }

        return stringByUser;
    }

    public void registerUser(){

        int election = 0;

        do{

            System.out.println("Selecciona el tipo de usuario que vas a registrar: ");
            System.out.println("1. Regular");
            System.out.println("2. Premium");

            election = scan.nextInt();
            scan.nextLine();

            if(election < 0 || election > 2){

                System.out.println("Error. El dato ingresado no es valido");
                System.out.println("Vuelve a intentarlo");
            }
            
        }while(election < 0 || election > 2); 

        System.out.println("Ingresa el nombre del usuario: ");
        String nameComplete = validString();

        String.out.println("Ingrese la identificacion del usuario: ");
        String id = validString();

        String.out.println("Ingrese el correo electronico del usuario: ");
        String emailUser = validString();

        String.out.println("Ingrese el numero de celular del usuario: ")
        String telephone = validString();

        if(election == 1){

        }
    }

    public void showUsers(){

        String users = "";
        users = controller.showUsers();

        System.out.println(users);
    }






    public static void main(String[] args){

        controller = new CanoaAppController("Canoa");
        scan = new Scanner(System.in);

        CanoaApp canoa = new CanoaApp(controller, scan);

        canoa.menu();
    }
}