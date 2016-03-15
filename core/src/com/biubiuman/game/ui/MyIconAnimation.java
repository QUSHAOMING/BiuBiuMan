package com.biubiuman.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.util.Constants;

public class MyIconAnimation extends Actor{
    private Array<TextureRegion> keyFrames;  
    private Animation mAnimation;  
    private float stateTime;  
    private boolean isFinish;
	
	public MyIconAnimation(Array<TextureRegion> keyFrames) {
		this.keyFrames = keyFrames;
		init();
	}
	

	private void init() {
		mAnimation = new Animation(1, keyFrames);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		 stateTime += Gdx.graphics.getDeltaTime();  
	     TextureRegion textureRegion = mAnimation.getKeyFrame(stateTime,true);  
	     batch.draw(textureRegion, getX(), getY(),  
	                textureRegion.getRegionWidth() / 2,  
	                textureRegion.getRegionHeight() / 2,  
	                textureRegion.getRegionWidth(),  
	                textureRegion.getRegionHeight(), getScaleX(), getScaleY(),  
	                getRotation());  
	     if(mAnimation.isAnimationFinished(stateTime)){
	    	 isFinish = true;
	    	 Constants.isShowIcon = true;
	    	 clear();
	     }
	}

	@Override
	public void clear() {
		  super.clear();  
	}

	public boolean isFinish() {
		return isFinish;
	}
	
	
}
