package io.github.danielt3131.cnt4504.client;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Enter in the server ip and port");
        Scanner console = new Scanner(System.in);
        String[] line = console.nextLine().split(":");
        System.out.println("Press 1 for get the Date and Time");
        System.out.println("Press 2 for get the system uptime");
        System.out.println("Press 3 for get the system memory usage");
        System.out.println("Press 4 to run netstat");
        System.out.println("Press 5 to get a list of active users");
        System.out.println("Press 6 to get a list of all running processes");


        int option = Integer.parseInt(console.nextLine());

        System.out.println("Enter in how many requests you like to make (threads)");
        int numThreads = Integer.parseInt(console.nextLine());

        Client client = new Client(line[0], Integer.parseInt(line[1]), option);
        Thread[] threads = new Thread[numThreads];
        long runtime = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(client);
            threads[i].start();
        }
        runtime = System.currentTimeMillis() - runtime;
        System.out.println(runtime + "ms");
        PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true));
        writer.write(runtime + "ms");
        writer.close();

    }
}