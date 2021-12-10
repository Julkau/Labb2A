package CarLab;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class CarView extends JPanel implements CarObserver{

    private ArrayList<CarSprite> carSprites = new ArrayList<>();

    public void createCarSprite(String image, int x, int y, String licencePlate) {
        try {
            carSprites.add(new CarSprite(ImageIO.read(CarView.class.getResourceAsStream(image)), x, y, licencePlate));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, String licencePlate){
        for (CarSprite carSprite: carSprites) {
            if (carSprite.getLicencePlate().equals(licencePlate)) {
                carSprite.moveSprite(x, y);
            }
        }
    }

    // Initializes the panel and reads the images
    public CarView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.gray);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CarSprite carSprite: carSprites){
            g.drawImage(carSprite.getImage(), carSprite.getX()-30, carSprite.getY()-50, null);
        }
    }

    //public void notify() {

    //}
}
