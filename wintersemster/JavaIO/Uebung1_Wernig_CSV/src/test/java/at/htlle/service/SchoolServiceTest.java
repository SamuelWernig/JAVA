package at.htlle.service;
import at.htlle.confg.AppConfg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
class SchoolServiceTest {
    @Test
    void seed_save_reload(@TempDir Path tmp) {
        SchoolService s1 = SchoolService.create(new AppConfg(tmp));
        assertTrue(s1.isEmpty());
        s1.seedDemoData();
        s1.saveAll();
        SchoolService s2 = SchoolService.create(new AppConfg(tmp));
        s2.loadAll();
        assertFalse(s2.isEmpty());
        assertEquals(2, s2.getStudents().size());
        assertEquals(2, s2.getCourses().size());
        assertEquals(2, s2.getEnrollments().size());
    }
}