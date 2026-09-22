package at.htlle.sam;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        String url = "jdbc:h2:./data/school";
        String user = "sa";
        String password = "";
        String sql =
                "SELECT id, firstname, lastname FROM student where age >= 18";


        try (Connection con =
                     DriverManager.getConnection(url, user, password)){
            System.out.println("Connected to database successfully");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                System.out.println(id + ": " + firstname + " " + lastname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
