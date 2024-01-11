package ua.dymohlo.patterns;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carrier {
    private double kilometerPrice;
    private double distance;

    private static Carrier INSTANCE;

    public static Carrier createCarrier(double kilometerPrice, double distance) {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        return INSTANCE = new Carrier(kilometerPrice, distance);
    }

    public static double getKilometerPrice() {
        return INSTANCE != null ? INSTANCE.kilometerPrice : 0;
    }

    public static double setKilometerPrice(double kilometerPrice) {
        if (INSTANCE != null) {
            INSTANCE.kilometerPrice = kilometerPrice;
        }
        return kilometerPrice;
    }

    public static double getDistance() {
        return INSTANCE != null ? INSTANCE.distance : 0;
    }

    public static double setDistance(double distance) {
        if (INSTANCE != null) {
            INSTANCE.distance = distance;
        }
        return distance;
    }
}
