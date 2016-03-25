package com.biubiuman.game.util;

import com.badlogic.gdx.math.MathUtils;

public class MathUtil {
	
	//
	public static boolean passEnable(float x, float y,int[][] barriers,float width,float height){
	//+0.5
	int col = MathUtils.round(y/width);
	int row = MathUtils.round(x/height);
	boolean flag = barriers[col][row] == 0;
	return flag;
	}

	//
	public static boolean downEnable(float x, float y,int[][] barriers,float width,float height) {
	//+0.5
	boolean flag = barriers[(int) ((y/height-0.1f))][(int) (x/width+0.5f)] == 0;
	return flag;
	}
	
}
