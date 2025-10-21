package model;

public class ExecutiveTicket extends Ticket{

    private int boardingGroup;

    public Ticket(String nameOfAirlane, String numberOfFlight, String cityOfDeparture, String cityOfArrival, LocalDate dateOfDeparture, double kilometersCities, int groupOfBoarding){

        super(nameOfAirlane, numberOfFlight, cityOfDeparture, cityOfArrival, dateOfDeparture, kilometersCities);
        this.boardingGroup = groupOfBoarding;
    }
}