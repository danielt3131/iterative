package io.github.danielt3131.cnt4504.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private int optionSelector;

    public Client(int optionSelector) {
        this.optionSelector = optionSelector;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("139.62.210.155", 2000)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.write(String.valueOf(optionSelector));
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
