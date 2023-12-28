package ua.dymohlo.jdbcpractic;

import java.sql.*;

public class JDBCMethods {
    public static void insertIntoTableContact() {
        try (Connection connection = ConnectionManager.getConnection()) {
            String newMailContact = "INSERT INTO alevelgraduates.contact(contact, contact_type) VALUES ('snowSecond@gmail.com', 'mail')";
            PreparedStatement preparedStatement = connection.prepareStatement(newMailContact);
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createNewPersonInTableEmployee() {
        try (Connection connection = ConnectionManager.getConnection()) {
            String createNewPerson = "INSERT INTO alevelgraduates.employee(first_name, lust_name, contact_id) VALUES ('Savitar','God',30)";
            PreparedStatement preparedStatement = connection.prepareStatement(createNewPerson);
            preparedStatement.executeUpdate();
            System.out.println(createNewPerson);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void selectFromTableEmployee() {
        try (Connection connection = ConnectionManager.getConnection()) {
            String graduates = "SELECT * from alevelgraduates.employee";
            PreparedStatement preparedStatement = connection.prepareStatement(graduates);
            ResultSet graduatestSet = preparedStatement.executeQuery();
            while (graduatestSet.next()) {
                String lustName = graduatestSet.getString("lust_name");
                String firstName = graduatestSet.getString("first_name");
                String contact = graduatestSet.getString("contact_id");
                System.out.println(firstName + " " + lustName + " has contact_id # " + contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromTableContact() {
        try (Connection connection = ConnectionManager.getConnection()) {
            int searchId = 2;
            String selectEmployee = "SELECT * FROM alevelgraduates.contact WHERE id = " + searchId;
            try (PreparedStatement selectStatement = connection.prepareStatement(selectEmployee)) {
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Details before deletion:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("contact: " + resultSet.getString("contact"));
                    System.out.println("contact type: " + resultSet.getString("contact_type"));
                } else {
                    System.out.println("No employee found with ID " + searchId);
                    return;
                }
            }
            String deleteEmployee = "DELETE FROM alevelgraduates.contact WHERE id = " + searchId;
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployee)) {
                preparedStatement.executeUpdate();
                System.out.println("Employee with ID" + searchId + " deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromTableEmployee() {
        try (Connection connection = ConnectionManager.getConnection()) {
            int searchId = 2;
            String selectEmployee = "SELECT * FROM alevelgraduates.employee WHERE id = " + searchId;
            try (PreparedStatement selectStatement = connection.prepareStatement(selectEmployee)) {
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Employee details before deletion:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("first name: " + resultSet.getString("first_name"));
                    System.out.println("last name: " + resultSet.getString("lust_name"));
                } else {
                    System.out.println("No employee found with ID " + searchId);
                    return;
                }
            }
            String deleteEmployee = "DELETE FROM alevelgraduates.employee WHERE id = " + searchId;
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployee)) {
                preparedStatement.executeUpdate();
                System.out.println("Employee with ID" + searchId + " deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromTableOrder3() {
        try (Connection connection = ConnectionManager.getConnection()) {
            int searchId = 36;
            String selectEmployee = "SELECT * FROM alevelgraduates.orders3 WHERE id = " + searchId;
            try (PreparedStatement selectStatement = connection.prepareStatement(selectEmployee)) {
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Employee details before deletion:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("name order: " + resultSet.getString("nameorder"));
                    System.out.println("serial number: " + resultSet.getString("serialnumber"));
                    System.out.println("graduate: " + resultSet.getString("graduate"));
                } else {
                    System.out.println("No employee found with ID " + searchId);
                    return;
                }
            }
            String deleteEmployee = "DELETE FROM alevelgraduates.orders3 WHERE id = " + searchId;
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployee)) {
                preparedStatement.executeUpdate();
                System.out.println("Employee with ID" + searchId + " deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}