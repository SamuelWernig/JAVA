package at.htlle.sam;

import java.sql.*;
import java.util.Scanner;

/*
 * Mini-Frage Teil B:
 Bei "... WHERE genre = '" + genre + "'" wird die Eingabe direkt ins SQL eingebaut.
 Dadurch ist SQL-Injection möglich. Mit ? wird das Genre nur als Wert behandelt.
 */
public class Main {

    private static final String URL = "jdbc:h2:./data/movies";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
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
                case 0:
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        } while (choice != 0);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Tabelle anlegen und Beispieldaten nur einfügen, wenn die Tabelle leer ist
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

            statement.executeUpdate(createSql);

            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM movie")) {
                resultSet.next();
                if (resultSet.getInt(1) == 0) {
                    insertMovie("Interstellar", "Science Fiction", 2014, 8.7);
                    insertMovie("The Dark Knight", "Action", 2008, 9.0);
                    insertMovie("Parasite", "Drama", 2019, 8.5);
                    insertMovie("Dune", "Science Fiction", 2021, 8.0);
                    insertMovie("Knives Out", "Crime", 2019, 7.9);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil A
    private static void printAllMovies() {
        String sql = "SELECT * FROM movie ORDER BY id";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            printResult(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil B
    private static void printMoviesByGenre(String genre) {
        String sql = "SELECT * FROM movie WHERE genre = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genre);
            printResult(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil C
    private static void printMoviesWithMinimumRating(double rating) {
        String sql = "SELECT * FROM movie WHERE rating >= ? ORDER BY rating DESC";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, rating);
            printResult(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil D
    private static void insertMovie(String title, String genre, int releaseYear, double rating) {
        String sql = "INSERT INTO movie (title, genre, release_year, rating) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, genre);
            statement.setInt(3, releaseYear);
            statement.setDouble(4, rating);

            if (statement.executeUpdate() == 1) {
                System.out.println("Film \"" + title + "\" angelegt.");
            } else {
                System.out.println("Film konnte nicht angelegt werden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil E
    private static void updateRating(int id, double newRating) {
        String sql = "UPDATE movie SET rating = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, newRating);
            statement.setInt(2, id);

            if (statement.executeUpdate() > 0) {
                System.out.println("Bewertung aktualisiert.");
            } else {
                System.out.println("Kein Film mit dieser ID gefunden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil F
    private static void deleteMovie(int id) {
        String sql = "DELETE FROM movie WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            if (statement.executeUpdate() > 0) {
                System.out.println("Film gelöscht.");
            } else {
                System.out.println("Kein Film mit dieser ID gefunden.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Teil G
    private static void searchMovies(String searchText) {
        String sql = "SELECT * FROM movie WHERE LOWER(title) LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + searchText.toLowerCase() + "%");
            printResult(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Zusatzaufgabe
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
            e.printStackTrace();
        }
    }

    // gemeinsame Ausgabe für alle SELECT-Methoden
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
                System.out.println("Keine Filme gefunden.");
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
