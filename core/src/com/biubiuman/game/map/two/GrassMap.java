package com.biubiuman.game.map.two;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.util.Constants;

public class GrassMap extends GameMap2D {
	@Override
	public void initData() {
		super.initData();
		map = mapLoader.load(Constants.MAP_01);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
	}

}
