package at.htlle.sam;

import java.sql.*;

/*
 Übungsblock Teil A–D
 Vorher setup ausführen, damit die Daten im Ausgangszustand sind.

 11. Bei einer id, die nicht existiert, liefert executeUpdate() 0 zurück.
 14. Ohne WHERE würden ALLE Schüler gelöscht werden.
 */
public class Uebungsblock {

    private static final String URL = "jdbc:h2:./data/school";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Teil A – SELECT
            System.out.println("--- 1. Alle Schüler ---");
            printStudents(statement, "SELECT id, firstname, lastname, age FROM student");

            System.out.println("\n--- 2. Mindestens 18 ---");
            printStudents(statement, "SELECT id, firstname, lastname, age FROM student WHERE age >= 18");

            System.out.println("\n--- 3. Nach Nachname sortiert ---");
            printStudents(statement, "SELECT id, firstname, lastname, age FROM student ORDER BY lastname");

            System.out.println("\n--- 4. Unter 18, nach Alter und Nachname ---");
            printStudents(statement,
                    "SELECT id, firstname, lastname, age FROM student WHERE age < 18 ORDER BY age, lastname");

            System.out.println("\n--- 5. Nur Vor- und Nachname ---");
            try (ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname FROM student")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
                }
            }

            // Teil B – INSERT
            System.out.println("\n--- 6./7. INSERT Sarah Mayer ---");
            int inserted = statement.executeUpdate(
                    "INSERT INTO student (firstname, lastname, age) VALUES ('Sarah', 'Mayer', 20)");
            if (inserted == 1) {
                System.out.println("Datensatz wurde angelegt.");
            } else {
                System.out.println("Kein Datensatz angelegt.");
            }

            System.out.println("\n--- 8. Kontrolle ---");
            printStudents(statement, "SELECT id, firstname, lastname, age FROM student");

            // Teil C – UPDATE
            System.out.println("\n--- 9./10. UPDATE id 1 ---");
            int updated = statement.executeUpdate("UPDATE student SET age = 18 WHERE id = 1");
            System.out.println(updated + " Datensatz geändert.");

            System.out.println("\n--- 11. UPDATE mit nicht existierender id ---");
            int notFound = statement.executeUpdate("UPDATE student SET age = 30 WHERE id = 999");
            System.out.println(notFound + " Datensätze geändert.");

            // Teil D – DELETE
            System.out.println("\n--- 12. DELETE id 4 ---");
            int deleted = statement.executeUpdate("DELETE FROM student WHERE id = 4");
            System.out.println(deleted + " Datensatz gelöscht.");

            System.out.println("\n--- 13. Kontrolle ---");
            printStudents(statement, "SELECT id, firstname, lastname, age FROM student");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printStudents(Statement statement, String sql) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + ": "
                                + resultSet.getString("firstname") + " "
                                + resultSet.getString("lastname") + " ("
                                + resultSet.getInt("age") + ")"
                );
            }
        }
    }
}
