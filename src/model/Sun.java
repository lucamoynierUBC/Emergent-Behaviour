package model;

import java.awt.*;

public class Sun {
    public static final int RADIUS = 150;
    private static final Color COLOR = new Color(255, 165, 0);
    protected int x;
    protected int y;

    public Sun(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
        g.fillOval(x, y, RADIUS, RADIUS);
        g.setColor(savedCol);
    }

    public boolean within(Bee other) {
        return true; //stub


    }
}
