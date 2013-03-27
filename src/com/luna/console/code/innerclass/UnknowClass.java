package com.luna.console.code.innerclass;

/**
 * 测试匿名内部类
 * 
 * @author xukai
 * 
 */
public class UnknowClass {

    public void function1() {

        this.function2(new TestA() {

            @Override
            public void printInfo() {

                System.out.print("hello, World!");

            }
        });
    }

    public void function2(TestA a) {

        a.printInfo();
    }
}
