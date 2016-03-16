package com.biubiuman.game.map.two;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.builder.helper.ComposedHelper;
import com.biubiuman.game.map.GameMap;

public abstract class GameMap2D implements GameMap {

	protected Array<ComposedHelper> groundInMap;
	protected Array<ComposedHelper> wallInMap;
	protected Array<ComposedHelper> ceilingInMap;
	protected Array<AtlasRegion> groundAssets;
	
}
