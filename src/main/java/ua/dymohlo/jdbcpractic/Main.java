package ua.dymohlo.jdbcpractic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.getConnection()) {
            Statement statement = connection.createStatement();

            String newMailContact = "INSERT INTO alevelgraduates.contact(contact, contact_type) VALUES ('snow@gmail.com', 'mail')";
            statement.executeUpdate(newMailContact);

            String createNewPerson = "INSERT INTO alevelgraduates.employee(first_name, lust_name, contact_id) VALUES ('Caitlin', 'Snow',21)";
            statement.executeUpdate(createNewPerson);

            newMailContact = "INSERT INTO alevelgraduates.contact(contact, contact_type) VALUES ('wells@gmail.com', 'mail')";
            statement.executeUpdate(newMailContact);

            createNewPerson = "INSERT INTO alevelgraduates.employee(first_name, lust_name, contact_id) VALUES ('Harrison', 'Wells',22)";
            statement.executeUpdate(createNewPerson);

            String graduates = "SELECT * from alevelgraduates.employee";
            ResultSet graduatesSet = statement.executeQuery(graduates);
            while (graduatesSet.next()) {
                String lustName = graduatesSet.getString("lust_name");
                String firstName = graduatesSet.getString("first_name");
                String contact = graduatesSet.getString("contact_id");
                System.out.println(firstName + " " + lustName + " has contact_id # " + contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
