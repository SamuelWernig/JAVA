package at.htlle.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance() /* TODO: Get Logger instance */;
        Logger logger2 = Logger.getInstance() /* TODO: Get Logger instance */;

        logger1.log("Application started.");
        logger2.log("Still using the same logger?");

        // TODO: Prove that logger1 and logger2 are the same instance -> create JUnit-Test!
    }
}
