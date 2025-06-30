// File: Level2.java
import greenfoot.*;

public class Level2 extends BaseWorld {
    private Counter counter = new Counter("Score: ");
    private Timer timer = new Timer(60);
    private int nyawaBom = 3;
    private boolean gameOverTriggered = false;

    private ScoreBoard warningBoard;
    private GreenfootSound backgroundMusic = new GreenfootSound("sound.wav");

    public Level2() {
        super(600, 400, 1);
        setPaintOrder(
            LoseImage.class, WinImage.class, ScoreBoard.class,
            Counter.class, Timer.class,
            Petani.class, Apel.class, Pisang.class, jeruk.class, bomb.class
        );

        addObject(new Petani(), getWidth() / 2, getHeight() - 30);
        addObject(counter, 80, 30);
        addObject(timer, getWidth() - 80, 30);
    }

    public void act() {
        if (gameOverTriggered) return;

        if (Greenfoot.getRandomNumber(100) < 4) {
            int jenis = Greenfoot.getRandomNumber(3);
            int x = Greenfoot.getRandomNumber(getWidth());
            if (jenis == 0) addObject(new Apel(), x, 0);
            else if (jenis == 1) addObject(new Pisang(), x, 0);
            else addObject(new jeruk(), x, 0);
        }

        // Lebih jarang: 1 dari 250 chance (~0.4% kemungkinan tiap frame)
        if (Greenfoot.getRandomNumber(150) < 2) {
            addObject(new bomb(), Greenfoot.getRandomNumber(getWidth()), 0);
        }


        if (counter.getValue() >= 300) {
            gameOverTriggered = true;
            Greenfoot.playSound("menang.wav");
            showMessage("MENANG");
            backgroundMusic.stop();
            Greenfoot.delay(100);
            // Greenfoot.setWorld(new Level3());
        }

        if (timer.isTimeUp()) {
            gameOverTriggered = true;
            showMessage("KALAH");
            Greenfoot.playSound("gameover.wav");
            backgroundMusic.stop();
            Greenfoot.delay(100);
        }
    }

    public void addScore(int value) {
        counter.add(value);
    }

    public void forceGameOver() {
        nyawaBom--;
        Greenfoot.playSound("bom.wav");

        if (nyawaBom <= 0) {
            gameOverTriggered = true;
            showMessage("KALAH");
            Greenfoot.playSound("gameover.wav");
            backgroundMusic.stop();
            Greenfoot.delay(100);
        } else {
            if (warningBoard != null) removeObject(warningBoard);
            String peringatan = "\u26A0\uFE0F Kena Bom! Sisa nyawa: " + nyawaBom;
            warningBoard = new ScoreBoard(peringatan);
            addObject(warningBoard, getWidth() / 2, getHeight() / 2 + 120);
        }
    }

    private void showMessage(String status) {
        if (status.equals("KALAH")) {
            addObject(new LoseImage(), getWidth() / 2, getHeight() / 2);
        } else if (status.equals("MENANG")) {
            addObject(new WinImage(), getWidth() / 2, getHeight() / 2);
        }
    }

    public void started() {
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
        }
    }

    public void stopped() {
        backgroundMusic.pause();
    }

    public boolean isGameOver() {
        return gameOverTriggered;
    }
}