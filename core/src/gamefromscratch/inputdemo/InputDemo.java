package gamefromscratch.inputdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Orientation;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputDemo extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	String message = "Do something already!";
	float highestY = 0.0f;
	int w, h;
	
	@Override
	public void create () {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		int deviceAngle = Gdx.input.getRotation();
		Orientation orientation = Gdx.input.getNativeOrientation();
		float accelY = Gdx.input.getAccelerometerY();
		if (accelY > highestY)
			highestY = accelY;
		
		message = "Device rotated to: " + Integer.toString(deviceAngle) + " degrees\n";
		message += "Device orientation is ";
		switch (orientation) {
		case Landscape:
			message += " landscape.\n";
			break;
		case Portrait:
			message += " portrait.\n";
		default:
			message += " complete crap!\n";
			break;
		}
		
		message += "Device resolution: " + Integer.toString(w) + "," + Integer.toString(h) + "\n";
		message += "Y axis accel: " + Float.toString(accelY) + "\n";
		message += "Highest Y value: " + Float.toString(highestY) + "\n";
		
		if (Gdx.input.isPeripheralAvailable(Peripheral.Vibrator)) {
			if (accelY > 7)
				Gdx.input.vibrate(100);
		}
		
		if (Gdx.input.isPeripheralAvailable(Peripheral.Compass)) {
			message += "Azimuth: " + Float.toString(Gdx.input.getAzimuth()) + "\n";
			message += "Pitch: " + Float.toString(Gdx.input.getPitch()) + "\n";
			message += "Roll: " + Float.toString(Gdx.input.getRoll()) + "\n";
		} else {
			message += "No compass available\n";
		}
		
		font.draw(batch, message, 0, h);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		batch.dispose();
		batch = new SpriteBatch();
		w = width;
		h = height;
		String resolution = Integer.toString(w) + "," + Integer.toString(h);
		Gdx.app.log("MJF", "Resolution changed to: " + resolution);
	}
}
