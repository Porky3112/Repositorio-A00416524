public class EconomyTicket extends Ticket{

    private String chairCode;

    public EconomyTicket(String nameOfAirlane, String numberOfFlight, String cityOfDeparture, String cityOfArrival, LocalDate dateOfDeparture, double kilometersCities, String codeOfChair){

        super(nameOfAirlane, numberOfFlight, cityOfDeparture, cityOfArrival, dateOfDeparture, kilometersCities);
        this.chairCode = codeOfChair;
    }
}