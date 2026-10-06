package at.htlle.sam;

import java.sql.*;

/*
 * Skript SQL-Injection – Mini-Übungen
 * Vorher setup ausführen.
 *
 * Übung 1:
 * 1. Bei + name + wird die Eingabe direkt in den SQL-String eingebaut.
 * 2. Der Benutzer kann SQL-Code eingeben und die Abfrage verändern (SQL-Injection).
 * 3. Die Datenbank soll Eingaben als Daten behandeln.
 *
 * Übung 4:
 * Die Variante mit ? ist besser, weil SQL und Werte getrennt sind und so keine SQL-Injection möglich ist.
 */
public class PreparedStatementUebung {

    private static final String URL = "jdbc:h2:./data/school";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("--- Übung 2: age = 18 ---");
            findByAge(connection, 18);

            System.out.println("\n--- Übung 3: UPDATE id 1 ---");
            System.out.println(updateAge(connection, 1, 18) + " Datensatz geändert.");

            System.out.println("\n--- Übung 3: DELETE id 4 ---");
            System.out.println(deleteById(connection, 4) + " Datensatz gelöscht.");

            System.out.println("\n--- SQL-Injection Demo ---");
            demoSqlInjection(connection, "' OR '1'='1");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Übung 2
    public static void findByAge(Connection connection, int age) throws SQLException {
        String sql = "SELECT * FROM student WHERE age = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, age);
            printStudents(statement.executeQuery());
        }
    }

    // Übung 3.1
    public static int updateAge(Connection connection, int id, int newAge) throws SQLException {
        String sql = "UPDATE student SET age = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newAge);
            statement.setInt(2, id);
            return statement.executeUpdate();
        }
    }

    // Übung 3.2
    public static int deleteById(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    public static void demoSqlInjection(Connection connection, String lastname) throws SQLException {
        String unsafeSql = "SELECT * FROM student WHERE lastname = '" + lastname + "'";
        System.out.println("Statement: " + unsafeSql);
        try (Statement statement = connection.createStatement()) {
            printStudents(statement.executeQuery(unsafeSql));
        }

        System.out.println("PreparedStatement: SELECT * FROM student WHERE lastname = ?");
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM student WHERE lastname = ?")) {
            statement.setString(1, lastname);
            printStudents(statement.executeQuery());
        }
    }

    private static void printStudents(ResultSet resultSet) throws SQLException {
        try (resultSet) {
            int count = 0;
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + ": "
                                + resultSet.getString("firstname") + " "
                                + resultSet.getString("lastname") + " ("
                                + resultSet.getInt("age") + ")"
                );
                count++;
            }
            System.out.println(count + " Treffer");
        }
    }
}
