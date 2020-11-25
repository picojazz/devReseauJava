package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

      /*  InetAddress localAdress;
        InetAddress serverAddress;

        try{
            localAdress = InetAddress.getLocalHost();
            System.out.println("l'adresse locale est : "+localAdress);
            serverAddress=InetAddress.getByName("www.ucad.sn");
            System.out.println("l'adresse du serveur web de L'ucad est : "+serverAddress);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }

        */



      // recup a aprtr d'un serveur
    try{
        Socket s = new Socket("time-a.nist.gov",13);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        boolean more = true;
        while (more){
            String line = in.readLine();
            if(line == null)
                more = false;
            else
                System.out.println(line);
        }
    }catch (IOException e){
        e.printStackTrace();
    }

    }
}
