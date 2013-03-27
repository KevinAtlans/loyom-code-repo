package com.luna.console.SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {

        // 建立一个端口号为8001的服务器端ServerSocket对象
        ServerSocket server = new ServerSocket(5050);
        // 监听客户端的连接请求
        Socket acceptSocket = server.accept();
        // 提取socket对象的输入流
        InputStream serverIn = acceptSocket.getInputStream();
        // 提取socket对象的输出流
        OutputStream serverOut = acceptSocket.getOutputStream();
        // 在输出流上发送文字，客户端连接上后马上能接收到
        serverOut.write("welcom to visit server.".getBytes());
        // 建立缓冲流来显示客户端的输入
        BufferedReader buf = new BufferedReader(new InputStreamReader(serverIn));
        String temp = buf.readLine();
        System.out.println(temp);

        // 注意关闭顺序
        buf.close(); // 会自动关闭低层输入的字节流
        serverOut.close();
        acceptSocket.close();
        server.close();
    }

}
