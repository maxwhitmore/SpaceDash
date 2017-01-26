package csc2003s.game.helpers;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import java.util.*;

import com.badlogic.gdx.math.Vector2;
import csc2003s.game.items.Play;
import csc2003s.game.items.Star;
import csc2003s.game.display.Display.Status;

/*
 * This class helps create and move stars, the beautiful, simplistic background to the game
 */
public class StarHelper {

    private Play p;
    private Random rand;

    public StarHelper(Play p) {
        this.p = p;
        rand = new Random();
    }

    public void update(Status status, float dt) {
        if (status != Status.pause) { // if game is being played
            boolean checkStars = false;

            int i = 0;
            while (i < p.getStars().size()) { // run through all possible stars
                Star s = p.getStars().get(i);

                s.getLoc().y += -100 * dt; // update location

                if (s.getLoc().y > p.getH()) { // if there are stars above the screen, don't make more
                    checkStars = true;
                }
                i++;
            }

            if (!checkStars) { // if there are no stars above the screen, make more!
                int j = 0;
                while (j < 100) {
                    Vector2 v = new Vector2();
                    v.x = rand.nextInt() % p.getW(); // random mod the width restraints
                    v.y = rand.nextInt() % (p.getH() * 2 - p.getH()) + p.getH(); // random mod height restraints
                    p.getStars().add(new Star(v)); // add it to the collection
                    j++;
                }
            }

        }
    }
}