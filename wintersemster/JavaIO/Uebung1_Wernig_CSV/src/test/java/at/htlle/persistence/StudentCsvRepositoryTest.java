package at.htlle.persistence;
import at.htlle.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class StudentCsvRepositoryTest {
    @Test
    void roundtrip(@TempDir Path tmp) throws IOException {
        StudentCsvRepository repo = new StudentCsvRepository(tmp);
        List<Student> input = List.of(
                new Student(1, "Muster", "Max"),
                new Student(2, "Smith", "Anna")
        );
        repo.saveAll(input);
        List<Student> output = repo.findAll();
        assertEquals(input, output);
    }
}
