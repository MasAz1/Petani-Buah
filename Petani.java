import greenfoot.*;

public class Petani extends Actor {
    private final int speed = 3;

    public Petani() {
        GreenfootImage img = new GreenfootImage("petani.png");
        img.scale(70, 70);
        setImage(img);
    }

    public void act() {
        World w = getWorld();

        // Cek jika game over
        if ((w instanceof back && ((back) w).isGameOver()) ||
            (w instanceof Level2 && ((Level2) w).isGameOver())) return;

        // Gerak kiri-kanan dengan pembatas
        if (Greenfoot.isKeyDown("left") && getX() > 35) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right") && getX() < w.getWidth() - 35) {
            setLocation(getX() + speed, getY());
        }

        checkCatch();
    }

    private void checkCatch() {
        Actor buah = getOneIntersectingObject(Actor.class);
        if (buah == null) return;

        int skor = 0;

        if (buah instanceof Apel) skor = 5;
        else if (buah instanceof Pisang) skor = 10;
        else if (buah instanceof jeruk) skor = 15;
        else if (buah instanceof bomb) {
            if (getWorld() instanceof back) ((back) getWorld()).forceGameOver();
            else if (getWorld() instanceof Level2) ((Level2) getWorld()).forceGameOver();
            getWorld().removeObject(buah);
            return;
        }

        // Tambahkan skor
        if (skor > 0) {
            if (getWorld() instanceof back) ((back) getWorld()).addScore(skor);
            else if (getWorld() instanceof Level2) ((Level2) getWorld()).addScore(skor);
            Greenfoot.playSound("pop.wav");
            getWorld().removeObject(buah);
        }
    }
}
