package com.biubiuman.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameMap  extends Actor{
	
	public abstract void initData();

	public abstract void drawMap(SpriteBatch batch);
}
