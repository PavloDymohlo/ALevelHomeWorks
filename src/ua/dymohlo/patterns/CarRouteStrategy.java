package ua.dymohlo.patterns;

public class CarRouteStrategy implements RouteStrategy, RouteWithoutTrafficStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "the car is going to " + destination;
    }

    @Override
    public String calculateRouteWithoutTraffic(String destination) {
        return "the car is going to " + destination + " without traffic";
    }
}
