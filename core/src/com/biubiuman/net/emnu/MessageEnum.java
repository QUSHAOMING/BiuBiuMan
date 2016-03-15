package com.biubiuman.net.emnu;

public enum MessageEnum {
	HEADBEAT(0), LOGIN(1), REGIST(2);
	private int code;

	private MessageEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

}
