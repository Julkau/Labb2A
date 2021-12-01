import CarLab.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVolvo240 {

    @Test
    public void trim_factor_get_should_return_trim_factor() {
        assertEquals(1.25, Volvo240.getTrimFactor());
    }

}
