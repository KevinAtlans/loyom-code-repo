package com.luna.console.mud.server.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class SocketPool implements Runnable {

    private Socket socket;

    public SocketPool(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.write("========Welcome to Server=======\r\n".getBytes());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            boolean isExit = false;
            do {
                String readStr = input.readLine();
                output.write(String.format("你输入了：%s \r\n", readStr).getBytes());
                if ("exit".equals(readStr)) {
                    output.write("Bye Bye!\r\n".getBytes());
                    isExit = true;
                }
            } while (!isExit);
        } catch (SocketException ex) {
            System.out.println("XXX,断开链接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {

        return socket;
    }

    public void setSocket(Socket socket) {

        this.socket = socket;
    }
}
