package at.htlle.sam.javafx_arbeitszeiterfassung.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeEntry {

    private LocalDate date;
    private String project;
    private LocalTime start;
    private LocalTime end;
    private int breakMinutes;
    private double hours;
    private String note;

    public TimeEntry(LocalDate date, String project, LocalTime start,
                     LocalTime end, int breakMinutes, double hours, String note) {
        this.date = date;
        this.project = project;
        this.start = start;
        this.end = end;
        this.breakMinutes = breakMinutes;
        this.hours = hours;
        this.note = note;
    }

    public LocalDate getDate() { return date; }
    public String getProject() { return project; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public int getBreakMinutes() { return breakMinutes; }
    public double getHours() { return hours; }
    public String getNote() { return note; }
}