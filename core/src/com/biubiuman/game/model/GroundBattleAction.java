package com.biubiuman.game.model;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.map.GameMap;
import com.biubiuman.game.map.two.GrassMap;

public class GroundBattleAction extends BattleAction {
	private GameMap map;
	
	public GroundBattleAction() {
	}

	public GroundBattleAction(int type) {

	}



	@Override
	public void show() {
		initScene();
	}
	
	private void initScene() {
		container = new Stage();
		map = ObjectBuilder.getInstance().createObject(GrassMap.class);
		container.addActor((GrassMap)map);
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		container.act();
		container.draw();
	}
	
	
}
