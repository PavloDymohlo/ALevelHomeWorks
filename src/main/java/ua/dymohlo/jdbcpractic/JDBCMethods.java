package ua.dymohlo.jdbcpractic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMethods {

    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }

    public static void insertIntoTableContact() {
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "INSERT INTO alevelgraduates.contact(contact, contact_type) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Next you will add data to the table 'contact'");
            preparedStatement.setString(1, input("Enter new contact"));
            preparedStatement.setString(2, input("Enter new contact_type"));
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createNewPersonInTableEmployee() {
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "INSERT INTO alevelgraduates.employee(first_name, lust_name) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Next you will add data to the table 'employee'");
            preparedStatement.setString(1, input("Enter first name"));
            preparedStatement.setString(2, input("enter last name"));
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
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
        int searchId = Integer.parseInt(input("Enter the id of user you want to delete from the table 'contact'"));
        try (Connection connection = ConnectionManager.getConnection()) {
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
            String query = "DELETE FROM alevelgraduates.contact WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, searchId);
                preparedStatement.executeUpdate();
                System.out.println("Employee with ID" + searchId + " deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFromTableEmployee() {
        try (Connection connection = ConnectionManager.getConnection()) {
            int searchId = Integer.parseInt(input("Enter the id of user you want to delete from the table 'employee'"));
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
            int searchId = Integer.parseInt(input("Enter the id of user you want to delete from the table 'order3'"));
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