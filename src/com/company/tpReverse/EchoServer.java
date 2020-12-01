package com.company.tpReverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class EchoServer {


    public static void main(String[] args) {
        int port =5555;

       try{

           ServerSocket s = new ServerSocket(port);

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


