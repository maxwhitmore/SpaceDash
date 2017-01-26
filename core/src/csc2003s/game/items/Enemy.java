package csc2003s.game.items;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/*
 * This class stores the basic info for the enemy (the falling circles)
 * Basic "AI" was implemented thru this feature, as the circles each fall towards the user
 */
public class Enemy {

    private Vector2 loc;
    private Rectangle outline;
    private Rectangle collis;
    private int numPipe;
    private float velocity;

    public Enemy(Play p, float velocity) {
        Random rand = new Random();

        loc = new Vector2(); // get the location
        outline = new Rectangle(); // a sort of bounding box
        collis = new Rectangle(); // checks for collisions

        outline.width = 300; // values
        outline.height = 300;
        collis.width = 100;
        collis.height = 100;
        this.velocity = velocity;

        numPipe = Math.abs(rand.nextInt() % p.getPipes().length); // make the initial position
        loc.y = p.getH() + outline.height / 2;
        loc.x = p.getPipes()[numPipe];

        outline.x = loc.x - outline.width / 2; // get the outline box for the user
        outline.y = loc.y - outline.height / 2;

        collis.x = loc.x - collis.width / 2; // get the outline collision box for the user
        collis.y = loc.y - collis.height / 2;
    }

    public Vector2 getLoc() {
        return loc;
    }

    public Rectangle getOutline(){
        return outline;
    }

    public Rectangle getCollis() {
        return collis;
    }

    public int getNumPipe() {
        return numPipe;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float x) {
        velocity = x;
    }

}
