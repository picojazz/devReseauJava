package com.company.tpReverse;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try{
            ServerSocket s = new ServerSocket(5555);
            while(true) {
                Socket incoming = s.accept();
                Worker worker = new Worker(incoming);
                worker.start();

            }



        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
