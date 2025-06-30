import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Counter extends Actor
{
    private int value = 0;
    private String text;
    private int stringLength;

    public Counter()
    {
        this("");
    }

    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // gunakan font besar
        
        updateImage();
    }

    public void act()
    {
        // Tidak perlu animasi lambat, jadi act kosong bisa juga
    }

    public void add(int score)
    {
        value += score;
        updateImage();  // langsung tampilkan nilai baru
    }

    public void subtract(int score)
    {
        value -= score;
        updateImage();
    }

    public int getValue()
    {
        return value;
    }

    /**
     * Membuat ulang gambar teks skor
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
