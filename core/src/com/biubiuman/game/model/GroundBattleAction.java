package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.map.GameMap;
import com.biubiuman.game.map.two.GrassMap;

public class GroundBattleAction extends BattleAction {
	private GameMap map;
	
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
		map = ObjectBuilder.getInstance().createObject(GrassMap.class);
		container.addActor((GrassMap)map);
//		Gdx.app.log("random", MathUtils.floor((float) 10.9)+"");
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		container.act();
		container.draw();
	}
	
	
}
