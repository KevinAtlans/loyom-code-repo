package com.luna.console.mud.server.login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

    private boolean isEnd = false;

    public void start() {

        acceptLogin();
    }

    private void acceptLogin() {

        boolean isEnd = false;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            do {
                Socket socket = serverSocket.accept();

                SocketPool pool = new SocketPool(socket);
                Thread h = new Thread(pool);
                h.start();

            } while (!isEnd);
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isEnd() {

        return isEnd;
    }

    public void setEnd(boolean isEnd) {

        this.isEnd = isEnd;
    }
}
