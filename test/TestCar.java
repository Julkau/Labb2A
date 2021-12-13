import CarLab.Car;
import CarLab.Saab95;
import CarLab.Scania;
import CarLab.Volvo240;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void test_turn_left() {
        Car saab95 = new Saab95("GYU438");
        saab95.turnLeft();
        saab95.turnLeft();
        assertEquals(Car.DIRECTION.SOUTH, saab95.getDirection());
    }

    @Test
    public void test_turn_right() {
        Car saab95 = new Saab95("GYU438");
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(Car.DIRECTION.NORTH, saab95.getDirection());
    }

    @Test
    public void test_all_directions() {
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        saab95.move();
        assertEquals(Car.DIRECTION.NORTH, saab95.getDirection());
        saab95.turnRight();
        saab95.move();
        assertEquals(Car.DIRECTION.EAST, saab95.getDirection());
        saab95.turnRight();
        saab95.move();
        assertEquals(Car.DIRECTION.SOUTH, saab95.getDirection());
        saab95.turnRight();
        saab95.move();
        assertEquals(Car.DIRECTION.WEST, saab95.getDirection());
    }


    @Test
    public void should_move_on_y_axis_only_from_zero() {
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        saab95.move();
        assertNotEquals(0, saab95.getCoordinate()[1]);
        assertEquals(0, saab95.getCoordinate()[0]);
    }

    @Test
    public void should_move_on_x_axis_only_from_zero() {
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        saab95.turnRight();
        saab95.move();
        assertNotEquals(0, saab95.getCoordinate()[0]);
        assertEquals(0, saab95.getCoordinate()[1]);
    }

    @Test
    public void engine_power_should_not_be_zero_nor_negative(){
        Car saab95 = new Saab95("GYU438");
        double testingFactor = Math.abs(saab95.getEnginePower());
        assertNotEquals(0, saab95.getEnginePower());
        assertEquals(0, saab95.getEnginePower() - testingFactor);
    }

    @Test
    public void number_of_doors_should_not_be_zero_nor_negative(){
        Car saab95 = new Saab95("GYU438");
        double testingFactor = Math.abs(saab95.getNrDoors());
        assertNotEquals(0, saab95.getNrDoors());
        assertEquals(0, saab95.getNrDoors() - testingFactor);
    }

    @Test
    public void current_speed_should_not_be_zero_nor_negative_while_moving(){
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        saab95.gas(1);
        saab95.move();
        double testingFactor = Math.abs(saab95.getCurrentSpeed());
        assertNotEquals(0, saab95.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed() - testingFactor);
    }

    @Test
    public void current_speed_should_be_01_when_engine_is_started(){
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    public void car_should_have_a_colour(){
        Car saab95 = new Saab95("GYU438");
        saab95.setColor(Color.BLACK);
        assertEquals(saab95.getColor().toString(), Color.BLACK.toString());
    }

    @Test
    public void gas_should_only_increment_speed_when_engine_on() {
        Car saab95 = new Saab95("GYU438");
        Car volvo = new Volvo240("JZK991");
        saab95.gas(1);
        volvo.gas(1);
        assertEquals(0, saab95.getCurrentSpeed());
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    public void gas_should_raise_exception_if_argument_not_within_0_to_1() {
        Car saab95 = new Saab95("GYU438");
        Car volvo = new Volvo240("JZK991");
        assertThrows(IllegalArgumentException.class, () -> saab95.gas(2));
        assertThrows(IllegalArgumentException.class, () -> volvo.gas(2));
    }

    @Test
    public void brake_should_raise_exception_if_argument_not_within_0_to_1() {
        Car saab95 = new Saab95("GYU438");
        Car volvo = new Volvo240("JZK991");
        assertThrows(IllegalArgumentException.class, () -> saab95.brake(2));
        assertThrows(IllegalArgumentException.class, () -> volvo.brake(2));
    }

    @Test
    public void brake_should_not_brake_to_negative_speed() {
        Car saab95 = new Saab95("GYU438");
        Car volvo = new Volvo240("JZK991");
        saab95.startEngine();
        volvo.startEngine();
        saab95.gas(0.2);
        volvo.gas(0.2);
        saab95.brake(1);
        volvo.brake(1);
        assertEquals(0, saab95.getCurrentSpeed() + volvo.getCurrentSpeed());
    }

    @Test
    public void engineOn_should_change_when_engine_is_switched_off() {
        Car saab95 = new Saab95("GYU438");
        saab95.startEngine();
        assertTrue(saab95.getEngineOn());
        saab95.stopEngine();
        assertFalse(saab95.getEngineOn());
    }

    @Test
    public void car_should_always_start_on_coordinate_zero(){
        Car saab95 = new Saab95("GYU438");
        assertEquals( 0 , saab95.getCoordinate()[0]);
        assertEquals(0, saab95.getCoordinate()[1]);
    }
}
