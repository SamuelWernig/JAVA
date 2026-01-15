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
    public String log(String message) {
        String output = "[LOG] " + message;
        System.out.println(output);
        return output;
    }

}
