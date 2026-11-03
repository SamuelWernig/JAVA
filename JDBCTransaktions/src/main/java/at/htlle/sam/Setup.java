package at.htlle.sam;

import java.sql.*;

public class Setup {

    public static final String URL = "jdbc:h2:./data/bank";
    public static final String USER = "sa";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS account");

            statement.executeUpdate(
                    "CREATE TABLE account ("
                            + "id INT AUTO_INCREMENT PRIMARY KEY, "
                            + "owner VARCHAR(100) NOT NULL, "
                            + "balance DECIMAL(10, 2) NOT NULL)"
            );

            statement.executeUpdate("INSERT INTO account (owner, balance) VALUES ('Anna Berger', 1000.00)");
            statement.executeUpdate("INSERT INTO account (owner, balance) VALUES ('Max Huber', 500.00)");

            System.out.println("Tabelle account angelegt:");
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM account ORDER BY id")) {
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getInt("id") + " | "
                                    + resultSet.getString("owner") + " | "
                                    + resultSet.getBigDecimal("balance") + " €"
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
