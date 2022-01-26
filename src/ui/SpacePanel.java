package ui;

import model.BeeSpace;

import javax.swing.*;
import java.awt.*;

public class SpacePanel extends JPanel {

    private BeeSpace space;

    public SpacePanel(BeeSpace s) {
        setPreferredSize(new Dimension(BeeSpace.WIDTH, BeeSpace.HEIGHT));
        setBackground(Color.BLACK);
        space = s;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSpace(g);
    }

    private void drawSpace(Graphics g) {
        space.draw(g);
    }

}
