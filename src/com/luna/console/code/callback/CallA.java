package com.luna.console.code.callback;

import com.loyom.utils.Print;

public class CallA implements CallBack {

	public void answer(CallBack cb, String question) {
		Print.println("问题是:"+ question);
		String anse = "我去...";
		cb.execute(anse);
	}

	@Override
	public void execute(String Data) {
		Print.println(Data);
	}
}
