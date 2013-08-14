package com.luna.console.ThreadDemo.Thead.test1;

import com.loyom.utils.Print;

public class FinalVarClass {
	public final int a;
	public int b = 0;

	static FinalVarClass co;

	public FinalVarClass() {
		a = 1;
		b = 1;
	}

	// 线程1创建FinalVarClass对象 co
	public static void create() {
		Print.println("Create FinalVarClass...");
		if (co == null) {
			co = new FinalVarClass();
			Print.println("Create FinalVarClass End");
		}
	}

	// 线程2访问co对象的a，b属性
	public static void vistor() {
		Print.println("vistor...");
		if (co != null) {
			Print.println("A:%s", co.a);// 这里返回的一定是1,a一定初始化完成
			Print.println("B:%s", co.b);// 这里返回的可能是0，因为b还未初始化完成
		}
	}
}
