package com.biubiuman.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.biubiuman.bean.User;
import com.biubiuman.game.DirectedGame;
import com.biubiuman.game.screen.rtt.ScreenTransition;
import com.biubiuman.game.screen.rtt.ScreenTransitionFade;
import com.biubiuman.game.ui.MyIconAnimation;
import com.biubiuman.game.util.CommonUtil;
import com.biubiuman.game.util.Constants;
import com.biubiuman.net.emnu.MessageEnum;
import com.biubiuman.net.pojo.Message;
import com.biubiuman.net.util.FormatUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;

public class LoginScreen extends AbstractScreen {
	private String TAG = "login";
	private TextField tfUserName;
	private TextField tfPassword;
	private Image clearUserName;
	private Image clearPassword;
	private boolean login;
	private TextButton btnLogin;
	private TextButton btnRegist;
	private TextButton btnConfirm;
	private Label lbPassword;
	private Label lbUserName;
	private Image bg;
	ScreenTransition transition = ScreenTransitionFade.init(0.75f);
	
	public LoginScreen(DirectedGame game,Channel ch) {
		super(game,ch);
	}

	@Override
	public void show() {

		stage = new Stage(new ScalingViewport(Scaling.fit, Constants.GAME_WIDTH, Constants.GAME_HEIGHT,
				new OrthographicCamera()));
		skin = CommonUtil.getMySkin();
		lbUserName = new Label(CommonUtil.getI18NBundle().get("username"), skin);
		lbUserName.setX((Constants.GAME_WIDTH - lbUserName.getWidth()) / 2 - 130);
		lbUserName.setY(300);
		lbUserName.setWidth(50);
		lbUserName.setHeight(30);

		tfUserName = new TextField("", skin);
		tfUserName.setX((Constants.GAME_WIDTH - tfUserName.getWidth()) / 2);
		tfUserName.setY(300);
		tfUserName.setWidth(200);
		tfUserName.setHeight(30);

		lbPassword = new Label(CommonUtil.getI18NBundle().get("password"), skin);
		lbPassword.setX((Constants.GAME_WIDTH - lbPassword.getWidth()) / 2 - 130);
		lbPassword.setY(250);
		lbPassword.setWidth(50);
		lbPassword.setHeight(30);

		tfPassword = new TextField("", skin);
		tfPassword.setPasswordMode(true);
		tfPassword.setPasswordCharacter('*');
		tfPassword.setX((Constants.GAME_WIDTH - tfPassword.getWidth()) / 2);
		tfPassword.setY(250);
		tfPassword.setWidth(200);
		tfPassword.setHeight(30);

		btnLogin = new TextButton(CommonUtil.getI18NBundle().get("btnlogin"), skin);
		btnLogin.setX(260);
		btnLogin.setY(180);
		btnLogin.setWidth(80);
		btnLogin.setHeight(40);

		btnRegist = new TextButton(CommonUtil.getI18NBundle().get("btnregist"), skin);
		btnRegist.setX(400);
		btnRegist.setY(180);
		btnRegist.setWidth(80);
		btnRegist.setHeight(40);

		dlHint = CommonUtil.getdlHint(skin);

		btnConfirm = dlHint.getBtnConfirm();

		lbHint = CommonUtil.getlbHint(skin);

		clearUserName = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("images/btn_clear.png"))));
		clearUserName.setX((Constants.GAME_WIDTH + tfUserName.getWidth()) / 2);
		clearUserName.setY(305);

		clearPassword = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("images/btn_clear.png"))));
		clearPassword.setX((Constants.GAME_WIDTH + tfPassword.getWidth()) / 2);
		clearPassword.setY(255);

		bg = new Image(new Texture("images/bg_login_regist.png"));
		Array<TextureRegion> keyFrames = new Array<TextureRegion>();

		keyFrames.add(new TextureRegion(new Texture("images/before_login_.png")));

		iconOpt();
		dlHint.setVisible(false);
		clearUserName.setVisible(false);
		clearPassword.setVisible(false);

		btnLogin.addListener(new MyClickListener(Constants.LOGIN_BTN));

		btnRegist.addListener(new MyClickListener(Constants.REGIST_BTN));

		btnConfirm.addListener(new MyClickListener(Constants.CONFIRM_BTN));

		clearUserName.addListener(new MyClickListener(Constants.CLEAR_USERNAME_BTN));

		clearPassword.addListener(new MyClickListener(Constants.CLEAR_PW_BTN));

		tfUserName.addListener(new MyClickListener(Constants.USERNAME_TF));

		tfPassword.addListener(new MyClickListener(Constants.PASSWORD_TF));

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0.7f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		super.render(delta);
	}

	private void iconOpt() {
		stage.addActor(bg);
		stage.addActor(btnRegist);
		stage.addActor(btnLogin);
		stage.addActor(lbUserName);
		stage.addActor(tfUserName);
		stage.addActor(lbPassword);
		stage.addActor(tfPassword);
		stage.addActor(clearPassword);
		stage.addActor(clearUserName);
		stage.addActor(dlHint);
	}

	private void loginOpt() {
		User user = new User();
		user.setUserName("bb");
		user.setPassword("123");
		Message message = new Message(MessageEnum.LOGIN.getCode(), FormatUtil.formatPojo(user));
		ch.writeAndFlush(message);
		
		Gdx.app.log("111", "2222");
		// HttpRequest request = new HttpRequest(HttpMethods.POST);
		//
		// request.setUrl(Constants.SERVER + TAG + Constants.FILTER);
		//
		// Json json = new Json();
		//
		// User user = new User();
		//
		// String userName = tfUserName.getText().trim();
		// String password = tfPassword.getText().trim();
		//
		// if (CommonUtil.judgeUserName(userName)
		// && CommonUtil.judgePassword(password)) {
		// user.setUserName('"' + userName + '"');
		// user.setPassword('"' + password + '"');
		// request.setHeader("user", json.toJson(user));
		// Gdx.net.sendHttpRequest(request, new MyHttpResponseListener());
		// }

	}

	private void registOpt() {
		game.setScreen(new RegistScreen(game,ch));
	}

	private void confimrOpt() {
		if (!login) {
			dlHint.setVisible(false);
			lbHint.setText("");
		} else {
			login = false;
			CommonUtil.enterGame(game,ch);
		}
	}

	private void clearUserNameOpt() {
		CommonUtil.clear(tfUserName, clearUserName);
	}

	private void clearPasswordOpt() {
		tfPassword.setText("");
		clearPassword.setVisible(false);
		CommonUtil.clear(tfPassword, clearPassword);
	}

	private class MyHttpResponseListener implements HttpResponseListener {

		@Override
		public void handleHttpResponse(HttpResponse httpResponse) {
			String a = httpResponse.getResultAsString();
			Gdx.app.log("HttpRequestExample", "response: " + a);

			JsonReader reader = new JsonReader();
			JsonValue jsonValue = reader.parse(a);

			String isRegist = jsonValue.getString("isRegist");
			if (isRegist.equals("no")) {
				dlHint.setVisible(true);
				lbHint.setText(CommonUtil.getI18NBundle().get("usernameisnotexsit"));
				dlHint.text(lbHint);

			} else {
				String isLogin = jsonValue.getString("isLogin");
				if (isLogin.equals("yes")) {
					dlHint.setVisible(true);
					lbHint.setText(CommonUtil.getI18NBundle().get("registsuccess"));
					login = true;

				} else {
					dlHint.setVisible(true);
					lbHint.setText(CommonUtil.getI18NBundle().get("passwordisincorrect"));
					dlHint.text(lbHint);
				}
			}
		}

		@Override
		public void failed(Throwable t) {
			dlHint.setVisible(true);
			lbHint.setText(CommonUtil.getI18NBundle().get("neterror"));
			dlHint.text(lbHint);
		}

		@Override
		public void cancelled() {
			Gdx.app.log("HttpRequestExample", "cancelled");
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
			// login
			case 0:
				loginOpt();
				break;
			// regist
			case 1:
				registOpt();
				break;
			// confirm
			case 2:
				confimrOpt();
				break;
			case 4:
				clearUserNameOpt();
				break;
			case 5:
				clearPasswordOpt();
				break;
			default:
				break;
			}

			super.clicked(event, x, y);
		}

		@Override
		public boolean keyTyped(InputEvent event, char character) {
			switch (id) {
			case 101:
				CommonUtil.checkEmpty(clearUserName, tfUserName.getText());
				break;
			case 102:
				CommonUtil.checkEmpty(clearPassword, tfPassword.getText());
				break;
			default:
				break;
			}
			return super.keyTyped(event, character);
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			Image[] is;
			switch (id) {
			case 101:
				is = new Image[] { clearPassword };
				CommonUtil.showClose(is, clearUserName, tfUserName.getText());
				break;
			case 102:
				is = new Image[] { clearUserName };
				CommonUtil.showClose(is, clearPassword, tfPassword.getText());
				break;
			default:
				break;
			}
			super.touchUp(event, x, y, pointer, button);
		}

	}

	@Override
	public InputProcessor getInputProcessor() {
		return stage;
	}

}
