package test.java.movieRentalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import movieRental.Customer;
import movieRental.Movie;
import movieRental.Rental;
import movieRental.InterceptorLogger.FreqentRenterPointsLog;
import movieRental.InterceptorLogger.InventoryCheckLogger;
import movieRental.InterceptorLogger.LoggerDispatcher;

public class testCustomer {

	@Test
    public void test() {
    
        Customer testCustomer1 = new Customer("Walter");
        Customer testCustomer2 = new Customer("James");

        Movie testMovie1 = new Movie("Puss in Boots: The Last Wish", 1);
        Movie testMovie2 = new Movie("Sonic the Hedgehog 2", 2);

        Rental testRental1 = new Rental(testMovie1, 2);
        Rental testRental2 = new Rental(testMovie2, 3);
        Rental testRental3 = new Rental(testMovie1, 5);
        testCustomer1.addRental(testRental1);
        testCustomer1.addRental(testRental2);
        testCustomer2.addRental(testRental3);

        InventoryCheckLogger inventorylog1 = new InventoryCheckLogger(testRental1);
        LoggerDispatcher.getDispatcherInstance().InventoryCheckLogger(inventorylog1);
        InventoryCheckLogger inventorylog2 = new InventoryCheckLogger(testRental2);
        LoggerDispatcher.getDispatcherInstance().InventoryCheckLogger(inventorylog2);
        InventoryCheckLogger inventorylog3 = new InventoryCheckLogger(testRental3);
        LoggerDispatcher.getDispatcherInstance().InventoryCheckLogger(inventorylog3);

        FreqentRenterPointsLog frequentRenterPointslog1 = new FreqentRenterPointsLog(testCustomer1, testRental1);
        LoggerDispatcher.getDispatcherInstance().FreqentRenterPointsLog(frequentRenterPointslog1);
        FreqentRenterPointsLog frequentRenterPointslog2 = new FreqentRenterPointsLog(testCustomer1, testRental2);
        LoggerDispatcher.getDispatcherInstance().FreqentRenterPointsLog(frequentRenterPointslog2);
        FreqentRenterPointsLog frequentRenterPointslog3 = new FreqentRenterPointsLog(testCustomer2, testRental3);
        LoggerDispatcher.getDispatcherInstance().FreqentRenterPointsLog(frequentRenterPointslog3);
        
        //testRental1
        assertEquals("Puss in Boots: The Last Wish", inventorylog1.getMovieTitle());
        assertEquals(2, inventorylog1.getDaysRented());
        assertEquals(1, inventorylog1.getMovieType());
        assertEquals("(New_Release)", inventorylog1.getMovieTypeTitle());

        //testRental2
        assertEquals("Sonic the Hedgehog 2", inventorylog2.getMovieTitle());
        assertEquals(3, inventorylog2.getDaysRented());
        assertEquals(2, inventorylog2.getMovieType());
        assertEquals("(Childrens)", inventorylog2.getMovieTypeTitle());

        //testRental3
        assertEquals("Puss in Boots: The Last Wish", inventorylog3.getMovieTitle());
        assertEquals(5, inventorylog3.getDaysRented());
        assertEquals(1, inventorylog3.getMovieType());
        assertEquals("(New_Release)", inventorylog3.getMovieTypeTitle());

        //testCustomer1
        assertEquals("Walter", frequentRenterPointslog1.getCustomerName());
        assertEquals("Walter", frequentRenterPointslog2.getCustomerName());
        assertEquals("Puss in Boots: The Last Wish", frequentRenterPointslog1.getMovieName());
        assertEquals("Sonic the Hedgehog 2", frequentRenterPointslog2.getMovieName());
        assertEquals(2, frequentRenterPointslog1.getFrequentRenterPoints());
        assertEquals(1, frequentRenterPointslog2.getFrequentRenterPoints());
        assertEquals(3, frequentRenterPointslog1.getTotalFrequentRenterPoints());
        assertEquals(3, frequentRenterPointslog2.getTotalFrequentRenterPoints());

        //testCustomer2
        assertEquals("James", frequentRenterPointslog3.getCustomerName());
        assertEquals("Puss in Boots: The Last Wish", frequentRenterPointslog3.getMovieName());
        assertEquals(2, frequentRenterPointslog3.getFrequentRenterPoints());
        assertEquals(2, frequentRenterPointslog3.getTotalFrequentRenterPoints());
    }
}