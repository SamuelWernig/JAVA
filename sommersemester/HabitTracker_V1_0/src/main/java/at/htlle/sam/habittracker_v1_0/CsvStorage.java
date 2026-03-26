package at.htlle.sam.habittracker_v1_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvStorage {

    private static final CsvStorage instance = new CsvStorage();
    private final Path filePath;

    private CsvStorage() {
        this.filePath = Path.of("habit_tracker.csv");
    }

    public static CsvStorage getInstance() {
        return instance;
    }

    public List<Habit> loadHabits() throws IOException {
        List<Habit> result = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return result;
        }

        Map<String, Habit> map = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            if (line == null) {
                return result;
            }

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                List<String> parts = parseCsvLine(line);
                if (parts.size() < 4) {
                    continue;
                }

                String name = parts.get(0);
                String category = parts.get(1);
                String dateText = parts.get(2);
                String doneText = parts.get(3);

                Habit habit = map.computeIfAbsent(name.toLowerCase(), k -> new Habit(name, category));

                if (!dateText.isBlank() && Boolean.parseBoolean(doneText)) {
                    habit.setDoneOn(LocalDate.parse(dateText), true);
                }
            }
        }

        result.addAll(map.values());
        return result;
    }

    public void saveHabits(List<Habit> habits) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            writer.write("name,category,date,done");
            writer.newLine();

            for (Habit habit : habits) {
                if (habit.getDoneDates().isEmpty()) {
                    writer.write(toCsv(habit.getName()) + "," + toCsv(habit.getCategory()) + ",,false");
                    writer.newLine();
                } else {
                    for (LocalDate date : habit.getDoneDates()) {
                        writer.write(toCsv(habit.getName()) + "," +
                                toCsv(habit.getCategory()) + "," +
                                date + ",true");
                        writer.newLine();
                    }
                }
            }
        }
    }

    private String toCsv(String value) {
        if (value == null) {
            return "\"\"";
        }
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    private List<String> parseCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '\"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '\"') {
                    current.append('\"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        values.add(current.toString());
        return values;
    }
}