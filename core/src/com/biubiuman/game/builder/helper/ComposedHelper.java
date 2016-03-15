package com.biubiuman.game.builder.helper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.biubiuman.game.util.Constants;

public class ComposedHelper {
	private Array<AtlasRegion> atlasRegions;
	private Vector2 position;
	private Vector2 area;

	public ComposedHelper() {
	}

	public ComposedHelper(Array<AtlasRegion> atlasRegions) {
		this.atlasRegions = atlasRegions;
	}

	public void drawComposedEntity(SpriteBatch batch, int middleNumber, int mode, Vector2 position, int rotation) {
		Array<AtlasRegion> temp = atlasRegions;
		Vector2 tempArea = new Vector2(0, 0);
		if (mode == Constants.LEFT_RIGHT) {
			batch.draw(temp.get(0), position.x, position.y, 0, 0, temp.get(0).getRegionWidth(),
					temp.get(0).getRegionHeight(), 0, 0, rotation);
			for (int i = 1; i < middleNumber; i++) {
				tempArea.x = temp.get(0).getRegionWidth() + temp.get(1).getRegionWidth() * (i - 1);
				tempArea.y = temp.get(0).getRegionHeight();
				batch.draw(temp.get(1), position.x + tempArea.x, position.y, 0, 0, temp.get(1).getRegionWidth(),
						temp.get(1).getRegionHeight(), 0, 0, rotation);
			}
			tempArea.x = temp.get(0).getRegionWidth() + temp.get(1).getRegionWidth() * middleNumber;
			batch.draw(temp.get(2), position.x + tempArea.x, position.y, 0, 0, temp.get(2).getRegionWidth(),
					temp.get(2).getRegionHeight(), 0, 0, rotation);

		} else if (mode == Constants.MIDDLE_HORIZONTAL) {

		} else if (mode == Constants.RIGHT_LEFT) {

		} else if (mode == Constants.TOP_BOTTOM) {

		} else if (mode == Constants.MIDDLE_VERTICAL) {

		} else if (mode == Constants.BOTTOM_TOP) {
			batch.draw(temp.get(0), position.x, position.y, 0, 0, temp.get(0).getRegionWidth(),
					temp.get(0).getRegionHeight(), 0, 0, rotation);
			for (int i = 1; i < middleNumber; i++) {
				tempArea.x = temp.get(0).getRegionWidth();
				tempArea.y = temp.get(0).getRegionHeight() + temp.get(1).getRegionHeight() * (i - 1);
				batch.draw(temp.get(1), position.x, position.y + tempArea.y, 0, 0, temp.get(1).getRegionWidth(),
						temp.get(1).getRegionHeight(), 0, 0, rotation);
			}
			tempArea.y = temp.get(0).getRegionHeight() + temp.get(1).getRegionHeight() * middleNumber;
			batch.draw(temp.get(2), position.x, position.y + tempArea.y, 0, 0, temp.get(2).getRegionWidth(),
					temp.get(2).getRegionHeight(), 0, 0, rotation);

		}
		area = tempArea;
		this.position = position;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getArea() {
		return area;
	}

	public void setArea(Vector2 area) {
		this.area = area;
	}

}
