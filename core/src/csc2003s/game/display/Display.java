package csc2003s.game.display;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import csc2003s.game.helpers.StarHelper;
import csc2003s.game.helpers.UserHelper;
import csc2003s.game.helpers.EnemyHelper;
import csc2003s.game.items.Play;
import csc2003s.game.set.GameRender;

/*
 * This class serves to hold the information of the display, rendering the status of gameplay (on or paused)
 */
public class Display implements Screen {

    private Status status;
    private Play p;
    private GameRender render;
    private UserHelper userHelper;
    private EnemyHelper enemyHelper;
    private StarHelper starHelper;

    public enum Status { // enums help!
        play, pause, over
    }

    @Override
    public void show() {
        status = Status.play;
        p = new Play();
        render = new GameRender(p);
        userHelper = new UserHelper(p);
        enemyHelper = new EnemyHelper(p);
        starHelper = new StarHelper(p);
        Gdx.input.setInputProcessor(userHelper);
   }

    @Override
    public void render(float delta) {
        status = Status.play; // get the status

        if (userHelper.isPause() && (status == Status.play)) { // pause the game
            status = Status.pause;
        }

        if (!userHelper.isPause() && status == Status.pause) { // resume playing
            status = Status.play;
        }

        if (enemyHelper.isOver()) { // game is over!
            status = Status.over;
        }

        if (status == Status.play) { // update the score
            p.setScr(p.getScr() + 100 * delta);
        }

        userHelper.update(status); // update all helpers and render what's new
        enemyHelper.update(status, delta);
        starHelper.update(status, delta);
        render.render(status);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}