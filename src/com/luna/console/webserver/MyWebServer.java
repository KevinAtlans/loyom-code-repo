package com.luna.console.webserver;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

public class MyWebServer {

    public static final int DEFAULT_PORT_NUMBER = 9527;

    private Server server;

    public void startServer() throws Exception {

        server = new Server(MyWebServer.DEFAULT_PORT_NUMBER);
        Context root = new Context(server, "/SimpleRestService", Context.SESSIONS);
        root.addServlet(new ServletHolder(new WebServlet()), "/*");
        server.start();
    }

    public void stopServer() throws Exception {

        if (server.isStarted()) {
            server.stop();
        } else {
            throw new Exception("The server is not started");
        }
    }

    /**
     * @return the server
     */
    public Server getServer() {

        return server;
    }

    /**
     * @param server
     *            the server to set
     */
    public void setServer(Server server) {

        this.server = server;
    }
}
