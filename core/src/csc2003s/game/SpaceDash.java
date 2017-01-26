package csc2003s.game;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.Game;
import csc2003s.game.display.Display;

public class SpaceDash extends Game {

    @Override
    public void create() {
        setScreen(new Display());
    }
}