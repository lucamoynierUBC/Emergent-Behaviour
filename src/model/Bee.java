package model;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bee {
    public static final int SIZE_X = 6;
    public static final int SIZE_Y = 6;
    public static final int SPEED = 4;
    public static final Color COLOR = new Color(255, 255, 0);

    private static final int EAST = 1;
    private static final int WEST = -1;
    private static final int NORTH = 2;
    private static final int SOUTH = -2;
    private static final int INTERVAL = 3000;


    private int direction;
    private Boolean collisionDetected;
    private Boolean invincible;
    private Timer t;

    protected int x;
    protected int y;


    //Constructs a bee
    //Effects: Bee is at specified location
    public Bee(int x, int y) {
        this.x = x;
        this.y = y;
        collisionDetected = false;
        invincible = false;
    }


    public boolean getCollisionDetected() {
        return collisionDetected;
    }

    public boolean isInvincible() {
        return invincible;
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
        if (direction == EAST) {
            beeFront.addPoint(x + SIZE_X / 2, y + SIZE_Y / 2);
            beeFront.addPoint(x + SIZE_X, y);
            beeFront.addPoint(x + SIZE_X / 2, y - SIZE_Y / 2);
        } else if (direction == WEST) {
            beeFront.addPoint(x - SIZE_X / 2, y + SIZE_Y / 2);
            beeFront.addPoint(x - SIZE_X, y);
            beeFront.addPoint(x - SIZE_X / 2, y - SIZE_Y / 2);
        } else if (direction == NORTH) {
            beeFront.addPoint(x + SIZE_X / 2, y + SIZE_Y / 2);
            beeFront.addPoint(x, y + SIZE_Y);
            beeFront.addPoint(x - SIZE_X / 2, y + SIZE_Y / 2);
        } else {
            beeFront.addPoint(x + SIZE_X / 2, y - SIZE_Y / 2);
            beeFront.addPoint(x, y - SIZE_Y);
            beeFront.addPoint(x - SIZE_X / 2, y - SIZE_Y / 2);
        }
        return beeFront;
    }


    public void pause() {
        collisionDetected = true;
    }

    public void unPause() {
        collisionDetected = false;
    }

    public void setInvincible() {
        invincible = true;
    }
    public void setNormal() {
        invincible = false;
    }


    public void move() {
        int movement = generateRndNum();

        if (collisionDetected == false || invincible) {

            if (movement == 0) {
                x = x + SPEED;
                direction = EAST;
            } else if (movement == 1) {
                x = x - SPEED;
                direction = WEST;
            } else if (movement == 2) {
                y = y + SPEED;
                direction = NORTH;
            } else {
                y = y - SPEED;
                direction = SOUTH;
            }
            handleBoundary();
        }

    }


    public int getDirection() {
        return direction;
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



