
import java.util.Scanner;

public class SistemaCurso{

    //Declaro Scanner como una variable estatica

    private static Scanner scan = new Scanner(System.in);






    public static void menu(){

         int option;

        // Se le muestra el menu al usuario

        do{
            System.out.println("******Bienvenido al Sistema de ICESI*****");
            System.out.println("1. Registrar curso");
            System.out.println("2. Asociar actividades al curso");
            System.out.println("3. Cargar notas");
            System.out.println("4. Visualizar actividades");
            System.out.println("5. Consultar promedio del curso");
            System.out.println("6. Salir del sistema");
            System.out.println();
            System.out.print("¿Cual opcion quieres escoger?: ");
            option = scan.nextInt();

            switch (option){
                
                case 1: registrarCurso();
                break;

                case 2:asociarActividades();
                break;
                
                case 3:cargarNotas();
                break;

                case 4:visualizarActividades();
                break;

                case 5: consultarPromedio();
                break;

                case 6: System.out.println("¡¡Nos vemos pronto!!");
                break;

                default: System.out.println("La opcion que dijitaste no existe.");
            }

        } while (option != 6);
 
    }







    public static void registrarCurso(){


    } 

    public static void asociarActividades(){


    }

    public static void cargarNotas(){


    }

    public static void visualizarActividades(){


    }

    public static void consultarPromedio(){


    }



    public static void main (String [] args ){



        menu();
        
    }
}