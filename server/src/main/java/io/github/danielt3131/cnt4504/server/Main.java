package io.github.danielt3131.cnt4504.server;

import java.io.*;
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
                System.out.println("New client connected");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                int option = Integer.parseInt(in.readLine());
                System.out.println(option);
                System.out.println("Processing request");
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

                if (option == 1) {
                    printWriter.println(new Date().toString());
                    System.out.println("Processed");
                } else if (option == 2) {
                    Process process = Runtime.getRuntime().exec("uptime");
                    Scanner scanner = new Scanner(process.getInputStream());
                    while (scanner.hasNextLine()) {
                        printWriter.println(scanner.nextLine());
                    }
                    System.out.println("Processed");
                } else if (option == 3) {
                    Process process = Runtime.getRuntime().exec("free -h");
                    Scanner scanner = new Scanner(process.getInputStream());
                    while (scanner.hasNextLine()) {
                        printWriter.println(scanner.nextLine());
                    }
                    System.out.println("Processed");
                } else if (option == 4) {
                    Process process = Runtime.getRuntime().exec("netstat");
                    Scanner scanner = new Scanner(process.getInputStream());
                    while (scanner.hasNextLine()) {
                        printWriter.println(scanner.nextLine());
                    }
                    System.out.println("Processed");
                } else if (option == 5) {
                    Process process = Runtime.getRuntime().exec("w");
                    Scanner scanner = new Scanner(process.getInputStream());
                    while (scanner.hasNextLine()) {
                        printWriter.println(scanner.nextLine());
                    }
                    System.out.println("Processed");
                } else if (option == 6) {
                    Process process = Runtime.getRuntime().exec("ps aux");
                    Scanner scanner = new Scanner(process.getInputStream());
                    while (scanner.hasNextLine()) {
                        printWriter.println(scanner.nextLine());
                    }
                    System.out.println("Processed");
                } else {
                    printWriter.println("Womp womp");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}