package com.biubiuman.game.map.two;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TideMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.util.Constants;

public class GrassMap extends GameMap2D {
	@Override
	public void initData() {
		super.initData();
		AssetLoader.getInstance().initParam(Constants.GROUND_PACK);
		groundAssets.add(AssetLoader.getInstance().groundAsset.lgrass);
		groundAssets.add(AssetLoader.getInstance().groundAsset.mgrass);
		groundAssets.add(AssetLoader.getInstance().groundAsset.rgrass);
		map = mapLoader.load(Constants.MAP_01);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
	}

}
