package CarLab;

/**
 * A platform that can be raised and lowered with an amount within 0 and a maxAngle.
 */
public class Platform {
    private final double maxPlatformAngle;
    private double platformAngle;

    /**
     * Creates a platform that has an angle.
     * @param maxRampAngle is the max angle the ramp can have.
     */
    public Platform(double maxRampAngle) {
        this.platformAngle = 0;
        this.maxPlatformAngle = maxRampAngle;
    }

    /**
     * Raise ramp increases the angle of the ramp, represented by increasing rampAngle to a max angle of maxRampAngle.
     */
    public void raise() {
        platformAngle = Math.min(getAngle() + 1, maxPlatformAngle);
    }

    /**
     * Lower ramp reduces the angle of the ramp, represented by reducing rampAngle, to a min angle of 0.
     */
    public void lower() {
        platformAngle = Math.max(getAngle() - 1, 0);
    }

     /**
     * Getter for the attribute rampAngle.
     * @return Returns double value from rampAngle.
     */
    public double getAngle() {
        return platformAngle;
    }
}
