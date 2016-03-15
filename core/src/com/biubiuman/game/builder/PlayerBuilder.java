package com.biubiuman.game.builder;

import com.badlogic.gdx.Gdx;

public class PlayerBuilder implements Builder {
	private String TAG = this.getClass().getName();
	private PlayerBuilder playerBuilder;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T createObject(Class<T> c) {
		T player = null;
		try {
			player = (T) (Class.forName(c.getName()).newInstance());
		} catch (Exception e) {
			Gdx.app.error(TAG, "player builer is wrong");
		}
		return player;
	}

	public PlayerBuilder getInstance() {
		if (playerBuilder == null) {
			playerBuilder = new PlayerBuilder();
		}
		return playerBuilder;
	}

}
