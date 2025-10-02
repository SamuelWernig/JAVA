package at.htlle.sam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// CAVE: if you rename this class, check pom.xml and Test-Class too!
public class Start {

    private static final Logger LOG = LoggerFactory.getLogger( Start.class );

    public static void main( String[] args ) {
        LOG.info("Application starting...");
        try {
            LOG.debug("Debug info: args length={}", args.length);
            System.out.println( "Hello World from Project-Template!" );
            LOG.info("Work done successfully.");
        } catch (Exception e) {
            LOG.error("Error during work:", e);
        }

    }
}
