package CarLab;

/**
 * A platform that can be raised and lowered with an amount within 0 and a maxAngle.
 */
public class Platform {
    private final double maxRampAngle;
    private double platformAngle;

    /**
     * Creates a platform that has an angle.
     * @param maxRampAngle is the max angle the ramp can have.
     */
    public Platform(double maxRampAngle) {
        this.platformAngle = 0;
        this.maxRampAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle to a max angle of maxRampAngle.
     * @param amount The amount to increase rampAngle by.
     */
    public void raise(double amount) {
        platformAngle = Math.min(getAngle() + amount, maxRampAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle, to a min angle of 0.
     * @param amount The amount to reduce rampAngle by.
     */
    public void lower(double amount) {
        platformAngle = Math.max(getAngle() - amount, 0);
    }

     /**
     * Getter for the attribute rampAngle.
     * @return Returns double value from rampAngle.
     */
    public double getAngle() {
        return platformAngle;
    }
}
