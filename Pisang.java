import greenfoot.*;

public class Pisang extends Actor {
    private double y;
    private final double speed = 1.2;

    public void addedToWorld(World world) {
        y = getY();
    }

    public void act() {
        y += speed;
        setLocation(getX(), (int) y);

        // Hapus jika menyentuh tanah
        if (getY() >= getWorld().getHeight() - 10 && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
}
