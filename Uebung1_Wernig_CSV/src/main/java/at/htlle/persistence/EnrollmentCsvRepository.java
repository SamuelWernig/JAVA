package at.htlle.persistence;

import at.htlle.domain.Enrollment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class EnrollmentCsvRepository {
    private static final String HEADER = "id;studentId;courseId";
    private final Path file;

    public EnrollmentCsvRepository(Path baseDir) {
        this.file = baseDir.resolve("Enrollment.csv");
    }

    public void saveAll(List<Enrollment> items) throws IOException {
        Files.createDirectories(file.getParent()); // Ordner sicherstellen

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(HEADER);
            writer.newLine();
            for (Enrollment e : items) {
                writer.write(e.getId() + ";" + e.getStudentId() + ";" + e.getCourseId());
                writer.newLine();
            }
        }
    }

    public List<Enrollment> findAll() throws IOException {
        if (!Files.exists(file)) {
            return List.of();
        }

        return Files.lines(file, StandardCharsets.UTF_8)
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(";");
                    int id = Integer.parseInt(parts[0]);
                    int studentId = Integer.parseInt(parts[1]);
                    int courseId = Integer.parseInt(parts[2]);
                    return new Enrollment(id, studentId, courseId);
                })
                .toList();
    }
}
