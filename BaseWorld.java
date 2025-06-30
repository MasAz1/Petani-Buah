import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BaseWorld extends World {
    public BaseWorld(int width, int height, int cellSize) {
        super(width, height, cellSize);
    }

    // Konstruktor kosong jika diperlukan:
    public BaseWorld() {
        super(600, 400, 1); // default size
    }
}

