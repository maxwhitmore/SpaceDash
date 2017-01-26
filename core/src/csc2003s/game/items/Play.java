package csc2003s.game.items;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import java.util.ArrayList;
import java.util.List;

/*
 * This class initializes the gameplay information, being the user, enemies, stars, and score
 */
public class Play {

    private int[] pipes = {180, 540, 900};
    private final int W = 1080;
    private final int H = 1920;

    private User bot;
    private List<Enemy> enemies;
    private List<Star> stars;
    private float scr;

    public Play() {
        bot = new User(this); // make a new user
        enemies = new ArrayList<Enemy>(); // create a list of enemies to "keep track" of
        stars = new ArrayList<Star>(); // create a list of stars to "keep track" of
        scr = 0;
    }

    public int[] getPipes() {
        return pipes;
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }

    public User getBot() {
        return bot;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Star> getStars() {
        return stars;
    }

    public float getScr() {
        return scr;
    }

    public void setScr(float x) {
        scr = x;
    }
}