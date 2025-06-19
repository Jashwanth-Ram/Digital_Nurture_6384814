public class Logger {
    private static Logger instance;

    private Logger() {
        //private constructor
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
   
}
