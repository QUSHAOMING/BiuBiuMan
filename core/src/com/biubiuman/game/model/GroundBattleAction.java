package com.biubiuman.game.model;

import com.biubiuman.game.map.two.GrassMap;
import com.biubiuman.game.role.Player;

public class GroundBattleAction extends BattleAction {

	public GroundBattleAction() {
	}

	public GroundBattleAction(int type) {

	}

	@Override
	public void show() {
		initScene(new GrassMap(), new Player());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		container.act();
		container.draw();
	}

}
