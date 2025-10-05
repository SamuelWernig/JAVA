package at.htlle;
import at.htlle.confg.AppConfg;
import at.htlle.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        AppConfg cfg = AppConfg.load();
        SchoolService service = SchoolService.create(cfg);
        log.info("Data directory: {}", cfg.dataDir().toAbsolutePath());
        service.loadAll();
        if (service.isEmpty()) {

            log.info("No data found  seeding demo data");
            service.seedDemoData();
            service.saveAll();
            service.loadAll();
        }
        log.info("Loaded: {} students, {} courses, {} enrollments",
                service.getStudents().size(),
                service.getCourses().size(),
                service.getEnrollments().size());


    }
}
