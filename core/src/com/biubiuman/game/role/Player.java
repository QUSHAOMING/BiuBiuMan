package com.biubiuman.game.role;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.util.Constants;
import com.biubiuman.game.util.MathUtil;

public class Player extends GameRole {
	private Array<AtlasRegion> hero;
	private Animation heroAni;
	private float stateTime;
	@Override
	public void initData() {
		AssetLoader.getInstance().initParam(Constants.HERO_PACK);
		hero = AssetLoader.getInstance().herosAsset.allHeros.get("hero1");
		heroAni = new Animation(0.2f, hero);
		this.setWidth(hero.get(0).getRegionWidth());
		this.setHeight(hero.get(0).getRegionHeight());
	}

	@Override
	public void drawRole(Batch batch) {
		stateTime += Gdx.graphics.getDeltaTime();
		TextureRegion temp = heroAni.getKeyFrame(stateTime,true);
		batch.draw(temp, currentX, currentY, 0, 0, temp.getRegionWidth(),
				temp.getRegionHeight(), 1, 1, 0);
		handleInput();
	}
	public void handleInput() {
		Vector2 currentPostion = MathUtil.handeInput(new Vector2(currentX, currentY));
		currentX = currentPostion.x;
		currentY = currentPostion.y;
	}
}
