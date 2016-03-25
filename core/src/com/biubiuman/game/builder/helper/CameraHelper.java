package com.biubiuman.game.builder.helper;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.biubiuman.game.util.Constants;

public class CameraHelper {
	private static CameraHelper cameraHelper;

	public static CameraHelper getInstance() {
		if (cameraHelper == null) {
			cameraHelper = new CameraHelper();
		}
		return cameraHelper;
	}

	public OrthographicCamera createCamera() {
		OrthographicCamera camera = new OrthographicCamera(
				Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
		return camera;
	}

	public void initCamera(OrthographicCamera camera) {
		camera.viewportHeight = Constants.GAME_HEIGHT;
		camera.viewportWidth = Constants.GAME_WIDTH;
	}

	public void translateCamera(OrthographicCamera camera, float x, float y) {
		camera.translate(x, y);
		camera.update();
	}

	public void lockTheRole(OrthographicCamera camera, float x, float y) {
		camera.position.x = x;
		camera.position.y = y;
		camera.update();
	}

}
