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
 * the resource loader
 * 
 * @author Kimitur
 *
 */
public class AssetLoader implements Disposable, AssetErrorListener {
	private static AssetLoader assetLoader;
	private AssetManager assetManager;
	private GroundAsset groundAsset;
	private HerosAsset herosAsset;
	private IconAsset iconAsset;

	public AssetLoader() {
		initParam();
	}

	public static AssetLoader getInstance() {
		if (assetLoader == null) {
			assetLoader = new AssetLoader();
		}
		return assetLoader;
	}

	private void initParam() {
		assetManager = new AssetManager();
		// start load the textures
		assetManager.load(Constants.GROUND_PACK, TextureAtlas.class);

		// finish loading
		assetManager.finishLoading();

		TextureAtlas atlas = assetManager.get(Constants.GROUND_PACK);

		groundAsset = new GroundAsset(atlas);
		herosAsset = new HerosAsset(atlas);
		iconAsset = new IconAsset(atlas);

	}

	@Override
	public void dispose() {
		Gdx.app.log("Asset log", "assert is disposed");
		assetManager.dispose();
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error("Asset error", "The file couldn't be loaded" + asset.fileName);
	}

	public class GroundAsset {
		private AtlasRegion lgrass;
		private AtlasRegion mgrass;
		private AtlasRegion rgrass;

		public GroundAsset(TextureAtlas atlas) {
			lgrass = atlas.findRegion("lgrass");
			mgrass = atlas.findRegion("mgrass");
			rgrass = atlas.findRegion("rgrass");
		}

		public AtlasRegion getLgrass() {
			return lgrass;
		}

		public AtlasRegion getMgrass() {
			return mgrass;
		}

		public AtlasRegion getRgrass() {
			return rgrass;
		}
	}

	public class HerosAsset {
		private Map<String, Array<AtlasRegion>> allHeros;

		public HerosAsset(TextureAtlas atlas) {
			allHeros.put("hero1", atlas.findRegions("hero1"));
			allHeros.put("hero2", atlas.findRegions("hero2"));
			allHeros.put("hero3", atlas.findRegions("hero3"));

		}

		public Map<String, Array<AtlasRegion>> getAllHeros() {
			return allHeros;
		}

		public void setAllHeros(Map<String, Array<AtlasRegion>> allHeros) {
			this.allHeros = allHeros;
		}

	}

	public class IconAsset {
		private AtlasRegion selectHeroIcon;

		public IconAsset(TextureAtlas atlas) {
			selectHeroIcon = atlas.findRegion("hero");
		}

		public AtlasRegion getSelectHeroIcon() {
			return selectHeroIcon;
		}

	}

	public GroundAsset getGroundAsset() {
		return groundAsset;
	}

	public HerosAsset getHerosAsset() {
		return herosAsset;
	}

	public IconAsset getIconAsset() {
		return iconAsset;
	}

}
