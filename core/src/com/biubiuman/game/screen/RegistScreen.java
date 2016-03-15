package com.biubiuman.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.biubiuman.bean.User;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.util.CommonUtil;
import com.biubiuman.game.util.Constants;

import io.netty.channel.Channel;

public class RegistScreen extends AbstractScreen {
	private String TAG = "regist";
	private TextField tfUserName;
	private TextField tfPassword;
	private TextField tfConfirmPassword;
	private TextField tfTelephone;
	private boolean regist;

	private Image[] clears;

	public RegistScreen(DirectedGame game,Channel ch) {
		super(game,ch);
	}

	@Override
	public void show() {
		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = new Skin(Gdx.files.internal(Constants.JSON), new TextureAtlas(
				Constants.UI_PACK));

		Label lbUserName = new Label(
				CommonUtil.getI18NBundle().get("username"), skin);
		lbUserName
				.setX((Constants.GAME_WIDTH - lbUserName.getWidth()) / 2 - 130);
		lbUserName.setY(350);
		lbUserName.setWidth(50);
		lbUserName.setHeight(30);

		tfUserName = new TextField("", skin);
		tfUserName
				.setX((Constants.GAME_WIDTH - tfUserName.getWidth()) / 2 + 30);
		tfUserName.setY(350);
		tfUserName.setWidth(200);
		tfUserName.setHeight(30);

		Label lbPassword = new Label(
				CommonUtil.getI18NBundle().get("password"), skin);
		lbPassword
				.setX((Constants.GAME_WIDTH - lbPassword.getWidth()) / 2 - 130);
		lbPassword.setY(300);
		lbPassword.setWidth(50);
		lbPassword.setHeight(30);

		tfPassword = new TextField("", skin);
		tfPassword.setPasswordMode(true);
		tfPassword.setPasswordCharacter('*');
		tfPassword
				.setX((Constants.GAME_WIDTH - tfPassword.getWidth()) / 2 + 30);
		tfPassword.setY(300);
		tfPassword.setWidth(200);
		tfPassword.setHeight(30);

		Label lbConfirmPassword = new Label(CommonUtil.getI18NBundle().get(
				"confirmpassword"), skin);
		lbConfirmPassword.setX((Constants.GAME_WIDTH - lbConfirmPassword
				.getWidth()) / 2 - 130);
		lbConfirmPassword.setY(250);
		lbConfirmPassword.setWidth(50);
		lbConfirmPassword.setHeight(30);

		tfConfirmPassword = new TextField("", skin);
		tfConfirmPassword.setPasswordMode(true);
		tfConfirmPassword.setPasswordCharacter('*');
		tfConfirmPassword.setX((Constants.GAME_WIDTH - tfConfirmPassword
				.getWidth()) / 2 + 30);
		tfConfirmPassword.setY(250);
		tfConfirmPassword.setWidth(200);
		tfConfirmPassword.setHeight(30);

		Label lbTelephone = new Label(CommonUtil.getI18NBundle().get(
				"telephone"), skin);
		lbTelephone
				.setX((Constants.GAME_WIDTH - lbTelephone.getWidth()) / 2 - 130);
		lbTelephone.setY(200);
		lbTelephone.setWidth(50);
		lbTelephone.setHeight(30);

		tfTelephone = new TextField("", skin);
		tfTelephone
				.setX((Constants.GAME_WIDTH - tfTelephone.getWidth()) / 2 + 30);
		tfTelephone.setY(200);
		tfTelephone.setWidth(200);
		tfTelephone.setHeight(30);

		TextButton btnRegist = new TextButton(CommonUtil.getI18NBundle().get(
				"btnregist"), skin);
		btnRegist.setX(260);
		btnRegist.setY(130);
		btnRegist.setWidth(80);
		btnRegist.setHeight(40);

		TextButton btnBack = new TextButton(CommonUtil.getI18NBundle().get(
				"btnback"), skin);
		btnBack.setX(400);
		btnBack.setY(130);
		btnBack.setWidth(80);
		btnBack.setHeight(40);

		dlHint = CommonUtil.getdlHint(skin);

		TextButton btnConfirm = dlHint.getBtnConfirm();

		clears = new Image[4];
		for (int i = 0; i < clears.length; i++) {
			clears[i] = new Image(new TextureRegionDrawable(new TextureRegion(
					new Texture("images/btn_clear.png"))));
		}

		clears[0].setX((Constants.GAME_WIDTH + tfUserName.getWidth()) / 2 + 30);
		clears[0].setY(355);

		clears[1].setX((Constants.GAME_WIDTH + tfPassword.getWidth()) / 2 + 30);
		clears[1].setY(305);

		clears[2]
				.setX((Constants.GAME_WIDTH + tfConfirmPassword.getWidth()) / 2 + 30);
		clears[2].setY(255);

		clears[3]
				.setX((Constants.GAME_WIDTH + tfTelephone.getWidth()) / 2 + 30);
		clears[3].setY(205);

		lbHint = CommonUtil.getlbHint(skin);

		stage.addActor(btnRegist);
		stage.addActor(btnBack);
		stage.addActor(lbUserName);
		stage.addActor(tfUserName);
		stage.addActor(lbPassword);
		stage.addActor(tfPassword);
		stage.addActor(lbConfirmPassword);
		stage.addActor(tfConfirmPassword);
		stage.addActor(lbTelephone);
		stage.addActor(tfTelephone);

		for (int i = 0; i < clears.length; i++) {
			stage.addActor(clears[i]);
			clears[i].setVisible(false);
			clears[i].addListener(new MyClickListener(
					Constants.CLEAR_USERNAME_BTN + i));
		}

		stage.addActor(dlHint);
		dlHint.setVisible(false);

		btnBack.addListener(new MyClickListener(Constants.BACK_BTN));

		btnConfirm.addListener(new MyClickListener(Constants.CONFIRM_BTN));

		btnRegist.addListener(new MyClickListener(Constants.REGIST_BTN));

		tfUserName.addListener(new MyClickListener(Constants.USERNAME_TF));

		tfPassword.addListener(new MyClickListener(Constants.PASSWORD_TF));

		tfConfirmPassword.addListener(new MyClickListener(
				Constants.COMFIRMPW_TF));

		tfTelephone.addListener(new MyClickListener(Constants.TELEPHONE_TF));

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0.7f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		super.render(delta);
	}

