package com.biubiuman.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.map.two.GrassMap;
import com.biubiuman.game.role.Player;
import com.biubiuman.game.screen.LoginScreen;
import com.biubiuman.game.util.Constants;
import com.biubiuman.game.util.MathUtil;

public class GroundBattleAction extends BattleAction {

	public GroundBattleAction() {
	}

	public GroundBattleAction(int type, DirectedGame game) {
		super(type, game);
	}

	@Override
	public void show() {
		if (type == Constants.GROUND_GRASS) {
			initScene(new GrassMap(), new Player());
		}
	}

	@Override
	public void render(float delta) {
		if (!isGameOver()) {
			super.render(delta);
			container.act();
			container.draw();
			setGravity();
<<<<<<< Updated upstream
=======
			setCollision();
>>>>>>> Stashed changes
		} else {
			Gdx.gl.glClearColor(0.3f, 0.3f, 0.2f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			System.out.println("Game over!");
		}
	}

	public void setGravity() {
<<<<<<< Updated upstream
		if (player != null
				&& MathUtil.downEnable(player.currentX, player.currentY,
						barriers, player.getWidth(), player.getHeight())) {
			player.currentY -= 10;
		}
	}

	public boolean isGameOver() {
		return MathUtil.collideTheBorder(player.currentX, player.currentY,
				barriers, player.getWidth(), player.getHeight());
=======
		if (player != null) {
			player.currentY -= 10;
		}
	}

	public void setCollision() {
		if (player != null) {
			int collideIndex = MathUtil.passEnable(player.currentX, player.currentY, barriers, player.getWidth(),
					player.getHeight());
			if (collideIndex == 1) {
				player.currentX += 10;
			} else if (collideIndex == 2) {
				player.currentX -= 10;
			} else if (collideIndex == 3) {
				player.currentY -= 10;
			}else{
				player.currentY += 10;
			}
		}
	}

	public boolean isGameOver() {
		return MathUtil.collideTheBorder(player.currentX, player.currentY, barriers, player.getWidth(),
				player.getHeight());
>>>>>>> Stashed changes
	}
}
