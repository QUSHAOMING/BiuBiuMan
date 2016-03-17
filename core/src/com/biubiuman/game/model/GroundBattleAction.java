package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.biubiuman.game.map.two.GrassMap;

public class GroundBattleAction extends BattleAction {
	private GrassMap grassMap;
	
	public GroundBattleAction() {
	}

	public GroundBattleAction(int[] groundTypes) {

	}

	public GroundBattleAction(int[] groundTypes, int[] environments) {

	}

	@Override
	public void show() {
		initScene();
	}
	
	private void initScene() {
		container = new Stage();
		grassMap = new GrassMap();
		container.addActor(grassMap);
//		Gdx.app.log("random", MathUtils.floor((float) 10.9)+"");
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		container.act();
		container.draw();
	}
	
	
}
