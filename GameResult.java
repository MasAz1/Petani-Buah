
import greenfoot.*;

public class GameResult extends Actor {
    public GameResult(String type) {
        if (type.equals("win")) {
            setImage("you_win.png"); // Gambar kemenangan
        } else {
            setImage("you_lose.jpg"); // Gambar kekalahan
        }

        // Perkecil agar tidak terlalu besar
        GreenfootImage img = getImage();
        img.scale(250, 150); // Atur ukuran sesuai keinginan
        setImage(img);
    }
}
