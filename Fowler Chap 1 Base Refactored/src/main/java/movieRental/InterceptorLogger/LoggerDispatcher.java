package movieRental.InterceptorLogger;

import java.util.ArrayList;

public class LoggerDispatcher implements ILoggerInterceptor{

    private static LoggerDispatcher dispatcher;
    private ArrayList<LoggerInterceptor> interceptorList;

    private LoggerDispatcher() {
        interceptorList = new ArrayList<LoggerInterceptor>();
    }

    public static LoggerDispatcher getDispatcherInstance() {
        if(dispatcher != null) {
            return dispatcher; 
        }
        return dispatcher = new LoggerDispatcher();
    }

    public void attach(LoggerInterceptor logger) {
        interceptorList.add(logger);
    }

    public void detach(LoggerInterceptor logger) {
        interceptorList.remove(logger);
    }

    public void InventoryCheckLogger(InventoryCheckLogger log) {
        for(LoggerInterceptor interceptors: interceptorList) {
            interceptors.InventoryCheckLogger(log);
        }
    }

    public void FreqentRenterPointsLog(FreqentRenterPointsLog log) {
        for(LoggerInterceptor interceptors: interceptorList) {
            interceptors.FreqentRenterPointsLog(log);
        }
    }

}
