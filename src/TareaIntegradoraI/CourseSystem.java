import java.util.Scanner;

public class CourseSystem{

    // Scanner to read user input
    private static Scanner scan = new Scanner(System.in);

    // Array to store course details: code, name, teacher, classroom
    public static String[] detailsOfCourse = new String[4];

    // Number of activities
    public static int quantityActivities; 

    // Arrays to store activity information
    public static String [] nameOfActivities ;
    public static String [] dateOfActivities ;
    public static float [] percentageOfActivities ;
    public static float [] gradesOfActivities ;

    // Variable to store the average grade of the course
    public static float averageCourse;

    // Number of credits of the course
    public static int credits;



    public static void menu(){

        int option;

        // Show the menu until the user chooses option 6
        do{
            System.out.println("******Bienvenido al Sistema de ICESI*****");
            System.out.println("1. Registrar curso");
            System.out.println("2. Asociar actividades al curso");
            System.out.println("3. Cargar notas");
            System.out.println("4. Visualizar actividades");
            System.out.println("5. Consultar promedio del curso");
            System.out.println("6. Salir del sistema");
            System.out.println();
            System.out.print("Ingresa un numero: ");
            option = scan.nextInt();
            scan.nextLine();

            // The system analize the input of the user
            switch (option){
                
                case 1: registerCourse();  // Option to register course
                break;

                case 2: associateActivities();  // Option to add activities
                break;
                
                case 3: loadGrades();  // Option to add grades
                break;

                case 4: showActivities(nameOfActivities, dateOfActivities, percentageOfActivities);  
                break;

                case 5: calculateAverage(gradesOfActivities, percentageOfActivities);
                        showAverage(nameOfActivities, percentageOfActivities, gradesOfActivities);
                break;

                case 6: System.out.println("¡Nos vemos pronto!");
                break;

                default: System.out.println("La opcion no existe.");
                         System.out.println();
            }

        } while (option != 6);

        // If option = 6, the program turn off
 
    }


    public static void registerCourse(){

        // Field names of the course
        String[] courseFieldNames = {"codigo", "nombre", "profesor", "salon"};

        int i;

        // Read each field from the user
        for (i = 0; i < courseFieldNames.length; i++){

            System.out.println("Ingrese el "+courseFieldNames[i]+" del curso: " );
            detailsOfCourse[i] = scan.nextLine();

            // Validation: field cannot be empty and eliminate all the spaces
            while (detailsOfCourse[i].trim().isEmpty()){

                System.out.println("El " + courseFieldNames[i] +" del curso no puede estar vacio. Intenta de nuevo: ");
                detailsOfCourse[i] = scan.nextLine();

            }          
        }

        // Read the number of credits
        System.out.println("Ingrese la cantidad de creditos del curso: ");
        credits = scan.nextInt();
        scan.nextLine();

        // validation: credist needs to be greater than 0

        while(credits <= 0  || credits > 10 ){

            System.out.println("Error, dato fuera del rango permitido");
            System.out.println("Ingrese un numero positivo mayor a 0 y menor o igual a 10:");
            credits = scan.nextInt();
            scan.nextLine();

        }
    } 


