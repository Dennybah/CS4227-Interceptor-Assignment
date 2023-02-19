package movieRental.InterceptorLogger;

public class LoggerInterceptor implements ILoggerInterceptor {

    public void InventoryCheckLogger(InventoryCheckLogger log) {
        System.out.println("INVENTORY CHECK");
        System.out.println("Movie being rented: " + log.getMovieTitle());
        System.out.println("How many days: " + log.getDaysRented());
        System.out.println("Type of movie: " + log.getMovieType() + " " + log.getMovieTypeTitle() + "\n");
    }

    public void FreqentRenterPointsLog(FreqentRenterPointsLog log) {
        System.out.println("Customer name: " + log.getCustomerName());
        System.out.println("Movie being rented: " + log.getMovieName());
        System.out.println("Frequent renter points gained: " + log.getFrequentRenterPoints());
        System.out.println("Total frequent renter points: " + log.getTotalFrequentRenterPoints() + "\n");
    }
}
