package ua.dymohlo.patterns;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Computer {
    private String processorName;
    private double displaySize;
    private String videoCardType;
    private int videoCardSize;
    private int RAMSize;
    private String driveType;
    private int driveSize;

    private static Computer INSTANCE;

    public static Computer createComputer(String processorName, double displaySize, String videoCardType,
                                          int videoCardSize, int RAMSize, String driveType, int driveSize) {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        return new Computer(processorName, displaySize, videoCardType, videoCardSize, RAMSize, driveType, driveSize);
    }
}
