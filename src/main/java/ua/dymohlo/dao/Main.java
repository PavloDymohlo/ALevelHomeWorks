package ua.dymohlo.dao;


import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JDBCUserDao jdbcUserDao = JDBCUserDao.getINSTANCE();
        User JDBCUser = new User();
        HibernateUserDao hibernateUserDao = HibernateUserDao.getINSTANCE();
        User user = new User();

        // create jdbcUserDao
        JDBCUser.setFullName(input("Enter user's full name: "));
        JDBCUser.setProfession(input("Enter user's profession: "));
        jdbcUserDao.create(JDBCUser);
        System.out.println(JDBCUser);

        //create HibernateUserDao
        user.setFullName(input("Enter user's full name: "));
        user.setProfession(input("Enter user's profession: "));
        hibernateUserDao.create(user);
        System.out.println(user);

        //read jdbcUserDao
        Optional<User> readUser = jdbcUserDao.findById(Long.valueOf(input("enter the id of the user whose data you want to see: ")));
        System.out.println(readUser);

        //read HibernateUserDao
        Optional<User> readHibernateUser = hibernateUserDao.findById(Long.valueOf(input("enter the id of the user whose data you want to see: ")));
        System.out.println(readHibernateUser);

        //update jdbcUserDao
        Optional<User> update = jdbcUserDao.update(JDBCUser);
        System.out.println(update);

        //update HibernateUserDao
        Optional<User> updateUser = hibernateUserDao.update(user);
        System.out.println(updateUser);

        //delete jdbcUserDao
        jdbcUserDao.deleteById(Long.valueOf(input("enter the id of the user whose data you want to delete: ")));

        //delete HibernateUserDao
        hibernateUserDao.deleteById(Long.valueOf(input("enter the id of the user whose data you want to delete: ")));
    }

    public static String input(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }
}
