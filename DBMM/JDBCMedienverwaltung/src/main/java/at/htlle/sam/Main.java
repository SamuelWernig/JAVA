package at.htlle.sam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String URL = "jdbc:h2:./data/movies";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        logger.info("Medienverwaltung gestartet");
        createTable();

        int choice;
        do {
            System.out.println("\n--- MOVIE DATABASE ---");
            System.out.println("1 - Alle Filme anzeigen");
            System.out.println("2 - Nach Genre suchen");
            System.out.println("3 - Nach Mindestbewertung suchen");
            System.out.println("4 - Film hinzufügen");
            System.out.println("5 - Bewertung ändern");
            System.out.println("6 - Film löschen");
            System.out.println("7 - Film suchen");
            System.out.println("8 - Statistik");
            System.out.println("9 - Fehlertest");
            System.out.println("0 - Programm beenden");
            choice = readInt("Auswahl: ");

            switch (choice) {
                case 1:
                    printAllMovies();
                    break;
                case 2:
                    printMoviesByGenre(readText("Genre: "));
                    break;
                case 3:
                    printMoviesWithMinimumRating(readDouble("Mindestbewertung: "));
                    break;
                case 4:
                    insertMovie(
                            readText("Titel: "),
                            readText("Genre: "),
                            readInt("Erscheinungsjahr: "),
                            readDouble("Bewertung: ")
                    );
                    break;
                case 5:
                    updateRating(readInt("ID: "), readDouble("Neue Bewertung: "));
                    break;
                case 6:
                    deleteMovie(readInt("ID: "));
                    break;
                case 7:
                    searchMovies(readText("Suchtext: "));
                    break;
                case 8:
                    printStatistics();
                    break;
                case 9:
                    runErrorTests();
                    break;
                case 0:
                    logger.info("Programm beendet");
                    break;
                default:
                    logger.warn("Ungültige Auswahl: {}", choice);
            }
        } while (choice != 0);
    }

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        logger.debug("Verbindung geöffnet");
        return connection;
    }

    private static void createTable() {
        String createSql =
                "CREATE TABLE IF NOT EXISTS movie ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "title VARCHAR(100) NOT NULL, "
                        + "genre VARCHAR(50), "
                        + "release_year INT, "
                        + "rating DOUBLE)";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            logger.info("Datenbankverbindung hergestellt");
            statement.executeUpdate(createSql);
            logger.debug("Tabelle movie geprüft");

            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM movie")) {
                resultSet.next();
                if (resultSet.getInt(1) == 0) {
                    logger.info("Tabelle ist leer, Beispieldaten werden eingefügt");
                    insertMovie("Interstellar", "Science Fiction", 2014, 8.7);
                    insertMovie("The Dark Knight", "Action", 2008, 9.0);
                    insertMovie("Parasite", "Drama", 2019, 8.5);
                    insertMovie("Dune", "Science Fiction", 2021, 8.0);
                    insertMovie("Knives Out", "Crime", 2019, 7.9);
                }
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void printAllMovies() {
        String sql = "SELECT * FROM movie ORDER BY id";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            printResult(statement);

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void printMoviesByGenre(String genre) {
        String sql = "SELECT * FROM movie WHERE genre = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genre);
            logger.debug("Suche nach Genre: {}", genre);
            printResult(statement);

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void printMoviesWithMinimumRating(double rating) {
        String sql = "SELECT * FROM movie WHERE rating >= ? ORDER BY rating DESC";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, rating);
            logger.debug("Suche nach Mindestbewertung: {}", rating);
            printResult(statement);

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void insertMovie(String title, String genre, int releaseYear, double rating) {
        String sql = "INSERT INTO movie (title, genre, release_year, rating) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setInt(3, releaseYear);
            statement.setDouble(4, rating);

            if (statement.executeUpdate() == 1) {
                logger.info("Film \"{}\" erfolgreich angelegt", title);
            } else {
                logger.warn("Film \"{}\" konnte nicht angelegt werden", title);
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void updateRating(int id, double newRating) {
        String sql = "UPDATE movie SET rating = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, newRating);
            statement.setInt(2, id);

            if (statement.executeUpdate() > 0) {
                logger.info("Bewertung von Film {} auf {} geändert", id, newRating);
            } else {
                logger.warn("Film mit ID {} existiert nicht", id);
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void deleteMovie(int id) {
        String sql = "DELETE FROM movie WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            if (statement.executeUpdate() > 0) {
                logger.info("Film mit ID {} gelöscht", id);
            } else {
                logger.warn("Film mit ID {} existiert nicht", id);
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void searchMovies(String searchText) {
        String sql = "SELECT * FROM movie WHERE LOWER(title) LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + searchText.toLowerCase() + "%");
            logger.debug("Suche nach Titel: {}", searchText);
            printResult(statement);

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void printStatistics() {
        String sql = "SELECT COUNT(*) AS anzahl, AVG(rating) AS durchschnitt, "
                + "(SELECT title FROM movie ORDER BY rating DESC LIMIT 1) AS bester "
                + "FROM movie";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                System.out.println("Anzahl Filme: " + resultSet.getInt("anzahl"));
                System.out.printf("Durchschnittliche Bewertung: %.2f%n", resultSet.getDouble("durchschnitt"));
                System.out.println("Bester Film: " + resultSet.getString("bester"));
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private static void runErrorTests() {
        String[] sqls = {
                "SELECT * FROM filme",
                "SELECT name FROM movie",
                "SELEC * FROM movie",
                "INSERT INTO movie (title) VALUES (NULL)"
        };

        for (String sql : sqls) {
            logger.info("Fehlertest: {}", sql);

            try (Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {

                statement.execute(sql);

            } catch (SQLException e) {
                System.out.println("Message:   " + e.getMessage());
                System.out.println("SQLState:  " + e.getSQLState());
                System.out.println("ErrorCode: " + e.getErrorCode());
                handleSQLException(e);
            }
        }
    }

    private static void handleSQLException(SQLException e) {
        String sqlState = e.getSQLState();
        String sqlClass = "";

        if (sqlState != null && sqlState.length() >= 2) {
            sqlClass = sqlState.substring(0, 2);
        }

        switch (sqlClass) {
            case "08":
                logger.error("Verbindungsfehler: {}", e.getMessage());
                break;
            case "23":
                logger.error("Integritätsverletzung: {}", e.getMessage());
                break;
            case "42":
                logger.error("SQL-/Objektfehler: {}", e.getMessage());
                break;
            default:
                logger.error("Allgemeiner Datenbankfehler: {}", e.getMessage());
        }

        logger.error(
                "Database error: SQLState={}, ErrorCode={}",
                e.getSQLState(),
                e.getErrorCode(),
                e
        );
    }

    private static void printResult(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            boolean found = false;
            while (resultSet.next()) {
                found = true;
                System.out.println(
                        resultSet.getInt("id") + " | "
                                + resultSet.getString("title") + " | "
                                + resultSet.getString("genre") + " | "
                                + resultSet.getInt("release_year") + " | "
                                + resultSet.getDouble("rating")
                );
            }
            if (!found) {
                logger.warn("Keine Filme gefunden");
            }
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine ganze Zahl eingeben.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readText(prompt).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine Zahl eingeben.");
            }
        }
    }
}
