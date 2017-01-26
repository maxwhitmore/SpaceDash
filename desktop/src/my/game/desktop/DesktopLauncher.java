package my.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import csc2003s.game.SpaceDash;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SpaceDash";
		config.width = 432;
		config.height = 768;
		new LwjglApplication(new SpaceDash(), config);
	}
}