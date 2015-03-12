package gamefromscratch.inputdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputDemo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texture;
	Sprite sprite;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/0001.pgn"));
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 - sprite.getWidth()/2, h/2 - sprite.getHeight()/2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(-1f);
			else
				sprite.translateX(-10f);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT))
				sprite.translateX(1f);
			else
				sprite.translateX(10f);
		}
		
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
}
