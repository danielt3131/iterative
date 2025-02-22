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

        Client[] client = new Client[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            client[i] = new Client(line[0], Integer.parseInt(line[1]), option);
            threads[i] = new Thread(client[i]);
            threads[i].start();
        }
        long runtime = 0;
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
            runtime += client[i].getElapsedTime();
        }
        System.out.println(runtime + "ms");
        PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true));
        writer.println(runtime + "ms");
        writer.close();

    }
}