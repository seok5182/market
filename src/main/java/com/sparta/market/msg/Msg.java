package com.sparta.market.msg;

import lombok.Getter;

@Getter
public class Msg {
	private String msg;

	public Msg(String msg) {
		this.msg = msg;
	}
}
