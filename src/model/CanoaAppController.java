package model;

public class CanoaAppController{

    private String name;
    private Regular[] users;
    private final int maxUsers = 15; 
    

    public CanoaAppController(String nameApp){

        this.name = nameApp;
        users = new Regular[maxUsers];
    }

    public String showUsers(){

        String listUsers = "";

        for(int i = 0; i < users.length ; i++){

            if(users[i] != null){

                listUsers += "Usuario: " + (i+1) + "\n~~~~~~~~~~~~~~~~~~"+"\n" +users[i].toString()
            }
        }

        return listUsers;
    }
}