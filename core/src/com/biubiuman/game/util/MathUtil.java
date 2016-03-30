package com.biubiuman.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class MathUtil {

	//
	public static int passEnable(float x, float y, int[][] barriers, float width, float height) {
		if ((barriers[(int) (y / height)][(int) (x / width)] == 1)) {
			return 1;
		} else if ((barriers[(int) (y / height)][(int) (x / width + 1)] == 1)) {
			return 2;
		} else if ((barriers[(int) (y / height + 1)][(int) (x / width)] == 1)) {
			return 3;
		} else if ((barriers[(int) (y / height -0.1f)][(int) (x / width)] == 1)) {
			return 4;
		}
		return 0;
	}

	public static boolean collideTheBorder(float x, float y, int[][] barriers, float width, float height) {
		if ((barriers[(int) (y / height)][(int) (x / width - 0.1f)] == 1 && (int) (x / width - 0.1f) == 0)
				|| (barriers[(int) (y / height)][(int) (x / width + 1 + 0.1f)] == 1
						&& (int) (x / width + 1 + 0.1f) == Constants.MAX_WIDTH - 1)
				|| (barriers[(int) (y / height - 0.1f)][(int) (x / width)] == 1 && (int) (y / height - 0.1f) == 0)
				|| (barriers[(int) (y / height + 1 + 0.1f)][(int) (x / width)] == 1
						&& (int) (y / height + 1 + 0.1f) == Constants.MAX_HEIGHT - 1)) {
			return true;
		}
		return false;
	}

	public static Vector2 handeInput(Vector2 currentPostion) {

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			currentPostion.x -= Constants.speed;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			currentPostion.x += Constants.speed;
		}
		// if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
		// currentPostion.y -= 10;
		// }
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			currentPostion.y += Constants.jumpHigh;
		}
		return currentPostion;
	}

}
