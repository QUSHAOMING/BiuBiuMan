package com.biubiuman.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.ui.MyDialog;
import com.biubiuman.game.util.Constants;

import io.netty.channel.Channel;

public abstract class AbstractScreen  implements Screen {
	private String TAG = this.getClass().getName();
	protected DirectedGame game;
	protected Stage stage;
	protected MyDialog dlHint;
	protected Label lbHint;
	protected Skin skin;
	protected boolean pause;
	private SpriteBatch batch;
	protected Channel ch;
	private Texture texture;

	public AbstractScreen() {
	}

	public AbstractScreen(DirectedGame game,Channel ch) {
		this.game = game;
		this.ch = ch;
		texture = new Texture("images/click_down.png");
		batch = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {
		if (stage != null) {
			stage.getViewport().update(width, height, true);
		}
	}

	@Override
	public void pause() {
		pause = true;
	}

	@Override
	public void resume() {
		pause = false;
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
		stage = null;
		batch.dispose();
		batch = null;
	}

	public abstract InputProcessor getInputProcessor();

	@Override
	public void render(float delta) {
		if (Gdx.input.isTouched()) {
			// Gdx.app.log("isTouched", batch + "yes");
			batch.begin();
			batch.draw(texture, Gdx.input.getX(), Constants.GAME_HEIGHT - Gdx.input.getY());
			batch.end();
		}
	}

}
