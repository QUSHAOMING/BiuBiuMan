package com.biubiuman.game.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.I18NBundle;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.screen.LoadingScreen;
import com.biubiuman.game.ui.MyDialog;

import io.netty.channel.Channel;

public class CommonUtil {
	private static String TAG = "CommonUtil";

	private static I18NBundle i18nBundle;

	private static MyDialog dlHint;

	private static Label lbHint;

	private static Skin skin;

	public static I18NBundle getI18nBundle(Locale locale) {
		return I18NBundle.createBundle(Gdx.files.internal("i18n/biubiuman"),
				locale);
	}

	public static boolean checkNet() {
		return false;
	}

	public static I18NBundle getI18NBundle() {
		if (i18nBundle == null) {
			String language = GamePreferences.getInstance().getPrefs()
					.getString("language", "");
			String country = GamePreferences.getInstance().getPrefs()
					.getString("country", "");
			i18nBundle = getI18nBundle(new Locale(language, country));
		}
		return i18nBundle;
	}

	public static MyDialog getdlHint(Skin skin) {
		if (dlHint == null) {
			dlHint = new MyDialog("\n\n    "
					+ CommonUtil.getI18NBundle().get("hint"), skin,
					(Constants.GAME_WIDTH - 300) / 2,
					(Constants.GAME_HEIGHT - 300) / 2, 300, 300,
					MyDialog.CONFIRM);
		}

		return dlHint;
	}

	public static Skin getMySkin() {
		if (skin == null) {
			skin = new Skin(Gdx.files.internal(Constants.JSON),
					new TextureAtlas(Constants.UI_PACK));
		}
		return skin;
	}

	public static Label getlbHint(Skin skin) {
		if (lbHint == null) {
			lbHint = dlHint.getContent();
		}
		return lbHint;
	}

	public static boolean judgeUserName(String userName) {
		if (userName.isEmpty()) {
			dlHint.setVisible(true);
			lbHint.setText(getI18NBundle().get("usernameisnull"));
		} else {
			Pattern userNamePattern = Pattern.compile("\\w{6,12}");
			Matcher matcher = userNamePattern.matcher(userName);
			if (matcher.matches()) {
				return true;
			} else {
				dlHint.setVisible(true);
				lbHint.setText(getI18NBundle().get("usernameiserror"));
			}

		}
		return false;
	}

	public static boolean judgePassword(String password) {
		if (password.isEmpty()) {
			dlHint.setVisible(true);
			lbHint.setText(CommonUtil.getI18NBundle().get("passwordisnull"));
		} else {
			Pattern passwordPattern = Pattern.compile(".{6,12}");
			Matcher matcher = passwordPattern.matcher(password);
			if (matcher.matches()) {
				return true;
			} else {
				dlHint.setVisible(true);
				lbHint.setText(CommonUtil.getI18NBundle()
						.get("passwordiserror"));
			}
		}
		return false;
	}

	public static boolean judgeConfirmPassword(String confirmPassword,
			String password) {
		if (confirmPassword.equals(password)) {
			return true;
		} else {
			dlHint.setVisible(true);
			lbHint.setText(CommonUtil.getI18NBundle().get(
					"confirmpasswordiserror"));
			return false;
		}
	}

	public static boolean judgeTelephone(String telephone) {
		Pattern passwordPattern = Pattern.compile("\\d{11}");
		Matcher matcher = passwordPattern.matcher(telephone);
		if (matcher.matches()) {
			return true;
		} else {
			dlHint.setVisible(true);
			lbHint.setText(CommonUtil.getI18NBundle().get("telephoneiserror"));
		}
		return false;
	}

	public static void showClose(Image[] c1, Image c2, String t) {
		for (int i = 0; i < c1.length; i++) {
			c1[i].setVisible(false);
		}
		if (!t.isEmpty()) {
			c2.setVisible(true);
		} else {
			c2.setVisible(false);
		}

	}

	public static void checkEmpty(Image c, String t) {
		if (!t.isEmpty()) {
			c.setVisible(true);
		} else {
			c.setVisible(false);
		}
	}

	public static void clear(TextField tx, Image c) {
		tx.setText("");
		c.setVisible(false);
	}

	public static void enterGame(DirectedGame game,Channel ch) {
		game.setScreen(new LoadingScreen(game,ch));
	}

	public static void dispose() {
		if (skin != null) {
			skin.dispose();
			skin = null;
			dlHint = null;
			i18nBundle = null;
			lbHint = null;
		}
	}

}
