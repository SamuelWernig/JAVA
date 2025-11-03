package at.htlle.service;
import at.htlle.confg.AppConfg;
import at.htlle.domain.*;
import at.htlle.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.*;
public class SchoolService {
    private static final Logger log =
            LoggerFactory.getLogger(SchoolService.class);
    private final StudentCsvRepository studentRepo;
    private final CourseCsvRepository courseRepo;
    private final EnrollmentCsvRepository enrollmentRepo;
    private final List<Student> students = new ArrayList ();
    private final List<Course> courses = new ArrayList ();
    private final List<Enrollment> enrollments = new ArrayList ();
    private SchoolService(AppConfg cfg) {
        this.studentRepo = new StudentCsvRepository(cfg.dataDir());
        this.courseRepo = new CourseCsvRepository(cfg.dataDir());
        this.enrollmentRepo = new EnrollmentCsvRepository(cfg.dataDir());
    }
    public static SchoolService create(AppConfg cfg) { return new
            SchoolService(cfg); }
    public void loadAll() {
        students.clear(); courses.clear(); enrollments.clear();
        try {
            students.addAll(studentRepo.findAll());
            courses.addAll(courseRepo.findAll());
            enrollments.addAll(enrollmentRepo.findAll());
        } catch (IOException e) {
            log.error("Loading CSV failed", e);
        }
    }
    public void saveAll() {
        try {
            studentRepo.saveAll(students);
            courseRepo.saveAll(courses);
            enrollmentRepo.saveAll(enrollments);
        } catch (IOException e) {
            log.error("Saving CSV failed", e);
        }
    }
    public boolean isEmpty() {
        return students.isEmpty() && courses.isEmpty() && enrollments.isEmpty();
    }
    //getters for tests / demo
    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public void seedDemoData() {
        students.add(new Student(1, "Muster", "Max"));
        students.add(new Student(2, "Smith", "Anna"));
        courses.add(new Course(1, "Math"));
        courses.add(new Course(2, "Programming"));
        enrollments.add(new Enrollment(1, 1, 2));
        enrollments.add(new Enrollment(2, 2, 1));
    }

}
