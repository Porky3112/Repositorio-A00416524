package model;

public class Premium extends Regular{

    private double defaultDiscount = 0.1;
    private double discount;
    private LocalDate registrationDate; 

    public Premium(String nameComplete, String id, String emailUser, String telephone,LocalDate inscriptionDate){

        super(nameComplete, id, emailUser, telephone);
        this.discount = defaultDiscount;
        this.registrationDate = inscriptionDate;
    }

    public String toString(){

        String userInformation = "";

        userInformation = super.toString() + "\nDescuento: " + (discount*100)+ "%" + "\n Fecha de inscripcion: " + registrationDate;

        return userInformation;
    }
}