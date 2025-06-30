import greenfoot.*;

public class ScoreBoard extends Actor
{
    public ScoreBoard(String text) {
        GreenfootImage image = new GreenfootImage(300, 100);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, 300, 100);
        image.setColor(Color.WHITE);
        image.setFont(new Font(24));
        image.drawString(text, 20, 50);
        setImage(image);
    }
}
