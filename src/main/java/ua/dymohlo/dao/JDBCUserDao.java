package ua.dymohlo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUserDao implements Dao {
    private static final JDBCUserDao INSTANCE = new JDBCUserDao();

    private JDBCUserDao() {
    }

    public static JDBCUserDao getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public User create(Object entity) {
        String INSERT_SQL = "INSERT INTO daopractic.users(full_name, profession) VALUES (?,?);";
        try (Connection connection = ConnectorManager.Connection()) {
            User user = (User) entity;
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getProfession());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUsersId(generatedKeys.getInt("users_id"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        String GET_SQL = "SELECT users_id, full_name, profession FROM daopractic.users WHERE users_id = ?";
        try (Connection connection = ConnectorManager.Connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("users_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("profession")
                );
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public User update(Long id) {
//        User user = new User();
//        String UPDATE_SQL = "UPDATE daopractic.users SET full_name= ?, profession= ? WHERE users_id = ?";
//        String GET_SQL = "SELECT users_id, full_name, profession FROM daopractic.users WHERE users_id = ?";
//        try (Connection connection = ConnectorManager.Connection()) {
//            try (PreparedStatement selectStatement = connection.prepareStatement(GET_SQL)) {
//                selectStatement.setLong(1, id);
//                ResultSet resultSet = selectStatement.executeQuery();
//
//                if (resultSet.next()) {
//                    System.out.println("User with id " + id + " does not exist.");
//                    return null;
//                }
//            }
//            String newFullName = input("Enter new user's full name: ");
//            String newProfession = input("Enter new user's profession:");
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
//            preparedStatement.setString(1, newFullName);
//            preparedStatement.setString(2, newProfession);
//            preparedStatement.setLong(3, id);
//
//            int updateUser = preparedStatement.executeUpdate();
//            if (updateUser > 0) {
//                return new User( user.getUsersId(),newFullName, newProfession);
//            }
//            return null;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public User update(Long id) {
        User user = new User();
        String UPDATE_SQL = "UPDATE daopractic.users SET full_name= ?, profession= ? WHERE users_id = ?";
        String GET_SQL = "SELECT users_id, full_name, profession FROM daopractic.users WHERE users_id = ?";
        try (Connection connection = ConnectorManager.Connection()) {
            try (PreparedStatement selectStatement = connection.prepareStatement(GET_SQL)) {
                selectStatement.setLong(1, id);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    String newFullName = input("Enter new user's full name: ");
                    String newProfession = input("Enter new user's profession:");
                    PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
                    preparedStatement.setString(1, newFullName);
                    preparedStatement.setString(2, newProfession);
                    preparedStatement.setLong(3, id);
                    int updateUser = preparedStatement.executeUpdate();
                    if (updateUser > 0) {
                        return new User(user.getUsersId(), newFullName, newProfession);
                    }
                }
                System.out.println("User with id " + id + " does not exist.");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteById(Long id) {
        String DELETE_SQL = "DELETE FROM daopractic.users WHERE users_id = ?";
        String GET_SQL = "SELECT users_id, full_name, profession FROM daopractic.users WHERE users_id = ?";
        try (Connection connection = ConnectorManager.Connection()) {
            try (PreparedStatement selectStatement = connection.prepareStatement(GET_SQL)) {
                selectStatement.setLong(1, id);
                ResultSet resultUser = selectStatement.executeQuery();

                if (resultUser.next()) {
                    System.out.println("User's details before deletion:");
                    System.out.println("users id: " + resultUser.getInt("users_id"));
                    System.out.println("full name: " + resultUser.getString("full_name"));
                    System.out.println("profession: " + resultUser.getString("profession"));
                }
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
                preparedStatement.setLong(1, id);
                int resultSet = preparedStatement.executeUpdate();
                if (resultSet > 0) {
                    System.out.println("User with id " + id + " was deleted.");
                } else {
                    System.out.println("User with id " + id + " does not exist.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }
}
