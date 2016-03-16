package com.biubiuman.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameMap {
	
	public abstract void initData();

	public abstract void drawMap(SpriteBatch batch);
}
