import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Plant extends LivingThing {

    private final ImageIcon image = new ImageIcon("plant.gif");

    protected Point position;

    protected Pasture pasture;

    public void tick() {
        int randnum = (int) (Math.random()*15);
    if (randnum == 2){
    int newX = (int)getPosition().getX() +(int)(Math.random() * 3) -1;
    int newY = (int)getPosition().getY() +(int)(Math.random() * 3) -1;

    if (newX < 0 || newX >= pasture.getWidth())
        newX = (int)getPosition().getX();
    if (newY < 0 || newY >= pasture.getHeight())
        newY = (int)getPosition().getY();


    int checkX = (int)getPosition().getX();
    int checkY = (int)getPosition().getY();
    if (newX == checkX && newY == checkY){
        newX = (int)getPosition().getX();
        newY = (int)getPosition().getY();
    }
    Point newPos = new Point(newX, newY);
    Plant newPlant = new Plant(pasture, newPos);
    pasture.addEntity(newPlant);
        }

    }




    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String type() {
        return "Plant";
    }
    public Plant(Pasture pasture) {
        this.pasture = pasture;
    }

    public Point getPosition() { return position; }

    public void setPosition(Point newPosition) { position = newPosition; }


    public Plant(Pasture pasture, Point position) {
        this.pasture   = pasture;
        this.position  = position;
    }

}
