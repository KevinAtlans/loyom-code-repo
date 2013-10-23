package com.luna.console.mina.server.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.loyom.utils.Print;

public class ConnectHandler extends IoHandlerAdapter {

	/**
	 * 当一个IO连接建立时被调用，这个方法在任何IO操作之前被调用，以便socket参数或session属性能够最先被设置。
	 */
	@Override
	public void sessionCreated(IoSession session) {
		Print.println("sessionCreated:%s", session.getId());
	}

	/**
	 * 在sessionCreated调用之后被调用。
	 */
	@Override
	public void sessionOpened(IoSession session) {
		Print.println("sessionOpened:%s", session.getId());
	}

	/**
	 * 当IO连接被关闭时被调用。
	 */
	@Override
	public void sessionClosed(IoSession session) {
		Print.println("sessionClosed:%s", session.getId());
	}

	/**
	 * 当在远程实体和用户程序之间没有数据传输的时候被调用。
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		Print.println("sessionIdle:%s", session.getId());
	}

	/**
	 * 当IoAcceptor 或者你的IoHandler.中出现异常时被调用。
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		Print.println("exceptionCaught:%s", session.getId());
		cause.printStackTrace();
	}

	/**
	 * 当接收到新的协议消息时被调用。可以在这里实现你的控制流程。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) {
		Print.println("messageReceived:%s", session.getId());
		Print.println(message);
		session.write("Time:" + System.currentTimeMillis());
	}

	/**
	 * 当用户请求的消息通过 IoSession#write(Object) 确实发送后被调用。
	 */
	@Override
	public void messageSent(IoSession session, Object message) {
		Print.println("messageSent:%s", session.getId());
		Print.println(message);
	}
}
