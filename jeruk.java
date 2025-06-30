import greenfoot.*;

public class jeruk extends Actor {
    private double y;
    private final double speed = 1.7;

    public void addedToWorld(World world) {
        y = getY();
    }

    public void act() {
        y += speed;
        setLocation(getX(), (int) y);

        if (getY() >= getWorld().getHeight() - 10 && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
}
