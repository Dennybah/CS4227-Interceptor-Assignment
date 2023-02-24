package movieRental;

import movieRental.InterceptorLogger.LoggerDispatcher;
import movieRental.InterceptorLogger.InventoryCheckLogger;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
        //Interception point used to log a created rental via InventoryCheckLogger
        InventoryCheckLogger log = new InventoryCheckLogger(this);
        LoggerDispatcher.getDispatcherInstance().InventoryCheckLogger(log);
    }
    
    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
    
}
