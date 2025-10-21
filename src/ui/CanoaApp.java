package ui;
import java.util.Scanner;
import java.time.LocalDate;

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

    public int year(){

        System.out.println("anio: ");
        int year =scan.nextInt();
        scan.nextLine();

        int actualYear = LocalDate.now().getYear();

        while(year < actualYear){

            System.out.println("Error. El anio debe ser por lo menos "+ actualYear);
            System.out.println("Vuelve a intentarlo: ");
            year =scan.nextInt();
            scan.nextLine();
        }

        return year;
    } 

    public int month(){

        System.out.println("Numero del mes: ");
        int month = scan.nextInt();
        scan.nextLine();

        while(month < 1 || month > 12){

            System.out.println("El mes debe estar entre 1 y 12");
            System.out.println("Vuelve a intentarlo: ");
            month = scan.nextInt();
            scan.nextLine();
        }

        return month;
    }

    public int day(int month){

        System.out.println("Dia: ");
        int day = scan.nextInt();
        scan.nextLine();

        boolean flat = true;

        while(flat){

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){

                while(day < 1 || day > 31){

                    System.out.println("El rango permitido para el mes es entre 1 y 31");
                    System.out.println("Vuelve a intentarlo: ");
                    day = scan.nextInt();
                    scan.nextLine();
                }

                flat = false;
            }

            if (month == 4 || month == 6 || month == 9 || month == 11){

                while( day < 1 || day > 30){

                    System.out.println("El rango permitido para el mes es entre 1 y 30");
                    System.out.println("Vuelve a intentarlo: ");
                    day = scan.nextInt();
                    scan.nextLine();
                }

                flat = false;
            }

            if(month == 2){

                while(day < 1 || day > 28){

                    System.out.println("El rango permitido para el mes es entre 1 y 28");
                    System.out.println("Vuelve a intentarlo: ");
                    day = scan.nextInt();
                    scan.nextLine();
                }

                flat= false;
            }
        }
        
        return day;
    }

    public LocalDate validDate(int year, int month, int day){

        LocalDate dateToValid = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();

        while(dateToValid.isBefore(dateNow)){

            System.out.println("La fecha no puede ser menor a la fecha actual");
            System.out.println("Vuelve a ingresar los datos");

            year = year();
            month = month();
            day= day(month);
            dateToValid = LocalDate.of(year, month, day);
        }

        return dateToValid;
    }

    public LocalDate askDate(){

        int beginDateYear = year();
        int beginDateMonth = month();
        int beginDateDay = day(beginDateMonth);

        LocalDate validDate = validDate(beginDateYear, beginDateMonth, beginDateDay );

        return validDate;
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

        boolean reachLimit = controller.countUsers();
        String menssage = "";
        int election = 0;

        if(reachLimit == true){

            menssage = "Has alcanzado el limite. No tienes mas espacio para registrar mas usuarios.";
            System.out.println(menssage);
        }
        
        else{

            do{

            System.out.println("Ingrese el numero que corresponda con el tipo de usuario que vas a registrar: ");
            System.out.println("1. Regular");
            System.out.println("2. Premium");

            election = scan.nextInt();
            scan.nextLine();

            if(election < 1 || election > 2){

                System.out.println("Error. El dato ingresado no es valido");
                System.out.println("Vuelve a intentarlo");
            }
            
            }while(election < 1 || election > 2); 

            System.out.println("Ingresa el nombre del usuario: ");
            String nameComplete = validString();

            System.out.println("Ingrese la identificacion del usuario: ");
            String id = validString();

            System.out.println("Ingrese el correo electronico del usuario: ");
            String emailUser = validString();

            System.out.println("Ingrese el numero de celular del usuario: ");
            String telephone = validString();

            if(election == 1){

                menssage = controller.registerUser(nameComplete, id, emailUser, telephone);
            }
            else{

                System.out.println("Ingrese la fecha de inscripcion del usuario: ");
                LocalDate inscriptionDate = askDate();
                menssage = controller.registerUser(nameComplete, id, emailUser, telephone, inscriptionDate);
            }

            System.out.println(menssage);
        } 
    }

    public void registerTicket(){

        System.out.println("Ingrese el numero de identificacion del usuario en donde va a registrar el ticket: ");
        String id = validString();
        String menssage = "";
        int election = 0;

        boolean reachLimit = controller.countTickets(id);

        if(reachLimit == true){

            menssage = "Error. Haz alcanzado el limite de tickets en este usuario.\nDe lo contrario, no se ha encontrado el usuario."
        }

        else{

            do{

            System.out.println("Ingrese el numero que corresponda con el tipo de ticket que vas a registrar: ");
            System.out.println("1. Clase economica");
            System.out.println("2. Clase ejecutiva");

            election = scan.nextInt();
            scan.nextLine();

            if(election < 1 || election > 2){

                System.out.println("Error. El digito ingresado esta afuera del rango permitido");
                System.out.println("Vuelva a intentarlo");
            }

            }while(election < 1 || election > 2);

            System.out.println("Ingrese el nombre de la aerolinea: ");
            String airlineName = validString();

            System.out.println("Ingrese el numero de vuelo: ");
            String flightNumber = validString();

            System.out.println("Ingrese la ciudad de salida: ");
            String departureCity = validString();

            System.out.println("Ingrese la ciudad de destino: ");
            String arrivalCity = validString();

            System.out.println("Ingrese la fecha de partida: ");
            LocalDate departureDate = askDate();

            double kilometers = 0;

            do{
                System.out.println("Kilometros que vas a recorrer durante vuelo: ");
                kilometers = scan.nextDouble();
                scan.nextLine();

                if(kilometers < 1){

                    System.out.println("Error. el minimo de kilometros permitidos es 1");
                    System.out.println("Vuelva a intentarlo");
                }   

            }while(kilometers < 1);

            if(election == 1){

                System.out.println("Ingrese el codigo de silla: ")
                String chairCode = validString();

                menssage = controller.registerTicket(id, airlineName, flightNumber, departureCity, arrivalCity, departureDate, kilometers, chairCode);
            }

            else{

                int boardingGroup = 0;

                do{
                    System.out.println("Ingrese el grupo de abordaje: ")
                    boardingGroup = scan.nextInt();

                    if(boardingGroup < 1 || boardingGroup > 30){

                        System.out.println("Error. El numero ingresado no esta dentro del rango permitido, entre 1 y 30");
                        System.out.println("Vuelva a intentarlo");
                    }

                }while(boardingGroup < 1 || boardingGroup > 30);

                menssge = controller.registerTicket(id, airlineName, flightNumber, departureCity, arrivalCity, departureDate, kilometers, boardingGroup);
            }
        }
        
        System.out.println(menssage);
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