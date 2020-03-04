package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWorker implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String inputLine;

    public ClientWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
    }

    @Override
    public void run() {
        try {
            // Echo
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client:" + inputLine);
                out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
