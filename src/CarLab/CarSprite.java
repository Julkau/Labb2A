package CarLab;

import java.awt.image.BufferedImage;

public class CarSprite {
    private BufferedImage image;
    private int x;
    private int y;
    private String licencePlate;

    public CarSprite(BufferedImage image, int x, int y, String licencePlate) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.licencePlate = licencePlate;
    }

    public void moveSprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
}
