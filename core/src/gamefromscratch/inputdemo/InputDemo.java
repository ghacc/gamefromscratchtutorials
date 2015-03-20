package gamefromscratch.inputdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class InputDemo extends ApplicationAdapter {
	
	public class MyActor extends Actor {
		Texture texture = new Texture(Gdx.files.internal("data/jet.png"));
		public boolean started = false;
		
		public MyActor() {
			setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
		}
		
		@Override
		public void draw(Batch batch, float parentAlpha) {
			batch.draw(texture, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(),
					this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0, texture.getWidth(), texture.getHeight(), false, false);
		}
	}
	
	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		MyActor actor = new MyActor();
		
		SequenceAction sequenceAction = new SequenceAction();
		
		MoveToAction moveAction = new MoveToAction();
		moveAction.setPosition(300f, 0f);
		moveAction.setDuration(10f);
		
		RotateToAction rotateAction = new RotateToAction();
		rotateAction.setRotation(90f);
		rotateAction.setDuration(5f);
		
		ScaleToAction scaleAction = new ScaleToAction();
		scaleAction.setScale(0.5f);
		scaleAction.setDuration(5f);
		
		sequenceAction.addAction(moveAction);
		sequenceAction.addAction(rotateAction);
		sequenceAction.addAction(scaleAction);
		
		actor.addAction(sequenceAction);
		
		stage.addActor(actor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}
}
