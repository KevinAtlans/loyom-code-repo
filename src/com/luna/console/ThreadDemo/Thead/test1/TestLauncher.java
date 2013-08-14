package com.luna.console.ThreadDemo.Thead.test1;

public class TestLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				FinalVarClass.create();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				FinalVarClass.vistor();
			}
		});
		
		
		t1.start();
		t2.start();
	}
}
