import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Shark implements Entity {

    private final ImageIcon image = new ImageIcon("wolf.gif");

    protected Point position;

    protected Pasture pasture;

    public Shark(Pasture pasture) {
        this.pasture = pasture;
    }

    public Shark(Pasture pasture, Point position) {
        this.pasture   = pasture;
        this.position  = position;
    }

    public Point getPosition() { return position; }


    public void setPosition(Point newPosition) { position = newPosition; }


    public void tick() {
        int newX = (int)getPosition().getX() +(int)(Math.random() * 3) -1;
        int newY = (int)getPosition().getY() +(int)(Math.random() * 3) -1;

        if (newX < 0 || newX >= pasture.getWidth())
            newX = (int)getPosition().getX();
        if (newY < 0 || newY >= pasture.getHeight())
            newY = (int)getPosition().getY();

        setPosition(new Point(newX,newY));
    }

    public String type() {
        return "wolf";
    }

    public ImageIcon getImage() { return image; }


}
