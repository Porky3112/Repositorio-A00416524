package model;

public class CanoaAppController{

    private String name;
    private Regular[] users;
    private final int maxUsers = 15; 
    

    public CanoaAppController(String nameApp){

        this.name = nameApp;
        users = new Regular[maxUsers];
    }

    public boolean countUsers(){

        boolean flag = true;

        for(int i = 0; i < users.length && flag; i++){

            if(users[i] == null){

                flag = false;
            }
        }

        return flag;
    }

    public Regular searchUser(String id){

        Regular temporalUser = null;
        boolean flag = true;

        for(int i = 0; i < users.length && flag; i++){

            if(users[i] != null){

                String temporalId = users[i].getIdUser();

                if(temporalId.equals(id)){

                    temporalUser = users[i];
                    flag = false;
                }
            }
        }

        return temporalUser;
    }

    public boolean countTickets(String idUser){

        boolean reachTicketsLimit = true;
        Regular temporalUser = null;

        temporalUser = searchUser(idUser);

        if(temporalUser != null){

            boolean reachLimit = temporalUser.countTickets();

            if(reachLimit == false){

                reachTicketsLimit = false;
            }
        }

        return reachTicketsLimit;
    }

    public String registerUser(String fullName, String idUser, String email, String cellNumber){

        String menssage = "";
        Regular userRegular = null;
        boolean flag = true;

        for(int i = 0; i < users.length && flag; i++){

            if(users[i] == null){

                userRegular = new Regular(fullName, idUser, email, cellNumber);
                users[i] = userRegular;
                menssage = "Se ha registrado un usuario Regular exitosamente";
                flag = false;
            }
        }

        return mesagge;
    }

    public String registerUser(String fullName, String idUser, String email, String cellNumber, LocalDate registrationDate){

        String menssage = "";
        Premium userPremium = null;
        boolean flag = true;

        for(int i = 0; i < users.length && flag; i++){

            if(users[i] == null){

                userPremium = new Premium(fullName, idUser, email, cellNumber, registrationDate);
                users[i] = userPremium;
                menssage = "Se ha registrado un usuario Premium exitosamente";
                flag = false;
            }
        }

        return mesagge;
    }

    public String registerTicket(String idUser,String nameOfAirlane, String numberOfFlight, String cityOfDeparture, String cityOfArrival,
    LocalDate dateOfDeparture, double kilometersCities, String codeOfChair){

        Regular temporalUser = searchUser(idUser);
        String menssage = "";

        if(temporalUser == null){

            menssage = "Error, no se ha encontrado el usuario.";
        }
        else{

            menssage = temporalUser.registerTicket(nameOfAirlane, numberOfFlight, cityOfDeparture, cityOfArrival, dateOfDeparture, kilometersCities, codeOfChair);
        }

        return menssage;
    }

    public String registerTicket(String idUser,String nameOfAirlane, String numberOfFlight, String cityOfDeparture, String cityOfArrival, 
    LocalDate dateOfDeparture, double kilometersCities, int groupOfBoarding){
        
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