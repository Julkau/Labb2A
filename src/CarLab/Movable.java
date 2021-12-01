package CarLab;

/**
 * Interface for used for moving; Can be used for turning right, left and moving forward
 */
public interface Movable {

    /**
     * Should move the object one "step".
     */
    void move();

    /**
     * Should turn the object to the right (clockwise).
     */
    void turnRight();

    /**
     * Should turn the object to the left (anti-clockwise).
     */
    void turnLeft();
}
