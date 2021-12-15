package CarLab;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class CarView extends JPanel implements CarObserver {

    private Map<String, BufferedImage> carSprites = new HashMap<>();
    private BufferedImage volvo;
    private BufferedImage saab;
    private BufferedImage scania;
    private final CarModel carModel;

    // Initializes the panel and reads the images
    public CarView(CarModel carModel, int x, int y) {
        this.carModel = carModel;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.gray);

        try {
            volvo = ImageIO.read(CarView.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab = ImageIO.read(CarView.class.getResourceAsStream("pics/Saab95.jpg"));
            scania = ImageIO.read(CarView.class.getResourceAsStream("pics/scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        carSprites.put("CarLab.Volvo240", volvo);
        carSprites.put("CarLab.Saab95", saab);
        carSprites.put("CarLab.Scania", scania);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carModel.getCars()) {
            g.drawImage(carSprites.get(car.getModelName()), (int)(car.getCoordinate()[0] - 20), (int) (car.getCoordinate()[1] - 30), null);
        }
    }

    @Override
    public void onNotification() {
        repaint();
    }
}