    public static void associateActivities(){

        int i;
        float totalPercentage = 0;

        // Ask the user how many activities he / she want

        System.out.println("Ingresa la cantidad de actividades que deseas asociar: ");
        quantityActivities = scan.nextInt();
        scan.nextLine();

        while(quantityActivities <= 0  || quantityActivities > 5){

            System.out.println("Debe ingresar un numero entre 1 y 5");
            quantityActivities = scan.nextInt();
            scan.nextLine();
        }

        // The size of the arrays is defined

        nameOfActivities = new String[quantityActivities];
        dateOfActivities = new String[quantityActivities];
        percentageOfActivities = new float[quantityActivities];
        gradesOfActivities = new float[quantityActivities];


        // Ask the user for each activity
        for (i = 0; i < nameOfActivities.length; i++){

            System.out.println("Ingrese el nombre de la actividad "+ (i+1));
            nameOfActivities[i] = scan.nextLine();

            // Validation: name cannot be empty and eliminate all the spaces
            while(nameOfActivities[i].trim().isEmpty()){
                System.out.println("El nombre de la actividad no puede estar vacio. Intenta de nuevo: ");
                nameOfActivities[i] = scan.nextLine();
            }

            // Read and validate the date
            System.out.println("Ingrese la fecha de entrega (dd/mm/aaaa) de la actividad "+ (i+1));
            dateOfActivities[i] = scan.nextLine();

            boolean flag = true;

            // The system validate the date format 
            while (flag){
                if (dateOfActivities[i].matches("(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[0-2])/\\d{4}")){
                    flag = false; 
                }
                else{
                    System.out.println("Debe ingresar la fecha en el formato correcto: ");
                    dateOfActivities[i] = scan.nextLine();
                }
            }


            // Read and validate the percentage
            System.out.println("Ingrese el porcentaje de la actividad " + (i+1) + " (La suma total debe ser 100%)");
            percentageOfActivities[i] = scan.nextFloat();
            scan.nextLine();

            while(percentageOfActivities[i] <= 0 || percentageOfActivities[i] > 100 ){

                System.out.println("El porcentaje debe estar entre 1 y 100. Intenta de nuevo: ");
                percentageOfActivities[i] = scan.nextFloat();

            }

            totalPercentage += percentageOfActivities[i];

        }

        // System validate the sum of percentages is equal 100%

        if (totalPercentage != 100){

            System.out.println("Lo siento, la suma de los porcentajes es "+totalPercentage+"%. Debe ser exactamente 100%.");
            System.out.println("Vuelve a ingresar las actividades");
            associateActivities();

            // if not, restart associateActivities()
        }
    }




    public static void loadGrades(){

        int i ;

        // Ask the user for each grade
        for (i = 0 ; i < gradesOfActivities.length ; i++){

            System.out.println("Ingrese la nota de la actividad "+ (i+1) +":");
            gradesOfActivities[i] = scan.nextFloat();
            scan.nextLine();

            // Validation: grade must be between 0.0 and 5.0
            while (gradesOfActivities[i] > 5 || gradesOfActivities[i] < 0 ){
                System.out.println("La nota debe estar entre 0.0 y 5.0. Intenta de nuevo: ");
                gradesOfActivities[i] = scan.nextFloat();
                scan.nextLine();
            }
        }
    }


    public static void showActivities(String [] nameOfActivities, String [] dateOfActivities, float [] percentageOfActivities){

        int i;

        // Print all activities with their details
        for (i = 0; i < nameOfActivities.length; i++){
            System.out.println("Actividad " + (i+1) +": - "+ nameOfActivities[i]+" - Fecha de entrega: " + dateOfActivities [i]+", Porcentaje: "+percentageOfActivities[i] );
        }
    }


    public static void calculateAverage(float [] gradesOfActivities, float [] percentageOfActivities){
        int i;
        float sum = 0;

        // Weighted average calculation 
        for(i = 0; i <gradesOfActivities.length ; i ++){
            sum += gradesOfActivities[i] * ((percentageOfActivities[i]) / 100);  
        }

        averageCourse = sum;
    }


    public static void showAverage(String [] nameOfActivities, float [] percentageOfActivities, float [] gradesOfActivities ){

        int i;

        // Print each activity with grade and percentage
        for (i = 0; i < nameOfActivities.length; i++){
            System.out.println("Actividad " + (i+1) +": - "+ nameOfActivities[i]+" - Porcentaje: "
            + percentageOfActivities[i]+", Nota: "+gradesOfActivities[i] );
        }

        // Print course average
        System.out.println("El promedio del curso es: "+averageCourse);
    }


    public static void main (String [] args ){
        // Start the program
        menu();
    }
}