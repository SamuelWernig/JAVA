package at.htlle.sam;

import java.sql.*;

public class setup {

    public static void main(String[] args) {

        String url = "jdbc:h2:./data/school";
        String user = "sa";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            System.out.println("Connected to database successfully");

            stmt.executeUpdate("DROP TABLE IF EXISTS student");

            stmt.executeUpdate(
                    "CREATE TABLE student (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "firstname VARCHAR(50), " +
                            "lastname VARCHAR(50), " +
                            "age INT" +
                            ")"
            );

            stmt.executeUpdate("INSERT INTO student (firstname, lastname, age) VALUES ('Anna', 'Berger', 17)");
            stmt.executeUpdate("INSERT INTO student (firstname, lastname, age) VALUES ('Max', 'Huber', 18)");
            stmt.executeUpdate("INSERT INTO student (firstname, lastname, age) VALUES ('Lena', 'Gruber', 19)");
            stmt.executeUpdate("INSERT INTO student (firstname, lastname, age) VALUES ('Paul', 'Steiner', 16)");

            System.out.println("Tabelle student neu angelegt.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
