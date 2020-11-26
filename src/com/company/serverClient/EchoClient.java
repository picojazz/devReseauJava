package com.company.serverClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("192.168.1.113", 5555);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            Scanner clavier = new Scanner(System.in);

            boolean more = true;
            while(more){
                String line = in.readLine();
                if(line == null)
                    more = false;
                else{
                    System.out.println(line);
                    line = clavier.nextLine();
                    out.println(line);

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
