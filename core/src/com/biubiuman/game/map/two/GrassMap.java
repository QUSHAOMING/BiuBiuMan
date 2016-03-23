package com.biubiuman.game.map.two;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.builder.helper.ComposedHelper;
import com.biubiuman.game.util.Constants;

public class GrassMap extends GameMap2D {
	@Override
	public void initData() {
		super.initData();
		AssetLoader.getInstance().initParam(Constants.GROUND_PACK);
		groundAssets.add(AssetLoader.getInstance().groundAsset.lgrass);
		groundAssets.add(AssetLoader.getInstance().groundAsset.mgrass);
		groundAssets.add(AssetLoader.getInstance().groundAsset.rgrass);
	}

	@Override
	public void drawMap(Batch batch) {
		for (int i = 0; i < Constants.MAX_WIDTH; i++) {
			 ComposedHelper tempGround = new ComposedHelper(groundAssets);
			 tempGround.drawComposedEntity(batch, Constants.MAX_WIDTH-2, Constants.LEFT_RIGHT, new Vector2(0, 0),
			 0);
		}
	}

}
