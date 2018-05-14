import java.awt.*;

public abstract class LivingThing implements Entity{

    protected Point position;

    public Point getPosition() {return position;}

    public void setPosition(Point pos) {
        position = pos;
    }

}