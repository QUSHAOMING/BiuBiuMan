package com.biubiuman.game.role;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public abstract class GameRole extends Actor {
	public float currentX;
	public float currentY;
	protected Array<AtlasRegion> player;
	
	public GameRole() {
		initData();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		drawRole(batch);
	}

	public abstract void initData();

	public abstract void drawRole(Batch batch);
}
