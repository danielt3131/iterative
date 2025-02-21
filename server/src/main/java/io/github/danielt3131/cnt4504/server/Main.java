package io.github.danielt3131.cnt4504.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       try (ServerSocket serverSocket = new ServerSocket(2000)) {
           while (true) {
               Socket socket = serverSocket.accept();
               InputStream inputStream = socket.getInputStream();
               Scanner scanner = new Scanner(inputStream);
               int option = Integer.parseInt(scanner.nextLine());
               scanner.close();
               inputStream.close();
               PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
               printWriter.println(new Date().toString());
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}