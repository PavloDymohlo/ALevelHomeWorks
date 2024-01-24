package ua.dymohlo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;
import java.util.Scanner;

public class HibernateUserDao implements Dao<User> {
    private final static HibernateUserDao INSTANCE = new HibernateUserDao();

    private HibernateUserDao() {
    }

    public static HibernateUserDao getINSTANCE() {
        return INSTANCE;
    }

    private static String input(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }

    @Override
    public User create(User user) {
       try(Session session = ConnectorManager.openSession()){
           Transaction transaction = session.getTransaction();
            transaction.begin();
            user.getFullName();
            user.getProfession();
            session.persist(user);
            transaction.commit();
       }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = ConnectorManager.openSession()) {
            User user = session.find(User.class, id);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public Optional<User> update(User user) {
        try (Session session = ConnectorManager.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User updateUser = session.get(User.class, user.getUsersId());
            if (updateUser != null) {
                String newFullName = input("Enter new user's full name: ");
                String newProfession = input("Enter new user's profession:");
                updateUser.setFullName(newFullName);
                updateUser.setProfession(newProfession);
                session.merge(updateUser);
                transaction.commit();
                return Optional.of(updateUser);
            }
            System.out.println("User with id " + user.getUsersId() + " does not exist.");
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = ConnectorManager.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User user = session.find(User.class, id);
            if (user != null) {
                System.out.println("User's details before deletion: ");
                System.out.println(user);
                session.remove(user);
                System.out.println("User with id " + id + " was deleted.");
            } else {
                System.out.println("User with id " + id + " does not exist.");
            }
            transaction.commit();
        }
    }
}
