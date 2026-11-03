package at.htlle.sam;

import java.sql.*;

public class Bank {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Setup.URL, Setup.USER, Setup.PASSWORD)) {

            transfer(connection, 1, 2, 200);
            System.out.println("Überweisung erfolgreich.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void transfer(Connection connection, int fromId, int toId, double amount)
            throws SQLException {

        String debitSql = "UPDATE account SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE account SET balance = balance + ? WHERE id = ?";

        connection.setAutoCommit(false);

        try (PreparedStatement debit = connection.prepareStatement(debitSql);
             PreparedStatement credit = connection.prepareStatement(creditSql)) {

            // Betrag abbuchen
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();


            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
}