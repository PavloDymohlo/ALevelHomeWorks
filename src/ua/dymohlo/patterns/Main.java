package ua.dymohlo.patterns;

public class Main {
    public static void main(String[] args) {
        staticFactoryMethod();
        shallowdeepcopy();
        factoryMethod();
        builder();
        strategy();
    }

    private static void staticFactoryMethod() {

        Carrier carrier = Carrier.createCarrier(25, 3);

        System.out.println(carrier);
        double newKilometerPrice = Carrier.setKilometerPrice(30);
        double newDistance = Carrier.setDistance(5);
        System.out.println(newKilometerPrice + "and " + newDistance);
        System.out.println(carrier);
    }

    private static void shallowdeepcopy() {
        Address address = new Address("Central City", " Central Street", "25-B");
        Person firstPerson = new Person("No", "Name", address);

        Person copyPerson = new Person(firstPerson.getFirstName(), firstPerson.getLastName(), firstPerson.getAddress());

        Person deepCopyPerson = (Person) firstPerson.clone();

        firstPerson.setFirstName("Billy");
        firstPerson.getAddress().setCity("Raccoon City");
        firstPerson.getAddress().setStreet("Umbrella Street");
        firstPerson.getAddress().setHouse("512/3");

        System.out.println("firstPerson info: " + firstPerson);
        System.out.println("copyPerson info: " + copyPerson);
        System.out.println("deepCopyPerson info: " + deepCopyPerson);
    }

    private static void factoryMethod() {
        Logger logger = new LoggerFactory().createLogger(LogType.DATABASELOGGER);

        logger.log("");
    }

    private static void builder() {
        Computer computer = Computer.builder()
                .processorName("intel core i5")
                .displaySize(15.2)
                .videoCardType("dedicated")
                .videoCardSize(4)
                .RAMSize(16)
                .driveType("SSD")
                .driveSize(512).build();

        System.out.println(computer);
    }

    private static void strategy() {

        RouteStrategy busRouteStrategy = new BusRouteStrategy();
        RouteStrategy walkRouteStrategy = new WalkRouteStrategy();
        RouteStrategy carRouteStrategy = new CarRouteStrategy();

        Navigator navigator = new Navigator(busRouteStrategy);
        String bus = navigator.calculateRoute("school");
        System.out.println(bus);

        navigator.setRouteStrategy(walkRouteStrategy);
        String man = navigator.calculateRoute("university");
        System.out.println(man);

        navigator.setRouteStrategy(carRouteStrategy);
        String car = navigator.calculateRoute("market");
        System.out.println(car);


        RouteWithoutTrafficStrategy newBusRouteStrategy = new BusRouteStrategy();
        RouteWithoutTrafficStrategy newWalkRouteStrategy = new WalkRouteStrategy();
        RouteWithoutTrafficStrategy newCarRouteStrategy = new CarRouteStrategy();

        Navigator newNavigator = new Navigator(newBusRouteStrategy);
        bus = newNavigator.calculateRouteWithoutTraffic("village");
        System.out.println(bus);

        newNavigator.setRouteWithoutTrafficStrategy(newWalkRouteStrategy);
        man = newNavigator.calculateRouteWithoutTraffic("park");
        System.out.println(man);

        newNavigator.setRouteWithoutTrafficStrategy(newCarRouteStrategy);
        car = newNavigator.calculateRouteWithoutTraffic("academy");
        System.out.println(car);
    }

}
