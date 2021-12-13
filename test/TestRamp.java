import CarLab.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestRamp {

    @Test
    public void cars_stack_size_should_be_at_zero_when_first_created(){
        Ramp ramp = new Ramp(70,5);
        assertEquals(0, ramp.getNumberOfCars());
    }

    @Test
    public void ramp_should_be_raised_at_first() {
        Ramp ramp = new Ramp(4, 5);
        assertTrue(ramp.isRaised());
    }

    @Test
    public void ramp_should_lower() {
        Ramp ramp = new Ramp(4, 5);
        ramp.lower();
        ramp.raise();
        assertTrue(ramp.isRaised());
    }

    @Test
    public void ramp_should_raise() {
        Ramp ramp = new Ramp(4, 5);
        ramp.lower();
        assertFalse(ramp.isRaised());
    }

    @Test
    public void load_cars_to_ramp(){
        Car volvo240 = new Volvo240("GYU438");
        Ramp ramp = new Ramp(2, 5);
        ramp.lower();
        ramp.loadCar(volvo240);
        assertEquals(1, ramp.getNumberOfCars());
    }

    @Test
    public void cars_unloads_in_order(){
        Car volvo240 = new Volvo240("GYU438");
        Car saab95 = new Saab95("JZK991");
        Ramp ramp = new Ramp(4, 10);
        ramp.lower();
        ramp.loadCar(volvo240);
        ramp.loadCar(saab95);
        Car one = ramp.unLoadCar();
        Car two = ramp.unLoadCar();
        assertEquals(saab95, one);
        assertEquals(volvo240, two);
    }

    @Test
    public void unloadCars_should_raise_exception_if_unloading_cars_while_stack_is_empty(){
        Ramp ramp = new Ramp(4, 5);
        assertThrows(ArrayIndexOutOfBoundsException.class, ramp::unLoadCar);

    }
}
