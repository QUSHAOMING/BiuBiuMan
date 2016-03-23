package com.biubiuman.game.map;

import com.biubiuman.game.map.two.GrassMap;

/**
 * it uses to create the map and create a file  
 * @author kimi
 *
 */
public class MapEditor {
	
	public static void main(String[] args) {
		try {
			System.out.println(Class.forName(GrassMap.class.getName()));
			System.out.println(Class.forName(GrassMap.class.getName()).newInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createMap(){
		
	}
}
