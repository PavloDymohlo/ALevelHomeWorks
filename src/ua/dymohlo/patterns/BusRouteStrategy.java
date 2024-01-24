package ua.dymohlo.patterns;

public class BusRouteStrategy implements RouteStrategy, RouteWithoutTrafficStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "the bus is going to " + destination;
    }

    @Override
    public String calculateRouteWithoutTraffic(String destination) {
        return "the bus is going to " + destination + " without traffic";
    }
}
