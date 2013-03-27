package com.luna.console.log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ClientLog4j {

    static Logger logger = Logger.getLogger(ClientLog4j.class.getName());

    public static void main(String[] args) {

        String welcome = null;
        String response = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        InputStream in = null;
        OutputStream out = null;
        Socket client = null;

        try {
            client = new Socket("localhost", 8001);
            logger.info("info: Client socket: " + client);
            System.out.println("info: Client socket: " + client);
            in = client.getInputStream();
            out = client.getOutputStream();
        } catch (IOException e) {
            logger.error("error: IOException : " + e);
            System.out.println("error: IOException : " + e);
            System.exit(0);
        }

        try {
            reader = new BufferedReader(new InputStreamReader(in));
            writer = new PrintWriter(new OutputStreamWriter(out), true);

            welcome = reader.readLine();
            System.out.println("debug: Server says: '" + welcome + "'");

            System.out.println("debug: HELLO");
            writer.println("HELLO");
            response = reader.readLine();
            System.out.println("debug: Server responds: '" + response + "'");

            System.out.println("debug: HELP");
            writer.println("HELP");
            response = reader.readLine();
            System.out.println("debug: Server responds: '" + response + "'");

            System.out.println("debug: QUIT");
            writer.println("QUIT");
        } catch (IOException e) {
            System.out.println("warn: IOException in client.in.readln()");
            System.out.println(e);
        }
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
    }
}
