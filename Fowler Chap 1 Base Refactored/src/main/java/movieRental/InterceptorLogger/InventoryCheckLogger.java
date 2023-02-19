package movieRental.InterceptorLogger;

import movieRental.Rental;

/**
 * This context object logs a rental and returns key information for an inventory system such as the title of 
 * the movie being rented, how many days it is being rented and the type of movie (both as an int and as a string)
 */

public class InventoryCheckLogger {
    private Rental rental;

    public InventoryCheckLogger(Rental rental) {
        this.rental = rental;
    } 
    
    public String getMovieTitle() {
        return rental.getMovie().getTitle();
    }

    public int getDaysRented() {
        return rental.getDaysRented();
    }

    public int getMovieType() {
        return rental.getMovie().getPriceCode();
    }

    public String getMovieTypeTitle() {
        String result = "";
        if(rental.getMovie().getPriceCode() == 0) {
            result = "(Regular)";
        }
        if(rental.getMovie().getPriceCode() == 1) {
            result = "(New_Release)";
        }
        if(rental.getMovie().getPriceCode() == 2) {
            result = "(Childrens)";
        }
        return result;
    }
}
