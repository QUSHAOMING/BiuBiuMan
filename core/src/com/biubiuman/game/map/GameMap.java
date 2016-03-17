package com.biubiuman.game.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameMap extends Actor {
	
	public GameMap() {
		initData();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		drawMap(batch);
	}

	public abstract void initData();

	public abstract void drawMap(Batch batch);
}
