package com.company.serverClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker extends Thread {
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;

    public Worker(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("bonjour Ecrivez votre nom et prenom :");
            String msg = in.readLine();
            System.out.println("Merci "+msg);

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
