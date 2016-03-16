package com.biubiuman.game.builder;

import com.badlogic.gdx.Gdx;


public class ObjectBuilder implements Builder{
	private String TAG = this.getClass().getName();
	private ObjectBuilder objectBuilder;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T createObject(Class<T> c) {
		T object = null;
		try {
			object = (T) (Class.forName(c.getName()).newInstance());
		} catch (Exception e) {
			Gdx.app.error(TAG, "object builer is wrong");
		}
		return object;
	}
	
	
	
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
	public ObjectBuilder getInstance() {
		if (objectBuilder == null) {
			objectBuilder = new ObjectBuilder();
		}
		return objectBuilder;
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
