package com.biubiuman.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.biubiuman.game.util.Constants;

public class MyProgressBar extends Actor implements Disposable {
	private Texture platform;
	private Texture bar;
	private float progress;

	public MyProgressBar() {
		platform = new Texture(Gdx.files.internal("images/black.png"));
		bar = new Texture(Gdx.files.internal("images/green.png"));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(platform, (Constants.GAME_WIDTH - bar.getWidth()) / 2, 10,
				platform.getWidth(), platform.getHeight());
		batch.draw(bar, (Constants.GAME_WIDTH - bar.getWidth()) / 2, 10,
				bar.getWidth() * progress / 100f, bar.getHeight());
	}

	@Override
	public void dispose() {
		platform.dispose();
		bar.dispose();
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public float getProgress() {
		return progress;
	}
	
}
