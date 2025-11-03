package at.htlle.persistence;
import at.htlle.domain.Student;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class StudentCsvRepository {
    private static final String HEADER = "id;lastName;firstName";
    private final Path file;

    public StudentCsvRepository(Path baseDir) { this.file = baseDir.resolve("Student.csv"); }

    public void saveAll(List<Student> items) throws IOException {
        try (PrintWriter writer =new PrintWriter(new FileWriter("data\\Student.csv"))){
            writer.println(HEADER);
            for ( Student s : items) {
                writer.println(s.getId() + ";" + s.getLastName() + ";" + s.getFirstName());
            }
        }
    }

    public static List<Student> findAll() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data\\Student.csv"))){
            List<Student> students = new ArrayList<>();
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                students.add(new Student(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                ));
            }
            return students;
        }
    }
}