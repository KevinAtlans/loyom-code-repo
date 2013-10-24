package com.luna.console.mina.server.bean;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 所以类的父类必须继承
 * @author kai
 *
 */
public class Obj implements Serializable {

	private static final long serialVersionUID = 6304872236132715778L;

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
