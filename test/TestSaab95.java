import CarLab.Saab95;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaab95 {

    @Test
    public void turbo_should_start_off() {
        Saab95 saab95 = new Saab95("GYU438");
        assertFalse(saab95.getTurboOn());
    }

    @Test
    public void turbo_should_turn_on() {
        Saab95 saab95 = new Saab95("GYU438");
        saab95.setTurboOn();
        assertTrue(saab95.getTurboOn());
    }

    @Test
    public void turbo_should_turn_off() {
        Saab95 saab95 = new Saab95("GYU438");
        saab95.setTurboOn();
        saab95.setTurboOff();
        assertFalse(saab95.getTurboOn());
    }
}
