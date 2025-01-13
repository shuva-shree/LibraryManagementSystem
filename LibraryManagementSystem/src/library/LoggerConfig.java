//package library;
//
//import java.util.logging.*;
//
//public class LoggerConfig {
//    private static final Logger logger = Logger.getLogger(LoggerConfig.class.getName());
//
//    static {
//        try {
//            LogManager.getLogManager().readConfiguration(LoggerConfig.class.getResourceAsStream("/logging.properties"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Logger getLogger() {
//        return logger;
//    }
//}
