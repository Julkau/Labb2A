package CarLab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents (one of) the Model part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    private final ArrayList<Car> cars;

    //Observers (Wishful programming)
    private ArrayList<CarObserver> carObservers = new ArrayList<>();

    public CarModel(ArrayList<Car> cars){
        this.cars = cars;
        this.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getCoordinate()[0]);
                int y = (int) Math.round(car.getCoordinate()[1]);
                notifyCarObservers();
            }
        }
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        System.out.println("gas");
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        System.out.println("brake");
        double brake = ((double) amount / 100);
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void startEngine() {
        System.out.println("start engine");
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopEngine() {
        System.out.println("stop engine");
        for (Car car: cars) {
            car.stopEngine();
        }
    }
    void turnLeft() {
        System.out.println("turn left");
        for (Car car: cars) {
            car.turnLeft();
        }
    }
    void turnRight() {
        System.out.println("turn right");
        for (Car car: cars) {
            car.turnRight();
        }
    }
    void turnTurboOn() {
        System.out.println("turbo on");
        for( Car car : cars){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turnTurboOff() {
        System.out.println("turbo off");
        for( Car car : cars){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void lowerPlatform() {
        System.out.println("lower platform");
        for(Car car : cars){
            if (car instanceof PlatformCar){
                ((PlatformCar) car).lowerPlatform();
            }
        }
    }
    void raisePlatform(){
        System.out.println("raise platform");
        for(Car car : cars){
            if (car instanceof PlatformCar){
                ((PlatformCar) car).raisePlatform();
            }
        }
    }
    void turboOn() {
        System.out.println("turbo on");
        for (Car car: cars) {
            if (car.getClass().getName().equals("CarLab.Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff() {
        System.out.println("turbo off");
        for (Car car: cars) {
            if (car.getClass().getName().equals("CarLab.Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void addCarObserver(CarObserver carObserver) {
        carObservers.add(carObserver);
    }

    public void removeCarObserver(int index) {
        carObservers.remove(index);
    }

    public void notifyCarObservers() {
        for(CarObserver cO : carObservers) {
            cO.onNotification();
        }
    }

}
