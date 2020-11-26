package com.company.serverClientNonConnect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClientUDP {
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String[] args) throws Exception{
        //InetAddress server = InetAddress.getByName("192.168.43.195");
        InetAddress server = InetAddress.getLocalHost();
        int length = "amadouDiop".length();
        byte buffer[] = "amadouDiop".getBytes();
        DatagramPacket dataSent = new DatagramPacket(buffer,length,server,4444);
        DatagramSocket socket = new DatagramSocket();
        socket.send(dataSent);
        DatagramPacket dataReceived = new DatagramPacket(new byte[length],length);
        socket.receive(dataReceived);
        System.out.println("Data Received : "+ new String(dataReceived.getData()));
        System.out.println("From : "+dataReceived.getAddress()+" : "+ dataReceived.getPort());

    }


}
