package at.htlle.sam;

import java.sql.*;

/*
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
            System.out.println("Connected to database successfully");

            insertStudent(connection, 99, "Test", "Schueler", 16);

            System.out.println("\n--- Mini-Übung 2: Schüler mit age = 16 ---");
            findByAge(connection, 16);

            System.out.println("\n--- Mini-Übung 3a: UPDATE age von id 99 auf 20 ---");
            int updated = updateAge(connection, 99, 20);
            System.out.println(updated + " Datensatz geändert.");
            findByAge(connection, 20);

            System.out.println("\n--- Mini-Übung 3b: DELETE id 99 ---");
            int deleted = deleteById(connection, 99);
            System.out.println(deleted + " Datensatz gelöscht.");

            System.out.println("\n--- Demo SQL-Injection (Eingabe: ' OR '1'='1) ---");
            demoSqlInjection(connection, "' OR '1'='1");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByAge(Connection connection, int age) throws SQLException {
        String sql = "SELECT * FROM student WHERE age = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, age);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    printStudent(resultSet);
                }
            }
        }
    }

    public static int updateAge(Connection connection, int id, int newAge) throws SQLException {
        String sql = "UPDATE student SET age = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newAge);
            statement.setInt(2, id);
            return statement.executeUpdate();
        }
    }

    public static int deleteById(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    public static int insertStudent(Connection connection, int id, String firstname,
                                    String lastname, int age) throws SQLException {
        String sql = "MERGE INTO student (id, firstname, lastname, age) KEY (id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setInt(4, age);
            return statement.executeUpdate();
        }
    }

    public static void demoSqlInjection(Connection connection, String lastname) throws SQLException {
        String unsafeSql = "SELECT * FROM student WHERE lastname = '" + lastname + "'";
        System.out.println("Statement (unsicher): " + unsafeSql);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(unsafeSql)) {
            while (resultSet.next()) {
                printStudent(resultSet);
            }
        }

        System.out.println("PreparedStatement (sicher): SELECT * FROM student WHERE lastname = ?");
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM student WHERE lastname = ?")) {
            statement.setString(1, lastname);
            try (ResultSet resultSet = statement.executeQuery()) {
                int count = 0;
                while (resultSet.next()) {
                    printStudent(resultSet);
                    count++;
                }
                System.out.println(count + " Treffer – die Eingabe wurde nur als Wert behandelt.");
            }
        }
    }

    private static void printStudent(ResultSet resultSet) throws SQLException {
        System.out.println(
                resultSet.getInt("id") + ": "
                        + resultSet.getString("firstname") + " "
                        + resultSet.getString("lastname") + " ("
                        + resultSet.getInt("age") + ")"
        );
    }
}
