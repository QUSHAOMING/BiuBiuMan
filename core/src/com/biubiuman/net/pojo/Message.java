package com.biubiuman.net.pojo;


public class Message {
	private int head;
	private String body;

	public Message(int head, String body) {
		this.head = head;
		this.body = body;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message [head=" + head + ", body=" + body + "]";
	}

}
