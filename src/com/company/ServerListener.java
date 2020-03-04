package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener implements Runnable {

    private int portNumber;
    private ServerSocket serverSocket;

    public ServerListener(int portNumber) {
        this.portNumber = portNumber;
    }


    public void start() throws IOException {
            serverSocket = new ServerSocket(portNumber);
    }

    @Override
    public void run() {
        try {

            while(true) {
               final Socket clientSocket = serverSocket.accept();
               new Thread(new ClientWorker(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
