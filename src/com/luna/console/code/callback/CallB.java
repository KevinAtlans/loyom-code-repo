package com.luna.console.code.callback;

import com.loyom.utils.Print;

public class CallB implements CallBack {

	private CallA ca;

	public CallB(CallA ca) {
		this.ca = ca;
	}

	public void ask() {
		final String que = "这是?";
		// 这里用一个线程就是异步，
		new Thread(new Runnable() {
			@Override
			public void run() {
				ca.answer(CallB.this, que);
			}
		}).start();
		
		doOther();
	}

	public void doOther() {
		Print.println("do other...");

	}

	@Override
	public void execute(String Data) {
		Print.println("答案是:"+Data);
	}

}
