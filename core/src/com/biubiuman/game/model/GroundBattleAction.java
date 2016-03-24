package com.biubiuman.game.model;

import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.map.two.GameMap2D;
import com.biubiuman.game.map.two.GrassMap;

public class GroundBattleAction extends BattleAction {
	private GameMap2D map;

	public GroundBattleAction() {
	}

	public GroundBattleAction(int type) {

	}

	@Override
	public void show() {
		super.show();
	}

	@Override
	protected void initScene() {
		super.initScene();
		map = ObjectBuilder.getInstance().createObject(GrassMap.class);
		container.addActor((GrassMap) map);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		container.act();
		map.getMapRenderer().setView(camera);
		container.draw();
	}

}
