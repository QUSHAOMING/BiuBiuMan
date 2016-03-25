package com.biubiuman.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.biubiuman.game.builder.ObjectBuilder;
import com.biubiuman.game.model.FlyBattleAction;
import com.biubiuman.game.model.GroundBattleAction;
import com.biubiuman.game.screen.LoadingScreen;
import com.biubiuman.game.screen.LoginScreen;
import com.biubiuman.game.screen.rtt.ScreenTransition;
import com.biubiuman.game.screen.rtt.ScreenTransitionFade;
import com.biubiuman.game.screen.rtt.ScreenTransitionSlice;
import com.biubiuman.game.screen.rtt.ScreenTransitionSlide;
import com.biubiuman.game.util.CommonUtil;
import com.biubiuman.game.util.Constants;
import com.biubiuman.net.handler.HandlerIniter;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class BiuBiuMan extends DirectedGame {

	private int port;
	private String host;
	private ChannelFuture f;
	private boolean isClientStart = false;

	@Override
	public void create() {
		// Gdx.app.log("start", "yes");
		// Gdx.app.log("CommonUtil", CommonUtil.getMySkin() + "");
		// Game
		// this.setScreen(new LoadingScreen(this));
		// ScreenTransition transition = ScreenTransitionSlice.init(10,
		// ScreenTransitionSlice.UP_DOWN, 5, Interpolation.pow5Out);
		// ScreenTransition transition = ScreenTransitionSlide.init(0.5f,
		// ScreenTransitionSlide.DOWN, false, Interpolation.bounceOut);
		// ScreenTransition transition = ScreenTransitionFade.init(0.75f);
		// this.setScreen(new LoginScreen(this), transition);
		// AsyncExecutor executor = new AsyncExecutor(1);
		//
		// executor.submit(new AsyncTask<T>() {
		//
		// @Override
		// public T call() throws Exception {
		//
		// return null;
		// }
		// });

		setScreen(new GroundBattleAction(Constants.GROUND_GRASS));
		// host = "192.168.0.120";
		// port = 18181;
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// runServer(host, port);
		// }
		// }).start();
		// while(!isClientStart){
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// if (isClientStart) {
		// break;
		// }
		// }
		// // setScreen(new LoginScreen(this,f.channel()));
	}

	@Override
	public void dispose() {
		Gdx.app.log("dispose", "yes");
		CommonUtil.dispose();
	}

	public void runServer(String host, int port) {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup).channel(NioSocketChannel.class)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.handler(new HandlerIniter());
			f = b.connect(host, port).sync();
			if (f.isSuccess()) {
				System.out.println("client is ok");
				isClientStart = true;
			}
			f.channel().closeFuture().sync();
		} catch (Exception e) {
		} finally {
			workerGroup.shutdownGracefully();
		}
	}
}
