import CarLab.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Small test class for CarLab.
 */
public class CarApp {
    /**
     * Start method that sets up the programs CMV parts. CarModel holds the connection to all model classes (car, etc.),
     * CarController controls the program and sets up the window and buttons, and CarView draws and updates the car-
     * pictures. Controller and View hold a reference to the Model. CarView is an observer to the Model as well to
     * receive the updates from Models timer.
     *
     * @param arg a string with possible arguments to the program.
     */
    public static void main(String[] arg) {
        Volvo240 volvo = new Volvo240("abc123");
        Saab95 saab = new Saab95("abc124");
        Scania scania = new Scania("abc125");

        saab.setCoordinate(0, 100);
        scania.setCoordinate(0, 200);

        ArrayList<Car> carsList = new ArrayList<>();

        carsList.add(volvo);
        carsList.add(saab);
        carsList.add(scania);

        CarModel carModel = new CarModel(carsList);
        CarView carView = new CarView(carModel, 800,400);
        CarController carController = new CarController("CarLab Cool Frame Name 2.0", carModel, carView);

        carModel.addCarObserver(carView);
    }
}
