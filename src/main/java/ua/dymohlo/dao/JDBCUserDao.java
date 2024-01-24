package ua.dymohlo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class JDBCUserDao implements Dao<User> {
    private static final JDBCUserDao INSTANCE = new JDBCUserDao();

    private JDBCUserDao() {
    }

    public static JDBCUserDao getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public User create(User user) {
        String INSERT_SQL = "INSERT INTO daopractic.users(full_name, profession) VALUES (?,?);";
        try (Connection connection = ConnectorManager.Connection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getProfession());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUsersId(generatedKeys.getInt("id"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        String GET_SQL = "SELECT id, full_name, profession FROM daopractic.users WHERE id = ?";
        try (Connection connection = ConnectorManager.Connection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("profession")
                );
                return Optional.of(user);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> update(User user) {
        String UPDATE_SQL = "UPDATE daopractic.users SET full_name= ?, profession= ? WHERE id = ?";
        String GET_SQL = "SELECT id, full_name, profession FROM daopractic.users WHERE id = ?";
        try (Connection connection = ConnectorManager.Connection();
             PreparedStatement selectStatement = connection.prepareStatement(GET_SQL);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {

                selectStatement.setLong(1, user.getUsersId());
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    String newFullName = input("Enter new user's full name: ");
                    String newProfession = input("Enter new user's profession:");

                    preparedStatement.setString(1, newFullName);
                    preparedStatement.setString(2, newProfession);
                    preparedStatement.setLong(3, user.getUsersId());
                    int updateUser = preparedStatement.executeUpdate();
                    if (updateUser > 0) {
                        return Optional.of(new User(user.getUsersId(), newFullName, newProfession));
                    }
                }
                System.out.println("User with id " + user.getUsersId() + " does not exist.");
                return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteById(Long id) {
        String DELETE_SQL = "DELETE FROM daopractic.users WHERE id = ?";
        String GET_SQL = "SELECT id, full_name, profession FROM daopractic.users WHERE id = ?";
        try (Connection connection = ConnectorManager.Connection();
             PreparedStatement selectStatement = connection.prepareStatement(GET_SQL);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);) {
                selectStatement.setLong(1, id);
                ResultSet resultUser = selectStatement.executeQuery();

                if (resultUser.next()) {
                    System.out.println("User's details before deletion:");
                    System.out.println("users id: " + resultUser.getInt("id"));
                    System.out.println("full name: " + resultUser.getString("full_name"));
                    System.out.println("profession: " + resultUser.getString("profession"));
                }

                preparedStatement.setLong(1, id);
                int resultSet = preparedStatement.executeUpdate();
                if (resultSet > 0) {
                    System.out.println("User with id " + id + " was deleted.");
                } else {
                    System.out.println("User with id " + id + " does not exist.");
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
