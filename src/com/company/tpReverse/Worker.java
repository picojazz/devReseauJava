package com.company.tpReverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker extends Thread {
    Socket socket = null;
    BufferedReader fin = null;
    PrintWriter fout = null;

    public String reverse(String line){
        return new StringBuilder(line).reverse().toString();
    }

    public Worker(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        try {
            fin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fout = new PrintWriter(socket.getOutputStream(), true);
            fout.println("bonjour , bienvenue dans le Tp Reverse String");
            System.out.println(socket.getInetAddress()+" s'est connecté");
            boolean done = false;
            while(!done) {
                String msg = fin.readLine();
                if(msg.isEmpty()) {
                    done = true;
                    fout.println("deconnexion");
                }else {
                    fout.println("inversé : "+reverse(msg));
                    System.out.println(socket.getInetAddress()+" a ecrit : "+msg+" et inversé en : "+reverse(msg));
                }
            }
            System.out.println(socket.getInetAddress()+" s'est déconnecté");
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
