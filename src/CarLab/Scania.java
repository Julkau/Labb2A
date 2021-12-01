package CarLab;

import java.awt.*;

/**
 * Class that represents Scania Trucks; Is a subclass of Car; Has a platform for loading, transporting and unloading cars.
 * @see Car
 * @see Platform
 */
public class Scania extends Car {
    private final Platform platform;

    /**
     * Constructor for Scania; Inputs number of doors, engine power, length, color and the model name of the car;
     * Creates Platform object and puts reference in platform
     *
     * @param licensePlate is an id-name
     */
    public Scania(String licensePlate) {
        super(2, 100, 5, Color.white, "CarLab.Scania", licensePlate);
        platform = new Platform(4);
    }

    /**
     * Method for getting scania's speed factor, used when gassing.
     *
     * @return Returns speedfactor for Scania class
     */
    @Override
    protected double speedFactor(){
        if (platform.getAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }

    /**
     * Method for raising the platform by a desired amount.
     *
     * @param amount amount The amount of degrees to raise the ramp  by
     * @throws IllegalStateException if car is moving.
     */
    public void raisePlatform(double amount) throws IllegalStateException{
        if (getCurrentSpeed() == 0) {
            platform.raise(amount);
        }
        else {
            throw new IllegalStateException("Can't raise platform when Scania is moving.");
        }
    }

    /**
     * Method for lowering the platform by a desired amount.
     *
     * @param amount The amount of degrees to lower the ramp  by
     * @throws IllegalStateException if car is moving.
     */
    public void lowerPlatform(double amount) throws IllegalStateException{
        if (getCurrentSpeed() == 0) {
            platform.lower(amount);
        }
        else {
            throw new IllegalStateException("Can't lower platform when Scania is moving.");
        }
    }

    /**
     * Getter for the attribute rampAngle in the ramp object.
     *
     * @return the angle of the ramp as double.
     */
    public double getRampAngle() {
        return platform.getAngle();
    }
}
