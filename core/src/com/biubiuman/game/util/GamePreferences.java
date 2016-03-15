package com.biubiuman.game.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
	private static  GamePreferences instance ;
	private Preferences prefs;
	
	public static GamePreferences getInstance(){
		if(instance ==null){
			instance  = new GamePreferences();
		}
		return instance; 
	}
	
	public GamePreferences() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(Constants.PREFERENCE);
	}

	public Preferences getPrefs() {
		return prefs;
	}

}
