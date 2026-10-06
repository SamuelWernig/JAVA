package at.htlle.sam;

import java.sql.*;

// Größere Übung: mehrere JDBC-Operationen hintereinander
public class Main {

    private static final String URL = "jdbc:h2:./data/school";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("--- Vorher ---");
        printStudents();

        insertStudent("Tom", "Wagner", 17);
        updateStudent(2, 19);
        deleteStudent(3);

        System.out.println("\n--- Nachher ---");
        printStudents();
    }

    private static void printStudents() {
        String sql = "SELECT id, firstname, lastname, age FROM student";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + ": "
                                + resultSet.getString("firstname") + " "
                                + resultSet.getString("lastname") + " ("
                                + resultSet.getInt("age") + ")"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(String firstname, String lastname, int age) {
        String sql = "INSERT INTO student (firstname, lastname, age) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setInt(3, age);

            int rows = statement.executeUpdate();
            System.out.println("\n" + rows + " Datensatz angelegt.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateStudent(int id, int newAge) {
        String sql = "UPDATE student SET age = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, newAge);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();
            System.out.println(rows + " Datensatz geändert.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            System.out.println(rows + " Datensatz gelöscht.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
