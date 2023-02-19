package movieRental.InterceptorLogger;

public interface ILoggerInterceptor {
    public void InventoryCheckLogger(InventoryCheckLogger log);
    public void FreqentRenterPointsLog(FreqentRenterPointsLog log);   
}
