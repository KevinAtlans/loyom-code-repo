package com.luna.console.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.loyom.utils.Print;
import com.luna.console.mina.server.handler.ConnectHandler;

public class MudServer {

	private static final int PORT = 801;

	private IoAcceptor acceptor = null;

	public MudServer() throws Exception {
		// 创建服务器监听
		acceptor = new NioSocketAcceptor();
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		addLogger(chain);
		addCodecFilter(chain);
		addSSLSupport(chain);
		setHandler(new ConnectHandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

	}

	public void start() throws IOException {
		acceptor.bind(new InetSocketAddress(PORT));
		Print.println("Server listening on port:%s", PORT);
	}

	public void setHandler(IoHandlerAdapter handler) {
		if (acceptor != null) {
			acceptor.setHandler(handler);
			Print.println("Handler support.");
		}
	}

	private void addLogger(DefaultIoFilterChainBuilder chain) throws Exception {
		chain.addLast("logger", new LoggingFilter());
		Print.println("Log support.");
	}

	private void addSSLSupport(DefaultIoFilterChainBuilder chain)
			throws Exception {
		Print.println("SSL support.");
	}

	private void addCodecFilter(DefaultIoFilterChainBuilder chain)
			throws Exception {
		TextLineCodecFactory textLine = new TextLineCodecFactory(Charset.forName("UTF-8"));
		chain.addLast("codec", new ProtocolCodecFilter(textLine));
		Print.println("Codec support.");
	}
}
