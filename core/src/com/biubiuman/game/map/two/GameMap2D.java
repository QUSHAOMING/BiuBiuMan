package com.biubiuman.game.map.two;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.builder.helper.ComposedHelper;
import com.biubiuman.game.map.GameMap;
import com.biubiuman.game.util.Constants;

public abstract class GameMap2D extends GameMap {

	protected Array<ComposedHelper> groundInMap;
	protected Array<ComposedHelper> wallInMap;
	protected Array<ComposedHelper> ceilingInMap;
	protected Array<AtlasRegion> groundAssets;
	protected int[][] mapSave;

	@Override
	public void initData() {
		groundAssets = new Array<AtlasRegion>();
		mapSave = new int[Constants.MAX_WIDTH][Constants.MAX_HEIGHT];
	}

}
