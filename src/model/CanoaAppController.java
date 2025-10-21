package model;

public class CanoaAppController{

    private String name;
    private Regular[] regularUsers;
    private final int maxUsers = 15; 
    

    public CanoaAppController(String nameApp){

        this.name = nameApp;
        regularUsers = new Regular[maxUsers];
    }

}