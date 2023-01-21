package by.a1qa.task3.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {
    private final static Logger logger = LogManager.getLogger();
    public static void info(String message){logger.log(Level.INFO, message);}
    public static void error(String message){
        logger.log(Level.ERROR, message);
    }
}
