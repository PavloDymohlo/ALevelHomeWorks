package ua.dymohlo.hibernetpractic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



public class Main {
    public static void main(String[] args) {
        newGraduate();
        buyersAndOrders();
        findingCharactersAndCalcOrders();
    }

    private static void newGraduate() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //creat new graduate:
            Graduate parker = new Graduate();
            parker.setFirstName("Peter");
            parker.setLastName("Parker");
            session.persist(parker);

            //read the information about the graduate
            Graduate graduate = session.find(Graduate.class, 20L);
            System.out.println(graduate);

            //update the information about the graduate
            graduate.setFirstName("Pit");
            session.update(graduate);
            System.out.println(graduate);

            //delete the graduates from base
            session.remove(graduate);

            transaction.commit();
        }
        sessionFactory.close();
    }

    private static void buyersAndOrders() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            // create a new character and his three orders;
            Graduate graduate = Graduate.builder()
                    .firstName("Tony")
                    .lastName("Stark")
                    .build();
            session.persist(graduate);

            Order lapTop = Order.builder()
                    .nameOrder("lapTop")
                    .serialNumber(Math.abs(ThreadLocalRandom.current().nextInt()))
                    .graduate(graduate)
                    .build();
            session.persist(lapTop);

            Order phone = Order.builder()
                    .nameOrder("phone")
                    .serialNumber(Math.abs(ThreadLocalRandom.current().nextInt()))
                    .graduate(graduate)
                    .build();
            session.persist(phone);

            Order powerBank = Order.builder()
                    .nameOrder("powerBank")
                    .serialNumber(Math.abs(ThreadLocalRandom.current().nextInt()))
                    .graduate(graduate)
                    .build();
            session.persist(powerBank);

            // get a new character and his three orders;
            Graduate findGraduate = session.find(Graduate.class, 41L);
            System.out.println(findGraduate);

            //create a new order and add it to another character
            Graduate secondGraduate = session.find(Graduate.class, 2L);
            Order headPhone = Order.builder()
                    .nameOrder("headPhone")
                    .serialNumber(Math.abs(ThreadLocalRandom.current().nextInt()))
                    .build();
            headPhone.setGraduate(secondGraduate);
            session.persist(headPhone);
            System.out.println(secondGraduate);


            transaction.commit();
        }
        sessionFactory.close();
    }

    private static void findingCharactersAndCalcOrders() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            //search for users who have only one order
            Query<Order> selectEFromOrderE = session.createQuery("select g from Graduate g WHERE size(g.orders) = 1", Order.class);
            List<Order> list = selectEFromOrderE.list();
            System.out.println(list);

            // finding the orders within a period of time
            //create shopping time
            List<Graduate> selectGFromGraduatesG = session.createQuery("select g from Graduate g", Graduate.class).list();
            for (Graduate graduate : selectGFromGraduatesG) {
                graduate.setPurchasesDate(LocalDateTime.now());
            }

            //finding the orders within a period of time
            List<Graduate> findingOrdersWithinTime =
                    session.createQuery("select g from Graduate g where g.purchasesDate between:startDate and :endDate",
                                    Graduate.class)
                            .setParameter("startDate", LocalDateTime.now().minus(1, ChronoUnit.DAYS))
                            .setParameter("endDate", LocalDateTime.now())
                            .list();

            System.out.println(findingOrdersWithinTime);

            //count the total number of orders for each user
            List<Object[]> results = session.createQuery(
                            "select  g, count(p) " +
                            "from Graduate g " +
                            "left join g.orders p " +
                            "group by g", Object[].class)
                    .list();

            for (Object[] result : results) {
                Graduate graduate = (Graduate) result[0];
                Long numberOfPurchases = (Long) result[1];
                System.out.println(graduate + ", Number of Purchases: " + numberOfPurchases);
            }

            transaction.commit();
        }
        sessionFactory.close();
    }


}
