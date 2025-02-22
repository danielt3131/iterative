package io.github.danielt3131.cnt4504.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private int optionSelector;
    private String host;
    private int port;


    public Client(String host, int port, int optionSelector) {
        this.optionSelector = optionSelector;
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(host, port)) {
            long runtime = System.currentTimeMillis();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.write(optionSelector);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            runtime = System.currentTimeMillis() - runtime;
            System.out.println(runtime);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
