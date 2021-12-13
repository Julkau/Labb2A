import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestScania {

    @Test
    public void scania_should_not_move_when_platform_is_raised() {
        Scania scania = new Scania("GYU438");
        scania.startEngine();
        scania.brake(1);
        scania.raisePlatform();
        scania.gas(1);
        assertEquals( 0 , scania.getCurrentSpeed());
    }

    @Test
    public void scania_should_not_move_platform_when_moving() {
        Scania scania = new Scania("GYU438");
        scania.startEngine();
        scania.gas(1);
        scania.raisePlatform();
        assertEquals( 0 , scania.getRampAngle());
    }

    @Test
    public void scania_should_move_when_platform_is_not_at_zero_degree() {
        Scania scania = new Scania("GYU438");
        scania.startEngine();
        scania.brake(1);
        scania.raisePlatform();
        scania.lowerPlatform();
        scania.gas(1);
        assertEquals( 1 , scania.getCurrentSpeed());
    }
}