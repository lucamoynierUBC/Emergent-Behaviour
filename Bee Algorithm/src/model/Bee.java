package model;

import java.awt.*;
import java.util.Random;

public class Bee {
    public static final int SIZE_X = 6;
    public static final int SIZE_Y = 4;
    public static final int SPEED = 2;
    public static final Color COLOR = new Color(255, 255, 0);
    protected int x;
    protected int y;


    //Constructs a bee
    //Effects: Bee is at specified location
    public Bee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return SIZE_X;
    }

    public int getHeight() {
        return SIZE_Y;
    }

    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
        Polygon beeFront = createBeeFront();
        g.fillPolygon(beeFront);
        g.setColor(savedCol);

    }

    private Polygon createBeeFront() {
        Polygon beeFront = new Polygon();
        beeFront.addPoint(x + SIZE_X / 2, y + SIZE_Y / 2);
        beeFront.addPoint(x + SIZE_X, y);
        beeFront.addPoint(x + SIZE_X / 2, y - SIZE_Y / 2);
        return beeFront;
    }

    public void move() {
        int movement = generateRndNum();
        if (movement == 0) {
            x = x + SPEED;
        } else if (movement == 1) {
            x = x - SPEED;
        } else if (movement == 2) {
            y = y + SPEED;
        } else {
            y = y - SPEED;
        }
    }

    public void handleBoundary() {
        if (x < 0) {
            x = 0;
        } else if (y < 0) {
            y = 0;
        } else if (x > BeeSpace.WIDTH) {
            x = BeeSpace.WIDTH;
        } else if (y > BeeSpace.HEIGHT) {
            y = BeeSpace.HEIGHT;
        }
    }

    public int generateRndNum() {
        int min = 0;
        int max = 3;
        Random r = new Random();
        int result = r.nextInt(max - min + 1) + min;
        return result;
    }

    public boolean collidedWith(Bee other) {
        Rectangle thisBoundingRect = new Rectangle(getX() - getWidth() / 2,
                getY() - getHeight() / 2,
                getWidth(),
                getHeight());
        Rectangle otherBoundingRect = new Rectangle(other.getX() - other.getWidth() / 2,
                other.getY() - other.getHeight() / 2,
                other.getWidth(),
                other.getHeight());
        return thisBoundingRect.intersects(otherBoundingRect);
    }


}



