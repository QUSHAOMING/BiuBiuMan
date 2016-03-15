package com.biubiuman.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.ui.MyProgressBar;
import com.biubiuman.game.util.Constants;

import io.netty.channel.Channel;

public class LoadingScreen extends AbstractScreen {
	private String TAG = this.getClass().getName();
	private MyProgressBar bar;
	private Image bg;
	
	private Image enterClick;

	public LoadingScreen(DirectedGame game,Channel ch) {
		super(game,ch);
	}

	@Override
	public void show() {
		stage = new Stage(new ScalingViewport(Scaling.fit,
				Constants.GAME_WIDTH, Constants.GAME_HEIGHT,
				new OrthographicCamera()));

		Gdx.input.setInputProcessor(stage);

		bar = new MyProgressBar();
		bg = new Image(new Texture("images/after_login_loading.png"));
		enterClick = new Image(new Texture("images/after_loading_click.png"));
		stage.addActor(bg);
		stage.addActor(bar);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		if (bar.getProgress() < 100)
			bar.setProgress(bar.getProgress() + 0.5f);
		// ��������
		if (bar.getProgress() == 100)
		{
			stage.clear();
			stage.addActor(enterClick);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		bar.dispose();
	}

	@Override
	public InputProcessor getInputProcessor() {
		return stage;
	}


}
