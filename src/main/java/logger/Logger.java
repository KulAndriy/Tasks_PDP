package logger;


import main.Main;

public class Logger {
    private static org.apache.log4j.Logger logger;

    public static org.apache.log4j.Logger getLogger(){
        if (logger == null){
            logger = org.apache.log4j.Logger.getLogger(Main.class);
        }
        return logger;
    }
}
