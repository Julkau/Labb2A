package CarLab;

import java.awt.*;

/**
 * Class that represents Saab95; Extends Car; Has turbo functionality for boosting speed factor.
 * @see Car
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Constructor for Saab95; Inputs number of doors, engine power, length, color and the model name of the car.
     *
     * @param licensePlate is an id-name
     */
    public Saab95(String licensePlate) {
        super(2, 125, 2.5, Color.red, "CarLab.Saab95", licensePlate);
        turboOn = false;
    }

    /**
     * Setter for setting the attribute turboOn to true
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Setter for setting the attribute turboOn to false
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Getter for the attribute turboOn
     *
     * @return turboOn as boolean
     */
    public boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Method for getting Saab95's speed factor, used in Car class when gassing
     *
     * @return Saab95's speed factor
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
