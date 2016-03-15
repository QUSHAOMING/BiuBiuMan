package com.biubiuman.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.biubiuman.game.util.CommonUtil;

public class MyDialog extends Dialog {

	private TextButton btnConfirm;

	private TextButton btnCanncel;

	private Label content;

	private int type;
	
	public static int CONFIRM =0;
	
	public static int CONFIRM_CANCEL = 1;

	public MyDialog(String title, Skin skin) {
		super(title, skin);
	}

	public MyDialog(String title, Skin skin, float x, float y, float width,
			float height, int type) {
		super(title, skin);
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.type = type;
		init(skin);
	}

	private void init(Skin skin) {
		btnConfirm = new TextButton(CommonUtil.getI18NBundle().get("btnconfirm"),
				skin);

		btnCanncel = new TextButton(
				CommonUtil.getI18NBundle().get("btncancel"), skin);

		content = new Label("", skin);
		this.text(content);
		switch (type) {
		case 0:
			this.addActor(btnConfirm);
			btnConfirm.setX((this.getWidth() - btnConfirm.getWidth()) / 2);
			btnConfirm.setY(5);
			break;
		case 1:
			this.addActor(btnConfirm);
			this.addActor(btnCanncel);
			btnConfirm.setY(5);
			btnCanncel.setY(5);
			break;
		default:
			break;
		}
	}

	public TextButton getBtnConfirm() {
		return btnConfirm;
	}

	public TextButton getBtnCanncel() {
		return btnCanncel;
	}

	public Label getContent() {
		return content;
	}

}
