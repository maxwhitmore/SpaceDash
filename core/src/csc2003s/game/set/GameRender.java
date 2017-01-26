package csc2003s.game.set;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import csc2003s.game.items.Play;
import csc2003s.game.items.Star;
import csc2003s.game.items.Enemy;
import csc2003s.game.items.User;
import csc2003s.game.display.Display.Status;
import com.badlogic.gdx.math.Rectangle;

/*
 * This class renders all assets and updates to the game display, using the built in LibGDX sprite batch tools
 */
public class GameRender {

    public static Rectangle buttonShape = new Rectangle(930, 1770, 150, 150);

    private Play p;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Assets assets;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font1;

    public GameRender(Play p) {
        this.p = p;

        cam = new OrthographicCamera(p.getW(), p.getH()); // set the camera proportions
        cam.position.set(p.getW() / 2, p.getH() / 2, 0);
        cam.update();

        batch = new SpriteBatch(); // create a spritebatch and focus appropriately
        batch.setProjectionMatrix(cam.combined);
        assets = new Assets(p);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        shapeRenderer.setColor(1, 1, 1, 1);

        font1 = new BitmapFont(Gdx.files.internal("space.fnt"));
        font1.setColor(1, 1, 1, 1);
    }

    public void render(Status status) {
        Gdx.gl.glClearColor(0, 0, 0, 1); // make sure screen is clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Filled);

        int i = 0;
        while (i < p.getStars().size()) { // render the stars
            Star s = p.getStars().get(i);
            shapeRenderer.circle(s.getLoc().x, s.getLoc().y, 2);
            i++;
        }

        shapeRenderer.end();

        batch.begin(); // create a new batch

        int j = 0;
        while (j < p.getPipes().length) { // render the pipes
            batch.draw(assets.getPipes()[j], p.getW() / p.getPipes().length * j, 0);
            j++;
        }

        int k = 0;
        while (k < p.getPipes().length) { // render the pipe backings
            batch.draw(assets.getPipeBack()[k], p.getW() / p.getPipes().length * k, 0);
            k++;
        }

        User s = p.getBot(); // render the user's triangle
        batch.draw(assets.getUser()[s.getNumPipe()], s.getOutline().x, s.getOutline().y, s.getOutline().width, s.getOutline().height);

        int l = 0;
        while (l < p.getEnemies().size()) { // render the enemies given the outline
            Enemy e = p.getEnemies().get(l);
            batch.draw(assets.getEnemy()[e.getNumPipe()], e.getOutline().x, e.getOutline().y, e.getOutline().width, e.getOutline().height);
            l++;
        }

        font1.draw(batch, "Score:", 0, p.getH()); // draw on the display

        float yPlacement = p.getH() - font1.getLineHeight(); // draw the user's score
        font1.draw(batch, Integer.toString((int) p.getScr()), 0, yPlacement);

        if (status == Status.pause) { // if pause, draw the play button
            batch.draw(assets.getPlay(), buttonShape.getX(), buttonShape.getY(), buttonShape.getWidth(), buttonShape.getHeight());
        } else if (status != Status.over) { // if play, draw the pause button
            batch.draw(assets.getPause(), buttonShape.getX(), buttonShape.getY(), buttonShape.getWidth(), buttonShape.getHeight());
        }
        batch.end();
    }
}