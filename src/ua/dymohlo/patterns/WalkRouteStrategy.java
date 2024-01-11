package ua.dymohlo.patterns;

public class WalkRouteStrategy implements RouteStrategy, RouteWithoutTrafficStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "the man is going to " + destination;
    }

    @Override
    public String calculateRouteWithoutTraffic(String destination) {
        return "the man is going to " + destination + " by a different route";
    }
}
