package at.htlle.logger;

public class Logger {
    // TODO: Implement Singleton Pattern for Logger
    private static Logger instance;

    private Logger(){

    }
    public static Logger getInstance(){
        if ( instance == null ){
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
