package com.luna.console.code.callback;

public class Launcher {

	public static void main(String[] args) {
		CallA a = new CallA();
		CallB b = new CallB(a);
		b.ask();
	}
}
