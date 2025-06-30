import greenfoot.*;

public class bomb extends Actor {
    private double y = 0;
    private final double speed = 1;

    public void addedToWorld(World world) {
        y = getY();
    }

    public void act() {
        World w = getWorld();
        if ((w instanceof back && ((back) w).isGameOver()) ||
            (w instanceof Level2 && ((Level2) w).isGameOver())) {
            return;
        }

        y += speed;
        setLocation(getX(), (int) y);

        if (getY() >= getWorld().getHeight() - 10 && getWorld() != null) {
            getWorld().removeObject(this);
            return;
        }

        Actor petani = getOneIntersectingObject(Petani.class);
        if (petani != null) {
            if (w instanceof back) {
                ((back) w).forceGameOver();
            } else if (w instanceof Level2) {
                ((Level2) w).forceGameOver();
            }

            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
