package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeeSpace {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Random RND = new Random();

    private List<Bee> bees;
    private Sun sun;

    public BeeSpace() {
        bees = new ArrayList<Bee>();
        initializeBees();
    }

    public void draw(Graphics g) {
        for (Bee aBee : bees) {

        }
    }

    public void initializeBees() {
        bees.clear();
        sun = new Sun(WIDTH/2, HEIGHT/2);
    }

    public void checkCollisions() {
        List<Bee> toBePaused = new ArrayList<>();
        for (Bee next : bees) {
            List<Bee> nextList = new ArrayList<>();
            nextList.addAll(bees);
            nextList.remove(next);
            for (Bee other : nextList) {
                if (next.collidedWith(other)) {
                    toBePaused.add(next);
                    toBePaused.add(other);
                }
            }
        }
        pauseBees(toBePaused);

    }

    public void pauseBees(List<Bee> pauseEm) {

    }

//    public void pauseBee(Bee bee, List<Bee> beesToPause) {
//
//        for (Bee next : bees) {
//            if (bee.collidedWith(next)) {
//                beesToPause.add(bee);
//                beesToPause.add(next);
//            }
//        }
//    }






}
