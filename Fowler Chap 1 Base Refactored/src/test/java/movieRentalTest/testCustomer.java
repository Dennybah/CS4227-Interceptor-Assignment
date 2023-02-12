package test.java.movieRentalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import movieRental.Customer;
import movieRental.Movie;
import movieRental.Rental;

public class testCustomer {

	@Test
    public void test() {
        Customer customer = new Customer("Gerald");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("SomeEpicMovie", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("SomeEpicMovie2", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 3));

        String expected = "" +
                "Rental Record for Gerald\n" +
                "\tJaws\t2.0\n" +
                "\tSomeEpicMovie\t3.0\n" +
                "\tSomeEpicMovie2\t6.0\n" +
                "\tToy Story\t1.5\n" +
                "Amount owed is 12.5\n" +
                "You earned 5 frequent renter points";

        assertEquals(expected, customer.statement());
        System.out.println(customer.statement());
    }
}