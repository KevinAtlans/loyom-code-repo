package com.luna.console.webserver;

public class Launcher {

    public static void main(String[] args) throws Exception {

        MyWebServer server = new MyWebServer();
        server.startServer();
    }
}
