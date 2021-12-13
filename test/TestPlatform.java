import CarLab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlatform {

    @Test
    public void platform_should_start_with_0_degrees_angle() {
        Platform platform = new Platform(70);
        assertEquals(0, platform.getAngle());
    }

    @Test
    public void raising_platform_angle_above_max_capacity_should_stop_at_max_capacity(){
        Platform platform = new Platform(70);
        for(int i = 0; i <= 50; i++) {
            platform.raise();
        }
        assertEquals(50, platform.getAngle());
        for(int i = 0; i <= 100; i++) {
            platform.raise();
        }
        assertEquals(70, platform.getAngle());
    }

    @Test
    public void cannot_lower_platform_below_0_degrees(){
        Platform platform = new Platform(70);
        platform.raise();
        platform.lower();
        assertEquals(0, platform.getAngle());

    }
}
