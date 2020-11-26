package com.company.serverClientNonConnect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServerUDP {
    final static int port = 4444;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];

    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(port);
        while(true){
            DatagramPacket data = new DatagramPacket(buffer,taille);
            socket.receive(data);
            System.out.println(data.getAddress()+" ==> "+new String(data.getData()));
            socket.send(data);
        }

    }

}
