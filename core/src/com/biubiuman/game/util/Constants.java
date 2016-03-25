package com.biubiuman.game.util;

/**
 * this is the class for all static constant
 * 
 * @author kimi
 * 
 */
public class Constants {
	// GAME WIDTH
	public static int GAME_WIDTH = 800;
	// GAME HEIGHT
	public static int GAME_HEIGHT = 480;

	/**
	 * image address
	 */
	// UI image resources
	public static String UI_PACK = "images/ui.pack";
	// ground image resources
	public static String GROUND_PACK = "images/grounds.pack";
	// hero image resources
	public static String HERO_PACK = "images/heros.pack";
	// icon image resources
	public static String ICON_PACK = "images/icons.pack";
	
	/**
	 * map address
	 */
	// map01
	public static String MAP_01= "maps/map01.tmx";
	// AFTER
	// btn
	public static int LOGIN_BTN = 0;

	public static int REGIST_BTN = 1;

	public static int BACK_BTN = 3;

	public static int CONFIRM_BTN = 2;

	public static int CLEAR_USERNAME_BTN = 4;

	public static int CLEAR_PW_BTN = 5;

	public static int CLEAR_CFPW_BTN = 6;

	public static int CLEAR_TL_BTN = 7;

	// TF
	public static int USERNAME_TF = 101;

	public static int PASSWORD_TF = 102;

	public static int COMFIRMPW_TF = 103;

	public static int TELEPHONE_TF = 104;

	// server address
	public static String SERVER = "http://localhost:8080/AppServer/";

	public static String FILTER = ".do";

	// Json address
	public static String JSON = "jsons/init.json";

	// preference address
	public static String PREFERENCE = "userdata";

	// common variable
	public static boolean hasNet = false;

	public static boolean isShowIcon = false;

	// BEFORE

	// sort type
	public static int LEFT_RIGHT = 0;

	public static int MIDDLE_HORIZONTAL = 1;

	public static int RIGHT_LEFT = 2;

	public static int TOP_BOTTOM = 3;

	public static int MIDDLE_VERTICAL = 4;

	public static int BOTTOM_TOP = 5;

	// Map type
	public static int MAP_GRASS = 0;
	// MAX GAME BLOCK NUMBER
	public static int MAX_HEIGHT = 40;

	public static int MAX_WIDTH = 50;
	// MAX GAME EMPTY NUMBER
	public static int MAX_EMPTY = 5;
	// MAX GAME TRAP NUMBER
	public static int MAX_TRAP = 5;

	public static int MAP_TYPE_EMPTY = 0;

	public static int MAP_TYPE_LAND = 1;

	public static int MAP_TYPE_WATER = 2;

	public static int MAP_TYPE_WALL = 3;

	public static int MAP_TYPE_CELLING = 4;

	public static int MAP_TYPE_BLOCK = 5;

}
