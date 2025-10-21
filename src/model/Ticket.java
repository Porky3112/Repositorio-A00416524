public abstract class Ticket{

    // atributes

    private String airlineName;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;
    private double kilometers;

    public Ticket(String nameOfAirlane, String numberOfFlight, String cityOfDeparture, String cityOfArrival, LocalDate dateOfDeparture, double kilometersCities){

        this.airlineName = nameOfAirlane;
        this.flightNumber = numberOfFlight;
        this.departureCity = cityOfDeparture;
        this.arrivalCity = cityOfArrival;
        this.departureDate = dateOfDeparture;
        this.kilometers = kilometersCities;
    }
}