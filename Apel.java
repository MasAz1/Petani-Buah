import greenfoot.*;

public class Apel extends Actor {
    private double y;
    private final double speed = 0.8;

    public void addedToWorld(World world) {
        y = getY();
    }

    public void act() {
        World w = getWorld();
        if ((w instanceof back && ((back) w).isGameOver()) ||
            (w instanceof Level2 && ((Level2) w).isGameOver())) return;

        y += speed;
        setLocation(getX(), (int) y);

        if (isTouching(Petani.class)) {
            if (w instanceof back) {
                ((back) w).addScore(1);
            } else if (w instanceof Level2) {
                ((Level2) w).addScore(1);
            }
            Greenfoot.playSound("pop.wav");
            w.removeObject(this);
            return;
        }

        if (getY() >= getWorld().getHeight() - 10) {
            getWorld().removeObject(this);
        }
    }
}
