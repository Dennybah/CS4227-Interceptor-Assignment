package movieRental.InterceptorLogger;

import movieRental.Customer;
import movieRental.Rental;

/**
 * This context object logs a customer and a rental to get the freqentRenterPoints for each movie rented along with 
 * calculating the totalFrequentRenterPoints by using getTotalFrequentRenterPoints() within customer
 */

public class FreqentRenterPointsLog {
    private Customer customer;
    private Rental rental;

    public FreqentRenterPointsLog(Customer customer, Rental rental) {
        this.customer = customer;
        this.rental = rental;
    }
    
    public String getCustomerName() {
        return customer.getName();
    }

    public String getMovieName() {
        return rental.getMovie().getTitle();
    }

    public int getFrequentRenterPoints() {
        return rental.getFrequentRenterPoints();
    }

    public int getTotalFrequentRenterPoints() {
        return customer.getTotalFrequentRenterPoints();
    }

}
