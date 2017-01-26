package csc2003s.game.helpers;

/**
 * Max Whitmore (WHTMAX002)
 * 10/31/16
 * CSC2003S - Game Features
 */
import csc2003s.game.items.Play;
import csc2003s.game.items.Enemy;
import csc2003s.game.display.Display.Status;

/*
 * This class updates the enemies as the are created, moving them throughout the display
 */
public class EnemyHelper {

    protected Play p;
    private boolean over;
    private float velocity;

    public EnemyHelper(Play p) {
        this.p = p;
        over = false;
        velocity = -200; // initial speed, gets faster
    }

    public void update(Status status, float dt) {
        if (status == Status.play) {
            velocity += -50 * dt; // update velocity

            if (p.getEnemies().isEmpty()) { // create new enemies!
                p.getEnemies().add(new Enemy(p, velocity));
            } else if (p.getH() - p.getEnemies().get(p.getEnemies().size() - 1).getLoc().y >= 300) { // create enemies
                p.getEnemies().add(new Enemy(p, velocity));
            }

            int i = 0;
            while (i < p.getEnemies().size()) {
                Enemy enemy = p.getEnemies().get(i);

                enemy.setVelocity(velocity); // update velocity

                enemy.getLoc().y = enemy.getLoc().y + enemy.getVelocity() * dt; // update location

                enemy.getOutline().x = enemy.getLoc().x - enemy.getOutline().width / 2; // find the outline of the enemy
                enemy.getOutline().y = enemy.getLoc().y - enemy.getOutline().height / 2;

                enemy.getCollis().x = enemy.getLoc().x - enemy.getCollis().width / 2; // use this info for collision testing
                enemy.getCollis().y = enemy.getLoc().y - enemy.getCollis().height / 2;

                // TODO: BETTER IMPLEMENTATION OF COLLISION CHECKING
                if ((enemy.getCollis().contains(p.getBot().getCollis().x + p.getBot().getCollis().width / 2, // check for collision
                        p.getBot().getCollis().y + p.getBot().getCollis().height))) {
                    over = true;
                }
                i++;

            }
        }
    }

    public boolean isOver() { // boolean indicator
        return over;
    }
}