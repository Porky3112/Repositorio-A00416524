package model;


public class Regular(){

    // atributes

    private String fullName;
    private String idUser;
    private String email;
    private String cellNumber;

    //relations

    private Ticket[] tickets;
    private int maxTickets = 10;

    public Regular(String nameComplete, String id, String emailUser, String telephone){

        this.fullName = nameComplete; 
        this.idUser = id; 
        this.email = emailUser;
        this.cellNumber = telephone;
        tickets = new Ticket[10];
    }

    public String getIdUser(){

        return idUser;
    }

    public boolean countTickets(){

        boolean flag = true;

        for(int i = 0; i < tickets.length && flag; i++){

            if(tickets[i] == null){

                flag = false;
            }
        }
        
        return flag;
    }

    public String registerTicket(String airlineName, String flightNumber, String departureCity, String arrivalCity, LocalDate departureDate, double kilometers, String chairCode){

        EconomyTicket temporalEconomyTicket= new EconomyTicket(airlineName, flightNumber, departureCity, arrivalCity, departureDate, kilometers, chairCode);
        b

        for(int i = 0; i < tickets.length ; i++){

            if(tickets[i] == null){

                tickets[i] = temporalEconomyTicket;
            }
        }
    }

    public String toString(){

        String userInformation = "";

        userInformation = "Nombre completo: " + fullName + "\nId: " + idUser + "\nCorreo electronico: " + email + "\ntelefono: " + cellNumber; 

        return userInformation;
    }
} 