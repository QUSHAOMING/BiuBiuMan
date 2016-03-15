package com.biubiuman.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.biubiuman.game.DirectedGame;

import io.netty.channel.Channel;

public class CityOfSkyScreen extends AbstractScreen{

	public CityOfSkyScreen(DirectedGame game ,Channel ch) {
		super(game,ch);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		
	}

	@Override
	public InputProcessor getInputProcessor() {
		return stage;
	}


}
