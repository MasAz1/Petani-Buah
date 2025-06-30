import greenfoot.*;

public class Timer extends Actor
{
    private int timeLeft;  // dalam detik
    private long lastUpdate;

    public Timer(int seconds) {
        timeLeft = seconds;
        lastUpdate = System.currentTimeMillis();
        updateImage();
    }

    public void act() {
        if (System.currentTimeMillis() - lastUpdate >= 1000) {
            timeLeft--;
            lastUpdate = System.currentTimeMillis();
            updateImage();
        }
    }

    public boolean isTimeUp() {
        return timeLeft <= 0;
    }

    private void updateImage() {
        setImage(new GreenfootImage("Time: " + timeLeft, 24, Color.WHITE, new Color(0, 0, 0, 160)));
    }
}
