package com.biubiuman.game.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.asset.AssetLoader;
import com.biubiuman.game.builder.helper.ComposedHelper;
import com.biubiuman.game.map.GameMap;
import com.biubiuman.game.util.Constants;

import sun.print.resources.serviceui;

public class BattleMapBuilder implements Builder{
	private String TAG = this.getClass().getName();
	private BattleMapBuilder battleMapBuilder;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T createObject(Class<T> c) {
		T map = null;
		try {
			map = (T) (Class.forName(c.getName()).newInstance());
		} catch (Exception e) {
			Gdx.app.error(TAG, "map builer is wrong");
		}
		return map;
	}
	
	
	// private Array<ComposedHelper> groundInMap;
	// private Array<ComposedHelper> wallInMap;
	// private Array<ComposedHelper> ceilingInMap;
	// private Array<AtlasRegion> groundAssets;
	// private int mapType;
	// private int environment;
	// private int ground;
	// private int wall;
	// private int ceiling;
	// private int step;
	//
	// // random number
	// private int randomNumberEmpty;
	// private int randomNumberDraw;
	// private int randomNumberTrap;
	// private int[] randomNumberMiddles;
	//
	// public BattleMapBuilder() {
	// this(0);
	// }
	//
	// public BattleMapBuilder(int mapType) {
	// this(mapType, null);
	// }
	//
	// public BattleMapBuilder(int mapType, int[] param) {
	// this.mapType = mapType;
	// if (param != null) {
	// this.environment = param[0];
	// this.ground = param[1];
	// this.wall = param[2];
	// this.ceiling = param[3];
	// this.step = param[4];
	// }
	// initData();
	// }
	//
	// public void initData(){
	// if (ground == Constants.GROUND_PLAIN) {
	// groundAssets = new Array<AtlasRegion>();
	// groundAssets.add(AssetLoader.getInstance().getGroundAsset().getLgrass());
	// groundAssets.add(AssetLoader.getInstance().getGroundAsset().getMgrass());
	// groundAssets.add(AssetLoader.getInstance().getGroundAsset().getRgrass());
	// }
	// }
	//
	public BattleMapBuilder getInstance() {
		if (battleMapBuilder == null) {
			battleMapBuilder = new BattleMapBuilder();
		}
		return battleMapBuilder;
	}
	//
	// private void calculateRandomNumber() {
	// randomNumberEmpty = MathUtils.random(Constants.MAX_EMPTY);
	// randomNumberTrap = MathUtils.random(Constants.MAX_TRAP);
	// int left = Constants.MAX_WIDTH - randomNumberEmpty - randomNumberTrap;
	// randomNumberDraw = MathUtils.floor(left / 3);
	// randomNumberMiddles = new int[randomNumberDraw];
	// int tempSumMiddle = 0;
	// int i = 0;
	// while (i <= randomNumberDraw) {
	// int tempMiddle = MathUtils.random(left);
	// tempSumMiddle += tempMiddle;
	//
	// if (tempSumMiddle <= left) {
	// randomNumberMiddles[i] = tempMiddle;
	// } else {
	// randomNumberMiddles[i] = 0;
	// }
	// i++;
	// }
	// if (left > tempSumMiddle) {
	// int temp = MathUtils.random(randomNumberDraw);
	// randomNumberMiddles[temp] += randomNumberMiddles[temp] + (left -
	// tempSumMiddle);
	// }
	// }
	//
	// private void drawMap(SpriteBatch batch){
	// groundInMap = new Array<ComposedHelper>();
	// for (int i = 0; i < randomNumberDraw; i++) {
	// ComposedHelper tempGround = new ComposedHelper(groundAssets);
	//// tempGround.drawComposedEntity(batch, middleNumber, mode, position,
	// rotation);
	//
	// }
	// }
}
