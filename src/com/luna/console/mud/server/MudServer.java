package com.luna.console.mud.server;

import com.luna.console.mud.server.login.LoginServer;

public class MudServer {

    public static void main(String[] args) {

        LoginServer server = new LoginServer();
        server.start();
    }
}
