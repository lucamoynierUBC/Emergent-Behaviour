package ui;

import model.BeeSpace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private static final String BEES_TOTAL = "Total Bees: ";
    private JButton addBeeBtn;
    private JLabel beeLbl;
    private BeeSpace s;



    public ControlPanel(BeeSpace s) {
        setBackground(Color.YELLOW);
        addBeeBtn = new JButton(new AddBee());
        addBeeBtn.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));


        beeLbl = new JLabel(BEES_TOTAL + 0);
        beeLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(addBeeBtn);
        add(beeLbl);
        add(Box.createHorizontalStrut(10));

        this.s = s;
    }

    private class AddBee extends AbstractAction {

        AddBee() {
            super("Add Bee");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            s.addBee();
            beeLbl.setText(BEES_TOTAL + s.beesSize());
        }
    }


}
