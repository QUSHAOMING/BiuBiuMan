package com.biubiuman.game.map.two;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.map.GameMap;

public abstract class GameMap2D extends GameMap {

	protected Array<AtlasRegion> groundAssets;
	protected TmxMapLoader mapLoader;
	protected TiledMapRenderer mapRenderer;
	protected TiledMap map;

	@Override
	public void initData() {
		groundAssets = new Array<AtlasRegion>();
		mapLoader = new TmxMapLoader();
	}

	@Override
	public void drawMap(Batch batch) {
		mapRenderer.render();
	}

	public TiledMapRenderer getMapRenderer() {
		return mapRenderer;
	}

	public TiledMap getMap() {
		return map;
	}

}
