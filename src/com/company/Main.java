package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        ServerListener serverListener = new ServerListener(portNumber);
        try {
            serverListener.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverListener.run();

    }
}
