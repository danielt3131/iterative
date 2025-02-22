package io.github.danielt3131.cnt4504.server;

import java.io.*;
import java.net.ServerSocket;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            int i = 0;
            while (true) {
                ServerThread serverInstance = new ServerThread(serverSocket.accept());
                Thread serverThread = new Thread(serverInstance);
                serverThread.start();
                System.out.println(i);
                i++;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}