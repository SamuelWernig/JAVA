package at.htlle.sam.javafx_arbeitszeiterfassung.service;

import at.htlle.sam.javafx_arbeitszeiterfassung.model.TimeEntry;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.time.format.DateTimeFormatter;

public class CsvService {

    private static final String FILE_NAME = "time_entries.csv";
    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("HH:mm");

    public static void appendEntry(TimeEntry entry) throws IOException {

        File file = new File(FILE_NAME);
        boolean fileExists = file.exists();

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {

            // Header nur schreiben, wenn Datei neu ist
            if (!fileExists) {
                pw.println("date,project,start,end,break_min,hours,note");
            }

            pw.println(
                    entry.getDate() + "," +
                            escape(entry.getProject()) + "," +
                            entry.getStart().format(TIME_FMT) + "," +
                            entry.getEnd().format(TIME_FMT) + "," +
                            entry.getBreakMinutes() + "," +
                            entry.getHours() + "," +
                            escape(entry.getNote())
            );
        }
    }

    private static String escape(String text) {
        if (text == null) return "";

        // Nur Kommas schützen
        if (text.contains(",")) {
            return "\"" + text + "\"";
        }

        return text;
    }
}
