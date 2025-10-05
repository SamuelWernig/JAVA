package at.htlle.persistence;

import at.htlle.domain.Course;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class CourseCsvRepository {
    private static final String HEADER = "id;title";
    private final Path file;

    public CourseCsvRepository(Path baseDir) {
        this.file = baseDir.resolve("Course.csv");
    }

    public void saveAll(List<Course> items) throws IOException {
        Files.createDirectories(file.getParent()); // Ordner anlegen, falls nicht vorhanden

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(HEADER);
            writer.newLine();
            for (Course c : items) {
                writer.write(c.getId() + ";" + c.getTitle());
                writer.newLine();
            }
        }
    }

    public List<Course> findAll() throws IOException {
        if (!Files.exists(file)) {
            return List.of();
        }

        return Files.lines(file, StandardCharsets.UTF_8)
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(";");
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    return new Course(id, title);
                })
                .toList();
    }
}
