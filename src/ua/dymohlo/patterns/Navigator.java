package ua.dymohlo.patterns;

public class Navigator {
    private RouteStrategy routeStrategy;
    private RouteWithoutTrafficStrategy routeWithoutTrafficStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public Navigator(RouteWithoutTrafficStrategy routeWithoutTrafficStrategy) {
        this.routeWithoutTrafficStrategy = routeWithoutTrafficStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteWithoutTrafficStrategy(RouteWithoutTrafficStrategy routeWithoutTrafficStrategy) {
        this.routeWithoutTrafficStrategy = routeWithoutTrafficStrategy;
    }

    public String calculateRoute(String destination) {
        return routeStrategy.calculateRoute(destination);
    }

    public String calculateRouteWithoutTraffic(String destination) {
        return routeWithoutTrafficStrategy.calculateRouteWithoutTraffic(destination);
    }
}
