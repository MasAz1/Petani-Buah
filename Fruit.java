import greenfoot.*;

public class Fruit extends Actor
{
    public void act()
    {
        fall();
    }

    public void fall()
    {
        setLocation(getX(), getY() + 2); // jatuh perlahan
        if (getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this); // hilang kalau menyentuh tanah
        }
    }
}
