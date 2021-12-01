import CarLab.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarTransport {

    @Test
    public void carTransport_load_and_unload_cars() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 2);
        Saab95 saab95 = new Saab95("GYU438");
        Volvo240 volvo240 = new Volvo240("JZK991");
        carTran.lowerRamp();
        carTran.loadCar(saab95);
        carTran.loadCar(volvo240);
        assertEquals(volvo240, carTran.unLoadCar());
        assertEquals(saab95, carTran.unLoadCar());
    }

    @Test
    public void carTransport_should_throw_exception_when_loading_car_if_ramp_is_raised() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 4);
        Saab95 saab95 = new Saab95("GYU438");
        carTran.raiseRamp();
        assertThrows(UnsupportedOperationException.class, () -> carTran.loadCar(saab95));
    }

    @Test
    public void car_should_move_with_the_carTransport() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 2);
        Saab95 saab95 = new Saab95("GYU438");
        carTran.lowerRamp();
        carTran.loadCar(saab95);
        carTran.raiseRamp();
        carTran.startEngine();
        carTran.move();
        assertEquals(Arrays.toString(saab95.getCoordinate()), Arrays.toString(carTran.getCoordinate()));
    }

    @Test
    public void car_should_end_up_near_to_the_carTransport_when_unloaded() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 2);
        Saab95 saab95 = new Saab95("GYU438");
        carTran.lowerRamp();
        carTran.loadCar(saab95);
        carTran.unLoadCar();
        assertTrue(saab95.getCoordinate().length < 20);
    }

    @Test
    public void carTransport_should_not_gas_when_ramp_is_lowered() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 4);
        carTran.lowerRamp();
        carTran.startEngine();
        carTran.gas(1);
        assertEquals(0, carTran.getCurrentSpeed());
    }

    @Test
    public void carTransport_ramp_should_not_lower_when_at_a_speed() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 4);
        carTran.startEngine();
        carTran.gas(1);
        assertThrows(IllegalStateException.class, () -> carTran.lowerRamp());
    }

    @Test
    public void carTransport_should_only_load_cars_that_are_relatively_close(){
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 4);
        Saab95 saab952 = new Saab95("GYI438");
        saab952.setCoordinate(100,100);
        assertThrows(UnsupportedOperationException.class, () -> carTran.loadCar(saab952));
    }

    @Test
    public void carTransport_should_throw_exception_when_trying_to_load_itself() {
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 4);
        carTran.lowerRamp();
        assertThrows(UnsupportedOperationException.class, () -> carTran.loadCar(carTran));
    }

    @Test
    public void carTransport_cant_load_itself(){
        CarTransport carTran = new CarTransport(2,100, Color.white,"Test.CarTransport", "123abc", 1);
        assertThrows(UnsupportedOperationException.class, () -> carTran.loadCar(carTran));
    }
}
