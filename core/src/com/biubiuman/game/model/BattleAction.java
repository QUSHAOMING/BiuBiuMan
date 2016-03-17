package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class BattleAction implements Screen {
	protected Stage container;
	protected Image bgImg;
	private boolean pause;

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// if (Gdx.input.isTouched()) {
		// Gdx.app.log("fisrt", Gdx.input.getX(1) + " , " + Gdx.input.getY(1));
		//
		// Gdx.app.log("second", Gdx.input.getX(2) + " , " + Gdx.input.getY(2));
		// }
	}

	@Override
	public void resize(int width, int height) {

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
		pause = true;
	}

	@Override
	public void dispose() {
		container.dispose();
	}

}
