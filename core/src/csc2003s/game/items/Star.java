package csc2003s.game.items;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.math.Vector2;

/*
 * This class holds the information for a star (in the background), simply being a Vector2 state
 */
public class Star {

    private Vector2 loc; // x,y

    public Star(Vector2 loc) {
        this.loc = loc;
    }

    public Vector2 getLoc() {
        return loc;
    }
}