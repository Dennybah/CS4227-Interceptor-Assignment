package movieRental;

import java.util.Enumeration;
import java.util.Vector;

import movieRental.InterceptorLogger.FreqentRenterPointsLog;
import movieRental.InterceptorLogger.LoggerDispatcher;

/**
 * The customer class represents a customer.
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;   
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
        FreqentRenterPointsLog log = new FreqentRenterPointsLog(this, arg);
        LoggerDispatcher.getDispatcherInstance().FreqentRenterPointsLog(log);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
    
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
       
    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
