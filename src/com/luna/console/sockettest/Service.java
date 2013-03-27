package com.luna.console.sockettest;

import java.io.IOException;
import java.net.Socket;

public class Service  extends Thread {

    private final Socket _socket;

    public Service(Socket socket) {

        _socket = socket;
    }

    public void run() {

        try {
            // Write "Hello, world!" to the client.
            _socket.getOutputStream().write("Hello, world!\r\n".getBytes());
        } catch (IOException e) {
            // Abandon the current connection.
        } finally {
            try {
                // Close the connection.
                _socket.close();
            } catch (IOException e) {
                // Eat the IOException.
            }
        }
    }
}
