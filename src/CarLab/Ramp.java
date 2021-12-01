package CarLab;

import java.util.Stack;

/**
 * A Car-type transporting class. Can be raised and lowered. Will only accept Cars that are up to maxLength in length.
 * Uses a stack for storing the Cars.
 */
public class Ramp {
    private final int capacity;
    private final Stack<Car> cars = new Stack<>();
    private final double maxLength;
    private boolean raised;

    /**
     * Creates a Ramp-instance and defines its capacity and sets is raised status to true.
     *
     * @param capacity   is the number of cars the ramp can hold.
     * @param rampLength is the length of the ramp.
     */
    public Ramp(int capacity, double rampLength) {
        this.capacity = capacity;
        this.raised = true;
        this.maxLength = rampLength / capacity;
    }

    /**
     * A getter for how many cars there are in the stack numberOfCars.
     *
     * @return Returns int value from numberOfCars.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Raises the ramp.
     */
    public void raise() {
        raised = true;
    }

    /**
     * Lowers the ramp.
     */
    public void lower() {
        raised = false;
    }

    /**
     * @return boolean if ramp is raised.
     */
    public boolean isRaised() {
        return raised;
    }

    /**
     * Loads (adds) a car object to the top of the cars stack. Does so if the ramp angle is close or equal to the max
     * ramp angle, the car is small enough and if the ramp has capacity.
     *
     * @param car The Car object to be added to the cars stack.
     */
    public void loadCar(Car car) throws UnsupportedOperationException {
        if (cars.size() < capacity && !raised && car.getLength() <= maxLength) {
            cars.add(car);
        } else {
            throw new UnsupportedOperationException("Problem when loading car to ramp!");
        }
    }

    /**
     * Unloads (and removes) the car on the top of the cars-stack. If the cars-stack is empty then an exception
     * thrown.
     *
     * @return Returns the car at the top of the cars stack if there is one.
     * @throws ArrayIndexOutOfBoundsException if there is no cars to unload.
     */
    public Car unLoadCar() throws ArrayIndexOutOfBoundsException {
        if (cars.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There is no cars on the ramp to unload.");
        }
        return cars.pop();
    }

    /**
     * Gets the stack of Cars.
     *
     * @return a stack of all current loaded cars.
     */
    public Stack<Car> getCars() {
        return cars;
    }

}
