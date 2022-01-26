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
    private List<Bee> toBePaused;

    public BeeSpace() {
        bees = new ArrayList<Bee>();
        toBePaused = new ArrayList<>();
        initializeBees();
        checkCollisions();


    }

    public int beesSize() {
        return bees.size();
    }

    public void addBee() {
        Bee b = new Bee(RND.nextInt(WIDTH), RND.nextInt(HEIGHT));
        bees.add(b);
    }


    public void update() {
        checkCollisions();
        moveBees();

    }


    private void moveBees() {
        for (Bee next : bees) {
            next.move();
        }

    }

    public void draw(Graphics g) {
        for (Bee aBee : bees) {
            aBee.draw(g);

        }
    }

    public void initializeBees() {
        bees.clear();
        sun = new Sun(WIDTH / 2, HEIGHT / 2);
    }

    public void checkCollisions() {
        for (Bee next : bees) {
            if (!next.isInvincible()) {
                List<Bee> nextList = new ArrayList<>();
                nextList.addAll(bees);
                nextList.remove(next);

                for (Bee other : nextList) {
                    if (next.collidedWith(other) && !other.isInvincible()) {
                        toBePaused.add(next);
                        toBePaused.add(other);
                    }
                }
            }
            pauseBees(toBePaused);


        }
    }


    public void pauseBees(List<Bee> pauseEm) {
        for (Bee next : pauseEm) {
            next.pause();

        }

    }


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



