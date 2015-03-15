package gamefromscratch.inputdemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import gamefromscratch.inputdemo.InputDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "camera";
		config.width = 1280;
		config.height = 720;
		
		new LwjglApplication(new InputDemo(), config);
	}
}
