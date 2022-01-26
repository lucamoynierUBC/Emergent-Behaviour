package ui;

import model.BeeSpace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeeAlgorithm extends JFrame {

    private static final int INTERVAL1 = 20;


    private BeeSpace space;
    private SpacePanel sp;
    private ControlPanel cp;

    private Timer t1;
    private Timer t2;
    private Timer t3;

    public BeeAlgorithm() {
        super("Bee algorithm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        space = new BeeSpace();
        sp = new SpacePanel(space);
        cp = new ControlPanel(space);
        add(cp, BorderLayout.NORTH);
        add(sp);
        pack();
        setVisible(true);
        addTimer();
        t1.start();

    }

    private void addTimer() {
        t1 = new Timer(INTERVAL1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                space.update();
                sp.repaint();

            }
        });
    }

    public static void main(String[] args) {new BeeAlgorithm();}


}
