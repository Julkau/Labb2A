package CarLab;

import java.awt.*;

/**
 * Class that represents Volvo240; Extends Car; Has turbo functionality for boosting speed factor. Has a trim factor.
 * @see Car
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Constructor of Volvo240, sets the amount of doors, the engine power, the colour and the model name.
     *
     * @param licensePlate is an id-name
     */

    public Volvo240(String licensePlate) {
        super(4, 100, 2.5, Color.black, "CarLab.Volvo240", licensePlate);
    }

    /**
     * Gets the car's trim factor.
     *
     * @return a double.
     */
    public static double getTrimFactor() {
        return trimFactor;
    }

    /**
     * Getss the car's speed factor based on the engine power and trim factor, used when gassing.
     *
     * @return Volvo240's speed factor as a double.
     */

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
