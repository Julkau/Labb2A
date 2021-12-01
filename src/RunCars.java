import CarLab.Saab95;
import CarLab.Volvo240;
import CarLab.Workshop;

import java.awt.*;

/**
 * Small test class for CarLab.
 */
public class RunCars {
    /**
     * Start method.
     *
     * @param arg a string with possible arguments to the program.
     */
    public static void main(String[] arg) {
        Volvo240 volvo = new Volvo240("abc123");
        Saab95 saab = new Saab95("abc123");
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);

        System.out.println("Cars: " + volvo + " " + saab);
    }
}
