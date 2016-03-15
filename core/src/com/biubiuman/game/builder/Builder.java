package com.biubiuman.game.builder;

public interface Builder {
	public <T> T createObject(Class<T> c);
}
