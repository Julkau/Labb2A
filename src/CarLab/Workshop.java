package CarLab;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A workshop for cars to be stored in. The cars can also be collected again.
 *
 * @param <T> extends the Car-type and turns the workshop to a specific car-typ workshop.
 * @see Car
 */
public class Workshop<T extends Car> {
    private final int maxCapacity;
    private int currentCapacity;
    private List<T> cars = new ArrayList<>();

    /**
     * Creates a car specific workshop with a max capacity.
     *
     * @param maxCapacity is the max integer amount of cars to be stored in the workshop.
     */
    public Workshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    /**
     * Gets the current capacaty of cars in the workshop.
     *
     * @return an int of the number of cars.
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Stores a Car in the workshop. If max capacity is reached the car will not be
     * stored and an exception will be thrown.
     *
     * @param car is the car to be stored.
     * @throws ArrayStoreException when there is no capacity to store a car.
     */
    public void storeCar(T car) throws ArrayStoreException {
        if (currentCapacity < maxCapacity) {
            cars.add(car);
            currentCapacity++;
        } else {
            throw new ArrayStoreException("Can't store car in Workshop, it is full!");
        }
    }

    /**
     * Gets the matching car. Looks for the same licensePlate.
     *
     * @param licensePlate is the matching license plate to search for.
     * @throws NoSuchElementException when no car matching parameter licensePlate is found.
     */
    public void getCar(String licensePlate) throws NoSuchElementException {
        for (int i = 0; i < currentCapacity; i++) {
            if (licensePlate.equals(cars.get(i).getLicensePlate())) {
                cars.remove(i);
                currentCapacity--;
                return;
            }
        }
        throw new NoSuchElementException("No car with matching licence plate could be found.");
    }
}
