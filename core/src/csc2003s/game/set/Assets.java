package csc2003s.game.set;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import csc2003s.game.items.Play;

/*
 * This class loads and appropriately stores the asset images as TextureRegions, splitting them up
 * for efficiency
 */
public class Assets {

    private TextureRegion[] pipes;
    private TextureRegion[] pipeBack;
    private TextureRegion[] user;
    private TextureRegion[] enemy;

    private Texture play;
    private Texture pause;

    public Assets(Play level) {
        Texture eachPipe = new Texture(Gdx.files.internal("pipes.png")); // load the pipes
        pipes = new TextureRegion[level.getPipes().length];
        int i = 0;
        while (i < level.getPipes().length) { // set each pipe separately
            pipes[i] = new TextureRegion(eachPipe, eachPipe.getWidth() / level.getPipes().length * i, 0,
                    eachPipe.getWidth() / level.getPipes().length, eachPipe.getHeight());
            i++;
        }

        Texture eachPipeBack = new Texture(Gdx.files.internal("pipeBack.png")); // load the pipe backings
        pipeBack = new TextureRegion[level.getPipes().length];
        int j = 0;
        while (j < level.getPipes().length) { // set each pipe backing separately
            pipeBack[j] = new TextureRegion(eachPipeBack, eachPipeBack.getWidth() / level.getPipes().length * j, 0,
                    eachPipeBack.getWidth() / level.getPipes().length, eachPipeBack.getHeight());
            j++;
        }

        Texture eachUser = new Texture(Gdx.files.internal("tri.png")); // load the user triangle
        user = new TextureRegion[level.getPipes().length];
        int k = 0;
        while (k < level.getPipes().length) { // set each user triangle separately
            user[k] = new TextureRegion(eachUser, eachUser.getWidth() / level.getPipes().length * k, 0,
                    eachUser.getWidth() / level.getPipes().length, eachUser.getHeight());
            k++;
        }

        Texture eachEnemy = new Texture(Gdx.files.internal("circles.png")); // load the enemies
        enemy = new TextureRegion[level.getPipes().length];
        int l = 0;
        while (l < level.getPipes().length) { // set each enemy separately
            enemy[l] = new TextureRegion(eachEnemy, eachEnemy.getWidth() / level.getPipes().length * l, 0,
                    eachEnemy.getWidth() / level.getPipes().length, eachEnemy.getHeight());
            l++;
        }

        play = new Texture(Gdx.files.internal("play.png")); // play and pause buttons
        pause = new Texture(Gdx.files.internal("pause.png"));
    }

    public TextureRegion[] getPipes() {
        return pipes;
    }

    public TextureRegion[] getPipeBack() {
        return pipeBack;
    }

    public TextureRegion[] getUser() {
        return user;
    }

    public TextureRegion[] getEnemy() {
        return enemy;
    }

    public Texture getPlay() {
        return play;
    }

    public Texture getPause() {
        return pause;
    }
}