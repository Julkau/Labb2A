import CarLab.Car;
import CarLab.Saab95;
import CarLab.Workshop;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestWorkshop {

    @Test
    public void workshop_should_be_empty_when_first_created() {
        Workshop<Car> workshop = new Workshop<>(10);
        assertEquals(0, workshop.getCurrentCapacity());
    }

    @Test
    public void workshop_should_add_a_car() {
        Workshop<Car> workshop = new Workshop<>(10);
        Saab95 saab95 = new Saab95("GYU438");
        workshop.storeCar(saab95);
        assertEquals(1, workshop.getCurrentCapacity());
    }

    @Test
    public void workshop_should_remove_a_car() {
        Workshop<Car> workshop = new Workshop<>(10);
        Saab95 saab95 = new Saab95("GYU438");
        workshop.storeCar(saab95);
        workshop.getCar("GYU438");
        assertEquals(0, workshop.getCurrentCapacity());
    }

    @Test
    public void workshop_should_throw_exception_when_at_max_capacity_and_trying_to_add_a_car() {
        Workshop<Car> workshop = new Workshop<>(0);
        Saab95 saab95 = new Saab95("GYU438");
        assertThrows(ArrayStoreException.class, () -> workshop.storeCar(saab95));
    }

    @Test
    public void workshop_should_throw_exception_when_trying_to_get_a_car_that_does_not_exist() {
        Workshop<Car> workshop = new Workshop<>(10);
        assertThrows(NoSuchElementException.class, () -> workshop.getCar("NoCarLikeThisExist"));
    }
}
