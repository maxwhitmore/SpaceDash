package csc2003s.game.items;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * This class holds the information for the user, being the triangle
 */
public class User {

    private Vector2 loc;
    private Rectangle outline;
    private Rectangle collis;
    private int numPipe;

    public User(Play p) {
        numPipe = 1;

        loc = new Vector2(); // position of user (tells which pipe)
        outline = new Rectangle(); // box around the user
        collis = new Rectangle(); // box to help check for collision

        outline.width = 403; // hard-coded values that correspond to the game display
        outline.height = 378;
        collis.width = 203;
        collis.height = 178;

        loc.x = p.getPipes()[numPipe]; // the location must coincide with a pipe
        loc.y = 300;

        outline.x = loc.x - outline.width / 2; // update the outline box
        outline.y = loc.y - outline.height / 2;

        collis.x = loc.x - collis.width / 2; // update the collision box
        collis.y = loc.y - collis.height / 2;

    }

    public Vector2 getLoc() {
        return loc;
    }

    public Rectangle getOutline() {
        return outline;
    }

    public Rectangle getCollis() {
        return collis;
    }

    public int getNumPipe() {
        return numPipe;
    }

    public void setNumPipe(int x) {
        numPipe = x;
    }

}