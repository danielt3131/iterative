package io.github.danielt3131.cnt4504.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client implements Runnable {
    private int optionSelector;

    public Client(int optionSelector) {
        this.optionSelector = optionSelector;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("139.62.210.155", 2000)) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            outputStreamWriter.write(optionSelector);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            InputStream inputStream = socket.getInputStream();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