	private void backOpt() {
		game.setScreen(new LoginScreen(game,ch));

	}

	private void confimrOpt() {
		if (!regist) {
			dlHint.setVisible(false);
			lbHint.setText("");
		} else {
			// �M���[�򣬁K���xȡ�[�򔵓�������username�ķ��������xȡ�Ñ��Ĕ���
			regist = false;
			CommonUtil.enterGame(game,ch);

		}
	}

	private void registOpt() {

		HttpRequest request = new HttpRequest(HttpMethods.POST);

		request.setUrl(Constants.SERVER + TAG + Constants.FILTER);

		Json json = new Json();

		User user = new User();
		String userName = tfUserName.getText().trim();
		String password = tfPassword.getText().trim();
		String comfirmPassword = tfConfirmPassword.getText().trim();
		String telephone = tfTelephone.getText().trim();

		if (CommonUtil.judgeUserName(userName)
				&& CommonUtil.judgePassword(password)
				&& CommonUtil.judgeConfirmPassword(comfirmPassword, password)
				&& CommonUtil.judgeTelephone(telephone)) {
			user.setUserName('"' + userName + '"');
			user.setPassword('"' + password + '"');
			user.setTelephone(telephone);
			request.setHeader("user", json.toJson(user));
			Gdx.net.sendHttpRequest(request, new MyHttpResponseListener());
		}
	}

	private class MyClickListener extends ClickListener {
		private int id;

		public MyClickListener(int id) {
			this.id = id;
		}

		@Override
		public void clicked(InputEvent event, float x, float y) {
			switch (id) {
			// regist
			case 1:
				registOpt();
				break;
			// confirm
			case 2:
				confimrOpt();
				break;
			case 3:
				backOpt();
				break;
			case 4:
				CommonUtil.clear(tfUserName, clears[0]);
				break;
			case 5:
				CommonUtil.clear(tfPassword, clears[1]);
				break;
			case 6:
				CommonUtil.clear(tfConfirmPassword, clears[2]);
				break;
			case 7:
				CommonUtil.clear(tfTelephone, clears[3]);
				break;
			// back
			default:
				break;
			}

			super.clicked(event, x, y);
		}

		@Override
		public boolean keyTyped(InputEvent event, char character) {
			switch (id) {
			case 101:
				CommonUtil.checkEmpty(clears[0], tfUserName.getText());
				break;
			case 102:
				CommonUtil.checkEmpty(clears[1], tfPassword.getText());
				break;
			case 103:
				CommonUtil.checkEmpty(clears[2], tfConfirmPassword.getText());
				break;
			case 104:
				CommonUtil.checkEmpty(clears[3], tfTelephone.getText());
				break;
			default:
				break;
			}
			return super.keyTyped(event, character);
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer,
				int button) {
			switch (id) {
			case 101:
				CommonUtil.showClose(clears, clears[0], tfUserName.getText());
				break;
			case 102:
				CommonUtil.showClose(clears, clears[1], tfUserName.getText());
				break;
			case 103:
				CommonUtil.showClose(clears, clears[2], tfUserName.getText());
				break;
			case 104:
				CommonUtil.showClose(clears, clears[3], tfUserName.getText());
				break;
			default:
				break;
			}
			super.touchUp(event, x, y, pointer, button);
		}
	}

	private class MyHttpResponseListener implements HttpResponseListener {

		@Override
		public void handleHttpResponse(HttpResponse httpResponse) {
			String a = httpResponse.getResultAsString();
			Gdx.app.log("HttpRequestExample", "response: " + a);

			JsonReader reader = new JsonReader();
			JsonValue jsonValue = reader.parse(a);

			String isRegist = jsonValue.getString("isRegist");
			String registOk = jsonValue.getString("Registed");
			Gdx.app.log("isRegist", "" + isRegist);
			Gdx.app.log("registOk", "" + isRegist);
			if (isRegist.equalsIgnoreCase("no")) {
				if (registOk.equalsIgnoreCase("yes")) {
					dlHint.setVisible(true);
					lbHint.setText(CommonUtil.getI18NBundle().get(
							"registsuccess"));
					regist = true;
				}

			} else {
				dlHint.setVisible(true);
				lbHint.setText(CommonUtil.getI18NBundle().get("usernameisused"));
			}

		}

		@Override
		public void failed(Throwable t) {

		}

		@Override
		public void cancelled() {

		}

	}

	@Override
	public InputProcessor getInputProcessor() {
		return stage;
	}

}
