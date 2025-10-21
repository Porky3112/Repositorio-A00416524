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

    public String toString(){

        String userInformation = "";

        userInformation = "Nombre completo: " + fullName + "\nId: " + idUser + "\nCorreo electronico: " + email + "\ntelefono: " + cellNumber; 

        return userInformation;
    }
} 