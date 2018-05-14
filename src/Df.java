import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Df implements Entity {

    private final ImageIcon image = new ImageIcon("fence.gif");

    protected Point position;

    protected Pasture pasture;

    public Df(Pasture pasture) {
        this.pasture = pasture;
    }

    public Df(Pasture pasture, Point position) {
        this.pasture   = pasture;
        this.position  = position;
    }

    public Point getPosition() { return position; }


    public void setPosition(Point newPosition) { position = newPosition; }


    public void tick() {
        int newX = (int)(Math.random() * 30);
        int newY = (int)(Math.random() * 30);

        if (newX < 0 || newX >= pasture.getWidth())
            newX = (int)getPosition().getX();
        if (newY < 0 || newY >= pasture.getHeight())
            newY = (int)getPosition().getY();
int fun;
        setPosition(new Point(newX,newY));
    }

    public String type() {
        return "fence";
    }

    public ImageIcon getImage() { return image; }


}
