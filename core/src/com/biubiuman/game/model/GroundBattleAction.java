package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GroundBattleAction extends BattleAction {
	
	
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
		Gdx.app.log("random", MathUtils.floor((float) 10.9)+"");
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
	}
	
	
}
