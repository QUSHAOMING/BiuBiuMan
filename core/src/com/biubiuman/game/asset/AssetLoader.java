package com.biubiuman.game.asset;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.biubiuman.game.util.Constants;

/**
 * the resource loader which is Singleton
 * 
 * @author Kimi
 * 
 */
public class AssetLoader implements Disposable, AssetErrorListener {
	private static AssetLoader assetLoader;
	private AssetManager assetManager;
	public GroundAsset groundAsset;
	public HerosAsset herosAsset;
	public IconAsset iconAsset;

	public AssetLoader() {
	}

	public static AssetLoader getInstance() {
		if (assetLoader == null) {
			assetLoader = new AssetLoader();
		}
		return assetLoader;
	}

	/**
	 * Accroding to the path to init the resource we need
	 * 
	 * @param path
	 */
	public void initParam(String path) {
		assetManager = new AssetManager();
		// start load the textures
		assetManager.load(path, TextureAtlas.class);

		// finish loading
		assetManager.finishLoading();

		TextureAtlas atlas = assetManager.get(path);
		if (path.equals(Constants.GROUND_PACK)) {
			groundAsset = new GroundAsset(atlas);
		} else if (path.equals(Constants.HERO_PACK)) {
			herosAsset = new HerosAsset(atlas);
		} else if (path.equals(Constants.ICON_PACK)) {
			iconAsset = new IconAsset(atlas);
		}

	}

	@Override
	public void dispose() {
		Gdx.app.log("Asset log", "assert is disposed");
		assetManager.dispose();
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error("Asset error", "The file couldn't be loaded"
				+ asset.fileName);
	}

	public class GroundAsset {
		public AtlasRegion lgrass;
		public AtlasRegion mgrass;
		public AtlasRegion rgrass;

		public GroundAsset(TextureAtlas atlas) {
			lgrass = atlas.findRegion("lgrass");
			mgrass = atlas.findRegion("mgrass");
			rgrass = atlas.findRegion("rgrass");
		}
	}

	public class HerosAsset {
		public Map<String, Array<AtlasRegion>> allHeros;

		public HerosAsset(TextureAtlas atlas) {
			allHeros.put("hero1", atlas.findRegions("hero1"));
			allHeros.put("hero2", atlas.findRegions("hero2"));
			allHeros.put("hero3", atlas.findRegions("hero3"));

		}

	}

	public class IconAsset {
		public AtlasRegion selectHeroIcon;

		public IconAsset(TextureAtlas atlas) {
			selectHeroIcon = atlas.findRegion("hero");
		}
	}
}
