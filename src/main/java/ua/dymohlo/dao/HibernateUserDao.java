package ua.dymohlo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class HibernateUserDao implements Dao {
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
    public Object create(Object entity) {
        User user = (User) entity;
        try (Session session = ConnectorManager.sessionFactory().openSession()) {
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
    public User findById(Long id) {
        try (Session session = ConnectorManager.sessionFactory().openSession()) {
            User user = session.find(User.class, id);
            return user;
        }
    }

    @Override
    public User update(Long id) {
        try (Session session = ConnectorManager.sessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User user = session.get(User.class, id);
            if (user != null) {
                String newFullName = input("Enter new user's full name: ");
                String newProfession = input("Enter new user's profession:");
                user.setFullName(newFullName);
                user.setProfession(newProfession);
                session.merge(user);
                transaction.commit();
                return user;
            }
            System.out.println("User with id " + id + " does not exist.");
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = ConnectorManager.sessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User user = session.find(User.class, id);
            if (user != null) {
                System.out.println("User's details before deletion: ");
                System.out.println("users id: " + user.getUsersId());
                System.out.println("full name: " + user.getFullName());
                System.out.println("profession: " + user.getProfession());
                session.remove(user);
                System.out.println("User with id " + id + " was deleted.");
            } else {
                System.out.println("User with id " + id + " does not exist.");
            }
            transaction.commit();
        }
    }
}
