package at.htlle.sam;

import java.sql.*;

public class setup {

    public static void main(String[] args) {

        String url = "jdbc:h2:./data/school";
        String user = "sa";
        String password = "";

        try (Connection con =
                     DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to database successfully");

            Statement stmt = con.createStatement();

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student (" +
                            "id INT PRIMARY KEY, " +
                            "firstname VARCHAR(50), " +
                            "lastname VARCHAR(50), " +
                            "age INT" +
                            ")"
            );

            stmt.executeUpdate(
                    "MERGE INTO student (id, firstname, lastname, age) " +
                    "INSERT INTO student VALUES (1, 'Anna', 'Berger', 17)"
            );

            stmt.executeUpdate(
                    "MERGE INTO student (id, firstname, lastname, age) " +
                    "INSERT INTO student VALUES (2, 'Max', 'Huber', 18)"
            );

            stmt.executeUpdate(
                    "MERGE INTO student (id, firstname, lastname, age) " +
                    "INSERT INTO student VALUES (3, 'Lena', 'Gruber', 19)"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}