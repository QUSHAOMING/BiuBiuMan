package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.builder.helper.CameraHelper;
import com.biubiuman.game.map.GameMap;
import com.biubiuman.game.map.two.GameMap2D;
import com.biubiuman.game.map.two.GrassMap;
import com.biubiuman.game.map.twohalf.GameMap2Dot5D;
import com.biubiuman.game.role.GameRole;
import com.biubiuman.game.role.Player;
import com.biubiuman.game.util.Constants;

public abstract class BattleAction implements Screen {
	protected Stage container;
	protected OrthographicCamera camera;
	protected GameRole player;
	protected GameMap map;
	protected boolean pause;
	protected  int[][] barriers;
	
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput();
		if (map instanceof GameMap2D) {
			((GameMap2D) map).getMapRenderer().setView(camera);
			((GameMap2D) map).getMapRenderer().render();
		} else if (map instanceof GameMap2Dot5D) {

		}
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

	protected void initScene(GameMap m, GameRole p) {
		container = new Stage();
		camera = (OrthographicCamera) container.getCamera();
		CameraHelper.getInstance().initCamera(camera);
		barriers = new int[Constants.MAX_HEIGHT][Constants.MAX_WIDTH];
		map = m;
		player = p;
		container.addActor(map);
		container.addActor(player);
		setBarriers();
	}

	public void setBarriers() {
		if (map instanceof GrassMap) {
			MapLayers layers = ((GrassMap) map).getMap().getLayers();

			for (MapLayer layer : layers) {//
				if (layer.getName().equals("Players")) {//
					MapObjects objs = layer.getObjects();
					for (MapObject obj : objs) {//
						if (obj.getName().equals("me")) {//
							RectangleMapObject rmobj = (RectangleMapObject) obj;
							player.currentX = rmobj.getRectangle().x;
							player.currentY = rmobj.getRectangle().y;
							break;
						}
					}
				}

				if (layer.getName().equals("Map")) {//
					if (layer instanceof TiledMapTileLayer) {//
						TiledMapTileLayer tlayer = (TiledMapTileLayer) layer;
						for (int x = 0; x < Constants.MAX_HEIGHT; x++) {
							for (int y = 0; y < Constants.MAX_WIDTH; y++) {
								if (tlayer.getCell(y, x) != null) {
									barriers[x][y] = 1;
								}
							}
						}
					}
				}
			}
		}

	}

	public void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.currentX -= 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.currentX += 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.currentY -= 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player.currentY += 10;
		}
		CameraHelper.getInstance().lockTheRole(camera, player.currentX,
				player.currentY);
	}

}
