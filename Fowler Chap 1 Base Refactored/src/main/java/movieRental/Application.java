package movieRental;

import movieRental.InterceptorLogger.LoggerDispatcher;
import movieRental.InterceptorLogger.LoggerInterceptor;

public class Application {
    public static void main(String[] args) {
        
        LoggerInterceptor interceptor = new LoggerInterceptor();
        LoggerDispatcher dispatcher = LoggerDispatcher.getDispatcherInstance();
        dispatcher.attach(interceptor);

        Customer customer1 = new Customer("Gerald");
        Rental rental1 = new Rental(new Movie("Puss in Boots: The Last Wish", 1), 2);
        Rental rental2 = new Rental(new Movie("Sonic the Hedgehog 2", 2), 3);

        customer1.addRental(rental1);
        customer1.addRental(rental2);
    }
}

