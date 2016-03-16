package com.biubiuman.game.map.two;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.builder.helper.ComposedHelper;
import com.biubiuman.game.util.Constants;

public class GrassMap extends GameMap2D {
	
	public GrassMap() {
		initData();
	}

	@Override
	public void initData() {
		groundAssets = new Array<AtlasRegion>();
		groundAssets.add(AssetLoader.getInstance().getGroundAsset().getLgrass());
		groundAssets.add(AssetLoader.getInstance().getGroundAsset().getMgrass());
		groundAssets.add(AssetLoader.getInstance().getGroundAsset().getRgrass());
	}

	@Override
	public void drawMap(SpriteBatch batch) {
		for (int i = 0; i < Constants.MAX_WIDTH; i++) {
			 ComposedHelper tempGround = new ComposedHelper(groundAssets);
			 tempGround.drawComposedEntity(batch, Constants.MAX_WIDTH, Constants.LEFT_RIGHT, new Vector2(0, 0),
			 0);
		}
	}

}
