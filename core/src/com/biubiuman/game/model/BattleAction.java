package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.builder.helper.CameraHelper;
import com.biubiuman.game.map.two.GrassMap;

public abstract class BattleAction implements Screen {
	protected Stage container;
	protected Image bgImg;
	private boolean pause;
	protected OrthographicCamera camera;

	@Override
	public void show() {
		initScene();
	}

	@Override
	public void render(float delta) {
		handleInput();
		// Gdx.gl.glClearColor(0f, 0f, 0f, 1);
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
		AssetLoader.getInstance().dispose();
	}

	protected void initScene() {
		container = new Stage();
		camera = CameraHelper.getInstance().createCamera();
	}

	public void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			camera.translate(-50, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			camera.translate(50, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			camera.translate(0, -50, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			camera.translate(0, 50, 0);
		}
		camera.update();
	}

}
