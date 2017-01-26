package csc2003s.game.helpers;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import csc2003s.game.items.Play;
import csc2003s.game.items.User;
import csc2003s.game.display.Display.Status;
import com.badlogic.gdx.math.Rectangle;

// GOOD
public class UserHelper implements InputProcessor {

    public static Rectangle buttonShape = new Rectangle(930, 1770, 150, 150);

    private User user;
    private Status status;
    private boolean paus;

    private Play level;

    public UserHelper(Play level) {
        this.level = level;
        user = level.getBot();
        paus = false;
    }

    public void update(Status status) {
        this.status = status;

        if (status == Status.play) {
            user.getLoc().x = level.getPipes()[user.getNumPipe()];

            user.getOutline().x = user.getLoc().x - user.getOutline().width / 2;
            user.getOutline().y = user.getLoc().y - user.getOutline().height / 2;

            user.getCollis().x = user.getLoc().x - user.getCollis().width / 2;
            user.getCollis().y = user.getLoc().y - user.getCollis().height / 2;
        }
    }

    @Override
    public boolean keyDown(int key) {
        if (status == Status.play) {
            if (key == Keys.LEFT && user.getNumPipe() > 0) {
                user.setNumPipe(user.getNumPipe() - 1);
            }

            if (key == Keys.RIGHT && user.getNumPipe() < 2) {
                user.setNumPipe(user.getNumPipe() + 1);
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int key) {
        return true;
    }

    @Override
    public boolean keyTyped(char charac) {
        return true;
    }

    @Override
    public boolean touchDown(int x, int y, int cent, int but) {
        if (buttonShape.contains(x * (float) level.getW() / Gdx.graphics.getWidth(),
                level.getH() - (y * level.getH() / Gdx.graphics.getHeight()))) {
            paus = !paus;
        }
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int cent, int but) {
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int cent) {
        return true;
    }

    @Override
    public boolean mouseMoved(int x, int y) {
        return true;
    }

    @Override
    public boolean scrolled(int amt) {
        return true;
    }

    public boolean isPause() {
        return paus;
    }

}